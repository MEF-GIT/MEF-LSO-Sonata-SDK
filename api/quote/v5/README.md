# Changes introduced comparing to SDK RC 5

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

## GitHub Issues

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
