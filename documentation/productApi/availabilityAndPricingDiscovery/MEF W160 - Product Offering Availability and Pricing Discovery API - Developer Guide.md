<style>
img
{
  display:block;
  float:none;
  margin-left:auto;
  margin-right:auto;
}
</style>

![MEF_LOGO](media/mefLogo.png)

<div style="font-weight:bold; font-size:33pt; font-family: sensation;  text-align:center">
Working Draft
</br>
MEF W160 v0.1
</br>
</br>
LSO Cantata and LSO Sonata Product Offering Availability and Pricing Discovery API - Developer Guide
</br>
</br>
<p style="color:red;font-weight:bold; font-size:18pt">This draft represents MEF work in progress and is subject to change.</p>
June 2023
</br>
<p style="color:red;font-weight:bold; font-size:18pt">EXPORT CONTROL: This document contains technical data. The download, export, re-export or disclosure of the technical data contained in this document may be restricted by applicable U.S. or foreign export laws, regulations and rules and/or applicable U.S. or foreign sanctions ("Export Control Laws or Sanctions"). You agree that you are solely responsible for determining whether any Export Control Laws or Sanctions may apply to your download, export, reexport or disclosure of this document, and for obtaining (if available) any required U.S. or foreign export or reexport licenses and/or other required authorizations.</p>
</div>

<div class="page"/>

**Disclaimer**

© MEF Forum 2023. All Rights Reserved.

The information in this publication is freely available for reproduction and
use by any recipient and is believed to be accurate as of its publication date.
Such information is subject to change without notice and MEF Forum (MEF) is not
responsible for any errors. MEF does not assume responsibility to update or
correct any information in this publication. No representation or warranty,
expressed or implied, is made by MEF concerning the completeness, accuracy, or
applicability of any information contained herein and no liability of any kind
shall be assumed by MEF as a result of reliance upon such information.

The information contained herein is intended to be used without modification by
the recipient or user of this document. MEF is not responsible or liable for
any modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way
create, by implication or otherwise:

- (a) any express or implied license or right to or under any patent,
  copyright, trademark or trade secret rights held or claimed by any MEF member
  which are or may be associated with the ideas, techniques, concepts or
  expressions contained herein; nor

- (b) any warranty or representation that any MEF member will announce any
  product(s) and/or service(s) related thereto, or if such announcements are
  made, that such announced product(s) and/or service(s) embody any or all of
  the ideas, technologies, or concepts contained herein; nor

- (c) any form of relationship between any MEF member and the recipient or user
  of this document.

Implementation or use of specific MEF standards, specifications or
recommendations will be voluntary, and no Member shall be obliged to implement
them by virtue of participation in MEF Forum. MEF is a non-profit international
organization to enable the development and worldwide adoption of agile, assured
and orchestrated network services. MEF does not, expressly or otherwise,
endorse or promote any specific products or services.

**Copyright**

© MEF Forum 2023. Any reproduction of this document, or any portion thereof,
shall contain the following statement: "Reproduced with permission of MEF
Forum." No user of this document is authorized to modify any of the information
contained herein.

<div class="page"/>

**Table of Contents**

- [List of Contributing Members](#list-of-contributing-members)
- [1. Abstract](#1-abstract)
- [2. Terminology and Abbreviations](#2-terminology-and-abbreviations)
- [3. Compliance Levels](#3-compliance-levels)
- [4. Introduction](#4-introduction)
  - [4.1. Description](#41-description)
  - [4.2. Conventions in the Document](#42-conventions-in-the-document)
  - [4.3. Relation to Other Documents](#43-relation-to-other-documents)
  - [4.4. Approach](#44-approach)
  - [4.5. High-Level Flow](#45-high-level-flow)
- [5. API Description](#5-api-description)
  - [5.1. High-level use cases](#51-high-level-use-cases)
  - [5.2. API Endpoint and Operation Description](#52-api-endpoint-and-operation-description)
  - [5.3. Specifying the Buyer ID and the Seller ID](#53-specifying-the-buyer-id-and-the-seller-id)
  - [5.4. Integration of Product Specifications into the API](#54-integration-of-product-specifications-into-the-api)
  - [5.5. Sample Product Specification](#55-sample-product-specification)
  - [5.6. Model Structural Validation](#56-model-structural-validation)
  - [5.7. Security Considerations](#57-security-considerations)
- [6. API Interaction \& Flows](#6-api-interaction--flows)
  - [6.1. Use case 1: Retrieve Product Offering Availability](#61-use-case-1-retrieve-product-offering-availability)
    - [6.1.1 Request](#611-request)
    - [6.1.2 Response](#612-response)
  - [6.2. Use case 2: Retrieve Pricing for a Product Offering Configuration](#62-use-case-2-retrieve-pricing-for-a-product-offering-configuration)
    - [6.2.1 Request](#621-request)
    - [6.2.1 Response](#621-response)
- [7. API Details](#7-api-details)
  - [7.1. API patterns](#71-api-patterns)
    - [7.1.1. Indicating errors](#711-indicating-errors)
      - [7.1.1.1. Type Error](#7111-type-error)
      - [7.1.1.2. Type Error400](#7112-type-error400)
      - [7.1.1.3. `enum` Error400Code](#7113-enum-error400code)
      - [7.1.1.4. Type Error401](#7114-type-error401)
      - [7.1.1.5. `enum` Error401Code](#7115-enum-error401code)
      - [7.1.1.6. Type Error403](#7116-type-error403)
      - [7.1.1.7. `enum` Error403Code](#7117-enum-error403code)
      - [7.1.1.8. Type Error422](#7118-type-error422)
      - [7.1.1.9. `enum` Error422Code](#7119-enum-error422code)
      - [7.1.1.10. Type Error500](#71110-type-error500)
  - [7.2. API Data model](#72-api-data-model)
    - [7.2.1. Product Offering Availability](#721-product-offering-availability)
      - [7.2.1.1 Type ProductOfferingAvailability\_Common](#7211-type-productofferingavailability_common)
      - [7.2.1.2. Type ProductOfferingAvailability\_Request](#7212-type-productofferingavailability_request)
      - [7.2.1.3. Type ProductOfferingAvailability](#7213-type-productofferingavailability)
      - [7.2.1.4. `enum` ProductActionAddModifyType](#7214-enum-productactionaddmodifytype)
      - [7.2.1.5. Type ProductRelationship](#7215-type-productrelationship)
      - [7.2.1.6. Type ProductOfferingConfiguration](#7216-type-productofferingconfiguration)
      - [7.2.1.7. Type ProductOfferingRef](#7217-type-productofferingref)
      - [7.2.1.8. Type MEFProductConfiguration](#7218-type-mefproductconfiguration)
      - [7.2.1.9. Type ProductRef](#7219-type-productref)
      - [7.2.1.10. Type ProductSpecificationRef](#72110-type-productspecificationref)
      - [7.2.1.11. Type MEFItemTerm](#72111-type-mefitemterm)
      - [7.2.1.12. Type Duration](#72112-type-duration)
      - [7.2.1.13. Type TimePeriod](#72113-type-timeperiod)
      - [7.2.1.14. `enum` TimeUnit](#72114-enum-timeunit)
    - [7.2.2. Pricing Discovery](#722-pricing-discovery)
      - [7.2.2.1 Type PricingDiscovery\_Common](#7221-type-pricingdiscovery_common)
      - [7.2.2.2. Type PricingDiscovery\_Request](#7222-type-pricingdiscovery_request)
      - [7.2.2.3. Type PricingDiscovery](#7223-type-pricingdiscovery)
      - [7.2.2.4. Type PricingAndTerm](#7224-type-pricingandterm)
      - [7.2.2.5. Type QuotePrice](#7225-type-quoteprice)
      - [7.2.2.6. `enum` MEFChargePeriod](#7226-enum-mefchargeperiod)
      - [7.2.2.7. `enum` MEFEndOfTermAction](#7227-enum-mefendoftermaction)
      - [7.2.2.8. `enum` MEFPriceType](#7228-enum-mefpricetype)
      - [7.2.2.9. Type Money](#7229-type-money)
      - [7.2.2.10. Type Price](#72210-type-price)
    - [7.2.3. Place representation](#723-place-representation)
      - [7.2.3.1. Type RelatedPlaceRefOrValue](#7231-type-relatedplacereforvalue)
      - [7.2.3.2. Type FieldedAddress](#7232-type-fieldedaddress)
      - [7.2.3.3. Type FormattedAddress](#7233-type-formattedaddress)
      - [7.2.3.4. Type MEFGeographicPoint](#7234-type-mefgeographicpoint)
      - [7.2.3.5. Type GeographicSubAddress](#7235-type-geographicsubaddress)
      - [7.2.3.6. Type GeographicAddressRef](#7236-type-geographicaddressref)
      - [7.2.3.7. Type GeographicSiteRef](#7237-type-geographicsiteref)
      - [7.2.3.8. Type GeographicAddressLabel](#7238-type-geographicaddresslabel)
      - [7.2.3.9. Type MEFSubUnit](#7239-type-mefsubunit)
- [8. References](#8-references)

<div class="page"/>

# List of Contributing Members

The following members of the MEF participated in the development of this
document and have requested to be included in this list.

| Member |
| ------ |
|        |
|        |
|        |

**Table 1: Contributing Members**

<div class="page"/>

# 1. Abstract

This standard is intended to assist implementation of the Product Offering
Availability and Pricing Discovery functionality defined for the LSO Cantata
and LSO Sonata Interface Reference Points (IRPs), for which requirements and
use cases are defined in MEF 110 _Product Offering Availability and Pricing
Discovery - Business Requirements and Use Cases_ [[MEF110](#8-references)].
This standard consists of this document and complementary API definitions.

This standard normatively incorporates the following files by reference as if
they were part of this document, from the GitHub repository:

<https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK>

- [`productApi/availabilityAndPricingDiscovery/productOfferingAvailabilityAndPricingDiscovery.api.yaml`](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/working-draft/productApi/availabilityAndPricingDiscovery/productOfferingAvailabilityAndPricingDiscovery.api.yaml)

<https://github.com/MEF-GIT/MEF-LSO-Cantata-SDK>

- [`productApi/availabilityAndPricingDiscovery/productOfferingAvailabilityAndPricingDiscovery.api.yaml`](https://github.com/MEF-GIT/MEF-LSO-Cantata-SDK/blob/working-draft/productApi/availabilityAndPricingDiscovery/productOfferingAvailabilityAndPricingDiscovery.api.yaml)

<div class="page"/>

# 2. Terminology and Abbreviations

This document does not define any new terms or definitions. All of them are
defined in the standards referenced below and are included in this document by
reference:

- MEF 110 - Product Offering Availability and Pricing Discovery - Business
  Requirements and Use Cases [[MEF110](#8-references)]
- MEF 55.1 Lifecycle Service Orchestration (LSO): Reference Architecture and
  Framework [[MEF55.1](#8-references)]

<div class="page"/>

# 3. Compliance Levels

The key words **"MUST"**, **"MUST NOT"**, **"REQUIRED"**, **"SHALL"**, **"SHALL
NOT"**, **"SHOULD"**, **"SHOULD NOT"**, **"RECOMMENDED"**, **"NOT
RECOMMENDED"**, **"MAY"**, and **"OPTIONAL"** in this document are to be
interpreted as described in BCP 14 (RFC 2119 [[rfc2119](#8-references)], RFC
8174 [[rfc8174](#8-references)]) when, and only when, they appear in all
capitals, as shown here. All keywords must be in bold text.

Items that are **REQUIRED** (contain the words **MUST** or **MUST NOT**) are
labeled as **[Rx]** for required. Items that are **RECOMMENDED** (contain the
words **SHOULD** or **SHOULD NOT**) are labeled as **[Dx]** for desirable.
Items that are **OPTIONAL** (contain the words MAY or OPTIONAL) are labeled as
**[Ox]** for optional.

<div class="page"/>

# 4. Introduction

This standard specification document describes the Application Programming
Interface (API) for Product Offering Availability and Pricing Discovery
functionality of the LSO Cantata Interface Reference Point (IRP) and Sonata IRP
as defined in the MEF 55.1 _Lifecycle Service Orchestration (LSO): Reference
Architecture and Framework_ [[MEF55.1](#8-references)]. The LSO Reference
Architecture is shown in Figure 1 with both IRPs highlighted.

![Figure 1](media/lsoArchitecture.png)

**Figure 1. The LSO Reference Architecture**

This document is structured as follows:

- [Chapter 4](#4-introduction) provides an introduction to Product Offering
  Availability and Pricing Discovery and its description in a broader context
  of Cantata and Sonata
- [Chapter 5](#5-api-description) gives an overview of endpoints, resource
  model and design patterns.
- Use cases and flows are presented in
  [Chapter 6](#6-api-interactions-and-flows).
- And finally, [Chapter 7](#7-api-details) complements previous sections with a
  detailed resource model description.

## 4.1. Description

Product Offering Availability Discovery is a way for the Buyer to specify a
Product Specification to the Seller and to receive from the Seller a list of
zero or more Product Offering Configurations.

Pricing Discovery allows the Buyer to receive from the Seller a list of one or
more terms and pricing information for the Product Configuration specified by
the Buyer.

## 4.2. Conventions in the Document

- Code samples are formatted using code blocks. When notation `<< some text >>`
  is used in the payload sample it indicates that a comment is provided instead
  of an example value and it might not comply with the OpenAPI definition.
- Model definitions are formatted as in-line code (e.g.
  `ProductOfferingAvailability`).
- In UML diagrams the default cardinality of associations is `0..1`. Other
  cardinality markers are compliant with the UML standard.
- In the API details tables and UML diagrams required attributes are marked
  with a `*` next to their names.
- In UML sequence diagrams `{{variable}}` notation is used to indicate a
  variable to be substituted with a correct value.

## 4.3. Relation to Other Documents

The requirements and use cases for Product Offering Availability and Pricing
Discovery functionality are defined in MEF 110 [[MEF110](#8-references)].

## 4.4. Approach

As presented in Figure 2. both LSO Cantata and LSO Sonata API frameworks
consist of three structural components:

- Generic API framework
- Product-independent information (Function-specific information and
  Function-specific operations)
- Product-specific information (MEF product specification data model)

![Figure 2](media/lsoApiStructure.png)

**Figure 2. Cantata and Sonata API framework**

The essential concept behind the framework is to decouple the common structure,
information, and operations from the specific product information content.  
Firstly, the Generic API Framework defines a set of design rules and patterns
that are applied across all Cantata or Sonata APIs.  
Secondly, the product-independent information of the framework focuses on a
model of a particular Cantata or Sonata functionality and is agnostic to any of
the product specifications.  
Finally, the product-specific information part of the framework focuses on MEF
product specifications that define business-relevant attributes and
requirements for trading MEF subscriber and MEF operator services.

## 4.5. High-Level Flow

Product Offering Availability and Pricing Discovery is part of a broader
Cantata and Sonata End-to-End flow. Figure 3. below shows a high-level diagram
to get a good understanding of the whole process.

![Figure 3](media/cantataSonataEndToEndFlow.png)

**Figure 3. Cantata and Sonata End-to-End Function Flow**

- Address Validation:
  - Allows the Buyer to retrieve address information from the Seller, including
    exact formats, for addresses known to the Seller.
- Site Retrieval:
  - Allows the Buyer to retrieve Service Site information including exact
    formats for Service Sites known to the Seller.
- Product Catalog:
  - Allows the Buyer to retrieve Product Categories and Product Offering
    information, including specification details from a Seller's Product
    Catalog.
- Product Offering Qualification (POQ):
  - Allows the Buyer to check whether the Seller can deliver a product or set
    of products from among their product offerings at the geographic address or
    a service site specified by the Buyer; or modify a previously purchased
    product.
- Quote:
  - Allows the Buyer to submit a request to find out how much the installation
    of an instance of a Product Offering, an update to an existing Product, or
    a disconnect of an existing Product will cost.
- Product Order:
  - Allows the Buyer to request the Seller to initiate and complete the
    fulfillment process of an installation of a Product Offering, an update to
    an existing Product, or a disconnect of an existing Product at the address
    defined by the Buyer.
- Product Inventory:
  - Allows the Buyer to retrieve information about existing Product instances
    from Seller's Product Inventory.
- Billing:
  - Allows the Seller to generate the document to the Buyer relating to charges
    associated with Products provided by the Seller to the Buyer.
- Trouble Ticketing:
  - Allows the Buyer to create, retrieve, and update Trouble Tickets as well as
    receive notifications about Incidents' and Trouble Tickets' updates. This
    allows for managing issues and situations that are not part of the normal
    operations of the Product provided by the Seller.

Product Offering Availability and Pricing Discovery APIs are drawn as a fork to
standard POQ and Quote as they implement the same functionality but in a
slightly different approach. The discrepancies will be explained in detail in
further sections.

# 5. API Description

This section discusses the API structure and design patterns. It starts with
the high-level use cases diagram and then it describes the REST endpoints with
use case mapping.

## 5.1. High-level use cases

Figure 4 presents a high-level use case diagram as specified in MEF 110
[[MEF110](#8-references)]. This picture aims to help understand endpoint
mapping. Use cases are described extensively in
[chapter 6](#6-api-interactions-and-flows)

![Figure 4](media/useCases.png)

**Figure 4. High-level use cases**

## 5.2. API Endpoint and Operation Description

**Base URL for Cantata**:
`https://{{serverBase}}:{{port}}{{?/seller_prefix}}/mefApi/cantata/productOfferingAvailabilityAndPricingDiscovery/v1/`

**Base URL for Sonata**:
`https://{{serverBase}}:{{port}}{{?/seller_prefix}}/mefApi/sonata/productOfferingAvailabilityAndPricingDiscovery/v1/`

**_Note:_** All examples will include only the Sonata version of the Base Path.

Table 2 lists the API endpoints with mapping to business use cases:

| API endpoint                        | Description                                                                                                                            | MEF 110 Use case mapping                                    |
| ----------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------- |
| `POST /productOfferingAvailability` | A request initiated by the Buyer to receive a list of zero or more Product Offering Configurations                                     | UC 1: Retrieve Product Offering Availability                |
| `POST /pricingDiscovery`            | A request initiated by the Buyer to receive a list of one or more terms and pricing information for the Product Offering Configuration | UC 2: Retrieve Pricing for a Product Offering Configuration |

**Table 2. Seller side endpoints.**

**[R1]** The Buyer implementation **MUST** be able to use all REST methods that
are listed in Table 2. [MEF110 R1], [MEF110 R2], [MEF110 R29], [MEF110 R30]

## 5.3. Specifying the Buyer ID and the Seller ID

A business entity willing to represent multiple Buyers or multiple Sellers must
follow requirements of MEF 79 [[MEF79](#8-references)] chapter 8.8, which
states:

<!-- TODO update to 150 when ready-->

> For requests of all types, there is a business entity that is initiating an
> Operation (called a Requesting Entity) and a business entity that is
> responding to this request (called the Responding Entity). In the simplest
> case, the Requesting Entity is the Buyer and the Responding Entity is the
> Seller. However, in some cases, the Requesting Entity may represent more than
> one Buyer, and similarly, the Responding Entity may represent more than one
> Seller.
>
> While it is outside the scope of this specification, it is assumed that the
> Requesting Entity and the Responding Entity are aware of each other and can
> authenticate requests initiated by the other party. It is further assumed
> that both the Buying Entity and the Requesting Entity know:
>
> a) the list of Buyers the Requesting Entity represents when interacting with
> this Responding Entity; and  
> b) the list of Sellers that this Responding Entity represents to this
> Requesting Entity.

In the API the `buyerId` and `sellerId` are represented as an optional query
parameters in each defined operation.

**[R2]** If the Requesting Entity has the authority to represent more than one
Buyer the request **MUST** include the `buyerId` query parameter that
identifies the Buyer being represented [MEF79 R80]

**[R3]** If the Requesting Entity represents precisely one Buyer with the
Responding Entity, the request **MUST NOT** specify the `buyerId` [MEF79 R81]

**[R4]** If the Responding Entity represents more than one Seller to this Buyer
the request **MUST** include the `sellerId` query parameter that identifies the
The seller with whom this request is associated [MEF79 R82]

**[R5]** If the Responding Entity represents precisely one Seller to this
Buyer, the request **MUST NOT** specify the `sellerId` [MEF79 R83]

## 5.4. Integration of Product Specifications into the API

Product specification schemas are defined and provided using JsonSchema
(draft 7) format and are integrated into the API using the extension pattern.

The extension hosting type in the API data model is `MEFProductConfiguration`.
The `@type` attribute of that type must be set to a value that uniquely
identifies the product specification. A unique identifier for MEF standard
product specifications is in URN format and is assigned by MEF. This identifier
is provided as root schema `$id` and in product specification documentation.
Use of non-MEF standard product definitions is allowed. In such a case the
schema identifier must be agreed upon between the Buyer and the Seller.

![Figure 5](media/extension_pattern.png)

**Figure 5. The Extension Pattern**

Figure 5 presents two MEF `<<ProductSpecifications>>` that represent Access
E-Line OVC and Carrier Ethernet Operator UNI products. When these products are
used as a Product Offering Availability or Pricing Discovery payload the
`@type` of `MEFProductConfiguration` takes
`"urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all"` or
`"urn:mef:lso:spec:sonata:carrier-ethernet-operator-uni:v5.0.0:all"` value to
indicate which product specification schema must be used to interpret a set of
product-specific attributes included in the payload. An example of a product
definition inside the `ProductOrderItem` is presented in
[Section 6.1.6](#616-use-case-1a-product-order-item-to-install-product).

The _all_ suffix after the product type name in the URN indicates that the
schema can be used in the context of all APIs (POQ, Quote, Order, or
Inventory).

The example below shows a header of a Product Specification schema, which is
referring to the Access E-Line OVC, where
`"$id": urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all` is the
abovementioned URN:

```yaml
'$schema': http://json-schema.org/draft-07/schema#
'$id': urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all
title: MEF LSO Sonata - Access Eline OVC Product Schema
```

Product specifications are provided as Json schemas without the
`MEFProductConfiguration` context.

Product-specific attributes are introduced via the
`ProductOfferingConfiguration`. This entity has the `productConfiguration`
attribute of type `MEFProductConfiguration` which is used as an extension point
for product-specific attributes.

Implementations might choose to integrate selected product specifications into
the data model during development. In such a case an integrated data model is
built and product specifications are in an inheritance relationship with
`MEFProductConfiguration` as described in the OAS specification. This pattern
is called **Static Binding**. The SDK is additionally shipped with a set of API
definitions that statically bind all product-related APIs (POQ, Quote, Order,
Inventory) with all corresponding product specifications available in the
release. The snippet below presents an example of a static binding of the
envelope API with two product specifications. This is a subset of one yaml file
describing the API. Some attributes and their descriptions are truncated for
readability.

```yaml
MEFProductConfiguration:
  description:
    MEFProductConfiguration is used as an extension point for MEF-specific
    product/service payload. The `@type` attribute is used as a discriminator
  discriminator:
    mapping:
      urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all: '#/components/schemas/AccessElineOvc'
      urn:mef:lso:spec:sonata:carrier-ethernet-operator-uni:v5.0.0:all: '#/components/schemas/CarrierEthernetOperatorUni'
    propertyName: '@type'
  properties:
    '@type':
      description:
        The name of the type, defined in the JSON schema specified above, for
        the product that is the subject of the Request. The named type must be
        a subclass of MEFProductConfiguration.
      type: string
AccessElineOvc:
  allOf:
    - $ref: '#/components/schemas/MEFProductConfiguration'
    - $ref: '#/components/schemas/AccessElineOvcCommon'
    - type: object
      properties:
        uniEp:
          $ref: '#/components/schemas/AccessElineOvcEndPoint'
          description:
            MEF 26.2 sec. 16 - The OVC EP object for the OVC EP at the UNI. The
            UNI OVC End Point must be included in the Access E-Line Product.
        enniEp:
          $ref: '#/components/schemas/AccessElineOvcEndPoint'
          description:
            MEF 26.2 sec. 16 - The OVC EP object for the OVC EP at the ENNI.
            The ENNI OVC End Point must be included in the Access E-Line
            Product.
CarrierEthernetOperatorUni:
      allOf:
        - $ref: '#/components/schemas/MEFProductConfiguration'
        - properties:
            listOfPhysicalLinks:
              type: array
              items:
                $ref: '#/components/schemas/UniPhysicalLink'
              minItems: 1
              uniqueItems: true
            linkAggregation:
              $ref: '#/components/schemas/LinkAggType'
            aggregationLinkMap:
              type: array
              items:
                $ref: '#/components/schemas/ConversationIdToAggregationLinkMap'
              minItems: 0
              uniqueItems: true
            maximumServiceFrameSize:
              type: integer
              minimum: 1522
            ...
```

Alternatively, implementations might choose not to build an integrated model
and choose a different mechanism allowing runtime validation of
product-specific fragments of the payload. The system can validate a given
product against a new schema without redeployment. This pattern is called
**Dynamic Binding.**

Regardless of chosen implementation pattern, the HTTP payload is exactly the
same. Both implementation approaches must conform to the requirements specified
below.

**[R6]** `MEFProductConfiguration` type is an extension point that **MUST** be
used to integrate product specifications' properties into a request/response
payload.

**[R7]** The `@type` property of `MEFProductConfiguration` **MUST** be used to
specify the type of the extending entity.

**[R8]** Product attributes specified in the payload must conform to the
product specification specified in the `@type` property.

## 5.5. Sample Product Specification

The SDK contains product specification definitions, from which UNI and Access
E-Line (OVC) are used in the payload samples in this section. They are located
in the SDK package at:

`\productSchema\carrierEthernet\operatorEthernet\accessEline\accessElineOvc.yaml`
`\productSchema\carrierEthernet\operatorEthernet\carrierEthernetOperatorUni\carrierEthernetOperatorUni.yaml`

The product specification data model definitions are available as JsonSchema
(version `draft 7`) documents. Figures 6 and 7 present an instance diagram of
OVC and UNI products with simplified configuration. This document aims to
explain the pattern of exchanging product-specific attributes, not to explain
the particular product itself.

![Figure 6](media/productAEL.png)

**Figure 6. Access E-Line OVC Product Shortened Configuration Example**

![Figure 7](media/productUNI.png)

**Figure 7. Operator Carrier Ethernet UNI Product Shortened Configuration
Example**

Product specifications define several product-related and envelope-related
requirements. For example:

- for an Access E-Line OVC product two mandatory relationship roles must be
  specified, one with the Operator ENNI (`ENNI_REFERENCE`) and a second with
  the operator UNI (`UNI_REFERENCE`). First must be realized as a product
  relationship (relation to product existing in Seller's Inventory), second
  might be realized as an order item (being part of the same order) or as a
  product relationship
- in the case of a `modify` action, product relationships must have the same
  value as in the `add` action. They must not be changed
- for an Operator UNI product a place relationship (`INSTALL_LOCATION`) must be
  specified
- in the case of a `modify` action, place relationships must have the same
  value as in the `add` action. They must not be changed

Figure 8 presents the Access E-Line product required relations. The Access
E-Line OVC has two product relationships:

- towards ENNI - `ENNI_REFERENCE`
- towards UNI - `UNI_REFERENCE`

The UNI product has one place relationship pointing to `INSTALL_LOCATION`.

![Figure 8](media/productAELRelationships.png)

**Figure 8. Operator Carrier Ethernet UNI Product Shortened Configuration
Example**

In case, some of these requirements are violated the Seller returns an error
response to the Buyer that indicates specific functional errors. These errors
are listed in the response body (a list of `Error422` entries) for HTTP `422`
response.

## 5.6. Model Structural Validation

The structure of the HTTP payloads exchanged via Address Validation API
endpoints is defined using OpenAPI version 3.0.

**[R9]** Implementations **MUST** use payloads that conform to these
definitions.

## 5.7. Security Considerations

There must be an authentication mechanism whereby a Seller can be assured who a
Buyer is and vice-versa. There must also be authorization mechanisms in place
to control what a particular Buyer or Seller is allowed to do and what
information may be obtained. However, the definition of the exact security
mechanism and configuration is outside the scope of this document. It is
specified by a separate MEF Project (MEF 128).

# 6. API Interaction & Flows

This section provides a detailed insight into the API functionality, use cases,
and flows. First, it presents a list of business use cases and then provides
examples with a comprehensive explanation of all usage aspects.

| Use Case # | Use Case Name                                         | Use Case Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ---------- | ----------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 1          | Retrieve Product Offering Availability                | The Buyer requests a list of available Product Offering Configurations from the Seller for a specific Product Specification within the specified Delivery Context. The Seller responds to the Buyer with a list of Product Offering Configurations meeting the Buyer's criteria and the Installation Interval for each for the specified Delivery Context of these. Each Product Offering Configuration has a unique identifier that is passed to the Buyer by the Seller. This identifier is used for Use Case 2. |
| 2          | Retrieve Pricing for a Product Offering Configuration | The Buyer requests a list of Commercial and Contractual Options from the Seller for a specific Product Offering Configuration Identifier. The Seller synchronously responds to the Buyer with a list of Commercial and Contractual Options meeting the Buyer's Product Offering Configuration.                                                                                                                                                                                                                     |

**Table 3. Use cases description**

The detailed business requirements of each of the use cases are described in
section 8 of MEF 110 [[MEF110](#8-references)].

## 6.1. Use case 1: Retrieve Product Offering Availability

To send a Retrieve Product Offering Availability request the Buyer uses the
`POST /productOfferingAvailability`. The retrieve operation is performed with a
`POST` operation to allow passing complex data structure of the Delivery
Context as a request payload.

The flow is a simple request-response pattern, as presented in Figure 9:

![Figure 9](media/uc1flow.png)

**Figure 9. Use Case 1 Flow**

Figure 10 presents the model of Use Case 1. The request uses
`ProductOfferingAvailability_Request` as the root object and the response is
provided with the use of `ProductOfferingAvailability`.

![Figure 10](media/uc1model.png)

**Figure 10. Use Case 1 Product Offering Availability Model**

### 6.1.1 Request

The question that the Buyer asks with this request is "What
`availableProductOfferingConfigurations` of product of given
`productSpecification` can you provide me with given delivery context?".

The context can be provided by:

- `place` - a reference to a Geographic Address or Site where the product is to
  be installed. This applies to location-oriented products, e.g. Operator UNI.
- `productRelationship` - relation to an existing product to which product
  being asked for references, e.g. Access E-Line OVC pointing to UNI and ENNI
  products.
- `productRef` - in case of modification request a reference to an existing
  product that is to be updated. In this case, there is no need to provide
  additional context.

**_Note:_** The `place` can be provided by a reference or by value. Please
refer to MEF 79 [[MEF79](#8-references)] and MEF 79.0.2
[[MEF79.0.2](#8-references)] for details on Address and Site modeling and
example. This API specification contains a model of Address and Site but does
not define it. Any further changes of these types will update the API
specification, but will not be reflected in this document.

The following snippet shows the body of a Product Offering Availability check
request:

`ProductOfferingAvailability_Request:`

```json
{
  "action": "add",
  "productSpecification": {
    "id": "urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all"
  },
  "productRelationship": [
    {
      "id": "UNI-ID-0001",
      "relationshipType": "CONNECTS_TO_UNI"
    },
    {
      "id": "ENNI-ID-0001",
      "relationshipType": "CONNECTS_TO_ENNI"
    }
  ]
}
```

The request is very simple and has only three parameters:

- `action` - to state if the Buyer is interested in the creation or
  modification of a product.
- `productSpecification`: to point to product specification that is of Buyer's
  interest. For the sake of example, the `id` in the example is the `urn` as
  defined by MEF standard describing the Access E-Line. In practise, this is an
  identifier as presented by the Seller in Product Catalog.
- `productRelationship` - to provide the delivery context. As shown in Figure 8
  Access E-Line requires 2 product relationships. Other products may require
  providing place relationship (e.g. UNI)

**[R10]** If `action=add`, the request **MUST** provide `productSpecification`.
[MEF110 R3]

**[R11]** If `action=add`, the request **MUST NOT** provide `productRef`.
[MEF110 R7]

**[R12]** If `action=add` the request **MUST** only provide `place` that
conform to the requirements of Product Specification (if any). [MEF110 R5],
[MEF110 R9]

**[R13]** If `action=add` the request **MUST** only provide
`productRelationship` that conforms to requirements of Product Specification
(if any). [MEF110 R6], [MEF110 R11]

**[R14]** If `action=modify`, the request **MUST** provide `productRef`.
[MEF110 R4]

**[R15]** If `action=modify`, the request **MUST NOT** provide following
attributes: [MEF110 R8], [MEF110 R10]

- `place`
- `productRelationship`
- `productSpecification`

### 6.1.2 Response

The Seller performs necessary checks for the request's correctness and
compliance with provided Product Specifications and provides a response.

An example of a response to an example of request is presented in the following
snippet:

```json
{
  "action": "add",
  "productSpecification": {
    "id": "urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all"
  },
  "productRelationship": [
    {
      "id": "UNI-ID-0001",
      "relationshipType": "CONNECTS_TO_UNI"
    },
    {
      "id": "ENNI-ID-0001",
      "relationshipType": "CONNECTS_TO_ENNI"
    }
  ],
  "availableProductOfferingConfigurations": [
    {
      "productOffering": {
        "id": "Access E-Line OVC - Low Class of Service"
      },
      "productConfigurationIdentifier": "PC-ID-0001",
      "productConfiguration": {
        "@type": "urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all",
        "maximumFrameSize": 1526,
        "listOfClassOfServiceNames": ["low"],
        "enniEp": {
          "identifier": "ENNI-ID-0001-EndPoint-0001"
        },
        "uniEp": {
          "identifier": "UNI-ID-0001-EndPoint-0001",
          "ingressBandwidthProfilePerClassOfServiceName": [
            {
              "classOfServiceName": "low",
              "bwpFlow": {
                "cir": {
                  "irValue": 0,
                  "irUnits": "MBPS"
                },
                "cirMax": {
                  "irValue": 0,
                  "irUnits": "MBPS"
                },
                "eir": {
                  "irValue": 70,
                  "irUnits": "MBPS"
                },
                "eirMax": {
                  "irValue": 70,
                  "irUnits": "MBPS"
                }
              }
            }
          ]
        }
      },
      "installationInterval": {
        "amount": 3,
        "units": "businessMinutes"
      }
    },
    {
      "productOffering": {
        "id": "Access E-Line OVC - High Class of Service"
      },
      "productConfigurationIdentifier": "PC-ID-0002",
      "productConfiguration": {
        "@type": "urn:mef:lso:spec:sonata:access-eline-ovc:v5.0.0:all",
        "maximumFrameSize": 1526,
        "listOfClassOfServiceNames": ["high"],
        "enniEp": {
          "identifier": "ENNI-ID-0001-EndPoint-0001"
        },
        "uniEp": {
          "identifier": "UNI-ID-0001-EndPoint-0001",
          "ingressBandwidthProfilePerClassOfServiceName": [
            {
              "classOfServiceName": "high",
              "bwpFlow": {
                "cir": {
                  "irValue": 200,
                  "irUnits": "MBPS"
                },
                "cirMax": {
                  "irValue": 200,
                  "irUnits": "MBPS"
                },
                "eir": {
                  "irValue": 0,
                  "irUnits": "MBPS"
                },
                "eirMax": {
                  "irValue": 0,
                  "irUnits": "MBPS"
                }
              }
            }
          ]
        }
      },
      "installationInterval": {
        "amount": 3,
        "units": "businessMinutes"
      }
    }
  ]
}
```

Figure 11 presents the general structure of the response. It echoes back the
Buyer's request and provides a list of
`availableProductOfferingConfigurations`. For better readability the details of
`productConfigurations` are `"<<skipped>>"` and will be presented on further
figures.

![Figure 11](media/uc1responseStructure.png)

**Figure 11. UC1 Response structure**

In this example in the given Delivery Context and Product Specification the
Seller has two possible Product Configurations. Each has its own distinct
`productConfigurationIdentifier` and is from a different Product Offering of
Access E-Line OVC. Different available Product Configurations can potentially
be from the same Product Offering as well.

**_Note:_** The `productConfigurationIdentifier` identifies only the Product
Specific Attributes values as provided in the `productConfiguration` attribute.
It does not identify the action or the delivery context. This allows to ask for
Pricing Discovery of the same `productConfiguration` in different delivery
contexts.

![Figure 12](media/uc1responsePC1.png)

**Figure 12. UC1 Response Product Configuration 1**

![Figure 13](media/uc1responsePC2.png)

**Figure 13. UC1 Response Product Configuration 2**

Figures 12 and 13 present details of two product configurations and highlight
discrepancies between them. The first one has a `low` class of service and has
`eir` and `eirMax` attributes set to `70 MBPS`. This means it offers a
best-effort bandwidth of a maximum 70 MBPS. The second one is of a `high` class
of service and has the `cir` and `cirMax` set to `200 MBPS` thus offering a
guaranteed bandwidth of `200 MBPS`.

**[R16]** The Seller **MUST** echo back the attributes of the Buyer's Product
Offering Availability request. [MEF110 R17]

**[R17]** The Seller **MUST NOT** return a response that contains
`productConfigurations` that differ only by `installationInterval` (in which
all other attributes are the same). [MEF110 R18]

**[R18]** If the request is successful, the response given by the Seller
**MUST** include a list of zero or more
`availableProductOfferingConfigurations`. [MEF110 R19]

**[R19]** If the request is unsuccessful or fails validation, the Seller
**MUST** return an `Error` response with the appropriate Error Code. [MEF110
R20]

**[R20]** For each returned `ProductOfferingConfiguration` the Seller **MUST**
include following attributes: [MEF110 R21], [MEF110 R22], [MEF110 R24], [MEF110
R26]

- `installationInterval`
- `productOffering`
- `productConfigurationIdentifier`
- `productConfiguration`

**[R21]** Every returned `productConfigurationIdentifier` **MUST** uniquely
identify a `productConfiguration` within the Seller. [MEF110 R21]

**[R22]** Every returned `productConfiguration` **MUST** contain only
attributes specified by Product Specification. [MEF110 R25]

**[R23]** `productConfigurationIdentifier` **MUST** be valid for Pricing
Discovery request for a period of at least 15 minutes. [MEF110 R28]

## 6.2. Use case 2: Retrieve Pricing for a Product Offering Configuration

This Use Case allows the Buyer to perform a Pricing Discovery (ask for
Commercial and Contractual Options) for a specific Product Configuration
identified by `productConfigurationIdentifier` (most probably) obtained in
previous use case.

This can be done with the use of the `POST /pricingDiscovery` operation. The
retrieve operation is performed with a `POST` operation to allow passing the
complex data structure of the Delivery Context as a request payload.

The flow is a simple request-response pattern, as presented in Figure 14:

![Figure 14](media/uc2flow.png)

**Figure 14. Retrieve Address by Identifier Flow**

Figure 15 presents the model of Use Case 1. The request uses
`PricingDiscovery_Request` as the root object and the response is provided with
use of `PricingDiscovery`.

![Figure 15](media/uc2model.png)

**Figure 15. Use Case 2 Pricing Discovery Model**

### 6.2.1 Request

The question that the Buyer asks with this request is "What `PricingAndTerms`
for a `productConfigurationIdentifier` can you provide me with given delivery
context?".

The rules of providing the delivery context are the same as described in Use
Case 1.

The following snippet shows the body of a Price Discovery request:

`PriceDiscovery_Request:`

```json
{
  "action": "add",
  "productRelationship": [
    {
      "id": "UNI-ID-0001",
      "relationshipType": "CONNECTS_TO_UNI"
    },
    {
      "id": "ENNI-ID-0001",
      "relationshipType": "CONNECTS_TO_ENNI"
    }
  ],
  "productConfigurationIdentifier": "PC-ID-0002"
}
```

The request is very simple and has only three parameters:

- `action` - to state if the Buyer is interested in the creation or
  modification of a product.
- `productConfigurationIdentifier`: to refer to Product Configuration that the
  Buyer is willing to price
- `productRelationship` - to provide the delivery context. As shown on Figure 8
  Access E-Line requires 2 product relationships. Other products may require
  providing place relationship (e.g. UNI)

**[R24]** The request **MUST** provide `productConfigurationIdentifier`.
[MEF110 R31], [MEF110 R33]

**[R25]** If `action=add` and the Product Specification defines mandatory place
relations, the request **MUST** provide them accordingly in the `place`
attribute. [MEF110 R31]

**[R26]** If `action=add` and the Product Specification (derived from
`productConfigurationIdentifier`) defines mandatory product relations, the
request **MUST** provide them accordingly in the `productRelationship`
attribute. [MEF110 R6], [MEF110 R132]

**[R27]** If `action=add`, the request **MUST NOT** provide `productRef`.
[MEF110 R32]

**[R28]** If `action=modify`, the request **MUST** provide `productRef`.
[MEF110 R33]

**[R29]** If `action=add` the request **MUST** only provide
`productRelationship` that conforms to requirements of Product Specification
(if any). [MEF110 R35], [MEF110 R36], [MEF110 R40]

**[R30]** If `action=add` the request **MUST** only provide a `place` that
conform to the requirements of Product Specification (if any). [MEF110 R37],
[MEF110 R38], [MEF110 R41], [MEF110 R42]

### 6.2.1 Response

The Seller performs necessary checks for the request's correctness, compliance
with provided Product Specification, and `productConfigurationIdentifier`
validity and then provides a response.

An example of a response to an example of request is presented in the following
snippet:

```json
{
  "action": "add",
  "productRelationship": [
    {
      "id": "UNI-ID-0001",
      "relationshipType": "CONNECTS_TO_UNI"
    },
    {
      "id": "ENNI-ID-0001",
      "relationshipType": "CONNECTS_TO_ENNI"
    }
  ],
  "productConfigurationIdentifier": "PC-ID-0002",
  "pricingAndTerms": [
    {
      "term": {
        "duration": {
          "amount": 12,
          "units": "calendarMonths"
        },
        "endOfTermAction": "roll",
        "name": "1-year term",
        "rollInterval": {
          "amount": 1,
          "units": "calendarMonths"
        }
      },
      "validFor": {
        "startDateTime": "2023-06-02T12:24:48.687Z",
        "endDateTime": "2023-06-09T12:24:48.687Z"
      },
      "subjectToAdditionalNonrecurringCharges": true,
      "price": [
        {
          "price": {
            "taxRate": 10,
            "taxIncludedAmount": {
              "unit": "EUR",
              "value": 110
            },
            "dutyFreeAmount": {
              "unit": "EUR",
              "value": 100
            }
          },
          "name": "Monthly price for a 1-year subscription",
          "priceType": "recurring",
          "recurringChargePeriod": "month"
        }
      ],
      "firm": true,
      "installationInterval": {
        "amount": 3,
        "units": "businessMinutes"
      },
      "productOffering": {
        "id": "Access E-Line OVC - High Class of Service"
      }
    },
    {
      "term": {
        "duration": {
          "amount": 36,
          "units": "calendarMonths"
        },
        "endOfTermAction": "roll",
        "name": "3-year term",
        "rollInterval": {
          "amount": 1,
          "units": "calendarMonths"
        }
      },
      "validFor": {
        "startDateTime": "2023-06-02T12:24:48.687Z",
        "endDateTime": "2023-06-09T12:24:48.687Z"
      },
      "subjectToAdditionalNonrecurringCharges": true,
      "price": [
        {
          "price": {
            "taxRate": 10,
            "taxIncludedAmount": {
              "unit": "EUR",
              "value": 88
            },
            "dutyFreeAmount": {
              "unit": "EUR",
              "value": 80
            }
          },
          "name": "Monthly price for a 3-year subscription",
          "priceType": "recurring",
          "recurringChargePeriod": "month"
        }
      ],
      "firm": true,
      "installationInterval": {
        "amount": 3,
        "units": "businessMinutes"
      },
      "productOffering": {
        "id": "Access E-Line OVC - High Class of Service"
      }
    }
  ]
}
```

Figure 16 presents the Seller's response. It echoes back the Buyer's request
and provides a list of `pricingAndTerms`. In this example in the given Delivery
Context and `productConfigurationIdentifier` the Seller has two possible
`PricingAndTerms`. Discrepancies between them are highlighted. The first one is
for a 1-year contract with a 110 EUR monthly rate, the other is for a 3-year
contract with a 88 EUR monthly rate. Each has its own distinct `identifier`.

![Figure 16](media/uc2response.png)

**Figure 16. UC2 Response**

**[R31]** The Seller **MUST** echo back the attributes of the Buyer's Pricing
Discovery request. [MEF110 R48] Sample request:

**[R32]** If the request is successful, the response given by the Seller
**MUST** include a list of zero or more `pricingAndTerms`. [MEF110 R44]

**[R33]** For each returned `PricingAndTerm` the Seller **MUST** include
following attributes: [MEF110 R49], [MEF110 R50], [MEF110 R51], [MEF110 R55],
[MEF110 R56], [MEF110 R57]

- `identifier`
- `term`
- `term.endOfTermAction`
- `validFor`
- `price`
- `subjectToAdditionalNonrecurringCharges`

**[D1]** The period of time after `autoRenew` occurs and in which the Buyer can
disconnect the Product without penalty **SHOULD** be agreed to by the Buyer and
Seller. [MEF110 D1]

**[R34]** If the `endOfTermAction` is set to `roll` the Seller **MUST** provide
the `rollInterval` attribute. [MEF110 R53]

**[R35]** If the `endOfTermAction` is set to `autoDisconnect` or `autoRenew`
the Seller **MUST NOT** provide the `rollInterval` attribute. [MEF110 R54]

**[R36]** If a Seller has returned multiple `productConfigurationIdentifiers`
to the Buyer in different Product Offering Availability responses that refer to
the same `productConfiguration` values, then the Seller **MUST** return the
same response to a Pricing Discovery request for a given delivery context that
contains any of those `productConfigurationIdentifiers` that are within their
validity period. [MEF110 R47]

**[D2]** For every unique combination of `productConfigurationIdentifier`,
`action`, `place`, `productAELRelationships`, `term`, `endOfTermAction`,
`rollInterval` and `price`, the Seller **SHOULD** give the `PriceAndTerm` a
consistent `identifier` no matter how many times the Buyer performs the
request. [MEF110 D2]

The following requirements apply to every `QuotePrice` object returned in the
`proce` attribute of the response.

**[R37]** The `recurringChargePeriod` **MUST** be provided if the `priceType`
is `recurring`. [MEF110 R63]

**[R38]** The `recurringChargePeriod` **MUST NOT** be provided if the
`priceType` is `nonRecurring` or `usageBased`. [MEF110 R64]

**[R39]** The `unitOfMeasure` **MUST** be provided if the `priceType` is
`usageBased`. [MEF110 R65]

**[R40]** The `unitOfMeasure` **MUST NOT** be provided if the `priceType` is
`recurring` or `nonRecurring`. [MEF110 R66]

**[R41]** The `priceAndTerms.firm` **MUST** be provided if the `priceType` is
`nonRecurring`. [MEF110 R67]

**[R42]** The `priceAndTerms.firm` attribute **MUST** have the value of `true`
if the `priceType` is `recurring` or `usageBased`. [MEF110 R68]

# 7. API Details

## 7.1. API patterns

### 7.1.1. Indicating errors

Erroneous situations are indicated by appropriate HTTP responses. An error
response is indicated by HTTP status 4xx (for client errors) or 5xx (for server
errors) and appropriate response payload. The Product Order API uses the error
responses as depicted and described below.

Implementations can use HTTP error codes not specified in this standard in
compliance with rules defined in RFC 7231 [[RFC7231](#8-references)]. In such a
case, the error message body structure might be aligned with the `Error`.

![Error response data model](media/errorModel.png)

**Figure 43. Data model types to represent an erroneous response**

#### 7.1.1.1. Type Error

**Description:** Standard Class used to describe API response error Not
intended to be used directly. The `code` in the HTTP header is used as a
discriminator for the type of error returned in runtime.

<table id="T_Error">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>reason*</td>
            <td>string<br/><span style="font-size:10px;font-style:italic">maxLength = 255</span></td>
            <td>Text that explains the reason for the error. This can be shown to a client user.</td>
        </tr><tr>
            <td>message</td>
            <td>string</td>
            <td>Text that provides mode details and corrective actions related to the error. This can be shown to a client user.</td>
        </tr><tr>
            <td>referenceError</td>
            <td>uri<br/><span style="font-size:10px;font-style:italic">format = uri</span></td>
            <td>URL pointing to documentation describing the error</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.2. Type Error400

**Description:** Bad Request.
(https://tools.ietf.org/html/rfc7231#section-6.5.1)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error400">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>code*</td>
            <td><a href="#T_Error400Code">Error400Code</a></td>
            <td>One of the following error codes:</br>
- missingQueryParameter: The URI is missing a required query-string parameter</br>
- missingQueryValue: The URI is missing a required query-string parameter value</br>
- invalidQuery: The query section of the URI is invalid.</br>
- invalidBody: The request has an invalid body</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.3. `enum` Error400Code

**Description:** One of the following error codes:

- missingQueryParameter: The URI is missing a required query-string parameter
- missingQueryValue: The URI is missing a required query-string parameter value
- invalidQuery: The query section of the URI is invalid.
- invalidBody: The request has an invalid body

#### 7.1.1.4. Type Error401

**Description:** Unauthorized.
(https://tools.ietf.org/html/rfc7235#section-3.1)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error401">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>code*</td>
            <td><a href="#T_Error401Code">Error401Code</a></td>
            <td>One of the following error codes:</br>
- missingCredentials: No credentials provided.</br>
- invalidCredentials: Provided credentials are invalid or expired</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.5. `enum` Error401Code

**Description:** One of the following error codes:

- missingCredentials: No credentials provided.
- invalidCredentials: Provided credentials are invalid or expired

#### 7.1.1.6. Type Error403

**Description:** Forbidden. This code indicates that the server understood the
request but refuses to authorize it.
(https://tools.ietf.org/html/rfc7231#section-6.5.3)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error403">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>code*</td>
            <td><a href="#T_Error403Code">Error403Code</a></td>
            <td>This code indicates that the server understood
the request but refuses to authorize it because
of one of the following error codes:</br>
- accessDenied: Access denied</br>
- forbiddenRequester: Forbidden requester</br>
- tooManyUsers: Too many users</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.7. `enum` Error403Code

**Description:** This code indicates that the server understood the request but
refuses to authorize it because of one of the following error codes:

- accessDenied: Access denied
- forbiddenRequester: Forbidden requester
- tooManyUsers: Too many users

#### 7.1.1.8. Type Error422

**Description:** Unprocessable entity due to a business validation problem.
(https://tools.ietf.org/html/rfc4918#section-11.2)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error422">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>code*</td>
            <td><a href="#T_Error422Code">Error422Code</a></td>
            <td>One of the following error codes:</br>
  - missingProperty: The property the Seller has expected is not present in the payload</br>
  - invalidValue: The property has an incorrect value</br>
  - invalidFormat: The property value does not comply with the expected value format</br>
  - referenceNotFound: The object referenced by the property cannot be identified in the Seller system</br>
  - unexpectedProperty: Additional property, not expected by the Seller has been provided</br>
  - tooManyRecords: the number of records to be provided in the response exceeds the Seller&#x27;s threshold.</br>
  - otherIssue: Other problem was identified (detailed information provided in a reason)</br>
</td>
        </tr><tr>
            <td>propertyPath</td>
            <td>string</td>
            <td>A pointer to a particular property of the payload that caused the validation issue. It is highly recommended that this property should be used.
Defined using JavaScript Object Notation (JSON) Pointer (https://tools.ietf.org/html/rfc6901).
</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.9. `enum` Error422Code

**Description:** One of the following error codes:

- missingProperty: The property the Seller has expected is not present in the
  payload
- invalidValue: The property has an incorrect value
- invalidFormat: The property value does not comply with the expected value
  format
- referenceNotFound: The object referenced by the property cannot be identified
  in the Seller system
- unexpectedProperty: Additional property, not expected by the Seller has been
  provided
- tooManyRecords: the number of records to be provided in the response exceeds
  the Seller's threshold.
- otherIssue: Other problem was identified (detailed information provided in a
  reason)

#### 7.1.1.10. Type Error500

**Description:** Internal Server Error.
(https://tools.ietf.org/html/rfc7231#section-6.6.1)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error500">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>code*</td>
            <td>string</td>
            <td>The following error code:</br>
- internalError: Internal server error - the server encountered an unexpected condition that prevented it from fulfilling the request.</td>
        </tr>
    </tbody>
</table>

## 7.2. API Data model

### 7.2.1. Product Offering Availability

#### 7.2.1.1 Type ProductOfferingAvailability_Common

**Description:** Common attributes for ProductOfferingAvailability_Request and
ProductOfferingAvailability

<table id="T_ProductOfferingAvailability_Common" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>action</td>
            <td><a href="#T_ProductActionAddModifyType">ProductActionAddModifyType</a></td>
            <td>M</td>
            <td>The action to be performed by the Seller to fulfil any Order that results from this interaction.</td>
            <td>Action</td>
        </tr><tr>
        <td>productRef</td>
            <td><a href="#T_ProductRef">ProductRef</a></td>
            <td>O</td>
            <td>A reference to a Product in the Product Inventory. It MUST be provided when the &#x60;action&#x60; &#x3D; &#x60;modify&#x60;. It MUST NOT be provided when the &#x60;action&#x60; &#x3D; &#x60;add&#x60;
</td>
            <td>Product Identifier</td>
        </tr><tr>
        <td>productSpecification</td>
            <td><a href="#T_ProductSpecificationRef">ProductSpecificationRef</a></td>
            <td>O</td>
            <td>A reference to a Product Specification used to describe the Product. This MUST be provided when the &#x60;action&#x60; is &#x60;add&#x60;. It MUST NOT be provided when the &#x60;action&#x60; &#x3D; &#x60;modify&#x60;</td>
            <td>Product Specification Identifier</td>
        </tr><tr>
        <td>productRelationship</td>
            <td><a href="#T_ProductRelationship">ProductRelationship</a>[]</td>
            <td>O</td>
            <td>A list of Product Relationships as defined by the Product Specification.</td>
            <td>Product Relationships</td>
        </tr><tr>
        <td>place</td>
            <td><a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>[]</td>
            <td>O</td>
            <td>A list of Addresses or Sites and their roles with relation to the Product.</td>
            <td>Locations</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.2. Type ProductOfferingAvailability_Request

**Description:** Product Offering Availability Request allows the Buyer to
provide the action, delivery context and Product Specification to ask the
Seller to provide a list of available Product Offering Configurations.

Inherits from:

- <a href="#T_ProductOfferingAvailability_Common">ProductOfferingAvailability_Common</a>

#### 7.2.1.3. Type ProductOfferingAvailability

**Description:** Product Offering Availability allows the Seller to provide the
list of Product Offering Configurations matching action, delivery context and
Product Specification provided by the Buyer

Inherits from:

- <a href="#T_ProductOfferingAvailability_Common">ProductOfferingAvailability_Common</a>

<table id="T_ProductOfferingAvailability" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>availableProductOfferingConfigurations</td>
            <td><a href="#T_ProductOfferingConfiguration">ProductOfferingConfiguration</a>[]<br/><span style="font-size:10px;font-style:italic">minItems = 0</span></td>
            <td>M</td>
            <td></td>
            <td>Not represented in MEF 110</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.4. `enum` ProductActionAddModifyType

**Description:** Action to be performed on the Product.

The following mapping has been used between `ProductActionType` and MEF 110:

| ProductActionType | MEF 110 |
| ----------------- | ------- |
| add               | INSTALL |
| modify            | CHANGE  |

#### 7.2.1.5. Type ProductRelationship

**Description:** A relationship to an existing Product. The requirements for
usage for given Product are described in the Product Specification.

<table id="T_ProductRelationship" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to the product in Seller&#x27;s inventory that is referenced Hyperlink MAY be used when providing a response by the Seller Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>Unique identifier of the related Product</td>
            <td>Related Product Identifier</td>
        </tr><tr>
        <td>relationshipType</td>
            <td>string</td>
            <td>M</td>
            <td>Specifies the type (nature) of the relationship to the related Product. The nature of required relationships varies for Products of different types. For example, a UNI or ENNI Product may not have any relationships, but an Access E-Line may have two mandatory relationships (related to the UNI on one end and the ENNI on the other). More complex Products such as multipoint IP or Firewall Products may have more complex relationships. As a result, the allowed and mandatory &#x60;relationshipType&#x60; values are defined in the Product Specification.
</td>
            <td>Product Relationship Nature</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.6. Type ProductOfferingConfiguration

**Description:** Allows the Seller to provide a detailed information of Product
Configuration matching Buyer's Product Offering Availability Request.

<table id="T_ProductOfferingConfiguration" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>productOffering</td>
            <td><a href="#T_ProductOfferingRef">ProductOfferingRef</a></td>
            <td>M</td>
            <td>A reference for the Product Offering that this configuration must be ordered as.
</td>
            <td>Product Offering Identifier</td>
        </tr><tr>
        <td>productConfigurationIdentifier</td>
            <td>string</td>
            <td>M</td>
            <td>An identifier of the returned &#x60;productConfiguration&#x60; that can be used in next step for Pricing Discovery
</td>
            <td>Product Offering Configuration Identifier</td>
        </tr><tr>
        <td>productConfiguration</td>
            <td><a href="#T_MEFProductConfiguration">MEFProductConfiguration</a></td>
            <td>M</td>
            <td>MEFProductConfiguration is used to specify the product specific attributes. The @type is used as a discriminator. It holds the detailed configuration of the product attributes.</td>
            <td>Product Specific Attributes</td>
        </tr><tr>
        <td>installationInterval</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>M</td>
            <td>The indicative duration &gt;0 for the delivery of the configuration in the specified Delivery Context when manual work is required. The shortest interval is specified by the Seller. It is not considered a commitment by the Seller.
</td>
            <td>Installation Interval</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.7. Type ProductOfferingRef

**Description:** A reference to a Product Offering offered by the Seller to the
Buyer.

<table id="T_ProductOfferingRef" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to a Product Offering in Sellers catalog. In case Seller is not providing a catalog API this field is not used. The catalog is provided by the Seller to the Buyer during onboarding. Hyperlink MAY be used by the Seller in responses   Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request.
</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>id of a Product Offering. It is assigned by the Seller. The Buyer and the Seller exchange information about offerings&#x27; ids during the onboarding process.</td>
            <td>Product Offering Identifier</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.8. Type MEFProductConfiguration

**Description:** MEFProductConfiguration is used as an extension point for MEF
specific product/service payload. The `@type` attribute is used as a
discriminator

<table id="T_MEFProductConfiguration" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>@type</td>
            <td>string</td>
            <td>M</td>
            <td>The name of the type that uniquely identifies the type of the product that is the subject of the POQ Request. In case of MEF product this is the URN provided in the Product Specification.</td>
            <td>Not represented in MEF 110</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.9. Type ProductRef

**Description:** A reference to a Product in the Product Inventory

<table id="T_ProductRef" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>Unique identifier of a Product</td>
            <td>Product Identifier</td>
        </tr><tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to a Product instance in Sellers Product Inventory. Hyperlink MAY be used by the Seller in responses. Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request.</td>
            <td>Not represented in MEF 110</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.10. Type ProductSpecificationRef

**Description:** A reference to a structured set of well-defined technical
attributes and/or behaviors that are used to construct a Product Offering for
sale to a market.

<table id="T_ProductSpecificationRef" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to a Product Specification in Sellers catalog. In case Seller is not providing a catalog API this field is not used. The catalog is provided by the Seller to the Buyer during onboarding. Hyperlink MAY be used by the Seller in responses. Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request.
</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>Unique identifier of the Product Specification</td>
            <td>Product Specification Identifier</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.11. Type MEFItemTerm

**Description:** Describes a term (also known as commitment)

<table id="T_MEFItemTerm" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>duration</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>M</td>
            <td>Duration of the term</td>
            <td>Duration</td>
        </tr><tr>
        <td>endOfTermAction</td>
            <td><a href="#T_MEFEndOfTermAction">MEFEndOfTermAction</a></td>
            <td>M</td>
            <td>The action the Seller will take once the term expires.</td>
            <td>End of Term Action</td>
        </tr><tr>
        <td>name</td>
            <td>string</td>
            <td>M</td>
            <td>Name of the term</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>description</td>
            <td>string</td>
            <td>O</td>
            <td>Description of the term</td>
            <td>Description</td>
        </tr><tr>
        <td>rollInterval</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>O</td>
            <td>The recurring period that the Buyer is required to pay at the end of the term to extend the term after the original term has expired. If &#x60;endOfTermAction&#x60; is equal to &#x60;roll&#x60; then &#x60;rollInterval&#x60; MUST be specified. If &#x60;endOfTermAction&#x60; is equal to &#x60;autoRenew&#x60; or &#x60;autoDisconnect&#x60;, then &#x60;rollInterval&#x60; MUST NOT be specified.</td>
            <td>Roll Interval</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.12. Type Duration

**Description:** A Duration in a given unit of time e.g. 3 hours, or 5 days.

<table id="T_Duration" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>amount</td>
            <td>integer<br/><span style="font-size:10px;font-style:italic">minimum = 0</span></td>
            <td>M</td>
            <td>Duration (number of seconds, minutes, hours, etc.)</td>
            <td>Amount</td>
        </tr><tr>
        <td>units</td>
            <td><a href="#T_TimeUnit">TimeUnit</a></td>
            <td>M</td>
            <td>Time unit enumerated</td>
            <td>Units</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.13. Type TimePeriod

**Description:** A period of time, either as a deadline (endDateTime only) a
startDateTime only, or both.

<table id="T_TimePeriod" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>startDateTime</td>
            <td>date-time<br/><span style="font-size:10px;font-style:italic">format = date-time</span></td>
            <td>O</td>
            <td>Start of the time period, using IETC-RFC-3339 format. If you define a start, you must also define an end</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>endDateTime</td>
            <td>date-time<br/><span style="font-size:10px;font-style:italic">format = date-time</span></td>
            <td>O</td>
            <td>End of the time period, using IETC-RFC-3339 format</td>
            <td>Valid Until</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.14. `enum` TimeUnit

**Description:** Represents a unit of time.

<table id="T_TimeUnit">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>calendarMonths</td>
            <td>CALENDAR_MONTHS</td>
        </tr><tr>
            <td>calendarDays</td>
            <td>CALENDAR_DAYS</td>
        </tr><tr>
            <td>calendarHours</td>
            <td>CALENDAR_HOURS</td>
        </tr><tr>
            <td>calendarMinutes</td>
            <td>MINUTES</td>
        </tr><tr>
            <td>businessDays</td>
            <td>BUSINESS_DAYS</td>
        </tr><tr>
            <td>businessHours</td>
            <td>BUSINESS_HOURS</td>
        </tr><tr>
            <td>businessMinutes</td>
            <td>MINUTES</td>
        </tr>
    </tbody>
</table>

### 7.2.2. Pricing Discovery

#### 7.2.2.1 Type PricingDiscovery_Common

**Description:** A set of attribute common to PricingDiscovery_Request and
PricingDiscovery

<table id="T_PricingDiscovery_Common" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>action</td>
            <td><a href="#T_ProductActionAddModifyType">ProductActionAddModifyType</a></td>
            <td>M</td>
            <td>The action to be performed by the Seller to fulfill any Order that results from this interaction.</td>
            <td>Action</td>
        </tr><tr>
        <td>productConfigurationIdentifier</td>
            <td>string</td>
            <td>M</td>
            <td>The identifier for the Product Configuration Pricing Discovery is being requested for.
</td>
            <td>Product Offering Configuration Identifier</td>
        </tr><tr>
        <td>productRef</td>
            <td><a href="#T_ProductRef">ProductRef</a></td>
            <td>O</td>
            <td>A reference to a Product in the Product Inventory
</td>
            <td>Product Identifier</td>
        </tr><tr>
        <td>productRelationship</td>
            <td><a href="#T_ProductRelationship">ProductRelationship</a>[]</td>
            <td>O</td>
            <td>A list of Product Relationships as defined by the Product Specification.</td>
            <td>Product Relationships</td>
        </tr><tr>
        <td>place</td>
            <td><a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>[]</td>
            <td>O</td>
            <td>A list of Addresses or Sites and their roles with relation to the Product.</td>
            <td>Locations</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.2. Type PricingDiscovery_Request

**Description:** Pricing Discovery Request allows the Buyer to provide the
action, delivery context and Product Configuration Identifier to ask the Seller
to provide a list of available Pricing and Terms

Inherits from:

- <a href="#T_PricingDiscovery_Common">PricingDiscovery_Common</a>

#### 7.2.2.3. Type PricingDiscovery

**Description:** PricingDiscovery allows the Seller to provide the list of
Pricing and Terms matching action, delivery context and Product Configuration
Identifier provided by the Buyer

Inherits from:

- <a href="#T_PricingDiscovery_Common">PricingDiscovery_Common</a>

<table id="T_PricingDiscovery" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>pricingAndTerms</td>
            <td><a href="#T_PricingAndTerm">PricingAndTerm</a>[]</td>
            <td>M</td>
            <td>Pricing and terms matching Buyer&#x27;s criteria</td>
            <td>Product Offering Config-uration Commercial and Contractual Options</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.4. Type PricingAndTerm

**Description:** Pricing and term specification for an available Product
Configuration

<table id="T_PricingAndTerm" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>identifier</td>
            <td>string</td>
            <td>M</td>
            <td>The identifier of the Pricing and Term.</td>
            <td>Product Offering Configuration Commercial and Contractual Option Identifier</td>
        </tr><tr>
        <td>installationInterval</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>M</td>
            <td>The indicative duration &gt;0 for the delivery of the configuration in the specified Delivery Context when manual work is required. The shortest interval is specified by the Seller. It is not considered a commitment by the Seller.
</td>
            <td>Installation Interval</td>
        </tr><tr>
        <td>term</td>
            <td><a href="#T_MEFItemTerm">MEFItemTerm</a></td>
            <td>M</td>
            <td>The minimum term for this PricingAndTerm for the given productConfigurationIdentifier within the requested Delivery Context.</td>
            <td>Term</td>
        </tr><tr>
        <td>validFor</td>
            <td><a href="#T_TimePeriod">TimePeriod</a></td>
            <td>M</td>
            <td>The date that the PricingAndTerm is valid until. For use in the context of this attribute, only the endDateTime attribute must be used.</td>
            <td>Valid Until Date</td>
        </tr><tr>
        <td>price</td>
            <td><a href="#T_QuotePrice">QuotePrice</a>[]<br/><span style="font-size:10px;font-style:italic">minItems = 1</span></td>
            <td>M</td>
            <td>The prices that apply to this PricingAndTerm for the given Product Configuration within the requested Delivery Context.</td>
            <td>Prices</td>
        </tr><tr>
        <td>subjectToAdditionalNonrecurringCharges</td>
            <td>boolean</td>
            <td>M</td>
            <td>An indicator to inform the Buyer that additional non-recurring charges may be added during fulfillment.</td>
            <td>Subject to Additional Non-recurring Charges</td>
        </tr><tr>
        <td>firm</td>
            <td>boolean</td>
            <td>M</td>
            <td>An indicator specifying whether or not this charge may change during fulfillment.</td>
            <td>Firm</td>
        </tr><tr>
        <td>productOffering</td>
            <td><a href="#T_ProductOfferingRef">ProductOfferingRef</a></td>
            <td>M</td>
            <td>A reference for the Product Offering that this configuration must be ordered as.
</td>
            <td>Not represented in MEF 110</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.5. Type QuotePrice

**Description:** Description of price and discount awarded

<table id="T_QuotePrice" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>name</td>
            <td>string</td>
            <td>M</td>
            <td>Name of the price</td>
            <td>Name</td>
        </tr><tr>
        <td>description</td>
            <td>string</td>
            <td>O</td>
            <td>Description of the price</td>
            <td>Description</td>
        </tr><tr>
        <td>priceType</td>
            <td><a href="#T_MEFPriceType">MEFPriceType</a></td>
            <td>M</td>
            <td>Indicates if the price is for recurring, non-recurring, or usage based charges</td>
            <td>Price Type</td>
        </tr><tr>
        <td>unitOfMeasure</td>
            <td>string</td>
            <td>O</td>
            <td>Unit of Measure if price depending on it (Gb, SMS volume, etc..) MSU be specified when &#x60;priceType&#x60; is &#x60;usageBased&#x60;</td>
            <td>Unit Of Measure</td>
        </tr><tr>
        <td>price</td>
            <td><a href="#T_Price">Price</a></td>
            <td>M</td>
            <td>The associated price</td>
            <td>Price Tax Rate
Price Tax Included Amount
Price Duty Free Amount</td>
        </tr><tr>
        <td>recurringChargePeriod</td>
            <td><a href="#T_MEFChargePeriod">MEFChargePeriod</a></td>
            <td>O</td>
            <td>The recurring duration for which this charge will be applied. MUST be provided if &#x60;priceType is &#x60;recurring&#x60;</td>
            <td>Recurring Charge Period</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.6. `enum` MEFChargePeriod

**Description:** Used for a recurring charge to indicate period.

<table id="T_MEFChargePeriod">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>hour</td>
            <td>HOUR</td>
        </tr><tr>
            <td>day</td>
            <td>DAY</td>
        </tr><tr>
            <td>week</td>
            <td>WEEK</td>
        </tr><tr>
            <td>month</td>
            <td>MONTH</td>
        </tr><tr>
            <td>year</td>
            <td>YEAR</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.7. `enum` MEFEndOfTermAction

**Description:** The action that needs to be taken by the Seller once the term
expires.

| Value          | Description                                                                                                            |
| -------------- | ---------------------------------------------------------------------------------------------------------------------- |
| roll           | The Product's contract will continue on a rolling basis once the contract's initial term ex-pires,                     |
| autoDisconnect | The Product will automatically be disconnected (and contract terminated) by the Seller once the contract term expires, |
| autoRenew      | The Product's contract will be renewed for another term equivalent to the original contract term.                      |

#### 7.2.2.8. `enum` MEFPriceType

**Description:** Indicates if the price is for recurring or non-recurring
charges.

<table id="T_MEFPriceType">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>recurring</td>
            <td>RECURRING</td>
        </tr><tr>
            <td>nonRecurring</td>
            <td>NON_RECURRING</td>
        </tr><tr>
            <td>usageBased</td>
            <td>USAGE_BASED</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.9. Type Money

**Description:** A base/value business entity used to represent money

<table id="T_Money" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>unit</td>
            <td>string</td>
            <td>M</td>
            <td>Currency (ISO4217 norm uses 3 letters to define the currency)</td>
            <td>Currency</td>
        </tr><tr>
        <td>value</td>
            <td>float<br/><span style="font-size:10px;font-style:italic">format = float</span></td>
            <td>M</td>
            <td>A positive floating point number</td>
            <td>Value</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.10. Type Price

**Description:** Provides all amounts (tax included, duty-free, tax rate), used
currency and percentage to apply for Price Alteration.

<table id="T_Price" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>taxRate</td>
            <td>float<br/><span style="font-size:10px;font-style:italic">format = float</span></td>
            <td>O</td>
            <td>Price Tax Rate. Unit: [%]. E.g. value 16 stand for 16% tax.</td>
            <td>Price Tax Rate</td>
        </tr><tr>
        <td>taxIncludedAmount</td>
            <td><a href="#T_Money">Money</a></td>
            <td>O</td>
            <td>All taxes included amount (expressed in the given currency)</td>
            <td>Price Tax Included Amount</td>
        </tr><tr>
        <td>dutyFreeAmount</td>
            <td><a href="#T_Money">Money</a></td>
            <td>M</td>
            <td>All taxes excluded amount (expressed in the given currency)</td>
            <td>Price Duty Free Amount</td>
        </tr>
    </tbody>
</table>

### 7.2.3. Place representation

There are several formats in which place information can be represented. The
model is presented in Figure 43.

![Figure 43](media/placeModel.png)

**Figure 43. Data model types representing a place**

#### 7.2.3.1. Type RelatedPlaceRefOrValue

**Description:** Place defines the places (locations) where the products being
subject of this qualification are to be provided.

<table id="T_RelatedPlaceRefOrValue" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>role</td>
            <td>string</td>
            <td>M</td>
            <td>Role of this place. The values that can be specified here are described by Product Specification (e.g. &quot;INSTALL_LOCATION&quot;).</td>
            <td>Location Role</td>
        </tr><tr>
        <td>@type</td>
            <td>string</td>
            <td>M</td>
            <td>This field is used as discriminator. The value is the name of one of the types that inherit from it using &#x27;allOf&#x27;, i.e. one of FieldedAddress, FormattedAddress, GeographicAddressLabel, MEFGeographicPoint, GeographicAddressRef, GeographicSiteRef. Moreover, it might discriminate for an additional related place as defined in &#x27;@schemaLocation&#x27;.
</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>@schemaLocation</td>
            <td>uri<br/><span style="font-size:10px;font-style:italic">format = uri</span></td>
            <td>O</td>
            <td>A URL to a JSON-Schema file that defines additional attributes and relationships. May be used to define additional related place types. Usage of this attribute must be agreed between Buyer and Seller.</td>
            <td>Not represented in MEF 110</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.2. Type FieldedAddress

**Description:** A type of Address that has a discrete field and value for each
type of boundary or identifier down to the lowest level of detail. For example
"street number" is one field, "street name" is another field, etc.

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_FieldedAddress" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>country</td>
            <td>string</td>
            <td>M</td>
            <td>Country that the address is in</td>
            <td>Country</td>
        </tr><tr>
        <td>streetType</td>
            <td>string</td>
            <td>O</td>
            <td>The type of street (e.g., alley, avenue, boulevard, brae, crescent, drive, highway, lane, terrace, parade, place, tarn, way, wharf)</td>
            <td>Street Type</td>
        </tr><tr>
        <td>postcodeExtension</td>
            <td>string</td>
            <td>O</td>
            <td>An extension of a postal code. E.g. the part following the dash in a US urban property address</td>
            <td>Postal Code Extension</td>
        </tr><tr>
        <td>city</td>
            <td>string</td>
            <td>M</td>
            <td>The city that the address is in</td>
            <td>City</td>
        </tr><tr>
        <td>streetNr</td>
            <td>string</td>
            <td>O</td>
            <td>Number identifying a specific property on a public street. It may be combined with streetNrLast for ranged addresses. MEF 79 defines it as required for the Seller response, however in certain countries it is not used, so it&#x27;s optional in API.</td>
            <td>Street Number</td>
        </tr><tr>
        <td>locality</td>
            <td>string</td>
            <td>O</td>
            <td>The locality that the address is in</td>
            <td>Locality</td>
        </tr><tr>
        <td>postcode</td>
            <td>string</td>
            <td>O</td>
            <td>A descriptor for a postal delivery area, used to speed and simplify the delivery of mail (also known as zip code) MEF 79 defines it as required however as in certain countries it is not used we make it optional in API.</td>
            <td>Postal Code</td>
        </tr><tr>
        <td>streetNrLast</td>
            <td>string</td>
            <td>O</td>
            <td>Last number in a range of street numbers allocated to a property</td>
            <td>Street Number Last</td>
        </tr><tr>
        <td>streetNrSuffix</td>
            <td>string</td>
            <td>O</td>
            <td>The first street number suffix</td>
            <td>Street Number Suffix</td>
        </tr><tr>
        <td>streetName</td>
            <td>string</td>
            <td>M</td>
            <td>Name of the street or other street type</td>
            <td>Street Name</td>
        </tr><tr>
        <td>stateOrProvince</td>
            <td>string</td>
            <td>O</td>
            <td>The State or Province that the address is in</td>
            <td>State Or Province</td>
        </tr><tr>
        <td>streetNrLastSuffix</td>
            <td>string</td>
            <td>O</td>
            <td>Last street number suffix for a ranged address</td>
            <td>Street Number Suffix Last</td>
        </tr><tr>
        <td>geographicSubAddress</td>
            <td><a href="#T_GeographicSubAddress">GeographicSubAddress</a></td>
            <td>O</td>
            <td>Additional fields used to specify an address, as detailed as possible.</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>streetSuffix</td>
            <td>string</td>
            <td>O</td>
            <td>A modifier denoting a relative direction</td>
            <td>Street Suffix</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.3. Type FormattedAddress

**Description:** A type of Address that has discrete fields for each type of
boundary or identifier with the exception of the street and more specific
location details, which are combined into a maximum of two strings based on
local postal addressing conventions.

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_FormattedAddress" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>country</td>
            <td>string</td>
            <td>M</td>
            <td>Country that the address is in</td>
            <td>Country</td>
        </tr><tr>
        <td>postcodeExtension</td>
            <td>string</td>
            <td>O</td>
            <td>An extension of a postal code. E.g. the part following the dash in a US urban property address</td>
            <td>Postal Code Extension</td>
        </tr><tr>
        <td>stateOrProvince</td>
            <td>string</td>
            <td>O</td>
            <td>The State or Province that the address is in</td>
            <td>State Or Province</td>
        </tr><tr>
        <td>city</td>
            <td>string</td>
            <td>M</td>
            <td>The city that the address is in</td>
            <td>City</td>
        </tr><tr>
        <td>addrLine2</td>
            <td>string</td>
            <td>O</td>
            <td>The second address line in a formatted address</td>
            <td>Address Line 2</td>
        </tr><tr>
        <td>addrLine1</td>
            <td>string</td>
            <td>M</td>
            <td>The first address line in a formatted address</td>
            <td>Address Line 1</td>
        </tr><tr>
        <td>locality</td>
            <td>string</td>
            <td>O</td>
            <td>An area of defined or undefined boundaries within a local authority or other legislatively defined area, usually rural or semi-rural in nature</td>
            <td>Locality</td>
        </tr><tr>
        <td>postcode</td>
            <td>string</td>
            <td>O</td>
            <td>A descriptor for a postal delivery area used to speed and simplify the delivery of mail (also known as ZIP code)</td>
            <td>Postal Code</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.4. Type MEFGeographicPoint

**Description:** A MEFGeographicPoint defines a geographic point through
coordinates.

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_MEFGeographicPoint" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>spatialRef</td>
            <td>string</td>
            <td>M</td>
            <td>The spatial reference system used to determine the coordinates (e.g. &quot;WGS84&quot;). The system used and the value of this field are to be agreed during the onboarding process.</td>
            <td>Spatial Reference</td>
        </tr><tr>
        <td>x</td>
            <td>string</td>
            <td>M</td>
            <td>The latitude expressed in the format specified by the &#x60;spacialRef&#x60;</td>
            <td>Latitude</td>
        </tr><tr>
        <td>y</td>
            <td>string</td>
            <td>M</td>
            <td>The longitude expressed in the format specified by the &#x60;spacialRef&#x60;</td>
            <td>Longitude</td>
        </tr><tr>
        <td>z</td>
            <td>string</td>
            <td>O</td>
            <td>The elevation expressed in the format specified by the &#x60;spacialRef&#x60;</td>
            <td>Elevation</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.5. Type GeographicSubAddress

**Description:** Additional fields used to specify an address, as detailed as
possible.

<table id="T_GeographicSubAddress" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>buildingName</td>
            <td>string</td>
            <td>O</td>
            <td>Allows for identification of places that require building name  as part of addressing information
</td>
            <td>Building Name</td>
        </tr><tr>
        <td>subUnit</td>
            <td><a href="#T_MEFSubUnit">MEFSubUnit</a>[]</td>
            <td>O</td>
            <td>Representation of a MEFSubUnit It is used for describing subunit within a subAddress e.g. BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>levelType</td>
            <td>string</td>
            <td>O</td>
            <td>Describes level types within a building</td>
            <td>Level Type</td>
        </tr><tr>
        <td>levelNumber</td>
            <td>string</td>
            <td>O</td>
            <td>Used where a level type may be repeated e.g. BASEMENT 1, BASEMENT 2</td>
            <td>Level Number</td>
        </tr><tr>
        <td>privateStreetNumber</td>
            <td>string</td>
            <td>O</td>
            <td>Private streets numbers internal to a private street</td>
            <td>Private Street Number</td>
        </tr><tr>
        <td>privateStreetName</td>
            <td>string</td>
            <td>O</td>
            <td>Private streets internal to a property (e.g. a university) may have internal names that are not recorded by the land title office</td>
            <td>Private Street Name</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.6. Type GeographicAddressRef

**Description:** A reference to a Geographic Address resource available through
Address Validation API.

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_GeographicAddressRef" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to the referenced Address. Hyperlink MAY be used by the Seller in responses. Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request.
</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>Identifier of the referenced Geographic Address. This identifier is assigned during a successful address validation request (Geographic Address Management API)</td>
            <td>Fielded | Formatted | Geographic Address Label | Geographic Point Identifier</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.7. Type GeographicSiteRef

**Description:** A reference to a Geographic Site resource available through
Service Site API

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_GeographicSiteRef" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>href</td>
            <td>string</td>
            <td>O</td>
            <td>Hyperlink to the referenced Site. Hyperlink MAY be used by the Seller in responses. Hyperlink MUST be ignored by the Seller in case it is provided by the Buyer in a request.
</td>
            <td>Not represented in MEF 110</td>
        </tr><tr>
        <td>id</td>
            <td>string</td>
            <td>M</td>
            <td>Identifier of the referenced Geographic Site.</td>
            <td>Site Identifier</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.8. Type GeographicAddressLabel

**Description:** A unique identifier controlled by a generally accepted
independent administrative authority that specifies a fixed geographical
location.

Inherits from:

- <a href="#T_RelatedPlaceRefOrValue">RelatedPlaceRefOrValue</a>

<table id="T_GeographicAddressLabel" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>externalReferenceId</td>
            <td>string</td>
            <td>M</td>
            <td>The unique reference to an Address as provided by the Administrative Authority.</td>
            <td>Administrative Authority Address Label</td>
        </tr><tr>
        <td>externalReferenceType</td>
            <td>string</td>
            <td>M</td>
            <td>The organization or standard from the organization that administers this Geographic Address Label ensuring it is unique within the Administrative Authority. The value(s) to be used are to be agreed upon during the onboarding. For North American providers this would normally be CLLI (Common Language Location Identifier) code.</td>
            <td>Administrative Authority</td>
        </tr>
    </tbody>
</table>

#### 7.2.3.9. Type MEFSubUnit

**Description:** Allows for sub unit identification

<table id="T_MEFSubUnit" style="width:100%">
    <thead style="font-weight:bold">
        <tr>
            <td>Name</td>
            <td style="width:15%">Type</td>
            <td>M/O</td>
            <td>Description</td>
            <td>MEF 110</td>
        </tr>
    </thead>
    <tbody>
        <tr>
        <td>subUnitNumber</td>
            <td>string</td>
            <td>M</td>
            <td>The discriminator used for the subunit, often just a simple number but may also be a range.</td>
            <td>Sub Unit Name</td>
        </tr><tr>
        <td>subUnitType</td>
            <td>string</td>
            <td>M</td>
            <td>The type of subunit e.g.BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.</td>
            <td>Sub Unit Type</td>
        </tr>
    </tbody>
</table>

# 8. References

- [MEF55.1](https://www.mef.net/wp-content/uploads/2021/02/MEF-55.1.pdf),
  Lifecycle Service Orchestration (LSO): Reference Architecture and Framework,
  February 2021
- [MEF79](https://www.mef.net/wp-content/uploads/2019/11/MEF-79.pdf), Address,
  Service Site, and Product Offering Qualification Management, Requirements and
  Use Cases, November 2019
- [MEF79.0.2](https://www.mef.net/wp-content/uploads/MEF-79.0.2.pdf), Amendment
  to MEF 79: Address Validation, July 2021
- [MEF110](https://www.mef.net/resources/mef-110-product-offering-availability-and-pricing-discovery-business-requirements-and-use-cases/)
  Product Offering Availability and Pricing Discovery - Business Requirements
  and Use Cases, Draft Standard 1, June 2023
- [MEF139] Internet Access Product Schemas and Developer Guide, July 2023
- [RFC2119](https://tools.ietf.org/html/rfc2119), Key words for use in RFCs to
  Indicate Requirement Levels, March 1997
- [RFC7231](https://tools.ietf.org/html/rfc7231), Hypertext Transfer Protocol
  (HTTP/1.1): Semantics and Content, June 2014
  https://tools.ietf.org/html/rfc7231
- [RFC8174](https://tools.ietf.org/html/rfc8174), Ambiguity of Uppercase vs
  Lowercase in RFC 2119 Key Words, May 2017
