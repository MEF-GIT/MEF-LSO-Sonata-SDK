# Address Validation: Release notes

## Release Irene:

**Readiness status**: Call for Comments #1 resolved. Ready to start Letter Ballot. It will be most likely published
as a standard in this form.

**Summary**:

- New Address Model - one with 4 representations
- Deferred response allowed - 201 response code added
- Notifications added
- Only 4 specified types of representations may be used. The Buyer and the Seller cannot agree to use other or extend the representation definitions.

### List of changes in the API:

**geographicAddressManagement.api.yaml:**

- `/geographicAddressValidation`:
  - `POST` - added `201` code for deferred response  
- `/geographicAddressValidation/{id}` - path added
  - `GET` - operation added
- `/hub` - path added
  - `POST` - operation added
- `/hub/{id}` - path added
  - `GET` - operation added
  - `DELETE` - operation added

- `EventSubscription` - added
- `EventSubscriptionInput` - added
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
- `GeographicAddress`:
  - `@schemaLocation` - removed
  - `@type` - made required and with constant `GeographicAddress` value
  - `associatedGeographicAddress` - removed
  - `id` - made required
  - `allowsNewSite`:
    - made required
    - changed type to `TrueFalseUnknown`
  - `hasPublicSite`:
    - made required
    - changed type to `TrueFalseUnknown`
  - `fieldedAddressRepresentation` - added
  - `formattedAddressRepresentation` - added
  - `geographicPointRepresentation` - added
  - `labelRepresentation` - added
- `GeographicAddress_Query` - added
- `GeographicAddressLabel` - replaced with `LabelRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `externalReferenceId` - renamed to `label`
  - `externalReferenceType` - renamed to `administrativeAuthority`
  - `language` - added
- `GeographicAddressValidation`:
  - `id` - added
  - `state` - added
  - `validationResult` - removed
  - `provideAlternative` - removed
  - `alternateGeographicAddress` - made required
  - `bestMatchGeographicAddress` - made required
- `GeographicAddressValidation_Create`
  - `instantSyncQualification` - added
- `GeographicSubAddress` - removed
- `MEFGeographicPoint` - replaced with `GeographicPointRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `x` - renamed to `longitude`
  - `y` - renamed to `latitude`
  - `z` - renamed to `elevation`
- `MEFSubUnit` - renamed to `SubUnit`
- `MEFValidationResultType` - removed
- `TrueFalseUnknown` - added

`geographicAddressNotification.api.yaml` - added

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
