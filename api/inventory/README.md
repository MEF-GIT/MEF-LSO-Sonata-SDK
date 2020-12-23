# Product Inventory Aretha - Release notes

## List of changes in the API

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
