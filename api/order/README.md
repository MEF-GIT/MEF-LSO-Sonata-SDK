# Product Offering Qualification Aretha - Release notes

## List of changes in the API:

Change Log:

- `/productOrder/{id}`

  - Removed `fields` from query parameters

- `Order`:
  - Removed
    - `buyerRequestDate`
    - `desiredResponse`
    - `expeditePriority`
    - `Note`
    - `orderActivity`
    - `orderMessage`
    - `pricingMethod`
    - `pricingReference`
    - `relatedBuyerPON`
    - `requestedCompletionDate`
    - `tspRestorationPriority`
    - `pricingTerm`
    - `priority`
- `OrderItem`:
  - Added:
    - `completionDate`
    - `coordinatedAction`
    - `expectedCompletionDate`
    - `expediteIndicator`
    - `Note`
    - `relatedBuyerPON`
    - `requestedCompletionDate`
    - `sellerItemIdentifier`
    - `tspRestorationPriority`
    - `requestedItemTerm`
  - Moved `productOffering` to `MEFProductRefOrValue`
  - `relatedParty` refactored to `RelatedContactInformation`
- `Error409` - removed
- `Error422`
  - `status` - removed
- `GlobalAddressId`
  - Renamed to `GeographicAddressIdentifier`
- `MEFBillingAccountRefOrValue`
  - Removed
    - `@type`
  - Added
    - `agreementName`
- `MEFBillingContact` replaced with `RelatedContactInformation`
- `MEFDesiredOrderResponse` removed
- `MEFEndOfTermAction` - added
- `MEFGeographicPoint`
  - Merged with `MEFGeographicLocation`
  - Added:
    - `z` - elevation
- `MEFGeographicLocation` - removed
- `MEFProductOrderItemStateType`
  - Removed `inProgress.configured`
- `MEFProductOrderStateType`
  - Removed
    - `inProgress.configured`
    - `inProgress.confirmed`
    - `inProgress.jeopardy`
- `MEFProductRefOrValue`
  - `productOffering` - added
  - `productSpecification` - removed
  - `@type` - removed
- `MEFQuoteItemRef`
  - Removed:
    - `@type`
    - `@referredType`
- `MEFEndOfTermAction` - added
- `MEFSeverity` - removed
- `Note`
  - Added `source` - mandatory
- `NoteSourceType` - added
- `OrderItemRelationship`
  - Removed
    - `@type`
- `OrderItemCoordinatedAction` - added
- `OrderItemCoordinationDependencyType` - Added
- `OrderTerm` changed to `MEFItemTerm`
- `PlaceRef`
  - Split to `GeographicAddressRef` and `GeographicSiteRef` to reflect existing
    MEF endpoints and ease implementation
- `ProductOfferingQualificationItemRef`
  - Removed:
    - `@type`
    - `@referredType`
- `ProductOfferingRef`
  - removed:
    - `name`
    - `@type`
    - `@referredType`
- `ProductRelationship`
  - Removed:
    - `buyerProductId` - removed
    - `@type`
    - `@referredType`
  - added:
    - `groupingKey`
- `ProductSpecificationRef` - removed
- `Quantity` unified to `Duration` and `TimeUnit`
- `RelatedParty`
  - refactored to `RelatedContactInformation`
  - added:
    - `organization`
    - `postalAddress`
- `TargetProductSchema` - removed
- Notifications:

- Added:
  - `cancelProductOrderCreateEvent`
  - `cancelProductOrderStateChangeEvent`
  - `productOrderExpectedCompletionDateSet`
  - `productOrderItemExpectedCompletionDateSet`
- Removed:
  - `productOrderAttributeValueChangeEvent`
  - produc`tOrderInformationRequiredEvent

## Developer Guide document

There is no Developer Guide document at his moment. A project is running to
deliver one for the next Billie release.

**Readiness status**: Work in progress and is subject to change
