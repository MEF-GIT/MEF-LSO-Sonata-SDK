# MEF-LSO-Sonata-SDK (R3)

This repository contains the MEF LSO Sonata SDK. It includes API definitions for the following functional areas:

*  Serviceability (Address, Service Site, and Product Offering Qualification Management)
*  Product Quote
*  Product Order
*  Product Inventory

It also holds Payload Descriptions for the following structures that are used with these APIs
*  JSON representations for Product Spec descriptions (initially for MEF Access E-Line services)
*  JSON representations for the UNI attributes (sourced from MEF 57.1)

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Maturity Level
The API files contained in this SDK are evolving and subject to change.  They are based on documents that are either ratified standards, or draft standards that have not yet completed the review cycles and approvals necessary to achieve the status as a MEF standard.  MEF is making these publicly available at this time to invite wider industry review.

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
	* Address, Service Site, and Product Offering Qualification Management (MEF 79 Draft (R2))
	* Product Order Management (MEF 80 Draft (R2))
	* Product Inventory Management (MEF 81 Draft (R2))

All superseded files can be found in the Git history, if needed.

## Precedents
Any developer intending to use the materials in this repository should first thoroughly read, review and understand the following materials:
*  [MEF 55: Lifecycle Service Orchestration (LSO): Reference Architecture and Framework](documentation/MEF%2055%20-%20LSO%20Reference%20Architecture%20and%20Framework.pdf) This document is a ratified MEF standard.
*  [MEF 55.0.1: Amendment to MEF 55: Operational Threads](documentation/MEF%2055.0.1%20-%20Operational%20Threads.pdf) This document is a ratified MEF standard.
*  [MEF 55.0.2: Amendment to MEF 55: TOSCA Services Templates](documentation/MEF%2055.0.2%20-%20TOSCA%20Service%20Templates.pdf) This document is a ratified MEF standard.
*  [MEF 50.1: MEF Services Lifecycle Process Flows](documentation/MEF%2050.1%20-%20MEF%20Services%20Lifecycle%20Process%20Flows.pdf) This document is a ratified MEF standard.
*  [MEF 79 Draft (R2): Address, Service Site, and Product Offering Qualification Management](documentation/MEF%2079%20Draft%20(R2)%20-%20Address%2C%20Service%20Site%2C%20and%20Product%20Offering%20Qualification%20Management.pdf)
*  [MEF 80 Draft (R2): Quote Management](documentation/MEF%2080%20Draft%20(R2)%20-%20Quote%20Management.pdf)
*  [MEF 81 Draft (R2): Product Inventory Management](documentation/MEF%2081%20Draft%20(R2)%20-%20Product%20Inventory%20Management.pdf)
*  [MEF 57.1: Ethernet Ordering Technical Standard - Business Requirements and Use Cases](documentation/MEF%2057.1%20-%20Ethernet%20Ordering%20Technical%20Specification%20-%20Business%20Requirements%20and%20Use%20Cases.pdf) This document is a ratified MEF standard.

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

© MEF Forum 2019. All Rights Reserved.
