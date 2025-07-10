# Quote Management: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

**Summary**:

- Common schemas consistency applied.
- Added [R24] - missed from Mplify 80 R22.
- Added [R27] and [R28] to clarify when `quoteItemInstallationInterval` and `quoteItemTerm` must be provided
- Use Case 2: Retrieve Quote List is changed to be optional, according to MEF 80. [R3] and [O1] updated
- Fixed Table 9 to `quoteLevel` not required in `rejected` and `unableToProvide` and [R30], [R31] to reflect that.

**quoteManagement.api.yaml:**

- `GET /quote`:
  - added `Error501` as possible response
- `ProductOfferingQualificationItemRef`:
  - `alternateProductProposalId` - renamed to `alternateProductOfferingProposalId` for consistency purposes

**quoteNotification.api.yaml:**

No changes.


## Release Irene:

**Readiness status**: Call for Comments Ballot #1. Work in progress and is
subject to change.

**Summary:**

- Implementing new Address model introduced by MEF 150
- Removed Requirement to provide `quoteItemLocationContact`. This is now part of
  `product.place` relation and optional to be provided.
- Fixed Table 6 and 7 - with state dependencies
- Some attributes were "clarified to be required" when there was a Requirement
  in the Developer Guide, but it was not set in the API spec.
- Revised, fully specialized Event model.
- State change events now carry the value of the new `state`
- `buyerId` and `sellerId` in notification now carried via query params (consistent
  with seller side API)
- Clarification of the requirements for `action=delete`
- Allowed change of ProductOffering in modification [O5], [R43]

### List of changes in the API:

**quoteManagement.api.yaml:**

- `GET /hub/{id}` - added
- `POST /hub`:
  - `422` - response code added
- `DELETE /hub/{id}`:
  - `422` - response code added
- `GET /quote`:
  - `422` - response code added
- `/rejectQuote` - renamed to `/declineQuote`

- `ContactInformation` - added
- `Duration`:
  - `amount` - added `minimum:0`
- `FieldedAddress` - replaced with `FieldedAddressRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `buildingName` - added
  - `country` - removed
  - `countryCode` - added
  - `geographicSubAddress` - removed
  - `language` - added
  - `poBox` - added
  - `privateStreetName` - added
  - `privateStreetNumber` - added
  - `streetPreDirection` - added
  - `streetPostDirection` - added
  - `streetSuffix` - removed
  - no attribute is required anymore
- `FormattedAddress` - replaced with `FormattedAddressRepresentation`
  - `addrLine1` - renamed to `formattedAddress`
  - `allOf` with `GeographicAddress` - removed
  - `addrLine2` - removed
  - `city` - removed
  - `country` - removed
  - `language` - added
  - `locality` - removed
  - `postcode` - removed
  - `postcodeExtension` - removed
  - `stateOrProvince` - removed
- `GeographicAddress_Query` - added
- `GeographicAddressLabel` - replaced with `LabelRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `externalReferenceId` - renamed to `label`
  - `externalReferenceType` - renamed to `administrativeAuthority`
  - `language` - added
- `GeographicAddressRef`
  - does not extend the `GeographicAddressRefOrValue`
  - `@type` - added with constant `GeographicAddressRef` value
- `GeographicSiteRef`
  - does not extend the `GeographicAddressRefOrValue`
  - `@type` - added with constant `GeographicSiteRef` value
- `GeographicSubAddress` - removed
- `MEFChargePeriod` - removed
- `MEFGeographicPoint` - replaced with `GeographicPointRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `x` - renamed to `longitude`
  - `y` - renamed to `latitude`
  - `z` - renamed to `elevation`
- `MEFProductRefOrValueQuote`:
  - `place` - ref type changed to `RelatedPlaceRefOrQueryWithSubUnit`
- `MEFQuoteItem_Common`:
  - `product` - clarified to be required
- `MEFQuoteItemStateChange` - added
- `MEFSubUnit` - renamed to `SubUnit`
- `Money`:
  - `unit` - clarified to be required
  - `value` - clarified to be required
- `PlaceRefOrQuery` - added, now using `oneOf` instead of `allOf` for refOrValue
  pattern
- `ProductRelationshipWithGrouping` - replaced with `ProductRelationship`
- `Quote`:
  - `state` - clarified to be required
  - `stateChange` - clarified to be required, `minItems=1`
- `QuoteItem`:
  - `stateChange` - added, required
- `QuotePrice`:
  - `name` - clarified to be required
  - `price` - clarified to be required
  - `priceType` - clarified to be required
  - `recurringChargePeriod` - changed `ref` type to `Duration`
- `RelatedContactInformation`:
  - `postalAddress` - changed ref type to `FieldedAddressRepresentation`
- `RelatedPlaceRefOrQueryWithSubUnit` - added
- `RelatedPlaceRefOrValue` - replaced with `RelatedPlaceRefOrQueryWithSubUnit`
- `TimeUnit`:
  - added:
    - `seconds`
    - `minutes`
    - `months`
    - `years`
  - removed:
    - `calendarMinutes`
    - `businessMinutes`
    - `calendarMonths`

**quoteNotification.api.yaml:**

- `POST /listener/quoteStateChangeEvent`:
  - `requestBody` changed to `QuoteStateChangeEvent`
  - `buyerId` and `sellerId` added to parameters
- `POST /listener/quoteItemStateChangeEvent`:
  - `requestBody` changed to `QuoteItemStateChangeEvent`
  - `buyerId` and `sellerId` added to parameters
  
- `Event` - made a generic Event
  - `eventType` - changed to `string`
  - `event` - changed to `object`
- `MEFQuoteItemStateType` - added
- `MEFQuoteStateType` - added
- `QuoteEvent` - removed
- `QuoteEventType` - removed
- `QuoteItemStateChangeEvent` - added to specialize generic `Event`
- `QuoteItemStateChangeEventPayload` - added
- `QuoteStateChangeEvent` - added to specialize generic `Event`
- `QuoteStateChangeEventPayload` - added

## Release Haley:

**Readiness status**: MEF Published Standard

No changes.

## Release Grace:

**Readiness status**: MEF Published Standard

No changes.

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
