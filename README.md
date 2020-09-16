# MEF LSO Sonata SDK Release Candidate 5 (hotfix 1)

## Download Link

Download the entire repository by clicking
[here](https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/releases/download/rc5/MEF-LSO-Sonata-SDK-rc5.1.zip)

## Overview

This release is a hotfix release to the SDK RC5. It contains fixes to following
list of issues: https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/projects/6

It provides consistency alignment between POQ, Quote and Order to use
MEFProductActionType.

It also provides a number of changes to Quote API introduced by latest works on
MEF 80 - Quote Management Requirements and Use Cases.

The detailed list of changes:

Address:

- geographicAddressManagement.api.yaml - v 5.0.0-RC2
  - `RelatedPlaceRefOrValue.role` - removed

Order:

- productOrderManagement.api.yaml - v 5.0.0-RC2
  - type OrderItemActionType changed to MEFProductActionType
  - ProductRelationship.name – removed
- productOrderNotification.api.yaml - v 5.0.0-RC2
  - version update for consistency

POQ:

- productOfferingQualificationManagement.api.yaml - v 5.0.0-RC2
  - ProductRelationship.name – removed
- productOfferingQualificationNotification.api.yaml - v 5.0.0-RC2
  - version update for consistency

Quote:

- quoteManagement.api.yaml - v 5.0.0-RC2
  - getList use case:
    - `Quote_Find` - introduced to define the response scope
    - Removed `fields` from query criteria
    - Added `Requested Quote Completion Date` to filtering criteria
  - `Quote`:
    - `sellerQuoteLevel` - renamed to `quoteLevel`
  - `QuoteItem` (all):
    - `action` - changed type to MEFProductActionType (add, modify, delete)
    - `place` - removed (present within the product)
    - `quoteItemLevel` - changed to `subjectToFeasibilityCheck`
    - `quoteItemInstallationInterval` - changed from `TimeInterval` to
      `Duration`
    - `requestedQuoteItemInstallationInterval` - changed from `TimeInterval` to
      `Duration`
  - `QuoteItem_Create`
    - Removed `terminationError`
    - `MEFQuoteItemStateType` - added `pending`, `inProgress.draft`
  - `ProductRelationship` - removed `buyerId`, `name`
  - `Termination error` - removed @type
  - `MEFItemTermSeller/Buyer` - removed @types
  - `Duration.TimeUnit` - added `calendarMonths` to enum
  - `TimeInterval` - removed
  - `Note` - added `source`
  - `NoteSource` - enum added
  - `ProductSpecificationRef.TargetProductSchema` - removed
  - Change of pattern in the Cancel or reject Quote case:
    - `CancelOrRejectQuote` - endpoint removed
    - `cancelQuote` - endpoint added
    - `rejectQuote` - endpoint added
    - `QuoteOperationData` - introduced instead of `CancelOrRejectQuote` and
      `CancelOrRejectQuote_Create`
    - `MEFCancelOrRejectStateType` - removed
    - `TaskStateType` - removed
- quoteNotification.api.yaml - v 5.0.0-RC2
  - Removed `QuoteLevelChangeNotification`
  - Added `QuoteItemStateChangeNotification`
  - Added `quoteItemId` in the notification body

Updated Documents:

- MEF 80 - pre Letter Ballot version
  (https://wiki.mef.net/download/attachments/75990189/MEF%20W80%20WD%20%238.docx?api=v2) -
  Not published yet, available for MEF Members only.

<!-- TODO - update of docuemnts? MEF 87, MEF 80 -->

## GitHub Issues Resolved

- buyerId and sellerId missing in Quote #163
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/163
- MEFQuoteItem_Create remove terminationError #162
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/162
- ProductSpecificationRef remove targetProductSchema #161
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/161
- QuoteItem - unnecessary place attribute #160
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/160
- MEFQuoteItemStateType missing pending state #159
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/159
- MEFQuoteItemStateType missing inProgress.draft state #158
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/158
- Attribute 'role' in globalAddressId in GeographicSite API #157
  https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/157

## Issues, questions, and Feedback

Issues should be reported with the use of GitHub issues. Questions and feedback
should be asked either at
[Sonata SDK Community](https://github.com/orgs/MEF-GIT/teams/mef-lso-sonata-sdk-community)
or directly to community_manager@mef.net.

**NOTE:** All artifacts included in this repository have line numbers. When
referring to specific content in any of these artifacts, please quote the line
numbers to which you are referring.

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

## Copyright

© MEF Forum 2020. All Rights Reserved.

## Disclaimer

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

(a) any express or implied license or right to or under any patent, copyright,
trademark or trade secret rights held or claimed by any MEF member which are or
may be associated with the ideas, techniques, concepts or expressions contained
herein; nor

(b) any warranty or representation that any MEF member will announce any
product(s) and/or service(s) related thereto, or if such announcements are
made, that such announced product(s) and/or service(s) embody any or all of the
ideas, technologies, or concepts contained herein; nor

(c) any form of relationship between any MEF member and the recipient or user
of this document.

Implementation or use of specific MEF standards, specifications, or
recommendations will be voluntary, and no Member shall be obliged to implement
them by virtue of participation in MEF Forum. MEF is a non-profit international
organization to enable the development and worldwide adoption of agile,
assured, and orchestrated network services. MEF does not, expressly or
otherwise, endorse or promote any specific products or services.
