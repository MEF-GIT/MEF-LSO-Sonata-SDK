# Site Retrieval: Release notes

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

- `GeographicAddressIdentifier` renamed to `GeographicAddressLabel`
- `FieldedAddress.geographicSubAddress` - removed the `maxItems: 1` restriction
- `Error422` added

**Readiness status**: Work in progress and is subject to change

## Release Aretha:

### List of changes in the API:

- `GeographicSite`
  - Removed: 
    - `Status`
    - `additionalSiteInformation`
  - `fieldedAddress`, `formattedAddress`, `geographicLocation`, `globalAddressId` replaced with `place[]` reference attribute
  - Renamed:
    - `siteCompanyName` => `companyName`
    - `siteCustomerName` => `customerName`
    - `siteContactName` => `serviceSiteContactName`
    - `relatedParty` => `relatedContactInformation`
- `/geographicSite/get/`:
  - Removed:
    - `status`
  - Renamed:
    - `siteDescription` => `description`
    - `siteName` => `name`
    - `siteCompanyName` => `companyName`
    - `siteCustomerName` => `customerName`
    - `siteContactName` => `serviceSiteContactName`
    - `geographicAddress.streetNr` => `streetNr`
    - `geographicAddress.streetName` => `streetName`
    - `geographicAddress.streetType` => `streetType`
    - `geographicAddress.city` => `city`
    - `geographicAddress.postcode` => `postcode`
    - `geographicAddress.country` => `country`
  - Returned type changed from `MEFGeographicSiteSummary` to `GeographicSite`
- `/geographicSite/{id}`
  - Removed `fields` from query parameters
- `GeographicAddressFindResp` - removed type
- `MefGeographicPoint`
  - Merged with `MEFGeographicLocation`
  - Added:
    - `z` - elevation
- `MEFGeographicLocation` - removed
- `FieldedAddress`
  - Removed:
    - `Id`
    - `Href`
    - `Name`
    - `@type`
  - Not mandatory:
    - `postcode`
    - `stateOrProvince`
    - `streetType`
  - Mandatory
    - `streetName`
- `FormattedAddress`
  - Removed:
    - `Id`
    - `Href`
    - `Name`
    - `@type`
  - Not mandatory
    - `Postcode`
    - `stateOrProvince`
- `GeographicSubAddress`
  - Removed
    - `Id`
    - `href`
    - `name`
    - `@type`
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `RelatedParty`
  - refactored with `RelatedContactInformation`
- `RelatedPlaceRefOrValue`
  - Replaced with more specific `GeographicAddressRefOrValue`
  - Removed:
    - `role`
- `Error`
  - Removed
    - `status`

**Readiness status**: Work in progress and is subject to change
