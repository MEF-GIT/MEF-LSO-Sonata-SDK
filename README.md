# MEF-LSO-Sonata-SDK - Billie Release

## Theme: Ordering and Inventory

## Download Link

Download the entire repository by clicking [here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/billie-final/MEF-LSO-Sonata-SDK-billie.zip)

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

It also provides Product Schemas for:

- Access E-Line
- EPL
- EPLAN
- EPTREE
- EVPL
- EVPLAN
- EVPTREE

## High-level release notes

The theme of this release is **Ordering and Inventory**: it delivers full coverage of Business Requirements, API and API Developer Guides for all above mentioned Sonata API functions.

- All APIs have been reviewed and updated to follow their respective Business Requirements & Use Cases and Developer Guides documents
- All API definitions are provided in OAS 3.0 standard.
- New documents:
  - MEF W116 - LSO Cantata and LSO Sonata Product Inventory API - Developer Guide
  - MEF W123 - LSO Cantata and LSO Sonata Product Order Management API - Developer Guide
  - MEF W124 - LSO Cantata and LSO Sonata Trouble Ticketing API - Developer Guide
  - MEF W125 - LSO Cantata and LSO Sonata Product Specification - Subscriber Ethernet - Schema Guide

**NOTE:** Please note the Readme files in particular directories that provide more detailed information about corresponding functionalities.

## Maturity Level

The API files contained in this SDK are evolving and subject to change. They are based on documents that are either ratified standards or draft standards that have not yet completed the review cycles and approvals necessary to achieve the status as a MEF standard. MEF is making these publicly available at this time to invite wider industry review.

The maturity per functionality presents as follows:

- Address Validation, Site Query:
  - Business Requirements
    - MEF 79 - **Published Standard**
    - MEF 79.0.2 - **Draft Release 2, Letter Ballot pending**
  - Developer Guide/API
    - MEF W121 - LSO Sonata Address Management API - Developer Guide - **work in progress - CfC#1 reviewed**
    - MEF W122 - LSO Sonata Site Management API - Developer Guide - **work in progress - CfC#1 reviewed**
- Product Offering Qualification:
  - Business Requirements
    - MEF 79 - **Published Standard**
    - MEF 79.0.1 - **Published Standard**
  - Developer Guide/API - MEF W87 - **work in progress - Draft Standard (R1), Ready for CfC#4**
- Quote:
  - Business Requirements - MEF W80 - **Draft Release 6, Letter Ballot pending**
  - Developer Guide/API- MEF W115 - LSO Sonata Quote Management API - Developer Guide - **work in progress, CfC#1 reviewed**
- Order:
  - Business Requirements - MEF 57.2 - **Draft Release 2**
  - Developer Guide/API - **work in progress - ready for CfC#1**
- Inventory:
  - Business Requirements - MEF 81, MEF 81.0.1 **Published Standard**
  - Developer Guide/API - **work in progress - ready for CfC#1**
- Product Specifications:
  - Access E-Line - MEF W106 **work in progress, CfC#2 reviewed**
  - EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE - **work in progress**

For details on the maturity map and the roadmap for future releases please refer to [LSO Sonata SDK Home Page](https://wiki.mef.net/display/CESG/LSO+Sonata+SDK) on the MEF WIKI.

## Contents

This SDK contains the following items:

- `COPYRIGHT` - Copyright 2021 MEF Forum
- `LICENSE` - Contains a copy of the Apache 2.0 license
- `README` - This file
- `productApi` - Definitions of the API are found in this directory
  - `inventory` - Contains the API definitions necessary for inter-carrier retrieval of Product Inventory
  - `order` - Contains the API definitions for inter-carrier service ordering capability.
  - `quote` - Contains the API definitions for inter-carrier service quotation capability
  - `serviceability` - Contains the APIs that allow the Service Provider or Buyer to perform:
    - `address` - Retrieve Address information including exact formats for Addresses known to the Seller
    - `offeringQualification` - Determine whether it is feasible for the Seller to deliver a particular Product with a given configuration to a particular geographic location if applicable.
    - `site` - Retrieve Service Site information including exact formats for Service Sites known to the Seller
  - `troubleTicket` - Create and manage Trouble Tickets
- `documentation` - All related standards and Developer Guides.
  - `productApi` - API related documentation - Developer Guides
    - `inventory` - MEF W116 Developer Guide
    - `order` - MEF W123 Developer Guide
    - `quote` - MEF W115 Developer Guide
    - `serviceability/address` - MEF W121 Developer Guide
    - `serviceability/offeringQualification` - MEF W87 Developer Guide
    - `serviceability/site` - MEF W122 Developer Guide
    - `troubleTicket` - MEF W124 Developer Guide
  - `productSchema` - product related documentation
    - `carrierEthernet` - MEF W106 and MEF W125 Product Schema Guides
  - `supportingStandards` - The rest of documents and standards.
- `ProductSchema` - Product Specification schemas for:
  - `carrierEthernet` - Carrier Ethernet product Schemas
- `generated/staticBinding/full` - contains automatically generated (with help of the open source [Sonata Blending Tool](https://github.com/Amartus/SonataBlendingTool)), not normative static bindings of envelope APIs with all Product Specifications. The Address, Site and Trouble Ticket APIs are not included as they do not carry product information.

## Issues, Questions, and Feedback

Issues should be reported with the use of GitHub issues. Questions and feedback should be asked either at [Sonata SDK Community](https://github.com/orgs/MEF-GIT/teams/mef-lso-sonata-sdk-community) or directly to community_manager@mef.net.

**NOTE:** All artifacts included in this repository have line numbers. When referring to specific content in any of these artifacts, please quote the line numbers to which you are referring.

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Copyright

© MEF Forum 2021. All Rights Reserved.

## Disclaimer

The information in this publication is freely available for reproduction and use by any recipient and is believed to be accurate as of its publication date. Such information is subject to change without notice and MEF Forum (MEF) is not responsible for any errors. MEF does not assume responsibility to update or correct any information in this publication. No representation or warranty, expressed or implied, is made by MEF concerning the completeness, accuracy, or applicability of any information contained herein and no liability of any kind shall be assumed by MEF as a result of reliance upon such information.

The information contained herein is intended to be used without modification by the recipient or user of this document. MEF is not responsible or liable for any modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way create, by implication or otherwise:

(a) any express or implied license or right to or under any patent, copyright, trademark or trade secret rights held or claimed by any MEF member which are or may be associated with the ideas, techniques, concepts or expressions contained herein; nor

(b) any warranty or representation that any MEF member will announce any product(s) and/or service(s) related thereto, or if such announcements are made, that such announced product(s) and/or service(s) embody any or all of the ideas, technologies, or concepts contained herein; nor

(c) any form of relationship between any MEF member and the recipient or user of this document.

Implementation or use of specific MEF standards, specifications, or recommendations will be voluntary, and no Member shall be obliged to implement them by virtue of participation in MEF Forum. MEF is a non-profit international organization to enable the development and worldwide adoption of agile, assured, and orchestrated network services. MEF does not, expressly or otherwise, endorse or promote any specific products or services.
