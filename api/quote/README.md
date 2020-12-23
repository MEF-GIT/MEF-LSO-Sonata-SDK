# Quote Management Aretha - Release notes

## List of changes in the API:

- `QuoteItem`
  - `agreement` - Changed from ref to name
  - moved `productOffering` to `MEFProductRefOrValue`
- `/quote/{id}`
  - Removed `fields` from query parameters
- `PlaceRef`
  - Split to `GeographicAddressRef` and `GeographicSiteRef` to reflect existing
    MEF endpoints and ease implementation
- `PoqEvent`:
  - added:
    - `sellerId`
    - `buyerId`
- `/cancelQuote` and `/rejectQuote`
  - Changed response from `201` (Created) to `200` (OK)
- Moved `sellerId` and `buyerId` to query parameters for each endpoint
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `MefGeographicPoint`
  - Merged with `MEFGeographicLocation`
  - Added:
    - `z` - elevation
- `MEFGeographicLocation` - removed
- `MEFItemTerm_Buyer` and `MEFItemTerm_Seller` merged into `MEFItemTerm`
  - Removed
    - `name`
    - `description`
- `MEFSellerEndOfTermAction` renamed to `MEFEndOfTermAction`
- `MEFProductRefOrValue` renamed to `MEFProductRefOrValueForQuote`
  - `productOffering` - added
  - `productSpecification` - removed
- `RelatedParty`
  - refactored to `RelatedContactInformation`
  - added:
    - `organization`
    - `postalAddress`

## Developer Guide document

The document has finished the CfC#1 review process and has resolved around 80%
of comments. Will be a subject to next Call for Comments in Q1 2021.

**Readiness status**: Work in progress and is subject to change
