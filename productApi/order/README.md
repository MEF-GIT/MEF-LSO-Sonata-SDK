# Product Order Management: Release notes

## Release Billie:

### List of changes in the API:

- endpoints added:
  - `/productOrder/{id}:`
    - `patch`
  - `/charge:`
    - `get`
  - `/charge/{id}:`
    - `get`
    - `patch`
  - `/modifyProductOrderItemCompletionDate:`
    - `get`
    - `post`
  - `/modifyProductOrderItemCompletionDate/{id}`
    - `get`
- `MEFProductOrderSummary` renamed to `MEFProductOrder_Find`
- `ProductOrder`:
  - added:
    - `charge`
    - `requestedCompletionDate` 
  - removed:
    - `pricingReference`
  - `state`:
    - `pending` - renamed to `pending.assessingModification`
    - `held` - renamed to `held.assessingCharge`
- `ProductOrderItem`
  - added:
    - `expediteAcceptedIndicator`
    - `charge`
    - `terminationError`
  - removed:
    - `itemPrice`
  - `itemTerm` - maxItems: 1
- `MEFProductOrderItem_Common`:
  - added:
    - `relatedBuyerPON`
    - `expediteIndicator`
  - removed:
    - `pricingReference`
    - `pricingTerm`
    - `pricingMethod`
    - `itemPrice`
  - `coordinatedAction` - changed to array
  - `requestedItemTerm` - changed from list to single reference
- `MEFItemTerm`
  - `name` - added
  - `description` - added
- `MEFProductRefOrValueForOrder`
  - renamed to `MEFProductRefOrValueOrder`
  - `buyerProductId` - removed
  - `productOffering` - not mandatory
- `MEFOrderItemCoordinatedAction`
  - `id` - renamed to `itemId`
- `MEFProductConfiguration`
  - `@schemaLocation` - removed
- `ProductRelationship`
  - `groupingKey` - removed
- `ProductOrderEventPayload`
  - `milestoneName` - added
- `Error` - removed `status`
- `CancelProductOrder`
  - added:
    - `cancellationReasonType`
    - `orderVersion`
    - `note`
    - `relatedContactInformation`
  - removed:
    - `requestedCancellationDate`
    - `effectiveCancellationDate`
    - `cancellationDeniedReason`
- `CancelProductOrder_Create`
  - added:
    - `cancellationReasonType`
    - `orderVersion`
    - `note`
    - `relatedContactInformation`
  - removed:
    - `requestedCancellationDate`
- `MEFBillingAccountRefOrValue` replaced with `MEFBillingAccount`
- `NoteSourceType` - renamed to `MEFBuyerSellerType`
- Notifications:
  - removed:
    - `productOrderCreateEvent`
    - `cancelProductOrderCreateEvent`
  - added:
    - `productOrderItemStateChangeEvent`
    - `productSpecificProductOrderMilestoneEvent`
    - `productSpecificProductOrderItemMilestoneEvent`
    - `chargeCreateEvent`
    - `chargeStateChangeEvent`
    - `chargeTimeoutEvent`
    - `modifyProductOrderItemCompletionDateStateChangeEvent`
  - renamed:
    - `productOrderExpectedCompletionDateSet` => `productOrderExpectedCompletionDateSetEvent`
    - `productOrderItemExpectedCompletionDateSet` => `productOrderItemExpectedCompletionDateSetEvent`
- Addded types
  - `ProductOrder_Update`
  - `MEFProductOrderItem_Update`
  - `MEFCharge`
  - `MEFChargeItem`
  - `MEFChargeActivityType`
  - `MEFPriceType`
  - `MEFChargeStateType`
  - `MEFAcceptedRejectedType`
  - `MEFModifyProductOrderItemCompletionDate`
  - `MEFModifyProductOrderItemCompletionDateStateType`
  - `MEFProductOrderItemRef`
  - `TerminationError`
  - `CancelProductOrderStateType`
  - `CancellationReasonType`
- Removed types:
  - `MEFPricingMethod`
  - `Error405`
  - `OrderPrice`
  - `TaskStateType`
  - `MEFPricingMethod`
  - `OrderPrice`

**Readiness status**: Work in progress and is subject to change

## Release Aretha:

### List of changes in the API:

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
  - `productOrderInformationRequiredEvent`

## Developer Guide document

There is no Developer Guide document at his moment. A project is running to
deliver one for the next Billie release.

**Readiness status**: Work in progress and is subject to change
