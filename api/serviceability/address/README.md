# Address Validation Aretha - Release notes

## List of changes in the API:

- Added `sellerId` and `buyerId` to query parameters for each endpoint
- `/geographicAddress/{id}/get`
  - Removed
    - `fields` parameter
  - Change response `201` (Created) to `200` (OK) because the response is not persisted
- `GeographicAddress`:
  - Changed `@type` to discriminator
  - Read-only:
    - `Id`
    - `Href`
    - `allowsNewSite`
    - `hasPublicSite`
    - `associatedGeographicAddress`
  - Refactored:
    - `fieldedAddress`, `formattedAddress`, `geographicLocation`, `globalAddressId` from single ref attributes to "`allOf`" pattern
    - `validGeographicAddress` split to `bestMatchGeographicAddress` and `alternateGeographicAddress`
  - Removed:
    - `validationDate`
- `GeographicAddressValidation_Create`
  - Added
    - `provideAlternative` - mandatory  for compliancy with TMF
- `GeographicSubAddress`
  - Removed:
    - `Id`
- `MefGeographicPoint`
  - Merged with `MEFGeographicLocation`
  - Added:
    - `z` - elevation
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `RelatedPlaceRefOrValue` - removed
- `Error409` - removed

## Developer Guide document

The document has reached the readiness for first Call for Comments process which will be initiated in Q1 2021.

**Readiness status**: Work in progress and is subject to change
