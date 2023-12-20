# MEF-LSO-Sonata-SDK - Grace Release

## Download Link

Download the entire repository by clicking
[here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/grace/MEF-LSO-Sonata-SDK-grace.zip)

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

There are the following document maturity changes:

- Documents published as MEF Standards:
  - MEF 123 - LSO Cantata and LSO Sonata Product Order Management API -
    Developer Guide
  - MEF 124 - LSO Cantata and LSO Sonata Trouble Ticket and Incident Management
    API - Developer Guide
  - MEF 137 - LSO Cantata and LSO Sonata Appointment Management API - Developer
    Guide
  - MEF 134 - Billing and Invoice Business Requirements and Use Cases
  - MEF 106 - LSO Sonata Access E-Line Product Schemas and Developer Guide
- Following documents have their Letter Ballots open and will be likely shortly
  published as MEF standards:
  - MEF W125.0.1 - Subscriber Ethernet Schemas and Product Schema Guide -
    Amendment (examples)
  - MEF W139 - Internet Access Product Schemas and Developer Guide
  - MEF W141 - LSO Cantata and LSO Sonata Billing Management API - Developer
    Guide
- Updated documents:
  - MEF W127 - LSO Cantata and LSO Sonata Product Catalog - Business
    Requirements and Use Cases
  - MEF W142 - LSO Cantata and LSO Sonata Product Catalog API & Developer Guide
  - MEF W110 - Product Offering Availability and Pricing Discovery - Business
    Requirements and Use Cases
  - MEF W160 - LSO Cantata and LSO Sonata Product Offering Availability and
    Pricing Discovery API - Developer Guide
  - MEF W128.1 - LSO API Security Profile
- New documents:
  - MEF 55.1.1 Amendment to MEF 55.1: Reference Architecture and Framework -
    Terminology

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

The maturity per functionality presents as follows:

(\*) is used to mark item that changes their maturity comparing to previous
release.

- Product Catalog:
  - Business Requirements:
    - \*MEF W127 - **Draft Standard R2**
  - Developer Guide/API:
    - \*MEF W142 - **work in progress - ready for CfC#2**
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
- Product Offering Availability and Pricing Discovery:
  - Business Requirements:
    - MEF \*W110 - **Draft Standard R2**
  - Developer Guide/API:
    - MEF \*W160: - **work in progress - ready for CfC#2**
- Order:
  - Business Requirements:
    - MEF 57.2 - **Published Standard**
  - Developer Guide/API:
    - MEF 123 - **Published Standard**
- Inventory:
  - Business Requirements:
    - MEF 81, MEF 81.0.1 - **Published Standard**
  - Developer Guide/API
    - MEF 116 - **Published Standard**
- Trouble Ticket:
  - Business Requirements:
    - MEF 113 - **Published Standard**
  - Developer Guide/API
    - MEF 124 - Trouble Ticket - **Published Standard**
    - MEF 137 - Appointment - **Published Standard**
- Billing:
  - Business Requirements:
    - MEF 134 - **Published Standard**
  - Developer Guide/API
    - MEF 141 - **Published Standard**
- Product Specifications:
  - MEF 106 - Access E-Line - **Published Standard**
  - MEF 125 - Subscriber Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE) -
    **Published Standard**
  - \*MEF 125.0.1 - Amendment to Subscriber Ethernet - **Published Standard**
  - \*MEF W139 - Basic and Advanced Internet Access - **Letter Ballot**
- Security:
  - MEF 128 - **Published Standard**
  - \*MEF W128.1 - **work in progress - Letter Ballot ready**

For high level information about the release compatibility and roadmap please
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
  - `productApi` - API related documentation - API Developer Guides
  - `productSchema` - Product related documentation - Product schema guides
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

© MEF Forum 2023. All Rights Reserved.

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
