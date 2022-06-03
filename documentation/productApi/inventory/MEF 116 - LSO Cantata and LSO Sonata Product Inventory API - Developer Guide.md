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
MEF Standard
</br>
MEF 116
</br>
</br>
LSO Cantata and LSO Sonata Product Inventory API - Developer Guide
</br>
</br>
</br>
</br>
May 2022
</div>

<div class="page"/>

**Disclaimer**

© MEF Forum 2022. All Rights Reserved.

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

© MEF Forum 2022. Any reproduction of this document, or any portion thereof,
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
  - [5.2. Resource/endpoint Description](#52-resourceendpoint-description)
    - [5.2.1. Seller Side Endpoints](#521-seller-side-endpoints)
    - [5.3. Specifying the Buyer ID and the Seller ID](#53-specifying-the-buyer-id-and-the-seller-id)
  - [5.4. Integration of Product Specifications into Product Inventory API](#54-integration-of-product-specifications-into-product-inventory-api)
  - [5.5. Sample Product Specification](#55-sample-product-specification)
  - [5.6. Model Structural Validation](#56-model-structural-validation)
  - [5.7. Security Considerations](#57-security-considerations)
- [6. API Interactions and Flows](#6-api-interactions-and-flows)
  - [6.1. Use case 1: Retrieve Product List](#61-use-case-1-retrieve-product-list)
  - [6.2. Use case 2: Retrieve Product by Identifier](#62-use-case-2-retrieve-product-by-identifier)
- [7. API Details](#7-api-details)
  - [7.1. API patterns](#71-api-patterns)
    - [7.1.1. Indicating errors](#711-indicating-errors)
      - [7.1.1.1. Type Error](#7111-type-error)
      - [7.1.1.2. Type Error400](#7112-type-error400)
      - [7.1.1.3. Type Error401](#7113-type-error401)
      - [7.1.1.4. Type Error403](#7114-type-error403)
      - [7.1.1.5. Type Error404](#7115-type-error404)
      - [7.1.1.6. Type Error422](#7116-type-error422)
      - [7.1.1.7. Type Error500](#7117-type-error500)
    - [7.1.2. Response pagination](#712-response-pagination)
  - [7.2. Management API Data model](#72-management-api-data-model)
    - [7.2.1. Product](#721-product)
      - [7.2.1.1. Type MEFProduct](#7211-type-mefproduct)
      - [7.2.1.2. Type MEFProduct_Find](#7212-type-mefproduct_find)
      - [7.2.1.3. `enum` MEFProductStatusType](#7213-enum-mefproductstatustype)
      - [7.2.1.4. Type MEFProductStatusChange](#7214-type-mefproductstatuschange)
      - [7.2.1.5. Type ProductPrice](#7215-type-productprice)
    - [7.2.2. Common](#722-common)
      - [7.2.2.1. Type Duration](#7221-type-duration)
      - [7.2.2.2. Type FieldedAddress](#7222-type-fieldedaddress)
      - [7.2.2.3. Type GeographicSubAddress](#7223-type-geographicsubaddress)
      - [7.2.2.4. Type MEFSubUnit](#7224-type-mefsubunit)
      - [7.2.2.5. Type MEFBillingAccount](#7225-type-mefbillingaccount)
      - [7.2.2.6. `enum` MEFChargePeriod](#7226-enum-mefchargeperiod)
      - [7.2.2.7. Type MEFItemTerm](#7227-type-mefitemterm)
      - [7.2.2.8. `enum` MEFEndOfTermAction](#7228-enum-mefendoftermaction)
      - [7.2.2.9. `enum` MEFPriceType](#7229-enum-mefpricetype)
      - [7.2.2.10. Type MEFProductConfiguration](#72210-type-mefproductconfiguration)
      - [7.2.2.11. Type MEFProductOrderItemRef](#72211-type-mefproductorderitemref)
      - [7.2.2.12. Type Price](#72212-type-price)
      - [7.2.2.13. Type Money](#72213-type-money)
      - [7.2.2.14. Type ProductOfferingRef](#72214-type-productofferingref)
      - [7.2.2.15. Type ProductRelationship](#72215-type-productrelationship)
      - [7.2.2.16. Type ProductSpecificationRef](#72216-type-productspecificationref)
      - [7.2.2.17. Type RelatedContactInformation](#72217-type-relatedcontactinformation)
      - [7.2.2.18. Type RelatedGeographicSite](#72218-type-relatedgeographicsite)
      - [7.2.2.19. `enum` TimeUnit](#72219-enum-timeunit)
- [8. References](#8-references)

<div class="page"/>

# List of Contributing Members

The following members of the MEF participated in the development of this
document and have requested to be included in this list.

| Member                 |
| ---------------------- |
| Amartus                |
| Colt                   |
| Lumen Technologies     |
| NEC/Netcracker         |
| Orange                 |
| Proximus               |
| Spirent Communications |

**Table 1. Contributing Members**

# 1. Abstract

This standard assists the implementation of the Product Inventory functionality
defined for the LSO Cantata and LSO Sonata Interface Reference Points (IRPs),
for which requirements and use cases are defined in MEF 81 _Product Inventory
Management Requirements and Use Cases_ [[MEF81](#8-references)] and MEF 81.0.1
_Amendment to MEF 81: Product Inventory Management_
[[MEF81.0.1](#8-references)]. This standard consists of this document and
complementary API definition.

This standard normatively incorporates the following files by reference as if
they were part of this document, from the GitHub repository:

<https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK>

commit id:
[2062c16db194adc5109d0b7c0578a1a9128c6471](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/tree/2062c16db194adc5109d0b7c0578a1a9128c6471)

- [`productApi/inventory/productInventoryManagement.api.yaml`](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/2062c16db194adc5109d0b7c0578a1a9128c6471/productApi/inventory/productInventoryManagement.api.yaml)

<https://github.com/MEF-GIT/MEF-LSO-Cantata-SDK>

commit id:
[fd4aad8d6417b6aed2fa4e2d4ffa9836648addb0](https://github.com/MEF-GIT/MEF-LSO-Cantata-SDK/tree/fd4aad8d6417b6aed2fa4e2d4ffa9836648addb0)

- [`productApi/inventory/productInventoryManagement.api.yaml`](https://github.com/MEF-GIT/MEF-LSO-Cantata-SDK/blob/fd4aad8d6417b6aed2fa4e2d4ffa9836648addb0/productApi/inventory/productInventoryManagement.api.yaml)

# 2. Terminology and Abbreviations

This section defines the terms used in this document. In many cases, the
normative definitions of terms are found in other documents. In these cases,
the third column is used to provide the reference that is controlling, in other
MEF or external documents.

<table>
<tr>
  <th>Term</th>
  <th>Description</th>
  <th>Reference</th>
</tr>
<tr>
  <td>Application Program Interface (API)</td>
  <td>In the context of LSO, API describes one of the Management Interface Reference Points based on the requirements specified in an Interface Profile, along with a data model, the protocol that defines operations on the data and the encoding format used to encode data according to the data model. In this document, API is used synonymously with REST API.</td>
  <td><a href="#8-references">[MEF55.1]</td>
</tr>
<tr>
  <td>Buyer</td>
  <td>In the context of this document, denotes the organization or individual acting as the customer in a transaction over a Cantata (Customer <-> Service Provider) or Sonata (Service Provider <-> Partner) Interface.</td>
  <td>This document; adapted from <a href="#8-references">[MEF80]</td>
</tr>
<tr>
  <td>Requesting Entity</td>
  <td>The business organization that is acting on behalf of one or more Buyers. In the most common case, the Requesting Entity represents only one Buyer and these terms are then synonymous.</td>
  <td><a href="#8-references">[MEF81]</a></td>
</tr>
<tr>
  <td>Responding Entity</td>
  <td>The business organization that is acting on behalf of one or more Sellers. In the most common case, the Responding Entity represents only one Seller and these terms are then synonymous.</td>
  <td><a href="#8-references">[MEF81]</a></td>
</tr>
<tr>
  <td>REST API</td>
  <td>Representational State Transfer. REST provides a set of architectural constraints that, when applied as a whole, emphasizes scalability of component interactions, generality of interfaces, independent deployment of components, and intermediary components to reduce interaction latency, enforce security, and encapsulate legacy systems.</td>
  <td><a href="#8-references">[REST]</a> </td>
</tr>
<tr>
  <td>Seller</td>
  <td>In the context of this document, denotes the organization acting as the supplier in a transaction over a Cantata (Customer <-> Service Provider) or Sonata (Service Provider <-> Partner) Interface.</td>
  <td>This document; adapted from <a href="#8-references">[MEF80]</td>
</tr>
</table>

# 3. Compliance Levels

The key words **"MUST"**, **"MUST NOT"**, **"REQUIRED"**, **"SHALL"**, **"SHALL
NOT"**, **"SHOULD"**, **"SHOULD NOT"**, **"RECOMMENDED"**, **"NOT
RECOMMENDED"**, **"MAY"**, and **"OPTIONAL"** in this document are to be
interpreted as described in BCP 14 (RFC 2119 [[rfc2119](#8-references)], RFC
8174 [[rfc8174](#8-references)]) when, and only when, they appear in all
capitals, as shown here. All key words must be in bold text.

Items that are **REQUIRED** (contain the words **MUST** or **MUST NOT**) are
labeled as **[Rx]** for required. Items that are **RECOMMENDED** (contain the
words **SHOULD** or **SHOULD NOT**) are labeled as **[Dx]** for desirable.
Items that are **OPTIONAL** (contain the words MAY or OPTIONAL) are labeled as
**[Ox]** for optional.

# 4. Introduction

This standard specification document describes the Application Programming
Interface (API) for Product Inventory functionality of the LSO Cantata
Interface Reference Point (IRP) and LSO Sonata IRP as defined in the _MEF 55.1
Lifecycle Service Orchestration (LSO): Reference Architecture and Framework_
[[MEF55.1](#8-references)]. The LSO Reference Architecture is shown in Figure 1
with both IRPs highlighted.

![Figure 1: The LSO Reference Architecture](media/lsoArchitecture.png)
**Figure 1. The LSO Reference Architecture**

Cantata and Sonata IRPs define pre-ordering and ordering functionalities that
allow an automated exchange of information between business applications of the
Buyer (Customer or Service Provider) and Seller (Partner) Domains. Those are:

- Address Validation
- Site Retrieval
- Product Offering Qualification
- Product Quote
- Product Ordering
- Product Inventory
- Trouble Ticketing
- Billing

The business requirements and use cases for Product Inventory are defined in
MEF 81 _Product Inventory Management Requirements and Use Cases_
[[MEF81](#8-references)] and MEF 81.0.1 _Amendment to MEF 81: Product Inventory
Management_ [[MEF81.0.1](#8-references)].

This document focuses on implementation aspects and is structured as follows:

- [Chapter 4](#4-introduction) provides an introduction to Product Inventory
  and its description in a broader context of Cantata and Sonata and their
  corresponding SDKs.
- [Chapter 5](#5-api-description) gives an overview of endpoints, resource
  model and design patterns.
- Use cases and flows are presented in
  [Chapter 6](#6-api-interactions-and-flows).
- And finally, [Chapter 7](#7-api-details) complements previous sections with a
  detailed API description.

## 4.1. Description

The Product Inventory API allows the Buyer to retrieve information about
existing (previously ordered) Products from the Seller's Inventory. The
Seller's Product Inventory is a set of instances of Products that have been
ordered by a Buyer. It is assumed, for a Product to exist in the Seller's
Product Inventory, that the Seller has passed the `Product.id` to the Buyer per
MEF 57.2.

The API payloads exchanged between the Buyer and the Seller consist of
product-independent and product-specific parts. The product-independent part is
technically defined in this standard. The product-specific part is defined in
the product specification standard of the concerned product. Both standards
must be used in combination to validate the correctness of the payloads.
[Section 5.4](#54-integration-of-product-specifications-into-product-inventory-api)
explains how to use product specifications as the Inventory API payloads.

This document uses samples of Access E-Line Product specification definitions
to construct API payload examples in [Section 6](#6-api-interaction--flows).

**_Note:_** The Access E-Line product is valid only in the Sonata context. It
is used only for the explanation of the rules of combining the product-agnostic
(envelope) and product-specific (payload) parts of the APIs. The examples are
not normative and are not updated to reflect new version of the product
specification (MEF 106). It is out of the scope of this document to explain the
details of any product.

Product specifications are defined using JSON Schema (draft 7) standard
[[JS](#8-references)], whereas Product Inventory API is defined using OpenAPI
3.0 [[OAS-V3](#8-references)].The payloads exchanged through Inventory
endpoints must comply with the product specification schema as well as with MEF
81 [[MEF81](#8-references)] and MEF 81.0.1 [[MEF81.0.1](#8-references)]
requirements for Product Inventory.

## 4.2. Conventions in the Document

- Code samples are formatted using code blocks. When notation `<< some text >>`
  is used in the payload sample it indicates that a comment is provided instead
  of an example value and it might not comply with the OpenAPI definition.
- Model definitions are formatted as in-line code (e.g. `Product`).
- In UML diagrams the default cardinality of associations is `0..1`. Other
  cardinality markers are compliant with the UML standard.
- In the API details tables and UML diagrams required attributes are marked
  with a `*` next to their names.
- In UML sequence diagrams `{{variable}}` notation is used to indicates a
  variable to be substituted with a correct value.

## 4.3. Relation to Other Documents

The requirements and use cases for Product Inventory Management are defined in
MEF 81 [[MEF81](#8-references)] and MEF 81.0.1 [[MEF81.0.1](#8-references)].
The API definition builds on _TMF637 Product Inventory Management API REST
Specification R19.0.0_ [[TMF637](#8-references)]. Product Inventory Use Cases
must support the use of any of MEF product specifications.

## 4.4. Approach

As presented in Figure 2. both Cantata and Sonata API frameworks consist of
three structural components:

- Generic API framework
- Product-independent information (Function-specific information and
  Function-specific operations)
- Product-specific information (MEF product specification data model)

![Figure 2. Cantata and Sonata API framework](media/lsoApiStructure.png)

**Figure 2. Cantata and Sonata API framework**

The essential concept behind the framework is to decouple the common structure,
information and operations from the specific product information content.  
Firstly, the Generic API Framework defines a set of design rules and patterns
that are applied across all Cantata or Sonata API suites throughout all LSO
Interface Reference Points' APIs.  
Secondly, the product-independent information of the framework focuses on a
model of a particular Cantata or Sonata functionality and is agnostic to any of
the product specifications. For example, this standard is describing the
Product Inventory model and operations that allow retrieval of detailed Product
information from the Seller's system.  
Finally, the product-specific information part of the framework focuses on MEF
product specifications that define business-relevant attributes and
requirements for trading MEF subscriber and MEF operator services.

This Developer Guide is not defining MEF product specifications but can be used
in combination with any product specifications defined by or compliant with
MEF.

## 4.5. High-Level Flow

Product Inventory is part of a broader Cantata and Sonata End-to-End flow.
Figure 3. below shows a high-level diagram to get a good understanding of the
whole process and the Product Inventory's position within it.

![Figure 3. Cantata and Sonata End-to-End Flow](media/cantataSonataEndToEndFlowInventory.png)

**Figure 3. Cantata and Sonata End-to-End Function Flow**

- Address Validation:
  - Allows the Buyer to retrieve address information from the Seller, including
    exact formats, for addresses known to the Seller.
- Site Retrieval:
  - Allows the Buyer to retrieve Service Site information including exact
    formats for Service Sites known to the Seller.
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
  - Allows the Buyer to retrieve the information about existing Product
    instances from Seller's Product Inventory.
- Trouble Ticketing:
  - Allows the Buyer to create, retrieve, and update Trouble Tickets as well as
    receive notifications about Incidents' and Trouble Tickets' updates. This
    allows managing issues and situations that are not part of normal
    operations of the Product provided by the Seller.

# 5. API Description

This section presents the API structure and design patterns. It starts with the
high-level use cases diagram. Then it describes the REST endpoints with use
case mapping. Next, it gives an overview of the API resource model and an
explanation of the design pattern that is used to combine product-agnostic and
product-specific parts of API payloads. Finally, payload validation and API
security aspects are discussed.

## 5.1. High-level use cases

Figure 4 presents a high-level use case diagram as specified in MEF 81
[[MEF81](#8-references)] in section 7.1. This picture aims to help understand
the endpoint mapping. Use cases are described extensively in
[chapter 6](#6-api-interactions-and-flows)

![Figure 4: Use cases](media/useCases.png)

**Figure 4: Use cases**

## 5.2. Resource/endpoint Description

### 5.2.1. Seller Side Endpoints

**Base URL for Cantata**:
`https://{{server}}:{{port}}{{?/seller_prefix}}/mefApi/cantata/productInventory/v1/`

**Base URL for Sonata**:
`https://{{server}}:{{port}}{{?/seller_prefix}}/mefApi/sonata/productInventory/v7/`

The following API endpoints are implemented by the Seller and allow the Buyer
to retrieve existing Product details or a list of Products. The endpoints and
corresponding data model are defined in
`productApi/inventory/productInventoryManagement.api.yaml`.

| API endpoint          | Description                                                                                                                       | MEF 81 Use case Mapping              |
| --------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------ |
| `GET /product`        | A request initiated by the Buyer to retrieve a list of Products (in any state) from the Seller based on a set of filter criteria. | UC 1: Retrieve Product List          |
| `GET /product/{{id}}` | A request initiated by the Buyer to retrieve full details of a single Product based on a Product identifier.                      | UC 2: Retrieve Product by Identifier |

**Table 2. Seller Side Endpoints**

**[R1]** The Buyer implementation **MUST** be able to use all REST methods
listed in the table above. [MEF81 R3], [MEF81 R4], [MEF81 R5], [MEF81 R6].

### 5.3. Specifying the Buyer ID and the Seller ID

A business entity willing to represent multiple Buyers or multiple Sellers must
follow requirements of MEF 81 [[MEF81](#8-references)] chapter 8.3, which
states:

> For requests of all types, there is a business entity that is initiating an
> Operation (called a Requesting Entity) and a business entity that is
> responding to this request (called the Responding Entity). In the simplest
> case, the Requesting Entity is the Buyer and the Responding Entity is the
> Seller. However, in some cases, the Requesting Entity may represent more than
> one Buyer and similarly, the Responding Entity may represent more than one
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

In the API the `buyerId` and `sellerId` are represented as query parameters in
each operation defined in `productInventoryManagement.api.yaml`.

**[R2]** If the Requesting Entity has the authority to represent more than
one Buyer the request **MUST** include `buyerId` query parameter that
identifies the Buyer being represented [MEF81 R12]

**[R3]** If the Requesting Entity represents precisely one Buyer with the
Responding Entity, the request **MUST NOT** specify the `buyerId` [MEF81 R13]

**[R4]** If the Responding Entity represents more than one Seller to this
Buyer the request **MUST** include `sellerId` query parameter that identifies
the Seller with whom this request is associated [MEF81 R14]

**[R5]** If the Responding Entity represents precisely one Seller to this
Buyer, the request **MUST NOT** specify the `sellerId` [MEF81 R15]

## 5.4. Integration of Product Specifications into Product Inventory API

Product specifications are defined using JsonSchema (draft 7) format and are
integrated into the `Product` payload using the TMF extension pattern.

The extension hosting type in the API data model is `MEFProductConfiguration`.
The `@type` attribute of that type must be set to a value that uniquely
identifies the product specification. A unique identifier for MEF standard
product specifications is in URN format and is assigned by MEF. This identifier
is provided as root schema `$id` and in product specification documentation.
Use of non-MEF standard product definitions is allowed. In such a case the
schema identifier must be agreed upon between the Buyer and the Seller.

The example below shows a header of a Product Specification schema, where
`"$id": urn:mef:lso:spec:sonata:access-eline:v1.0.0:inventory` is the
abovementioned URN:

```yaml
'$schema': http://json-schema.org/draft-07/schema#
'$id': urn:mef:lso:spec:sonata:access-eline:v1.0.0:inventory
title: MEF LSO Sonata - Access Eline OVC (Inventory) Product Specification
```

Product specifications are provided as Json schemas without the
`MEFProductConfiguration` context.

Product-specific attributes are introduced via the
`MEFProduct.productConfiguration` attribute of type `MEFProductConfiguration`
which is used as an extension point for product-specific attributes.

Implementations might choose to integrate selected product specifications to
data model during development. In such a case an integrated data model is built
and product specifications are in inheritance relationship with
`MEFProductConfiguration` as described in the OAS specification. This pattern
is called **Static Binding**. The SDK is additionally shipped with a set of API
definitions that statically bind all product-related APIs (POQ, Quote, Order,
Inventory) with all corresponding product specifications available in the
release. The snippets below present an example of a static binding of the
envelope API with several MEF product specifications, from both
`MEFProductConfiguration` and product specification point of view:

```yaml
MEFProductConfiguration:
  description:
    MEFProductConfiguration is used as an extension point for MEF specific
    product/service payload. The `@type` attribute is used as a discriminator
  discriminator:
    mapping:
      urn:mef:lso:spec:sonata:AccessElineOvc:v1.0.0:inventory: '#/components/schemas/AccessElineOvcInventory_v1.0.0'
      urn:mef:lso:spec:cantata-sonata:SubscriberUni:v1.0.0:inventory: '#/components/schemas/SubscriberUniInventory_v1.0.0'
      urn:mef:lso:spec:cantata-sonata:EplEvc:v1.0.0:inventory: '#/components/schemas/EplEvcInventory_v1.0.0'
      urn:mef:lso:spec:sonata:OperatorUNI:v1.0.0:inventory: '#/components/schemas/OperatorUNIInventory_v1.0.0'
    propertyName: '@type'
  properties:
    '@type':
      description:
        The name of the type, defined in the JSON schema specified above, for
        the product that is the subject of the Request. The named type must be
        a subclass of MEFProductConfiguration.
      type: string
```

```yaml
AccessElineOvcInventory_v1.0.0:
  allOf:
    - $ref: '#/components/schemas/MEFProductConfiguration'
    - description:
        OVC Service Attributes control the behavior observable at and between
        External Interfaces to the Carrier Ethernet Network (CEN). The
        behaviors are achieved by the Network Operator and the Operator's
        client (the Service Provider in this case) agreeing on the value for
        each of the Service Attributes.
```

Alternatively, implementations might choose not to build an integrated model
and choose a different mechanism allowing runtime validation of product
specific fragments of the payload. The system is able to validate a given
product against a new schema without redeployment. This pattern is called
**Dynamic Binding.**

Regardless of chosen implementation pattern, the HTTP payload is exactly the
same. Both implementation approaches must conform to the requirements specified
below.

**[R6]** `MEFProductConfiguration` type is an extension point that **MUST**
be used to integrate product specifications' properties into a request/response
payload.

**[R7]** The `@type` property of `MEFProductConfiguration` **MUST** be used
to specify the type of the extending entity.

**[R8]** Product attributes specified in the payload must conform to the
product specification specified in the `@type` property.

![Extension pattern](media/extension_pattern.png)

**Figure 5. The Extension Pattern with Sample Product Specific Extensions**

Figure 5. presents two MEF `<<ProductSpecifications>>` that represent Access
E-Line Operator UNI and OVC products. When these products are used as a Product
Inventory payload the `@type` of `MEFProductConfiguration` takes
`"urn:mef:lso:spec:sonata:AccessElineOvc:1.0.0:inventory"` or
`"urn:mef:lso:spec:sonata:OperatorUNI:1.0.0:inventory"` value to indicate which
product specification should be used to interpret a set of product-specific
attributes included in the payload. An example of a product configuration is
presented in [Section 6.2.](#62-use-case-2-retrieve-product-by-identifier).

The _inventory_ suffix after the product type name in the URN comes from the
approach that the product schemas may differ depending on the Interface
Reference Point function they are used with.

## 5.5. Sample Product Specification

The SDK contains product specification definitions, from which UNI and Access
E-Line (OVC) are used in the payload samples in this section. In Celine release
they are located in the SDK package at:

`\productSchema\carrierEthernet\accessEline\inventory\accessElineOvc.yaml`
`\productSchema\carrierEthernet\carrierEthernetOperatorUni\inventory\carrierEthernetOperatorUni.yaml`

The product specification data model definitions are available as JsonSchema
(version `draft 7`) documents. Figure 6. and 7 depict simplified UML views on
these data models in which:

- the mandatory attributes are marked with `*`,
- the mandatory relations have a cardinality of `1` or `1..*`,
- some relations and attributes that are not essential to the understanding of
  the product specification model are omitted.

The red color in figures 6 and 7 below highlights the data model of Access
E-Line.

![Access ELine Product Specification Example](media/product_spec_AEL.png)

**Figure 6. A simplified view on Access E-Line product specification data
model**

![UNI Product Specification Example](media/product_spec_UNI.png)

**Figure 7. A simplified view on UNI product specification data model**

## 5.6. Model Structural Validation

The structure of the HTTP payloads exchanged via Product Inventory API
endpoints are defined using:

- OpenAPI version 3.0 for product-agnostic part of the payload
- JsonSchema (draft 7) for product-specific part of the payload

**[R9]** Implementations **MUST** use payloads that conform to these
definitions.

**[R10]** A product specification may define additional consistency rules and
requirements that **MUST** be respected by implementations. These are defined
for:

- required relation type, multiplicity to other products in the Seller's
  product inventory
- related contact information roles
- relations to places (`Sites`) and their roles

## 5.7. Security Considerations

There must be an authentication mechanism whereby a Seller can be assured who a
Buyer is and vice-versa. There must also be authorization mechanisms in place
to control what a particular Buyer or Seller is allowed to do and what
information may be obtained. However, the definition of the exact security
mechanism and configuration is outside the scope of this document. It is being
worked on by a separate MEF Project (MEF W128).

# 6. API Interactions and Flows

This section provides a detailed insight into the API functionality, use cases,
and flows. It starts with Table 3 presenting a list and short description of
all business use cases then presents the variants of end-to-end interaction
flows, and in following subchapters describes the API usage flow and examples
for each of the use cases.

| Use Case # | Use Case Name                                                                   | Use Case Description                                                                               |
| ---------- | ------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| 1          | [Retrieve Product List](#61-use-case-1-retrieve-product-list)                   | The Buyer requests a list of Products from the Seller based on filter criteria.                    |
| 2          | [Retrieve Product by Identifier](#62-use-case-2-retrieve-product-by-identifier) | The Buyer retrieves the details associated with the Product that matches the specified Identifier. |

**Table 3. Use cases description**

## 6.1. Use case 1: Retrieve Product List

The Buyer can retrieve a list of `Products` by using a `GET /product` operation
with desired filtering criteria. The attributes that are available to be used
are:

- `status`
- `productSpecificationId`
- `productOfferingId`
- `externalId`
- `geographicalSiteId`
- `relatedProductId`
- `billingAccountId`
- `productOrderId`
- `startDate.gt`
- `startDate.lt`
- `lastUpdateDate.gt`
- `lastUpdateDate.lt`

The flow is a simple request - response pattern, as presented in Figure 8:

![Use case 1: Retrieve Product List flow](media/useCase1Flow.png)

**Figure 8. Use case 1: Retrieve Product List flow**

The part of the model taking part in this use case is presented in Figure 9

![Use case 1: Retrieve Product List model](media/useCase1Model.png)

**Figure 9. Use case 1: Retrieve Product List model**

```
https://serverRoot/mefApi/sonata/productInventory/v7/product?status=pendingTerminate
```

The example above shows a Buyer's request to get all `Products` that are in the
`pendingTerminate` status. The correct response (HTTP code `200`) in the
response body contains a list of `MEFProduct_Find` objects matching the
criteria. To get more details (e.g. the item level information), the Buyer has
to query a specific `Product` by `id`.

The snippet below shows an example of a response with 1 product matched:

```json
[
  {
    "id": "01494079-6c79-4a25-83f7-48284196d44d",
    "href": "{{baseUrl}}/product/01494079-6c79-4a25-83f7-48284196d44d",
    "status": "pendingTerminate",
    "externalId": "BuyerProduct-001",
    "lastUpdateDate": "2021-06-01T08:55:54.155Z",
    "startDate": "2021-05-01T08:55:54.155Z",
    "billingAccount": {
      "id": "00000000-1111-0000-0000-000000000001",
      "agreementName": "Buyer-Seller General Agreement 03/2021"
    },
    "productOffering": {
      "id": "00000000-5555-0000-0000-000000000001"
    },
    "productOrderItem": [
      {
        "productOrderItemId": "item-001",
        "productOrderHref": "{{baseUrl}}/productOrder/00000000-1111-2222-3333-000000000123",
        "productOrderId": "00000000-1111-2222-3333-000000000123"
      }
    ],
    "productRelationship": [
      {
        "id": "00000000-6666-0000-0000-000000000001",
        "relationshipType": "ENNI_REFERENCE"
      }
    ]
  }
]
```

**[R11]** The Buyer **MUST** be able to perform Buyer Inventory Query without
any filter criteria. [MEF81 R7]

**[O1]** The Seller **MAY** place a limit on the length of the list returned.
[MEF81 O2]

**[O2]** If the Buyer Inventory Query exceeds that length, the Seller **MAY**
return an error (`Error422`) indicating that the list is too long. [MEF81 O3]

The Buyer may also ask for pagination with the use of the `offset` and `limit`
parameters. The filtering and pagination attributes must be specified in URI
query format [rfc3986](#8-references). Section
[7.1.2.](#712-response-pagination) provides details about the implementation of
pagination mechanism.

**[R12]** In case no items matching the criteria are found, the Seller
**MUST** return a valid response with an empty list.

**[R13]** The Seller **MUST** put the following attributes (if set) into the
`MEFProduct_Find` object in the response: [MEF81 R8]:

- `id`
- `status`
- `externalId`
- `lastUpdateDate`
- `startDate`
- `billingAccount`
- `productOffering`
- `productOrderItem`
- `productRelationship`
- `productSpecification`
- `relatedSite`

## 6.2. Use case 2: Retrieve Product by Identifier

To get detailed up to date information about the Product, the Buyer sends a
Retrieve Product by Identifier request using a `GET /product/{id}` operation.

The flow is a simple request - response pattern, as presented in Figure 10:

![Use case 2: Retrieve Product by Identifier flow](media/useCase2Flow.png)

**Figure 10. Use case 2: Retrieve Product by Identifier flow**

The part of the model taking part in this use case is presented in Figure 11

![Use case 2: Retrieve Product model](media/useCase2Model.png)

**Figure 11. Use case 2: Retrieve Product model**

Example request and response:

`GET /mefApi/sonata/productInventory/v7/product/01494079-6c79-4a25-83f7-48284196d44d`

```json
{
  "id": "01494079-6c79-4a25-83f7-48284196d44d",
  "href": "{{baseUrl}}/product/01494079-6c79-4a25-83f7-48284196d44d",
  "externalId": "BuyerProduct-001",
  "lastUpdateDate": "2021-06-01T08:55:54.155Z",
  "startDate": "2021-05-01T08:55:54.155Z",
  "status": "pendingTerminate",
  "@type": "MEFProduct",
  "productConfiguration": {
    "@type": "urn:mef:lso:spec:sonata:AccessElineOvc:1.0.0:inventory",
    "enniEp": {
      "ingressBandwidthProfilePerClassOfServiceName": [
        {
          "classOfServiceName": "silver",
          "bwpFlow": [
            {
              "envelopeRank": 1,
              "couplingFlag": false,
              "envelopeName": "defaultENNI",
              "tokenRequestedOffset": 0,
              "colorMode": "COLOR_BLIND",
              "cir": {
                "irValue": 20,
                "irUnits": "MBPS"
              },
              "cbs": {
                "dataSizeValue": 50,
                "dataSizeUnits": "KBYTES"
              },
              "eir": {
                "irValue": 0,
                "irUnits": "BPS"
              },
              "ebs": {
                "dataSizeValue": 0,
                "dataSizeUnits": "BYTES"
              },
              "cirMax": {
                "irValue": 20,
                "irUnits": "MBPS"
              },
              "eirMax": {
                "irValue": 0,
                "irUnits": "BPS"
              }
            }
          ]
        }
      ]
    },
    "maximumFrameSize": 1522,
    "uniEp": {
      "ingressBandwidthProfilePerClassOfServiceName": [
        {
          "classOfServiceName": "silver",
          "bwpFlow": [
            {
              "envelopeRank": 1,
              "couplingFlag": false,
              "envelopeName": "defaultUNI",
              "tokenRequestedOffset": 0,
              "colorMode": "COLOR_BLIND",
              "cir": {
                "irValue": 20,
                "irUnits": "MBPS"
              },
              "cbs": {
                "dataSizeValue": 50,
                "dataSizeUnits": "KBYTES"
              },
              "eir": {
                "irValue": 0,
                "irUnits": "BPS"
              },
              "ebs": {
                "dataSizeValue": 0,
                "dataSizeUnits": "BYTES"
              },
              "cirMax": {
                "irValue": 20,
                "irUnits": "MBPS"
              },
              "eirMax": {
                "irValue": 0,
                "irUnits": "BPS"
              }
            }
          ]
        }
      ]
    }
  },
  "billingAccount": {
    "id": "00000000-1111-0000-0000-000000000001",
    "agreementName": "Buyer-Seller General Agreement 03/2021"
  },
  "productOffering": {
    "id": "00000000-5555-0000-0000-000000000001"
  },
  "productOrderItem": [
    {
      "productOrderItemId": "item-001",
      "productOrderHref": "{{baseUrl}}/productOrder/00000000-1111-2222-3333-000000000123",
      "productOrderId": "00000000-1111-2222-3333-000000000123"
    }
  ],
  "price": {
    "taxRate": 8,
    "dutyFreeAmount": {
      "unit": "USD",
      "value": 50
    },
    "taxIncludedAmount": {
      "unit": "USD",
      "value": 54
    }
  },
  "productRelationship": [
    {
      "id": "00000000-6666-0000-0000-000000000001",
      "relationshipType": "ENNI_REFERENCE"
    }
  ],
  "productTerm": [
    {
      "duration": {
        "amount": 12,
        "units": "calendarMonths"
      },
      "endOfTermAction": "autoRenew",
      "name": "Yearly Subscription"
    }
  ],
  "relatedContactInformation": [
    {
      "emailAddress": "Seller.AssuranceTechnicalContact@example.com",
      "name": "Seller Assurance Technical Contact",
      "number": "+98-765-432-10",
      "role": "sellerAssuranceTechnicalContact "
    },
    {
      "emailAddress": "Seller.CommercialContact@example.com",
      "name": "Seller Commercial Contact",
      "number": "+98-765-432-11",
      "role": "sellerCommercialContact"
    },
    {
      "emailAddress": "Seller.SLAManagementContact@example.com",
      "name": "Seller SLA Management Contact",
      "number": "+98-765-432-12",
      "role": "sellerSlaManagementContact"
    },
    {
      "emailAddress": "Buyer.AssuranceTechnicalContact@example.com",
      "name": "Buyer Assurance Technical Contact",
      "number": "+12-345-678-90",
      "role": "buyerAssuranceTechnicalContact "
    },
    {
      "emailAddress": "Buyer.CommercialContact@example.com",
      "name": "Buyer Commercial Contact",
      "number": "+12-345-678-91",
      "role": "buyerCommercialContact"
    },
    {
      "emailAddress": "Buyer.SLAManagementContact@example.com",
      "name": "Buyer SLA Management Contact",
      "number": "+12-345-678-92",
      "role": "buyerSlaManagementContact"
    }
  ],
  "statusChange": [
    {
      "changeDate": "2021-05-01T10:01:14.571Z",
      "status": "pendingActive"
    },
    {
      "changeDate": "2021-05-02T10:01:14.571Z",
      "status": "active"
    },
    {
      "changeDate": "2021-06-01T10:01:14.571Z",
      "status": "pendingTerminate"
    }
  ]
}
```

Figure 12 below presents the Product's lifecycle.

![Figure 12: Product State Machine](media/productStates.png)

**Figure 12: Product State Machine**

A detailed description of each of state can be found in the table below.

| name                        | MEF 81 name                 | Description                                                                                                                                                                                                                                                                     |
| --------------------------- | --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `active`                    | ACTIVE                      | The Product Order has been successfully completed and the Product Order and associated Product Order Items are in the Inventory.                                                                                                                                                |
| `active.pendingChange`      | ACTIVE_PENDING_CHANGE       | The Product is `active` and has a Product Order to change the Product that is in progress. The status returns to `active` when the order is completed or if the Product Order is cancelled.                                                                                     |
| `pendingTerminate`          | ACTIVE_PENDING_TERMINATE    | The Product is `active` and has a disconnect Order submitted by the Buyer that is in progress. The status changes to `terminated` if the disconnect is successful. The status returns to `active` if the Product Order fails to be completed or the Product Order is cancelled. |
| `cancelled`                 | CANCELLED                   | The Product is `cancelled` when the Product Order has moved to the `cancelled`.                                                                                                                                                                                                 |
| `pendingActive`             | PENDING                     | The Product Order has moved to the `acknowledged` state as defined in MEF 57.1 [11] and the Product ID for one or more Product Items have been passed from the Seller to the Buyer. The Product Order is not completed.                                                         |
| `suspended`                 | SUSPENDED                   | A Product has been successfully suspended. Products are placed into `suspended` state for some reason (e.g. nonpayment of bill) and removed from `suspended` state for some reason (e.g. after payment).                                                                        |
| `suspendedPendingTerminate` | SUSPENDED_PENDING_TERMINATE | The Product is in the process of being terminated by the Seller for some reason (e.g. non-payment). The status changes to `terminated` if the termination is successful. The status returns to `suspended` if the termination is not successful or cancelled.                   |
| `terminated`                | TERMINATED                  | The Product has been successfully terminated via a disconnect Product order initiated by the Buyer or by the Seller for some reason (e.g. non-payment).                                                                                                                         |

**Table 4: Product states**

Products that are terminated might be removed from the Seller's inventory
system or shown in the `terminated` state at the Seller's discretion.

**[R14]** The Seller **MUST** provide the following contact information:
[MEF81 R11]

| Contract Role               | `role` value                                                            | Description                                                                           |
| --------------------------- | ----------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| Assurance Technical Contact | `buyerAssuranceTechnicalContact`,</br>`sellerAssuranceTechnicalContact` | Operational contact such as Network Operations Center (NOC) for each party.           |
| Commercial Contact          | `buyerCommercialContact`, </br>`sellerCommercialContact`                | Contact for commercial issues like billing, contract extensions, etc. for each party. |
| SLA Management Contact      | `buyerSlaManagementContact`, </br>`sellerSlaManagementContact`          | Contact for SLA related issues, lifecycle reports, etc. for each party.               |

**Table 5. Required Related Contact Information `role`**

**_Note:_** The method used to update these contacts in the Seller's Inventory
system is assumed to be agreed to between the Buyer and the Seller and is
outside the scope of this document.

There is no step of Buyer's approval before moving a Product to `active`
status. This might be part of a bilateral agreement or procedure that takes
place outside of Product Inventory API.

Additions and changes to Products in the Product Inventory can be performed on
with use of Product Orders and the Product Order Management API, or by the
request of the Seller.

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

![Error response data model](media/error_entities.png)

**Figure 13. Data model types to represent an erroneous response**

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
            <td>message</td>
            <td>string</td>
            <td>Text that provides mode details and corrective actions related to the error. This can be shown to a client user.</td>
        </tr><tr>
            <td>reason*</td>
            <td>string</td>
            <td>Text that explains the reason for the error. This can be shown to a client user.</td>
        </tr><tr>
            <td>referenceError</td>
            <td>uri</td>
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
            <td>string</td>
            <td>One of the following error codes:<br>
- missingQueryParameter: The URI is missing a required query-string parameter<br>
- missingQueryValue: The URI is missing a required query-string parameter value<br>
- invalidQuery: The query section of the URI is invalid.<br>
- invalidBody: The request has an invalid body</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.3. Type Error401

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
            <td>string</td>
            <td>One of the following error codes:<br>
- missingCredentials: No credentials provided.<br>
- invalidCredentials: Provided credentials are invalid or expired</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.4. Type Error403

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
            <td>string</td>
            <td>This code indicates that the server understood
the request but refuses to authorize it because
of one of the following error codes:<br>
- accessDenied: Access denied<br>
- forbiddenRequester: Forbidden requester<br>
- tooManyUsers: Too many users</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.5. Type Error404

**Description:** Resource for the requested path not found.
(https://tools.ietf.org/html/rfc7231#section-6.5.4)

Inherits from:

- <a href="#T_Error">Error</a>

<table id="T_Error404">
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
            <td>The following error code:<br>
- notFound: A current representation for the target resource not found</td>
        </tr>
    </tbody>
</table>

#### 7.1.1.6. Type Error422

The response for HTTP status `422` is a list of elements that are structured
using the `Error422` data type. Each list item describes a business validation
problem. This type introduces the `propertyPath` attribute which points to the
erroneous property of the request, so that the Buyer may fix it easier. It is
highly recommended that this property should be used, yet remains optional
because it might be hard to implement.

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
            <td>string</td>
            <td>One of the following error codes:<br>
  - missingProperty: The property the Seller has expected is not present in the payload<br>
  - invalidValue: The property has an incorrect value<br>
  - invalidFormat: The property value does not comply with the expected value format<br>
  - referenceNotFound: The object referenced by the property cannot be identified in the Seller system<br>
  - unexpectedProperty: Additional property, not expected by the Seller has been provided<br>
  - tooManyRecords: the number of records to be provided in the response exceeds the Seller's threshold.<br>
  - otherIssue: Other problem was identified (detailed information provided in a reason)
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

#### 7.1.1.7. Type Error500

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
            <td>The following error code:<br>
- internalError: Internal server error - the server encountered an unexpected condition that prevented it from fulfilling the request.</td>
        </tr>
    </tbody>
</table>

### 7.1.2. Response pagination

A response to retrieve a list of results (e.g. `GET /product`) can be
paginated. The Buyer can specify the following query attributes related to
pagination:

- `limit` - number of expected list items
- `offset` - offset of the first element in the result list

The Seller returns a list of elements that comply with the requested `limit`.
If the requested `limit` is higher than the supported list size the smaller
list result is returned. In that case, the size of the result is returned in
the header attribute `X-Result-Count`. The Seller can indicate that there are
additional results available using:

- `X-Total-Count` header attribute with the total number of available results
- `X-Pagination-Throttled` header set to `true`

**[R15]** Seller **MUST** use either `X-Total-Count` or
`X-Pagination-Throttled` to indicate that the page was truncated and additional
results are available.

## 7.2. Management API Data model

Figure 14 presents the whole Product Inventory data model. The data types,
requirements related to them and mapping to MEF 81 specification are discussed
later in this section.

![Product Inventory Data Model](media/productMgtDataModel.png)

**Figure 14. Product Inventory Data Model**

### 7.2.1. Product

#### 7.2.1.1. Type MEFProduct

**Description:** A product is realized as one or more service(s) and/or
resource(s).

<table id="T_MEFProduct">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id*</td>
            <td>string</td>
            <td>Unique identifier of the product</td>
            <td>Seller Product Identifier</td>
        </tr><tr>
            <td>href</td>
            <td>string</td>
            <td>Reference of the product</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>externalId</td>
            <td>string</td>
            <td>Buyer identifier of the product</td>
            <td>Buyer Product Identifier</td>
        </tr><tr>
            <td>lastUpdateDate</td>
            <td>date-time</td>
            <td>Latest date when the product has been updated.</td>
            <td>Last Updated Date</td>
        </tr><tr>
            <td>startDate*</td>
            <td>date-time</td>
            <td>Is the date from which the product starts. MEF: Start date is when the product is active for the first time (when the install in the product order has been processed).</td>
            <td>Initial Order Completion Date</td>
        </tr><tr>
            <td>terminationDate</td>
            <td>date-time</td>
            <td>Is the date when the product was terminated. MEF: Termination date (commercial) is when the product has been terminated (when the disconnect in the product order has been processed).</td>
            <td>Termination Date</td>
        </tr><tr>
            <td>productConfiguration</td>
            <td><a href="#T_MEFProductConfiguration">MEFProductConfiguration</a></td>
            <td>MEFProductConfiguration is used to specify the MEF specific product payload.</td>
            <td>Product</td>
        </tr><tr>
            <td>billingAccount</td>
            <td><a href="#T_MEFBillingAccount">MEFBillingAccount</a></td>
            <td>The Billing Account associated with the Product</td>
            <td>Billing Account Identifier</td>
        </tr><tr>
            <td>productOffering</td>
            <td><a href="#T_ProductOfferingRef">ProductOfferingRef</a></td>
            <td>A particular Product Offering defines the technical and commercial attributes and behaviors of a Product.</td>
            <td>Product Offering ID</td>
        </tr><tr>
            <td>productOrderItem</td>
            <td><a href="#T_MEFProductOrderItemRef">MEFProductOrderItemRef</a>[]</td>
            <td>The Product Order Item of the associated Product order that resulted in the creation of this Product.</td>
            <td>Product Order Identifier, Product Order Item Identifier</td>
        </tr><tr>
            <td>productPrice</td>
            <td><a href="#T_ProductPrice">ProductPrice</a>[]</td>
            <td>A list of Prices associated with the Product</td>
            <td>Product Price</td>
        </tr><tr>
            <td>productRelationship</td>
            <td><a href="#T_ProductRelationship">ProductRelationship</a>[]</td>
            <td>A list of references to existing products that are related to the Product.</td>
            <td>Product Relationship</td>
        </tr><tr>
            <td>productSpecification</td>
            <td><a href="#T_ProductSpecificationRef">ProductSpecificationRef</a></td>
            <td>A reference to a Product Specification of the Product</td>
            <td>Product Specification ID</td>
        </tr><tr>
            <td>productTerm</td>
            <td><a href="#T_MEFItemTerm">MEFItemTerm</a>[]</td>
            <td>Term of the Product</td>
            <td>Product Order Item Term, Product Order Item Term End Date</td>
        </tr><tr>
            <td>relatedContactInformation</td>
            <td><a href="#T_RelatedContactInformation">RelatedContactInformation</a>[]</td>
            <td>Party playing a role for this Product</td>
            <td>Buyer Assurance Technical Contact, Buyer Commercial Contact, Buyer SLA Management Contact, Seller Assurance Technical Contact, Seller Commercial Contact, Seller SLA Management Contact</td>
        </tr><tr>
            <td>relatedSite</td>
            <td><a href="#T_RelatedGeographicSite">RelatedGeographicSite</a>[]</td>
            <td>Reference to a Site where the PRoduct is provided.</td>
            <td>Service Site Identifier</td>
        </tr><tr>
            <td>statusChange</td>
            <td><a href="#T_MEFProductStatusChange">MEFProductStatusChange</a>[]</td>
            <td>State change for the Product</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>status*</td>
            <td><a href="#T_MEFProductStatusType">MEFProductStatusType</a></td>
            <td>The lifecycle status of the product.</td>
            <td>Status</td>
        </tr><tr>
            <td>@type</td>
            <td>string</td>
            <td>When sub-classing, this defines the sub-class entity name</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.2. Type MEFProduct_Find

**Description:** Class used to provide product overview retrieved in GET (by
list) operation

<table id="T_MEFProduct_Find">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id*</td>
            <td>string</td>
            <td>Unique identifier of the product</td>
            <td>Seller Product Identifier</td>
        </tr><tr>
            <td>href</td>
            <td>string</td>
            <td>Reference of the product</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>externalId</td>
            <td>string</td>
            <td>This identifier is optionally provided during the product ordering and stored for informative purpose in the seller inventory</td>
            <td>Buyer Product Identifier</td>
        </tr><tr>
            <td>lastUpdateDate</td>
            <td>date-time</td>
            <td>Latest date when the product has been updated.</td>
            <td>Last Updated Date</td>
        </tr><tr>
            <td>startDate</td>
            <td>date-time</td>
            <td>The date from which the product starts</td>
            <td>Initial Order Completion Date</td>
        </tr><tr>
            <td>billingAccount</td>
            <td><a href="#T_MEFBillingAccount">MEFBillingAccount</a></td>
            <td>The Billing Account associated with the Product</td>
            <td>Billing Account Identifier</td>
        </tr><tr>
            <td>productOffering</td>
            <td><a href="#T_ProductOfferingRef">ProductOfferingRef</a></td>
            <td>A particular Product Offering defines the technical and commercial attributes and behaviors of a Product.</td>
            <td>Product Offering ID</td>
        </tr><tr>
            <td>productOrderItem</td>
            <td><a href="#T_MEFProductOrderItemRef">MEFProductOrderItemRef</a>[]</td>
            <td>The Product Order Item of the associated Product order that resulted in the creation of this Product.</td>
            <td>Product Order Identifier, Product Order Item Identifier</td>
        </tr><tr>
            <td>productRelationship</td>
            <td><a href="#T_ProductRelationship">ProductRelationship</a>[]</td>
            <td>A list of references to existing products that are related to the Product.</td>
            <td>Product Relationship</td>
        </tr><tr>
            <td>productSpecification</td>
            <td><a href="#T_ProductSpecificationRef">ProductSpecificationRef</a></td>
            <td>A reference to a Product Specification of the Product</td>
            <td>Product Specification ID</td>
        </tr><tr>
            <td>relatedSite</td>
            <td><a href="#T_RelatedGeographicSite">RelatedGeographicSite</a>[]</td>
            <td>Reference to a Site where the PRoduct is provided.</td>
            <td>Service Site Identifier</td>
        </tr><tr>
            <td>status*</td>
            <td><a href="#T_MEFProductStatusType">MEFProductStatusType</a></td>
            <td>The lifecycle status of the product.</td>
            <td>Status</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.3. `enum` MEFProductStatusType

**Description:** Possible values for the status of a MEF product

| name                        | MEF 81 name                 |
| --------------------------- | --------------------------- |
| `active`                    | ACTIVE                      |
| `active.pendingChange`      | ACTIVE_PENDING_CHANGE       |
| `pendingTerminate`          | ACTIVE_PENDING_TERMINATE    |
| `cancelled`                 | CANCELLED                   |
| `pendingActive`             | PENDING                     |
| `suspended`                 | SUSPENDED                   |
| `suspendedPendingTerminate` | SUSPENDED_PENDING_TERMINATE |
| `terminated`                | TERMINATED                  |

#### 7.2.1.4. Type MEFProductStatusChange

**Description:** Holds the reached state, reasons, and associated date the
Product Order state changed, populated by the Seller.

<table id="T_MEFProductStatusChange">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>changeDate*</td>
            <td>date-time</td>
            <td>The date and time the Status changed.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>changeReason</td>
            <td>string</td>
            <td>The reason why the Status changed.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>status*</td>
            <td><a href="#T_MEFProductStatusType">MEFProductStatusType</a></td>
            <td>Status of the product</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.1.5. Type ProductPrice

**Description:** An amount, usually of money, that represents the actual price
paid by a Customer for a purchase, a rent, or a lease of a Product. The price
is valid for a defined period of time.

<table id="T_ProductPrice">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>description</td>
            <td>string</td>
            <td>A narrative that explains in detail the semantics of this product price.</td>
            <td>Price Description</td>
        </tr><tr>
            <td>name</td>
            <td>string</td>
            <td>A short descriptive name such as &quot;Subscription price&quot;.</td>
            <td>Price Name</td>
        </tr><tr>
            <td>unitOfMeasure</td>
            <td>string</td>
            <td>Unit of Measure if price depending on it (Gb, SMS volume, etc..)</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>price*</td>
            <td><a href="#T_Price">Price</a></td>
            <td>Value of the Price</td>
            <td>Price</td>
        </tr><tr>
            <td>priceType*</td>
            <td><a href="#T_MEFPriceType">MEFPriceType</a></td>
            <td>A category that describes the price, such as recurring, nonRecurring, usageBased</td>
            <td>Price Type</td>
        </tr><tr>
            <td>recurringChargePeriod</td>
            <td><a href="#T_MEFChargePeriod">MEFChargePeriod</a></td>
            <td>Charge period for recurring charge.</td>
            <td>Price Recurring Change Period</td>
        </tr>
    </tbody>
</table>

### 7.2.2. Common

Types described in this subsection are shared among two or more Cantata and
Sonata APIs.

#### 7.2.2.1. Type Duration

**Description:** A Duration in a given unit of time e.g. 3 hours, or 5 days.

<table id="T_Duration">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>amount*</td>
            <td>integer</td>
            <td>Duration (number of seconds, minutes, hours, etc.)</td>
            <td>Product Order Item Term</td>
        </tr><tr>
            <td>units*</td>
            <td><a href="#T_TimeUnit">TimeUnit</a></td>
            <td>Time unit type</td>
            <td>Product Order Item Term</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.2. Type FieldedAddress

**Description:** A type of Address that has a discrete field and value for each
type of boundary or identifier down to the lowest level of detail. For example
"street number" is one field, "street name" is another field, etc. Reference:
MEF 79 (Sn 8.9.2)

<table id="T_FieldedAddress">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>city*</td>
            <td>string</td>
            <td>The city that the address is in</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>country*</td>
            <td>string</td>
            <td>Country that the address is in</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>geographicSubAddress</td>
            <td><a href="#T_GeographicSubAddress">GeographicSubAddress</a></td>
            <td>Additional fields used to specify an address, as detailed as possible.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>locality</td>
            <td>string</td>
            <td>The locality that the address is in</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>postcode</td>
            <td>string</td>
            <td>Descriptor for a postal delivery area, used to speed and simplify the delivery of mail (also known as zip code)</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>postcodeExtension</td>
            <td>string</td>
            <td>An extension of a postal code. E.g. the part following the dash in a US urban property address</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>stateOrProvince</td>
            <td>string</td>
            <td>The State or Province that the address is in</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetName*</td>
            <td>string</td>
            <td>Name of the street or other street type</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetNr</td>
            <td>string</td>
            <td>Number identifying a specific property on a public street. It may be combined with streetNrLast for ranged addresses. MEF 79 defines it as required however as in certain countries it is not used we make it optional in API.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetNrLast</td>
            <td>string</td>
            <td>Last number in a range of street numbers allocated to a property</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetNrLastSuffix</td>
            <td>string</td>
            <td>Last street number suffix for a ranged address</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetNrSuffix</td>
            <td>string</td>
            <td>The first street number suffix</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetSuffix</td>
            <td>string</td>
            <td>A modifier denoting a relative direction</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>streetType</td>
            <td>string</td>
            <td>The type of street (e.g., alley, avenue, boulevard, brae, crescent, drive, highway, lane, terrace, parade, place, tarn, way, wharf)</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.3. Type GeographicSubAddress

**Description:** Additional fields used to specify an address, as detailed as
possible.

<table id="T_GeographicSubAddress">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>buildingName</td>
            <td>string</td>
            <td>Allows for identification of places that require building name  as part of addressing information
</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>levelNumber</td>
            <td>string</td>
            <td>Used where a level type may be repeated e.g. BASEMENT 1, BASEMENT 2</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>levelType</td>
            <td>string</td>
            <td>Describes level types within a building</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>privateStreetName</td>
            <td>string</td>
            <td>&quot;Private streets internal to a property (e.g. a university) may have internal names that are not recorded by the land title office</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>privateStreetNumber</td>
            <td>string</td>
            <td>Private streets numbers internal to a private street</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>subUnit</td>
            <td><a href="#T_MEFSubUnit">MEFSubUnit</a>[]</td>
            <td>Representation of a MEFSubUnit It is used for describing subunit within a subAddress e.g. BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.4. Type MEFSubUnit

**Description:** Allows for subunit identification

<table id="T_MEFSubUnit">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>subUnitNumber*</td>
            <td>string</td>
            <td>The discriminator used for the subunit, often just a simple number but may also be a range.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>subUnitType*</td>
            <td>string</td>
            <td>The type of subunit e.g.BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.5. Type MEFBillingAccount

**Description:** References the billing arrangement that a buyer has with a
seller that provides products to the customer.

<table id="T_MEFBillingAccount">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id*</td>
            <td>string</td>
            <td>Identifies the buyer&#x27;s billing account to which the recurring and non-recurring charges for this order or order item will be billed. Required if the Buyer has more than one Billing Account with the Seller and for all new Product Orders.</td>
            <td>Billing Account Identifier</td>
        </tr><tr>
            <td>billingContact</td>
            <td><a href="#T_RelatedContactInformation">RelatedContactInformation</a></td>
            <td>Contact allow to capture contact information. It is used to capture billing account contact information.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>agreementName</td>
            <td>string</td>
            <td>The name of the Agreement which is referenced for the Product Order Item.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.6. `enum` MEFChargePeriod

**Description:** Used for a recurring charge to indicate a period.

<table id="T_MEFChargePeriod">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 81</td>
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

#### 7.2.2.7. Type MEFItemTerm

**Description:** The term of the Item

<table id="T_MEFItemTerm">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>description</td>
            <td>string</td>
            <td>Description of the term</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>duration</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>Duration of the term</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>endOfTermAction</td>
            <td><a href="#T_MEFEndOfTermAction">MEFEndOfTermAction</a></td>
            <td>The action that needs to be taken by the Seller once the term expires</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>name</td>
            <td>string</td>
            <td>Name of the term</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>rollInterval</td>
            <td><a href="#T_Duration">Duration</a></td>
            <td>The recurring period that the Buyer is willing to pay to the end of upon disconnecting the Product after the original term has expired.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.8. `enum` MEFEndOfTermAction

**Description:** The action the Seller will take once the term expires.

<table id="T_MEFEndOfTermAction">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>roll</td>
            <td>ROLL</td>
        </tr><tr>
            <td>autoDisconnect</td>
            <td>AUTO_DISCONNECT</td>
        </tr><tr>
            <td>autoRenew</td>
            <td>AUTO_RENEW</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.9. `enum` MEFPriceType

**Description:** Indicates if the price is for recurring or non-recurring
charges.

<table id="T_MEFPriceType">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 81</td>
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
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.10. Type MEFProductConfiguration

**Description:** MEFProductConfiguration is used as an extension point for MEF
specific product/service payload. The `@type` attribute is used as a
discriminator

<table id="T_MEFProductConfiguration">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>@type*</td>
            <td>string</td>
            <td>The name of the type, defined in the JSON schema specified  above, for the product that is the subject of the POQ Request. The named type must be a subclass of MEFProductConfiguration.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.11. Type MEFProductOrderItemRef

**Description:** A reference to a ProductOrder item

<table id="T_MEFProductOrderItemRef">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>productOrderItemId*</td>
            <td>string</td>
            <td>Id of an Item within the Product Order</td>
            <td>Product Order Item Identifier</td>
        </tr><tr>
            <td>productOrderHref</td>
            <td>string</td>
            <td>Reference of the related ProductOrder.</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>productOrderId*</td>
            <td>string</td>
            <td>Unique identifier of a ProductOrder.</td>
            <td>Product Order Identifier</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.12. Type Price

**Description:** Provides all amounts (tax included, duty free, tax rate), used
currency and percentage to apply for Price Alteration.

<table id="T_Price">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>taxRate</td>
            <td>float</td>
            <td>Price Tax Rate. Unit: [%]. E.g. value 16 stand for 16% tax.</td>
            <td>Price Tax Rate</td>
        </tr><tr>
            <td>dutyFreeAmount*</td>
            <td><a href="#T_Money">Money</a></td>
            <td>All taxes excluded amount (expressed in the given currency)</td>
            <td>Price Duty Free Amount</td>
        </tr><tr>
            <td>taxIncludedAmount</td>
            <td><a href="#T_Money">Money</a></td>
            <td>All taxes included amount (expressed in the given currency)</td>
            <td>Price Tax Included Amount</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.13. Type Money

**Description:** A base / value business entity used to represent money

<table id="T_Money">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>unit*</td>
            <td>string</td>
            <td>Currency (ISO4217 norm uses 3 letters to define the currency)</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>value*</td>
            <td>float</td>
            <td>A positive floating point number</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.14. Type ProductOfferingRef

**Description:** A reference to a Product Offering offered by the Seller to the
Buyer. A Product Offering contains the commercial and technical details of a
Product sold by a particular Seller. A Product Offering defines all of the
commercial terms and, through association with a particular Product
Specification, defines all the technical attributes and behaviors of the
Product. A Product Offering may constrain the allowable set of configurable
technical attributes and/or behaviors specified in the associated Product
Specification.

<table id="T_ProductOfferingRef">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>href</td>
            <td>string</td>
            <td>Hyperlink to a Product Offering in Sellers catalog. In case Seller is not providing a catalog API this field is not used. The catalog is provided by the Seller to the Buyer during onboarding.
</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>id*</td>
            <td>string</td>
            <td>id of a Product Offering. It is assigned by the Seller. The Buyer and the Seller exchange information about offerings&#x27; ids during the onboarding process.</td>
            <td>Product Offering ID</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.15. Type ProductRelationship

**Description:** A relationship to existing Product. The requirements for usage
for given Product are described in the Product Specification.

<table id="T_ProductRelationship">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id*</td>
            <td>string</td>
            <td>unique identifier</td>
            <td>Seller Product Identifier</td>
        </tr><tr>
            <td>href</td>
            <td>string</td>
            <td>Hyperlink of the referenced product</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>relationshipType*</td>
            <td>string</td>
            <td>Specifies the type (nature) of the relationship to the related Product. The nature of required relationships vary for Products of different types. For example, a UNI or ENNI Product may not have any relationships, but an Access E-Line may have two mandatory relationships (related to the UNI on one end and the ENNI on the other). More complex Products such as multipoint IP or Firewall Products may have more complex relationships. As a result, the allowed and mandatory &#x60;relationshipType&#x60; values are defined in the Product Specification.</td>
            <td>Relationship Nature</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.16. Type ProductSpecificationRef

**Description:** A reference to a structured set of well-defined technical
attributes and/or behaviors that are used to construct a Product Offering for
sale to a market.

<table id="T_ProductSpecificationRef">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>href</td>
            <td>string</td>
            <td>Hyperlink to a Product Specification in Sellers catalog. In case Seller is not providing a catalog API this field is not used. The catalog is provided by the Seller to the Buyer during onboarding.
</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>id*</td>
            <td>string</td>
            <td>Unique identifier of the product specification</td>
            <td>Product Specification ID</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.17. Type RelatedContactInformation

**Description:** Contact information of an individual or organization playing a
role for this Entity. The rule for mapping a represented attribute value to a
`role` is to use the _lowerCamelCase_ pattern e.g.

- Buyer Order Item Contact: `role=buyerOrderItemContact`
- Buyer Implementation Contact: `role=buyerImplementationContact`
- Buyer Technical Contact: `role=buyerTechnicalContact`

<table id="T_RelatedContactInformation">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>emailAddress*</td>
            <td>string</td>
            <td>Email address</td>
            <td>Contact email Address</td>
        </tr><tr>
            <td>name*</td>
            <td>string</td>
            <td>Name of the contact</td>
            <td>Contact Name</td>
        </tr><tr>
            <td>number*</td>
            <td>string</td>
            <td>Phone number</td>
            <td>Contact Phone Number</td>
        </tr><tr>
            <td>numberExtension</td>
            <td>string</td>
            <td>Phone number extension</td>
            <td>Contact Phone Number Extension</td>
        </tr><tr>
            <td>organization</td>
            <td>string</td>
            <td>The organization or company that the contact belongs to</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>role*</td>
            <td>string</td>
            <td>A role the party plays in a given context.</td>
            <td>Contact Role</td>
        </tr><tr>
            <td>postalAddress</td>
            <td><a href="#T_FieldedAddress">FieldedAddress</a></td>
            <td>Identifies the postal address of the person or office to be contacted.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

The `role` attribute is used to provide a reason the particular party
information is used. It can result from MEF 57.2 requirements (e.g. Seller
Contact Information) or from the Product Specification requirements.

The rule for mapping a represented attribute value to a `role` is to use the
_lowerCamelCase_ pattern e.g.

- Seller Contact: `role` equal to `sellerContact`
- Buyer Contact Information: `role` equal to `buyerContactInformation`

#### 7.2.2.18. Type RelatedGeographicSite

**Description:** A Geographic Site and an associated role as installation
address, delivery address, etc....

<table id="T_RelatedGeographicSite">
    <thead style="font-weight:bold;">
        <tr>
            <td>Name</td>
            <td>Type</td>
            <td>Description</td>
            <td>MEF 81</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id*</td>
            <td>string</td>
            <td>Unique identifier of the geographic site</td>
            <td>Service Site Identifier</td>
        </tr><tr>
            <td>href</td>
            <td>string</td>
            <td>Unique reference of the geographic site</td>
            <td>Not represented in MEF 81</td>
        </tr><tr>
            <td>role*</td>
            <td>string</td>
            <td>Role of the geographic site, such as: [home delivery], [shop retrieval]) MEF: The role that the Site plays, e.g. Billing Address, UNI Site, or ENNI Site.</td>
            <td>Not represented in MEF 81</td>
        </tr>
    </tbody>
</table>

#### 7.2.2.19. `enum` TimeUnit

**Description:** Represents a unit of time.

<table id="T_TimeUnit">
    <thead style="font-weight:bold;">
        <tr>
            <td>Value</td>
            <td>MEF 81</td>
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
            <td>CALENDAR_MINUTES</td>
        </tr><tr>
            <td>businessDays</td>
            <td>BUSINESS_DAYS</td>
        </tr><tr>
            <td>businessHours</td>
            <td>BUSINESS_HOURS</td>
        </tr><tr>
            <td>businessMinutes</td>
            <td>BUSINESS_MINUTES</td>
        </tr>
    </tbody>
</table>

**[R16]** The clarification of what Business days, hours, and minutes mean
**MUST** be done between the Buyer and the Seller during the onboarding
process.

# 8. References

- [OAS-v3] [Open API 3.0](http://spec.openapis.org/oas/v3.0.3.html), February
  2020
- [JS]
  [JSON Schema draft 7](https://json-schema.org/specification-links.html#draft-7),
  JSON Schema: A Media Type for Describing JSON Documents and associated
  documents, by Austin Wright and Henry Andrews, March 2018. Copyright © 2018
  IETF Trust and the persons identified as the document authors. All rights
  reserved.
- [REST]
  [Chapter 5: Representational State Transfer (REST)](http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
  Fielding, Roy Thomas, Architectural Styles and the Design of Network-based
  Software Architectures (Ph.D.).
- [MEF55.1]
  [MEF 55.1](https://www.mef.net/wp-content/uploads/2021/02/MEF-55.1.pdf)
  Lifecycle Service Orchestration (LSO): Reference Architecture and Framework,
  February 2021
- [MEF79] [MEF 79](https://www.mef.net/wp-content/uploads/2019/11/MEF-79.pdf),
  Address, Service Site, and Product Offering Qualification Management,
  Requirements and Use Cases, November 2019
- [MEF80] [MEF 80](https://www.mef.net/wp-content/uploads/MEF-80.pdf), Quote
  Management Requirements and Use Cases, July 2021
- [TMF637]
  [TMF 674](https://projects.tmforum.org/wiki/download/attachments/123080633/TMF637_Product_Inventory_Management_API_REST_Specification_R19.0.0.pdf)
  TMF637 Product Inventory Management API REST Specification R19.0.0, June 2019
