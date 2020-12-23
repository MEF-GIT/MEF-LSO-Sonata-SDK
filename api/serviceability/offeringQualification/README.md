# Product Offering Qualification Aretha - Release notes

## List of changes in the API:

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
- `MefGeographicPoint`
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

## Developer Guide document

The document has finished the CfC#2 review process and will be a subject to next Call for Comments review and Draft Ballot shortly.

**Readiness status**: Work in progress and is subject to change
