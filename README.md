# MEF-LSO-Sonata-SDK (Release Candidate 5)

This repository contains the MEF LSO Sonata SDK.
It includes API definitions for the following functional areas:

* Serviceability (Address, Service Site, and Product Offering Qualification Management)
* Product Quote
* Product Order
* Product Inventory

It also provides Product Specification for Access ELine as delivered by MEF W106

## High level release notes

* *MEF W87 - LSO Sonata Product Offering Qualification API - Developer Guide.* The first of a series of developer guides that explain the details of MEF API usage, process flows and the pattern resulting from the combining of the TMF-based envelope with Product Specifications. It comes with the update of POQ API Specification.

* *MEF W106 - LSO Sonata Product Specification - Access E-Line* which includes JSON schemas and the Requirements document.

* Update of all of LSO Sonata APIs:
  * Use of TM Forum tooling based on Domain Context Specialisation rules to ensure alignment with TM Forum APIs (see [MEF-TMF-ONAP-Collaboration](https://wiki.mef.net/pages/viewpage.action?pageId=106608028))
  * Introduction of envelope-payload and product characteristic patterns as described in MEF W87
  * Bug fixes and improvements

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Maturity Level
The API files contained in this SDK are evolving and subject to change.  They are based on documents that are either ratified standards, or draft standards that have not yet completed the review cycles and approvals necessary to achieve the status as a MEF standard.  MEF is making these publicly available at this time to invite wider industry review.

The maturity per functionality presents as follows:

* Address Validation, Site Query:
  * Business Requirements MEF 79 - **Published Standard**
  * Developer Guide - **none**
  * API - **work in progress**
* Product Offering Qualification:
  * Business Requirements MEF 79 - **Published Standard**
  * Developer Guide - MEF W87 - **work in progress - closed resolution of CfC#1**
  * API - MEF W87 - **work in progress - closed resolution of CfC#1**
* Quote:
  * Business Requirements - MEF W80 - **Draft (R7)**
  * Developer Guide - **open project, not yet included**
  * API - **work in progress, aligned with MEF W80 Draft (R)**
* Order:
  * Business Requirements - MEF 57.1 - **Published Standard** (the next version MEF W57.2 is being finalized)
  * Developer Guide - **none**
  * API - **work in progress**
* Inventory:
  * Business Requirements - MEF 81, MEF 81.0.1 **Published Standard**
  * Developer Guide - **none**
  * API - **work in progress**
  
For details on the maturity map and a roadmap for future releases please refer to [LSO Sonata SDK Home Page](https://wiki.mef.net/display/CESG/LSO+Sonata+SDK) on MEF WIKI.

## Contents

This SDK contains the following items:

*  COPYRIGHT - Copyright 2019 MEF Forum
*  LICENSE - Contains a copy of the Apache 2.0 license
*  README - This file
*  payload_description - Common descriptors are found in this directory
	*  ProductSpecDescription – Contains reference JSON schemas for product specification description.
*  api - Definitions of the API are found in this directory
	*  Inventory - Contains the API definitions necessary for inter-carrier retrieval  of  Product  Inventory
	*  Quote - Contains the API definitions for inter-carrier service quotation capability
	*  Serviceability - Contains the API definitions that allow the Service Provider, or Buyer to:
		* Retrieve Address information including exact formats for Addresses known to the Seller
		* Retrieve Service Site information including exact formats for Service Sites known to the Seller
		* Determine whether it is feasible for the Seller to deliver a particular Product with a given configuration to a particular geographic location if applicable.
	*  ProductOrder - Contains the API definitions for inter-carrier service ordering capability.
*  documentation - This contains the draft standards of the Business Requirements and Use Cases for
	* Address, Service Site, and Product Offering Qualification Management (MEF 79 Draft (R3))
	* Product Order Management (MEF 80 Draft (R2))
	* Product Inventory Management (MEF 81 Draft (R3))

All superseded files can be found in the Git history, if needed.

## Precedents
Any developer intending to use the materials in this repository should first thoroughly read, review and understand the following materials:
*  [MEF 55: Lifecycle Service Orchestration (LSO): Reference Architecture and Framework](documentation/MEF%2055%20-%20LSO%20Reference%20Architecture%20and%20Framework.pdf) This document is a ratified MEF standard.
*  [MEF 55.0.1: Amendment to MEF 55: Operational Threads](documentation/MEF%2055.0.1%20-%20Operational%20Threads.pdf) This document is a ratified MEF standard.
*  [MEF 55.0.2: Amendment to MEF 55: TOSCA Services Templates](documentation/MEF%2055.0.2%20-%20TOSCA%20Service%20Templates.pdf) This document is a ratified MEF standard.
*  [MEF 50.1: MEF Services Lifecycle Process Flows](documentation/MEF%2050.1%20-%20MEF%20Services%20Lifecycle%20Process%20Flows.pdf) This document is a ratified MEF standard.
*  [MEF 57.1: Ethernet Ordering Technical Standard - Business Requirements and Use Cases](documentation/MEF%2057.1%20-%20Ethernet%20Ordering%20Technical%20Specification%20-%20Business%20Requirements%20and%20Use%20Cases.pdf) This document is a ratified MEF standard.
*  [MEF 79: Address, Service Site, and Product Offering Qualification Management](documentation/MEF%2079%20-%20Address%2C%20Service%20Site%2C%20and%20Product%20Offering%20Qualification%20Management.pdf) This document is a ratified MEF standard.
*  [MEF 79.0.1 Draft (R2) - Amendment to MEF 79 Address, Service Site, and Product Offering Qualification Management Requirements and Use Cases](documentation/MEF%2079.0.1%20Draft%20(R2)%20-%20Amendment%20to%20MEF%2079%20Address,%20Service%20Site,%20and%20Product%20Offering%20Qualification%20Management%20Requirements%20and%20Use%20Cases.pdf)
*  [MEF 80 Draft (R7): Quote Management](documentation/MEF%2080%20Draft%20(R7)%20-%20Quote%20Management.pdf)
*  [MEF 81: Product Inventory Management](documentation/MEF%2081%20-%20Product%20Inventory%20Management.pdf)
*  [MEF 81.0.1: Amandment to MEF81 Product Inventory Management](documentation/MEF%2081.0.1%20-%20Amandment%20to%20MEF81%20Product%20Inventory%20Management.pdf)
* [MEF W87: LSO Sonata Product Offering Qualification API - Developer Guide](TODO)
* [MEF W106: LSO Sonata Product Specification - Access E-Line](TODO)

## Reference Implementations

**1) LSO Sonata APIs (older version) implementation on Buyer side - contributed by Amdocs**

   The example implementation of MEF LSO Sonata APIs on Buyer side provided by Amdocs. This example code is part of the solution between a Tier1 North American operator, Amdocs and a UK provider that was put into production in April 2019 to enable the automated ordering of Ethernet services.
   
   This LSO Sonata reference implementation is available on GitHub for MEF Members:

   https://github.com/MEF-GIT/Example-LSO-Sonata-Buyer-Implementation
   
   **NOTE:** If you are a MEF Member, please follow: [How do I get access to MEF GitHub?](https://wiki.mef.net/pages/viewpage.action?pageId=106624756)
   
   **NOTE:** This example LSO Sonata implementation does not provide an executable or runnable project and it is based on the older APIs version published in the "2018-dev-preview" release of the LSO Sonata SDK which is available here:
   https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/tag/2018-dev-preview

## Questions and Feedback
Questions and Feedback should be directed to LSO-Sonata@mef.net.  All artifacts included in this repository have line numbers.  When referring to specific content in any of these artifacts, please quote the line numbers to which you are referring.

# Disclaimer & Copyright

The information in this publication is freely available for reproduction and use by any recipient and is believed to be accurate as of its publication date. Such information is subject to change without notice and MEF Forum (MEF) is not responsible for any errors. MEF does not assume responsibility to update or correct any information in this publication. No representation or warranty, expressed or implied, is made by MEF concerning the completeness, accuracy, or applicability of any information contained herein and no liability of any kind shall be assumed by MEF as a result of reliance upon such information.

The information contained herein is intended to be used without modification by the recipient or user of this document. MEF is not responsible or liable for any modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way create, by implication or otherwise:

(a) any express or implied license or right to or under any patent, copyright, trademark or trade secret rights held or claimed by any MEF member which are or may be associated with the ideas, techniques, concepts or expressions contained herein; nor

(b) any warranty or representation that any MEF member will announce any product(s) and/or service(s) related thereto, or if such announcements are made, that such announced product(s) and/or service(s) embody any or all of the ideas, technologies, or concepts contained herein; nor

(c) any form of relationship between any MEF member and the recipient or user of this document.

Implementation or use of specific MEF standards, specifications, or recommendations will be voluntary, and no Member shall be obliged to implement them by virtue of participation in MEF Forum. MEF is a non-profit international organization to enable the development and worldwide adoption of agile, assured and orchestrated network services. MEF does not, expressly or otherwise, endorse or promote any specific products or services.

© MEF Forum 2020. All Rights Reserved.
