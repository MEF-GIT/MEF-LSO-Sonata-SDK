# Site Retrieval: Release notes

## Release Irene:

**Readiness status**: Call for Comments #1 resolved. Ready to start Letter
Ballot. It will be most likely published as a standard in this form.

**Summary**

- Introduction of new Geographic Address model - "Installation Place"
- `listGeographicSite` operation changed to `POST` to support request body
- response pagination defined
- `retrieveGeographicSite` operation is optional
- changed the `refOrValue` pattern to use `oneOf` instead of `allOf`
- `@type` introduced where required

### List of changes in the API:

**geographicSiteManagement.api.yaml:**

- `GET /geographicSite`:
  - operation removed and replaced with POST to allow passing body in the
    request
- `POST /geographicSite`:
  - operation added
  - `offset` and `limit` query parameters added to support pagination
- `GET /geographicSite/{id}`:
  - operation is optional to support.
  - added `Error501` (NotImplemented) to possible responses
- `Error501` - added
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
- `GeographicAddressRefOrQuery` - added
- `GeographicSite`:
  - `@type` - made required and with constant `GeographicSite` value
  - `companyName` - replaced by `administrativeAuthority`
  - `networkType` - added
  - `place`:
    - changed from array to single attribute
    - changed to only `GeographicAddressRefOrQuery` type
  - `relatedContactInformation` - removed
  - `siteType` - renamed to `siteRestrictionType`
  - `subUnit` - added
- `GeographicSite_Query` - added
- `GeographicSubAddress` - removed
- `MEFGeographicPoint` - replaced with `GeographicPointRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `x` - renamed to `longitude`
  - `y` - renamed to `latitude`
  - `z` - renamed to `elevation`
- `MEFSiteType` - renamed to `SiteRestrictionType`
- `MEFSubUnit` - renamed to `SubUnit`
- `RelatedContactInformation` -removed
- `SiteNetworkType` - added

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
  - `fieldedAddress`, `formattedAddress`, `geographicLocation`,
    `globalAddressId` replaced with `place[]` reference attribute
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
