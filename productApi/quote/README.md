# Quote Management: Release notes

## Release Fergie:

**Readiness status**: MEF Published Standard

No changes.

## Release Ella:

**Readiness status**: MEF Published Standard

No changes.

## Release Dolly:

**Readiness status**: MEF Published standard. 

### List of changes in the API:

- `Price`
  - `dutyFreeAmount` - made required
- `GeographicSubAddress`
  - `id` - removed

## Release Celine:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard in this form.

### List of changes in the API:

- `MEFItemTerm`
  - made required:
    - `duration`
    - `endOfTermAction`
    - `name`

## Release Billie:

### List of changes in the API:

- `Quote`
  - `state`:
    - `rejected.expired` renamed to `expired`
    - `rejected` renamed to `declined`
    - `rejected` added
    - `acknowledged` added
    - `quoteDate` changed to mandatory
    - `approved.answered` renamed to `answered`
    - `cancelled.unableToProvide` renamed to `unableToProvide`
    - `cancelled.insufficientInformationProvided` removed
    - `pending` - removed
- `QuoteItem`
  - `state`:
    - `rejected` renamed to `abandoned`
    - `rejected.unableToProvide` renamed to `unableToProvide`
    - `acknowledged` added
    - `approved.answered` renamed to `answered`
    - `rejected.insufficientInformationProvided` removed
    - `pending` - removed
  - `quoteItemTerm` changed to list with `maxItems=1`
  - `agreement` renamed to `agreementName`
- `Quote_Find`
  - removed `stateChange`
- `Quote Notifications`
  - `CreateQuoteNotification` - removed
- `Error405`
  - Removed from specification,
- `GeographicAddressIdentifier` renamed to `GeographicAddressLabel`
- `MEFItemTerm`
  - added `name`
  - added `description`
- `MEFProductConfiguration`
  - `@schemaLocation` - removed
- `MEFProductRefOrValueForQuote` renamed to `MEFProductRefOrValueQuote`
- `ProductRelationship` renamed to `ProductRelationshipWithGrouping`
- `TerminationError`
  - added `code`
  - added `propertyPath`

**Readiness status**: Work in progress and is subject to change

## Release: Aretha

### List of changes in the API:

- `QuoteItem`
  - `agreement` - Changed from ref to name
  - moved `productOffering` to `MEFProductRefOrValue`
- `/quote/{id}`
  - Removed `fields` from query parameters
- `PlaceRef`
  - Split to `GeographicAddressRef` and `GeographicSiteRef` to reflect existing
    MEF endpoints and ease implementation
- `PoqEvent`:
  - added:
    - `sellerId`
    - `buyerId`
- `/cancelQuote` and `/rejectQuote`
  - Changed response from `201` (Created) to `200` (OK)
- Moved `sellerId` and `buyerId` to query parameters for each endpoint
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `MEFGeographicPoint`
  - Merged with `MEFGeographicLocation`
  - Added:
    - `z` - elevation
- `MEFGeographicLocation` - removed
- `MEFItemTerm_Buyer` and `MEFItemTerm_Seller` merged into `MEFItemTerm`
  - Removed
    - `name`
    - `description`
- `MEFSellerEndOfTermAction` renamed to `MEFEndOfTermAction`
- `MEFProductRefOrValue` renamed to `MEFProductRefOrValueForQuote`
  - `productOffering` - added
  - `productSpecification` - removed
- `RelatedParty`
  - refactored to `RelatedContactInformation`
  - added:
    - `organization`
    - `postalAddress`

**Readiness status**: Work in progress and is subject to change

## Release: 5.1 hotfix

### List of changes in the API:

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
