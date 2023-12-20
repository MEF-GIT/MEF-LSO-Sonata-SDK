# Product Offering Qualification: Release notes

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

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

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
  - moved  `productOffering` to `MEFProductRefOrValue`
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
  - Split to `GeographicAddressRef` and `GeographicSiteRef` to reflect existing MEF endpoints and ease implementation
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

- `MEFProductConfiguration` introduced as an extension point for Product Specifications
- `ProductOfferingQualification_Common` introduced to accommodate commonalities between `ProductOfferingQualification_Create` and `ProductOfferingQualification`
- `ProductOfferingQualificationItem_Common` introduced to accommodate commonalities between `ProductOfferingQualificationItem_Create` and `ProductOfferingQualificationItem`
- `ProductActionType` : rename of enumeration values
- `ProductActionType` : rename of enumeration values, removal of `noChange` state
- `AlternateProductProposal` : refactored into `AlternateProductOfferingProposal`
- `ProductOfferingQualificationStateType` renamed to `MEFPOQTaskStateType`, the new `accepted` state introduced, rename of other states
- `ProductOfferingQualificationItemStateType` renamed to `MEFPOQItemTaskStateType`, the new `accepted` state introduced, rename of other states
- `ErrorRepresentation` model refactor into `Error` types hierarchy
- Addressing model improved:
  - adding `PlaceRef`
  - refactoring `ReferencedAddress` into `GlobalAddressId`, attributes renaming
  - refactoring of `GeographicLocation` into `MEFGeographicLocation` and aligning its structure with TMF counterpart
- state change log patter was introduced into `ProductOfferingQualification` and `ProductOfferingQualificationItem` types
- `basepath` aligned to match latest MEF guidelines