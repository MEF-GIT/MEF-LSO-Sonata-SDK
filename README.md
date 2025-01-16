# MEF-LSO-Sonata-SDK - Irene Release

## Download Link

Download the entire repository by clicking
[here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/irene/MEF-LSO-Sonata-SDK-irene.zip)

## Introduction

This repository contains the MEF LSO Sonata SDK. It includes API definitions for
the following functional areas:

- Product Catalog
- Serviceability
  - Address Validation
  - Site Retrieval
  - Product Offering Qualification Management
- Product Offering Availability and Pricing Discovery
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

No new APIs were introduced.

There is a major change in Geographic Address model, introduced by MEF 150. It
is implemented consistently across all the APIs.

There are also changes and fixes to some patterns:

- Revised, fully specialized Event model.
- State change events now carry the value of the new `state`
- `buyerId` and `sellerId` in notification now carried via query params
  (consistent with seller side API)

There are the following document maturity changes:

- Updated documents:

  - MEF 110 Product Offering Availability and Pricing Discovery - Business
    Requirements and Use Cases
  - MEF W142 - LSO Cantata and LSO Sonata Product Catalog API & Developer Guide
  - MEF W160 - LSO Cantata and LSO Sonata Product Offering Availability and
    Pricing Discovery API - Developer Guide

- New Documents:
  - MEF 57.2.1 Draft Release 1 Amendment to MEF 57.2: Product Order Management
    Business Requirements and Use Cases
  - MEF 79.1 Draft Release 1 Product Offering Qualification Management Business
    Requirements and Use Cases
  - MEF 80.0.1 Draft Release 1 Amendment to MEF 80: Quote Management
    Requirements and Use Cases
  - MEF 110 Draft Release 4 Product Offering Availability and Pricing
    Discovery - Business Requirements and Use Cases
  - MEF 127.1 - LSO Cantata and LSO Sonata Product Catalog - Business
    Requirements and Use Cases
  - MEF 150 Draft Release 1 Installation Place and Service Site Management
    Business Requirements and Use Cases
  - MEF W87.1 - LSO Cantata and LSO Sonata Product Offering Qualification API -
    Developer Guide
  - MEF W115.1 - LSO Cantata and LSO Sonata Quote Management API - Developer
    Guide
  - MEF W116.1- LSO Cantata and LSO Sonata Product Inventory API - Developer
    Guide
  - MEF W121.1 - LSO Cantata and LSO Sonata Address Management API - Developer
    Guide
  - MEF W122.1 - LSO Cantata and LSO Sonata Site Management API - Developer
    Guide
  - MEF W123.1 - LSO Cantata and LSO Sonata Product Ordering Management API -
    Developer Guide
  - MEF W124.1 - LSO Cantata and LSO Sonata Trouble Ticket and Incident
    Management API - Developer Guide
  - MEF W137.1 - LSO Cantata and LSO Sonata Appointment and Work Order
    Management API - Developer Guide
  - MEF W141.1 - LSO Cantata and LSO Sonata Billing Management API - Developer
    Guide

- Superseded Documents:
  - MEF 79 - Address, Service Site, and Product Offering Qualification Management Requirements and Use Cases
  - MEF 79.0.1 - Amendment to MEF 79: Address, Service Site, and Product Offering Qualification Management Requirements and Use Cases
  - MEF 79.0.2 - Amendment to MEF 79: Address Validation
  - MEF 127 - LSO Cantata and LSO Sonata Product Catalog - Business Requirements and Use Cases

The [LSO Marketplace](http://lso.mef.net) offers the possibility to blend the
desired APIs with chosen Products. Thus the APIs blended with all products that
were available in `generated/staticBinding` are no longer provided.

**NOTE:** Please note the Readme files in particular productApi directories to
see detailed release notes per API.

## Maturity Level

The API files contained in this SDK are evolving and subject to change. They are
based on documents that are either ratified standards or draft standards that
have not yet completed the review cycles and approvals necessary to achieve the
status as a MEF standard. MEF is making these publicly available at this time to
invite wider industry review.

The maturity per functionality is presented as follows:

(\*) is used to mark an item that changes its maturity compared to the previous
release.

- Product Catalog:
  - Business Requirements:
    - \*MEF 127.1 - **Draft Release 1**
  - Developer Guide/API:
    - \*MEF W142 - **work in progress - ready for CfC#3**
- Address Validation, Site Query:
  - Business Requirements:
    - \*MEF 150 - **Draft Release 1**
  - Developer Guide/API:
    - \*MEF W121.1 - Address Management - **work in progress - CfC#1 Resolved. Ready for LB**
    - \*MEF W122.1 - Site Management - **work in progress - CfC#1 Resolved. Ready for LB**
- Product Offering Qualification:
  - Business Requirements:
    - \*MEF 79.1 - **Draft Release 1**
  - Developer Guide/API:
    - \*MEF W87.1 - **work in progress - CfC#1 Resolved. Ready for LB**
- Quote:
  - Business Requirements:
    - MEF 80 - **Published Standard**
    - \*MEF 80.0.1 - **Draft Release 1**
  - Developer Guide/API:
    - \*MEF W115.1 - **work in progress - ready for CfC#1**
- Product Offering Availability and Pricing Discovery:
  - Business Requirements:
    - \*MEF 110 - **Draft Standard R4**
  - Developer Guide/API:
    - \*MEF W160: - **work in progress - ready for CfC#4**
- Order:
  - Business Requirements:
    - MEF 57.2 - **Published Standard**
    - \*MEF 57.2.1 - **Draft Release 1**
  - Developer Guide/API:
    - \*MEF W123.1 - **work in progress - ready for CfC#1**
- Inventory:
  - Business Requirements:
    - MEF 81, MEF 81.0.1 - **Published Standard**
  - Developer Guide/API
    - \*MEF W116.1 - **work in progress - ready for CfC#1**
- Trouble Ticket:
  - Business Requirements:
    - MEF 113 - **Published Standard**
  - Developer Guide/API
    - \*MEF W124.1 - Trouble Ticket - **work in progress - ready for CfC#1**
    - \*MEF W137.1 - Appointment - **work in progress - ready for CfC#1**
- Billing:
  - Business Requirements:
    - MEF 134 - **Published Standard**
  - Developer Guide/API
    - \*MEF W141 - **work in progress - ready for CfC#1**
- Product Specifications:
  - MEF 106 - Access E-Line - **Published Standard**
  - MEF 125 - Subscriber Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE) -
    **Published Standard**
  - MEF 125.0.1 - Amendment to Subscriber Ethernet - **Published Standard**
  - MEF 139 - Basic and Advanced Internet Access - **Published Standard**
- Security:
  - MEF 128.1 - **Published Standard**

For high-level information about the release compatibility and roadmap please
visit: [LSO Marketplace](https://lso.mef.net/lso-api-sdk-releases)

For details on the maturity map and the roadmap for future releases please refer
to [LSO Sonata SDK Home Page](https://wiki.mef.net/display/CESG/LSO+Sonata+SDK)
on the MEF WIKI.

## Contents

This SDK contains the following items:

- `COPYRIGHT` - Copyright 2022 MEF Forum
- `LICENSE` - Contains a copy of the Apache 2.0 license
- `README` - This file
- `productApi` - Definitions of the APIs - yaml files with schemas
- `documentation` - All related standards and Developer Guides
  - `productApi` - API-related documentation - API Developer Guides
  - `productSchema` - Product-related documentation - Product schema guides
  - `supportingStandards` - The rest of the documents and standards.
- `ProductSchema` - Product Specification schemas
- `generated`
  - `staticBinding` - No longer provided - please visit
    [LSO Marketplace](http://lso.mef.net) to use self-blending possibility.
  - `security` - A not normative version of the standard APIs including the
    security profiles as required by MEF 128.1. Provided for evaluation.

## Issues, Questions, and Feedback

Issues should be reported with the use of GitHub issues. Questions and feedback
should be asked either at
[Sonata SDK Discussions](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/discussions)
or directly to community_manager@mef.net.

**NOTE:** All artifacts included in this repository have line numbers. When
referring to specific content in any of these artifacts, please quote the line
numbers to which you are referring.

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Copyright

© MEF Forum 2025. All Rights Reserved.

## Disclaimer

The information in this publication is freely available for reproduction and use
by any recipient and is believed to be accurate as of its publication date. Such
information is subject to change without notice and MEF Forum (MEF) is not
responsible for any errors. MEF does not assume responsibility to update or
correct any information in this publication. No representation or warranty,
expressed or implied, is made by MEF concerning the completeness, accuracy, or
applicability of any information contained herein and no liability of any kind
shall be assumed by MEF as a result of reliance upon such information.

The information contained herein is intended to be used without modification by
the recipient or user of this document. MEF is not responsible or liable for any
modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way
create, by implication or otherwise:

(a) any express or implied license or right to or under any patent, copyright,
trademark or trade secret rights held or claimed by any MEF member which are or
may be associated with the ideas, techniques, concepts or expressions contained
herein; nor

(b) any warranty or representation that any MEF member will announce any
product(s) and/or service(s) related thereto, or if such announcements are made,
that such announced product(s) and/or service(s) embody any or all of the ideas,
technologies, or concepts contained herein; nor

(c) any form of relationship between any MEF member and the recipient or user of
this document.

Implementation or use of specific MEF standards, specifications, or
recommendations will be voluntary, and no Member shall be obliged to implement
them by virtue of participation in MEF Forum. MEF is a non-profit international
organization to enable the development and worldwide adoption of agile, assured,
and orchestrated network services. MEF does not, expressly or otherwise, endorse
or promote any specific products or services.
