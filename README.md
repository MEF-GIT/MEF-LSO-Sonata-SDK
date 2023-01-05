# MEF-LSO-Sonata-SDK - Ella Release

## Download Link

Download the entire repository by clicking [here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/ella/MEF-LSO-Sonata-SDK-ella.zip)

## Introduction

This repository contains the MEF LSO Sonata SDK. It includes API definitions for the following functional areas:

- Serviceability
  - Address
  - Site Retrieval
  - Product Offering Qualification Management
- Product Quote
- Product Order
- Product Inventory
- Trouble Ticket
  - Appointment
  - Work Order

It also provides Product Schemas for:

- Access E-Line
- Subscriber Carrier Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE)
- Internet Access

## High-level release notes

- Documents published as MEF Standards:
  - MEF 57.2 - Product Order Management Requirements and Use Cases
  - MEF 113 - Trouble Ticketing Requirements and Use Cases
  - MEF 128 - LSO API Security Profile
- Following documents have their Letter Ballots open and will be likely shortly published as MEF standards:
  - MEF W123 - LSO Cantata and LSO Sonata Product Order Management API - Developer Guide
  - MEF W124 - LSO Cantata and LSO Sonata Trouble Ticket and Incident Management API - Developer Guide
  - MEF W137 - LSO Cantata and LSO Sonata Appointment Management API - Developer Guide
  - MEF W134 - Billing and Invoice Business Requirements and Use Cases
  - MEF W106 - LSO Sonata Access E-Line Product Schemas and Developer Guide
  - MEF W125 - LSO Cantata and LSO Sonata - Subscriber Ethernet Product Schemas and Developer Guide
- New documents:
  - MEF W141 - LSO Cantata and LSO Sonata Billing Management API - Developer Guide
  - MEF W125.0.1 - Amendment to MEF 125 LSO Cantata and LSO Sonata - Subscriber Ethernet Product Schemas and Developer Guide

The [LSO Marketplace](http://lso.mef.net) has introduced the possibility to blend the desired APIs with chosen Products. Thus the APIs blended with all products that were available in `generated/staticBinding` are no longer provided.

**NOTE:** Please note the Readme files in particular productApi directories to see detailed release notes per API.

## Maturity Level

The API files contained in this SDK are evolving and subject to change. They are based on documents that are either ratified standards or draft standards that have not yet completed the review cycles and approvals necessary to achieve the status as a MEF standard. MEF is making these publicly available at this time to invite wider industry review.

The maturity per functionality presents as follows:

(*) is used to mark item that changes their maturity comparing to previous release.

- Address Validation, Site Query:
  - Business Requirements:
    - MEF 79 - **Published Standard**
    - MEF 79.0.2 - **Published Standard**
  - Developer Guide/API:
    - MEF 121 - Address Management - **Published Standard**
    - MEF 122 - Site Management - **Published Standard**
- Product Offering Qualification:
  - Business Requirements:
    - MEF 79 - **Published Standard**
    - MEF 79.0.1 - **Published Standard**
  - Developer Guide/API:
    - MEF 87 - **Published Standard**
- Quote:
  - Business Requirements:
    - MEF 80 - **Published Standard**
  - Developer Guide/API:
    - MEF 115: - **Published Standard**
- Order:
  - Business Requirements:
    - *MEF 57.2 - **Published Standard**
  - Developer Guide/API:
    - *MEF W123 - **Letter Ballot**
- Inventory:
  - Business Requirements:
    - MEF 81, MEF 81.0.1 - **Published Standard**
  - Developer Guide/API
    - MEF 116 - **Published Standard**
- Trouble Ticket:
  - Business Requirements:
    - *MEF 113 - **Published Standard**
  - Developer Guide/API
    - *MEF W124 - Trouble Ticket - **Letter Ballot**
    - *MEF W137 - Appointment - **Letter Ballot**
- Billing:
  - Business Requirements:
    - *MEF W134 - **Letter Ballot**
  - Developer Guide/API
    - *MEF W141 - **work in progress - ready for CfC#1**
- Product Specifications:
  - *MEF W106 - Access E-Line - **Letter Ballot**
  - *MEF W125 - Subscriber Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE) - **Letter Ballot**
  - *MEF W125.0.1 - Amendment to Subscriber Ethernet - **work in progress - ready for CfC#1**
  - *MEF W139 - Basic and Advanced Internet Access - **work in progress - ready for CfC#2**
- Security:
  - MEF 128 - **Published Standard**


For details on the maturity map and the roadmap for future releases please refer to [LSO Sonata SDK Home Page](https://wiki.mef.net/display/CESG/LSO+Sonata+SDK) on the MEF WIKI.

## Contents

This SDK contains the following items:

- `COPYRIGHT` - Copyright 2022 MEF Forum
- `LICENSE` - Contains a copy of the Apache 2.0 license
- `README` - This file
- `productApi` - Definitions of the APIs - yaml files with schemas
- `documentation` - All related standards and Developer Guides
  - `productApi` - API related documentation - API Developer Guides
  - `productSchema` - Product related documentation - Product schema guides
  - `supportingStandards` - The rest of documents and standards.
- `ProductSchema` - Product Specification schemas
- `generated`
  - `staticBinding` - No longer provided - please visit [LSO Marketplace](http://lso.mef.net) to use self-blending possibility.
  - `security` - A not normative version of the standard APIs including the security profiles as required by MEF 128. Provided for evaluation.

## Issues, Questions, and Feedback

Issues should be reported with the use of GitHub issues. Questions and feedback should be asked either at [Sonata SDK Community](https://github.com/orgs/MEF-GIT/teams/mef-lso-sonata-sdk-community) or directly to community_manager@mef.net.

**NOTE:** All artifacts included in this repository have line numbers. When referring to specific content in any of these artifacts, please quote the line numbers to which you are referring.

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Copyright

© MEF Forum 2023. All Rights Reserved.

## Disclaimer

The information in this publication is freely available for reproduction and use by any recipient and is believed to be accurate as of its publication date. Such information is subject to change without notice and MEF Forum (MEF) is not responsible for any errors. MEF does not assume responsibility to update or correct any information in this publication. No representation or warranty, expressed or implied, is made by MEF concerning the completeness, accuracy, or applicability of any information contained herein and no liability of any kind shall be assumed by MEF as a result of reliance upon such information.

The information contained herein is intended to be used without modification by the recipient or user of this document. MEF is not responsible or liable for any modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way create, by implication or otherwise:

(a) any express or implied license or right to or under any patent, copyright, trademark or trade secret rights held or claimed by any MEF member which are or may be associated with the ideas, techniques, concepts or expressions contained herein; nor

(b) any warranty or representation that any MEF member will announce any product(s) and/or service(s) related thereto, or if such announcements are made, that such announced product(s) and/or service(s) embody any or all of the ideas, technologies, or concepts contained herein; nor

(c) any form of relationship between any MEF member and the recipient or user of this document.

Implementation or use of specific MEF standards, specifications, or recommendations will be voluntary, and no Member shall be obliged to implement them by virtue of participation in MEF Forum. MEF is a non-profit international organization to enable the development and worldwide adoption of agile, assured, and orchestrated network services. MEF does not, expressly or otherwise, endorse or promote any specific products or services.
