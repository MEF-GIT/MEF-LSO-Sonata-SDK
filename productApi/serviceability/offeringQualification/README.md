# Product Offering Qualification: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

**Summary**:

- [R35] - removed `contact` from the list. Yaml spec was OK.
- [R65] - added `product.productOffering` to the list
- [CR2]<[O5] added
- 
**productOfferingQualificationManagement.api.yaml:**

No changes.

**productOfferingQualificationNotification.api.yaml**

No changes.

## Release Irene: 

**Readiness status**: Call for Comments Ballot #1 Resolved. Ready to start Letter Ballot. It will be most likely published
as a standard in this form.

**Summary:**

- Updating Address model according to new definition in MEF 150
- GET List operation is optional now allow to change product Offering
- Revised, fully specialized Event model.
- State change events now carry the value of the new `state`
- `buyerId` and `sellerId` in notification now carried vie query params (consistent with seller side API)

### List of changes in the API:

**productOfferingQualificationManagement.api.yaml:**

- `GET /hub/(id)` - added
- `POST /hub`:
  - `422` - response code added
- `DELETE /hub/(id)`:
  - `422` - response code added
- `GET /productOfferingQualification:`
  - `creationDate.gt` - query param added
  - `creationDate.lt` - query param added
  - `422` - response code added
  - `501` - response code added
- `GET /productOfferingQualification/(id):`
  - `501` - response code added

- `AlternateProductOfferingProposal`:
  - `3rdPartyProvider` - added
  - `3rdPartyProviderProductOffering` - added
  - `deliveryType` - added
  - `guaranteedUntilDate` - added
  - `serviceabilityConfidence` - added
  - `serviceabilityConfidenceReason` - added
- `AlternateServiceabilityColor` - added
- `ContactInformation` - added
- `DeliveryType` - added
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
- `MEFAlternateProduct`:
  - `productSpecification` - removed
- `MEFGeographicPoint` - replaced with `GeographicPointRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `x` - renamed to `longitude`
  - `y` - renamed to `latitude`
  - `z` - renamed to `elevation`
- `MEFPOQItemTaskStateType`:
  - `rejected` - state added
  - `done.ready` - renamed to `done`
- `MEFPOQTaskStateType`:
  - `rejected` - added
  - `done.ready` - renamed to `done`
  - `done.unableToProvide` - removed
  - `terminatedWithError` - mapped to `UNABLE_TO_MEET_TIME`
- `MEFSubUnit` - renamed to `SubUnit`
- `MEFProductRefOrValue`:
  - `place` - ref type changed to `RelatedPlaceRefOrQueryWithSubUnit`
- `PlaceRefOrQuery` - added, now using `oneOf` instead of `allOf` for refOrValue
  pattern
- `ProductActionType` - renamed to `PoqProductActionType`
  - `delete` - removed
- `ProductOfferingQualification`:
  - `3rdPartyProvider` - added
  - `3rdPartyProviderProductOffering` - added
  - `creationDate` - added
  - `effectiveQualificationDate` - removed
  - `stateChange`:
    - now explicitly required to track all states, including the
    Immediate Response
    - `minItems=1`
- `ProductOfferingQualification_Common`:
  - `instantSyncQualification` - made required, removed default value
  - `provideAlternative` - made required, removed default value
- `ProductOfferingQualification_Find`:
  - `creationDate` - added
- `ProductOfferingQualificationItem`:
  - `deliveryType` - added
  - `stateChange`:
    - now explicitly required to track all states, including the
    Immediate Response
    - `minItems=1`
- `ProductOfferingQualificationItem_Common`:
  - `endCustomerName` - added
  - `relatedContactInformation` - removed (moved to
    `RelatedPlaceRefOrQueryWithSubUnit`)
- `ProductRelationshipWithGrouping` - replaced with `ProductRelationship`
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

**productOfferingQualificationNotification.api.yaml:**

- `/listener/poqCreateEvent` - path removed

- `POST /listener/poqStateChangeEvent`:
  - `requestBody` changed to `PoqStateChangeEvent`
  - `buyerId` and `sellerId` added to parameters
- `POST /listener/poqItemStateChangeEvent`:
  - `requestBody` changed to `PoqItemStateChangeEvent`
  - `buyerId` and `sellerId` added to parameters

- `Event` - made a generic Event
  - `eventType` - changed to `string`
  - `event` - changed to `object`
- `MEFPOQTaskStateType` - added
- `MEFPOQItemTaskStateType` - added
- `PoqEventType` - removed
- `PoqItemStateChangeEvent` - added to specialize generic `Event`
- `PoqItemStateChangeEventPayload` - added
- `PoqStateChangeEvent` - added to specialize generic `Event`
- `PoqStateChangeEventPayload` - added

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

None

## Release Celine:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard in this form.

### List of changes in the API:

None

## Release Billie:

### List of changes in the API:

- `Error405`
  - Removed from specification,
- `Error408`
  - Removed from specification,
- `GeographicAddressIdentifier` renamed to `GeographicAddressLabel`
- `MEFAlternateProduct`
  - `productConfiguration` - required
  - `productOffering` - required
- `MEFProductConfiguration`
  - `@schemaLocation` - removed
- `poqItemStateChangeEvent` - added new notification type
- `ProductRelationship` renamed to `ProductRelationshipWithGrouping`
- `TerminationError`
  - added `code`
  - added `propertyPath`

## Release Aretha:

### List of changes in the API:

- Moved sellerId and buyerId to query parameters for each endpoint
- POQ
  - `relatedParty` refactored to `relatedContactInformation`
  - `state`: renamed `accepted` to `acknowledged` to conform to TMF
- POQ Item
  - `relatedParty` refactored to `relatedContactInformation`
  - moved `productOffering` to `MEFProductRefOrValue`
  - state: renamed `accepted` to `acknowledged` to conform to TMF
  - `serviceConfidenceReason` renamed to `serviceabilityConfidenceReason`
  - `expectedActivationDate` - removed
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `RelatedParty`
  - refactored to `RelatedContactInformation`
  - added:
    - `organization`
    - `postalAddress`
- `AlternateProductOfferingProposal`
  - `alternateProductOffering` - removed
- `Error`
  - Removed
    - `Status`
- `Error405` - added
- `GeographicPoint`
  - Merged with `MEFGeographicLocation`
  - z - elevation - added
- `MEFGeographicLocation` - removed
- `MEFPOQTaskStateType`
  - `done` renamed to `done.ready`
  - `accepted` renamed to `acknowledged`
- `MEFPOQItemTaskStateType`
  - `done` renamed to `done.ready`
  - `accepted` renamed to `acknowledged`
- `MEFProductRefOrValue`
  - `productOffering` - added
- `PlaceRef`
  - Removed
    - `@referredType`
  - Split to `GeographicAddressRef` and `GeographicSiteRef` to reflect existing
    MEF endpoints and ease implementation
- `ProductOfferingRef`
  - removed:
    - `name`
    - `@referredType`
- `ProductRelationship`
  - removed
    - `@referredType`
    - `name`
- `ProductSpecificationRef`
  - removed
    - `@referredType`
    - `name`
- `TerminationError`
  - removed
    - `id`
  - Required:
    - `value`
- `TimeInterval` unified to `Duration`
- `PoqEvent`:
  - added:
    - `sellerId`
    - `buyerId`

**Readiness status**: Work in progress and is subject to change

## Release 5:

### List of changes in the API:

- `MEFProductConfiguration` introduced as an extension point for Product
  Specifications
- `ProductOfferingQualification_Common` introduced to accommodate commonalities
  between `ProductOfferingQualification_Create` and
  `ProductOfferingQualification`
- `ProductOfferingQualificationItem_Common` introduced to accommodate
  commonalities between `ProductOfferingQualificationItem_Create` and
  `ProductOfferingQualificationItem`
- `ProductActionType` : rename of enumeration values
- `ProductActionType` : rename of enumeration values, removal of `noChange`
  state
- `AlternateProductProposal` : refactored into
  `AlternateProductOfferingProposal`
- `ProductOfferingQualificationStateType` renamed to `MEFPOQTaskStateType`, the
  new `accepted` state introduced, rename of other states
- `ProductOfferingQualificationItemStateType` renamed to
  `MEFPOQItemTaskStateType`, the new `accepted` state introduced, rename of
  other states
- `ErrorRepresentation` model refactor into `Error` types hierarchy
- Addressing model improved:
  - adding `PlaceRef`
  - refactoring `ReferencedAddress` into `GlobalAddressId`, attributes renaming
  - refactoring of `GeographicLocation` into `MEFGeographicLocation` and
    aligning its structure with TMF counterpart
- state change log patter was introduced into `ProductOfferingQualification` and
  `ProductOfferingQualificationItem` types
- `basepath` aligned to match latest MEF guidelines
