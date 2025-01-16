# Product Inventory: Release notes

## Release Irene:

**Readiness status**: A MEF 116.1 revision work in progress, subject to change. CfC#1 ready.

**Summary**

- New Address Model introduced by MEF 150 implemented.
- Product can refer not only to a Site but also to an Address.
- Mandated throwing `Error422` in case of too many matching items are found

### List of changes in the API:

**productInventoryManagement.api.yaml:**

- `GET /product`
  - `fields` - removed query parameter
  - `geographicAddressId` - added
  - `geographicalSiteId` - renamed to `geographicSiteId`
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
- `FormattedAddressRepresentation` - added
- `GeographicAddressRef` - added
- `GeographicAddress_Query` - added
- `GeographicPointRepresentation` - added
- `GeographicSiteRef` - added
- `GeographicSubAddress` - removed
- `LabelRepresentation` - added
- `MEFChargePeriod` - removed
- `MEFGeographicPoint` - added
- `MEFItemTerm`:
  - `name` - marked as required
  - `duration` - marked as required
  - `endOfTermAction` - marked as required
- `MEFProduct`:
  - `@type` - removed
  - `agreementName` - added
  - `relatedSite` - replaced with `place`
  - `statusChange` - made required
- `MEFProduct_Find`:
  - `relatedSite` - replaced with `place`
- `MEFSubUnit` - renamed to `SubUnit`
- `PlaceRefOrQuery` - added
- `ProductPrice`:
  - `recurringChargePeriod` - changed `ref` type to `Duration`
- `RelatedGeographicSite` - removed
- `RelatedContactInformation`:
  - `postalAddress` - changed ref type to `FieldedAddressRepresentation`
- `RelatedPlaceRefOrQuery` - added
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

**Readiness status**: MEF Published Standard

### List of changes in the API:

- `Price`:
  - `dutyFreeAmount` - made required
- `MEFBillingAccount` replaced with `MEFBillingAccountRef`

## Release Celine:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard in this form.

### List of changes in the API:

None

## Release Billie:

### List of changes in the API:

- `get '/product/'`
  - query params:
    - `status` - updated list
    - `geographicalSiteId` - renamed to `relatedSiteId`
- `Product`:
  - renamed to `MEFProduct`
  - removed:
    - `agreement`
  - `MEFProductConfiguration` - renamed to `productConfiguration`
  - `buyerProductId` - renamed to `externalId`
- `MEFProductSummary`
  - renamed to `MEFProduct_Find`
  - `lastUpdateDate` - added
  - `productSpecification` - changed type to `ProductSpecificationRef`
- `AgreementRef` - removed
- `ProductSpecificationRef`
  - aligned across all APIs
  - removed:
    - `name`
    - `targetProductSchema`
    - `@schemaLocation`
    - `@type`
- `MEFProductSpecificationSummary` - removed
- `ProductOfferingRef`
  - `href` - added
- `ProductRelationship`
  - removed:
    - `buyerProductId`
    - `name`
- `MEFProductStatusType`:
  - added:
    - `cancelled`
    - `activePendingChange`
  - renamed:
    - `activePendingTerminate` to `pendingTerminate`
- `ProductPrice`
  - `recurringChargePeriod` => changed to enum: `MEFChargePeriod`
  - `priceType` => changed to enum: `MEFPriceType`
- `TargetProductSchema` - removed
- `ProductTerm` replaced with `MEFItemTerm`
- `MEFEndOfTermAction` - added
- `MEFProductOrderItemRef`
  - `id` - renamed to `productOrderId`
  - `href` - renamed to `productOrderHref`
  - `orderItemId` - renamed to `productOrderItemId`
- `MEFProductConfiguration`
  - `@schemaLocation` - removed
- `Error`
  - `status` - removed
- `BillingAccountRef`
  - replaced with `MEFBillingAccount`
  - changed from array to single ref

## Release Aretha:

## List of changes in the API:

- `GET /product`
  - `sellerId` added to query
- `Quantity` unified to `Duration` and `TimeUnit`
- `RelatedGeographicSite`:
  - removed `@type`
- `Product`
  - `relatedParty` => `relatedContactInformation`
  - `@schemaLocation` = removed
  - `@BaseType` - removed
- `RelatedParty`
  - refactored to `RelatedContactInformation`
  - added:
    - `organization`
    - `postalAddress`
- `FieldedAddress` - added
- `GeographicSubAddress` - added
- `MEFSubUnit` - added
- `Price`:
  - removed `@type`
- `ProductPrice`:
  - removed `@type`

## Developer Guide document

There is no Developer Guide document at his moment. A project is running to
deliver one for the next Billie release.

**Readiness status**: Work in progress and is subject to change
