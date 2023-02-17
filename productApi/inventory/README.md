# Product Inventory: Release notes

## Release Ella:

**Readiness status**: MEF Published Standard

No changes.

## Release Dolly:

**Readiness status**: MEF Published Standard

### List of changes in the API:

`Price`:

- `dutyFreeAmount` - made required

`MEFBillingAccount` replaced with `MEFBillingAccountRef`

## Release Celine:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

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
