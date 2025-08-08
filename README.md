# Mplify-LSO-Sonata-SDK - Janis Release

## Download Link

Download the entire repository by clicking
[here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/janis/Mplify-LSO-Sonata-SDK-janis.zip)

## Introduction

All references to 'MEF Forum' or 'MEF' in the release documentation, links, and
YAML files should be interpreted to be references to 'Mplify Alliance' and
'Mplify' respectively. Since this release coincides with the transition of the
name of MEF Forum to Mplify Alliance, changes were not made to the all files on
this release. Standards that awere already published will retain the "MEF" name.

This repository contains the Mplify LSO Sonata SDK. It includes API definitions
for the following functional areas:

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
- Circuit Impairment and Maintenance Notification

It also provides Product Schemas for:

- Access E-Line
- Subscriber Carrier Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE)
- Internet Access

## High-level release notes

New Circuit Impairment and Maintenance (CIM) Notification API introduced (Mplify
W175)

There are the following document maturity changes:

- Updated documents:

  - Mplify 57.2.1 - Amendment to MEF 57.2: Product Order Management Business
    Requirements and Use Cases
  - Mplify 79.1 - Product Offering Qualification Management Business
    Requirements and Use Cases
  - Mplify 80.0.1 - Amendment to MEF 80: Quote Management Requirements and Use
    Cases
  - Mplify 127.1 - LSO Cantata and LSO Sonata Product Catalog - Business
    Requirements and Use Cases
  - Mplify 150 - Installation Place and Service Site Management Business
    Requirements and Use Cases
  - Mplify W87.1 - LSO Cantata and LSO Sonata Product Offering Qualification
    API - Developer Guide
  - Mplify W115.1 - LSO Cantata and LSO Sonata Quote Management API - Developer
    Guide
  - Mplify W116.1- LSO Cantata and LSO Sonata Product Inventory API - Developer
    Guide
  - Mplify W121.1 - LSO Cantata and LSO Sonata Address Management API -
    Developer Guide
  - Mplify W122.1 - LSO Cantata and LSO Sonata Site Management API - Developer
    Guide
  - Mplify W123.1 - LSO Cantata and LSO Sonata Product Ordering Management API -
    Developer Guide
  - Mplify W124.1 - LSO Cantata and LSO Sonata Trouble Ticket and Incident
    Management API - Developer Guide
  - Mplify W137.1 - LSO Cantata and LSO Sonata Appointment and Work Order
    Management API - Developer Guide
  - Mplify W141.1 - LSO Cantata and LSO Sonata Billing Management API -
    Developer Guide
  - Mplify W142 - LSO Cantata and LSO Sonata Product Catalog API & Developer
    Guide

- New Documents:

  - Mplify W139.1 - Internet Access Product Schemas and Developer Guide
  - Mplify W175 - Circuit Impairment and Maintenance Notification API and
    Developer Guide

- Superseded Documents:
  - MEF 139 - Internet Access Product Schemas and Developer Guide

The [LSO Marketplace](http://lso.mplify.net) offers the possibility to blend the
desired APIs with chosen Products. Thus the APIs blended with all products that
were available in `generated/staticBinding` are no longer provided.

**NOTE:** Please note the Readme files in particular productApi directories to
see detailed release notes per API.

## Maturity Level

The API files contained in this SDK are evolving and subject to change. They are
based on documents that are either ratified standards or draft standards that
have not yet completed the review cycles and approvals necessary to achieve the
status as a Mplify standard. Mplify is making these publicly available at this
time to invite wider industry review.

The maturity per functionality is presented as follows:

(\*) is used to mark an item that changes its maturity compared to the previous
release.

- Product Catalog:
  - Business Requirements:
    - \*Mplify 127.1 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify W142 - **Done. Ready for Letter Ballot**
- Address Validation, Site Query:
  - Business Requirements:
    - \*Mplify 150 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify W121.1 - Address Management - **Done. Ready for Letter Ballot**
    - \*Mplify W122.1 - Site Management - **Done. Ready for Letter Ballot**
- Product Offering Qualification:
  - Business Requirements:
    - \*Mplify 79.1 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify W87.1 - **Done. Ready for Letter Ballot**
- Quote:
  - Business Requirements:
    - MEF 80 - **Published Standard**
    - \*Mplify 80.0.1 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify W115.1 - **Done. Ready for Letter Ballot**
- Product Offering Availability and Pricing Discovery:
  - Business Requirements:
    - \*Mplify 110 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify 160: - **Published Standard**
- Order:
  - Business Requirements:
    - MEF 57.2 - **Published Standard**
    - \*Mplify 57.2.1 - **Published Standard**
  - Developer Guide/API:
    - \*Mplify W123.1 - **Done. Ready for Letter Ballot**
- Inventory:
  - Business Requirements:
    - MEF 81, MEF 81.0.1 - **Published Standard**
  - Developer Guide/API
    - \*Mplify W116.1 - **Done. Ready for Letter Ballot**
- Trouble Ticket:
  - Business Requirements:
    - MEF 113 - **Published Standard**
  - Developer Guide/API
    - \*Mplify W124.1 - Trouble Ticket - **Done. Ready for Letter Ballot**
    - \*Mplify W137.1 - Appointment - **Done. Ready for Letter Ballot**
- Circuit Impairment and Maintenance Notification
  - Business Requirements:
    - \*Mplify 173 - **Published Standard**
  - Developer Guide/API
    - \*Mplify W175 - **work in progress - ready for CfC#1**
- Billing:
  - Business Requirements:
    - MEF 134 - **Published Standard**
  - Developer Guide/API
    - \*Mplify W141.1 - **Done. Ready for Letter Ballot**
- Product Specifications:
  - MEF 106 - Access E-Line - **Published Standard**
  - MEF 125 - Subscriber Ethernet (EPL, EPLAN, EPTREE, EVPL, EVPLAN, EVPTREE) -
    **Published Standard**
  - MEF 125.0.1 - Amendment to Subscriber Ethernet - **Published Standard**
  - Mplify 139.1 - Internet Access Product Schemas and Developer Guide - **work
    in progress - ready for CfC#1**
- Security:
  - MEF 128.1 - **Published Standard**

For high-level information about the release compatibility and roadmap please
visit: [LSO Marketplace](https://lso.mplify.net/lso-api-sdk-releases)

For details on the maturity map and the roadmap for future releases please refer
to
[LSO Sonata SDK Home Page](https://wiki.mplify.net/display/CESG/LSO+Sonata+SDK)
on the Mplify WIKI.

## Contents

This SDK contains the following items:

- `COPYRIGHT` - Copyright 2025 Mplify Alliance
- `LICENSE` - Contains a copy of the Apache 2.0 license
- `README` - This file
- `productApi` - Definitions of the APIs - yaml files with schemas
- `documentation` - All related standards and Developer Guides
  - `productApi` - API-related documentation - API Developer Guides
  - `productSchema` - Product-related documentation - Product schema guides
  - `supportingStandards` - The rest of the documents and standards.
- `schema` - Product Specification schemas
  - `preStandard` - Draft schemas available for use with the LSO APIs, and not
    based on Mplify Product Attributes standards
- `generated`
  - `security` - A not normative version of the standard APIs including the
    security profiles as required by MEF 128.1. Provided for evaluation.

## Issues, Questions, and Feedback

Issues should be reported with the use of GitHub issues. Questions and feedback
should be asked either at
[Sonata SDK Discussions](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/discussions)
or directly to community_manager@mplify.net.

**NOTE:** All artifacts included in this repository have line numbers. When
referring to specific content in any of these artifacts, please quote the line
numbers to which you are referring.

The Mplify LSO Sonata SDK is released under the Apache 2.0 license.

## Copyright

© Mplify Alliance 2025. All Rights Reserved.

**Disclaimer**

The information in this publication is freely available for reproduction and use
by any recipient and is believed to be accurate as of its publication date. Such
information is subject to change without notice and Mplify Alliance (Mplify) is
not responsible for any errors. Mplify does not assume responsibility to update
or correct any information in this publication. No representation or warranty,
expressed or implied, is made by Mplify concerning the completeness, accuracy,
or applicability of any information contained herein and no liability of any
kind shall be assumed by Mplify as a result of reliance upon such information.

The information contained herein is intended to be used without modification by
the recipient or user of this document. Mplify is not responsible or liable for
any modifications to this document made by any other party.

The receipt or any use of this document or its contents does not in any way
create, by implication or otherwise:

- (a) any express or implied license or right to or under any patent, copyright,
  trademark or trade secret rights held or claimed by any Mplify member which
  are or may be associated with the ideas, techniques, concepts or expressions
  contained herein; nor

- (b) any warranty or representation that any Mplify member will announce any
  product(s) and/or service(s) related thereto, or if such announcements are
  made, that such announced product(s) and/or service(s) embody any or all of
  the ideas, technologies, or concepts contained herein; nor

- (c) any form of relationship between any Mplify member and the recipient or
  user of this document.

Implementation or use of specific Mplify standards, specifications or
recommendations will be voluntary, and no Member shall be obliged to implement
them by virtue of participation in Mplify Alliance. Mplify is a non-profit
international organization to enable the development and worldwide adoption of
agile, assured and orchestrated network services. Mplify does not, expressly or
otherwise, endorse or promote any specific products or services.
