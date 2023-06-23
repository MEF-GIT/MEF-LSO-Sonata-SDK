# Address Validation: Release notes

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

`GeographicAddressIdentifier` renamed to `GeographicAddressLabel`

**Readiness status**: Work in progress and is subject to change

## Release: Aretha

### List of changes in the API:

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

**Readiness status**: Work in progress and is subject to change
