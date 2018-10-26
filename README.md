# MEF-LSO-Sonata-SDK

This repository contains the MEF LSO Sonata SDK. It includes API definitions for the following functional areas:

*  Serviceability (Address/Site validation and Product Offering Qualification)
*  Product Quote
*  Product Order
*  Product Inventory

It also holds Payload Descriptions for the following structures that are used with these APIs
*  JSON representations for Product Spec descriptions (initially for MEF Access Eline services)
*  JSON representations for Place description

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Maturity Level
These files are in the Working Draft state.  It is work in progress and is subject to change.  This work has not yet successfully completed the review cycles and approvals necessary to achieve the status as a MEF standard.  The MEF is making these publicly available at this time to invite wider industry review.

## Contents

This SDK contains the following items:

*	COPYRIGHT - Copyright 2018 MEF Forum
*	LICENSE - Contains a copy of the Apache 2.0 license
*  README - This file
*  payload_description - Common descriptors are found in this directory
	*  PlaceDescription – Contains reference JSON schemas for place description.
	*  ProductSpecDescription – Contains reference JSON schemas for product specification description.
*  api - Definitions of the API are found in this directory
	*  Inventory -
	*  Quote -
	*  Serviceability - 
	*  ProductOrder - Contains the API definitions for inter-carrier service ordering capability.

All supersceded files can be found in the Git history, if needed.


## Precedents
Any developer intending to use the materials in this repository should first thoroughly read, review and understand the following materials:
*  [MEF 55: Lifecycle Service Orchestration (LSO): Reference Architecture and Framework](https://www.mef.net/resources/technical-specifications/download?id=44&fileid=file1) This document is a ratified MEF standard.
*  [MEF 55.0.1: Amendment to MEF55: Operational Threads](https://www.mef.net/resources/technical-specifications/download?id=99&fileid=file1) This document is a ratified MEF standard.
*  [MEF 50.1: MEF Services Lifecycle Process Flows](https://www.mef.net/resources/technical-specifications/download?id=96&fileid=file1) This document is a ratified MEF standard.
*  [Serviceability Management Technical Specification](https://wiki.mef.net/download/attachments/75990189/Serviceability%20Technical%20Specification.docx?api=v2) This document is in final ballot to become a MEF standard.
*  [Quote Management Technical Specification](https://wiki.mef.net/download/attachments/75990189/Quote%20Technical%20Specification.docx?api=v2) This document is in final ballot to become a MEF standard.
*  [Ethernet Ordering Technical Specification](https://wiki.mef.net/download/attachments/82222506/L67002_001_MEF57.1_LB_Kaplan.pdf?version=1&modificationDate=1537985603000&api=v2) This document is in final ballot to become a MEF standard.
*  [Inventory Management Technical Specification](https://wiki.mef.net/download/attachments/75990189/Product%20Inventory%20Technical%20Specification.docx?api=v2) This document is in final ballot to become a MEF standard.
*  [API Developer Guide: Serviceability](https://wiki.mef.net/download/attachments/75990189/Serviceability%20API%20Developer%20Guide.docx?api=v2) This document is a working draft and is subject to change.
*  [API Developer Guide: Quote Management](https://wiki.mef.net/download/attachments/75990189/Quote%20%20API%20Developer%20Guide.docx?api=v2) This document is a working draft and is subject to change.
*  [API Developer Guide: Product Order Management](https://wiki.mef.net/download/attachments/75990189/Product%20Ordering%20API%20Developer%20%20Guide.docx?api=v2) This document is a working draft and is subject to change.
*  [API Developer Guide: Product Inventory Management](https://wiki.mef.net/download/attachments/75990189/Product%20Inventory%20Technical%20Specification.docx?api=v2) This document is a working draft and is subject to change.

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

© MEF Forum 2018. All Rights Reserved.
