# Site Retrieval Aretha - Release notes

## List of changes in the API

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

## Developer Guide document

The document has reached the readiness for first Call for Comments process which will be initiated in Q1 2021.

**Readiness status**: Work in progress and is subject to change
