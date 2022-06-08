# Product Order Management: Release notes

## Release Dolly:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #2

### List of changes in the API:

**productOrderManagement.yaml:**

- `/productOrder/`
  - `GET`
    - `requestedCompletionDate.gt` - renamed to  `itemRequestedCompletionDate.gt`
    - `requestedCompletionDate.lt` - renamed to `itemRequestedCompletionDate.lt`
    - `expectedCompletionDate.gt` - renamed to `itemExpectedCompletionDate.gt` 
    - `expectedCompletionDate.lt` - renamed to `itemExpectedCompletionDate.lt`
    - `orderCancellationDate.gt` - renamed to `cancellationDate.gt`
    - `orderCancellationDate.lt` - renamed to `cancellationDate.lt`
- `/cancelProductOrder/`
  - `GET`
    - `productOrderExternalId` - removed
    - `state` - added
    - `cancellationReasonType` - added
- `/charge/`
  - `GET`
    - `creationDate.gt` - added
    - `creationDate.lt` - added

- `ProductOrder`
  - `orderVersion` - removed
  - `expectedCompletionDate` - removed
- `ProductOrder_Common`
  - `requestedCompletionDate` - removed
- `ProductOrder_Find`
  - `orderVersion` - removed
  - `requestedCompletionDate` - removed
- `ProductOrder_Update`
  - `orderVersion` - removed
- `CancelProductOrder`
  - `orderVersion` - removed
- `CancelProductOrder_Create`
  - `orderVersion` - removed
- `MEFModifyProductOrderItemRequestedDeliveryDate`
  - `orderVersion` - removed
- `MEFModifyProductOrderItemRequestedDeliveryDate_Create`
  - `orderVersion` - removed
- `ProductOrderItem`
  - `milestone` - added
- `CancelProductOrder`
  - `relatedContactInformation` - required role `sellerContact` renamed to `cancelProductOrderSellerContact`
- `CancelProductOrder_Find` - added and set as result type of `listCancelProductOrder` list operation

- `MEFProductOrderCharge`
  - `replacedCharge` - removed
  - `creationDate` - made required
- `MEFProductOrderChargeItem`
  - `chargeType` - renamed to `priceType`
  - `description` - renamed to `priceCategory`
  - `note` - added
- `MEFProductOrderChargeItem_Update`
  - `note` - added
- `MEFProductOrderCharge_Find` - added and set as result type of `listCharge` list operation
- `MEFProductOrderChargeItemDescription` - renamed to `MEFPriceCategory`
  - `other` - added to enumeration
- `MEFMilestone` - added
- `MEFItemTerm`
  - made required:
    - `name`
    - `duration`
    - `endOfTermAction`

**productOrderNotification.yaml:**

- server URL `/mefApi/sonata/productOrderingManagement/` changed to `/mefApi/sonata/productOrderingNotification/`

## Release Celine:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #1

### List of changes in the API:

**productOrderManagement.yaml:**

- `/productOrder/`
  - `GET`
    - `orderCancellationDate.gt` renamed to `cancellationDate.gt`
    - `orderCancellationDate.lt` renamed to `cancellationDate.lt`
- `/modifyProductOrderItemCompletionDate` renamed to
  `/modifyProductOrderItemRequestedDeliveryDate`
- `/modifyProductOrderItemRequestedDeliveryDate`
  - `GET`
    - added:
      - `creationDate.gt`
      - `creationDate.lt`
- `ProductOrder`
  - added:
    - `cancellationCharge`
  - removed:
    - `description`
    -
- `ProductOrderItem`
  - added:
    - `agreementName`
  - removed:
    - `sellerItemIdentifier`
- `MEFBillingAccount` - removed (replaced by MEFBillingAccountRef.
  `agreementName` and `billingContact` moved to Product Order Item level
- `MEFBillingAccountRef` - added
- `CancelProductOrder`
  - added:
    - `cancellationDeniedReason`
  - removed:
    - `note`
- `MEFCharge` - renamed to `MEFProductOrderCharge`
- `MEFCharge_Update` - renamed to `MEFProductOrderCharge_Update`
- `MEFChargeStateType` - renamed to `MEFProductOrderChargeStateType`
- `MEFChargeRef` - renamed to `MEFProductOrderChargeRef`
- `MEFChargeActivityType` - renamed to `MEFProductOrderChargeActivityType`
- `MEFChargeItem` - renamed to `MEFProductOrderChargeItem`
- `MEFChargeItem_Update` - renamed to `MEFProductOrderChargeItem_Update`
- `MEFChargeItemStateType` - renamed to `MEFProductOrderChargeItemStateType`
- `MEFChargeItemDescription` - renamed to
  `MEFProductOrderChargeItemDescription`
- `MEFChargeItemDescription`
  - `inFlightCancellation` - renamed to `cancellation`
- `MEFModifyProductOrderItemCompletionDate` - renamed to
  `MEFModifyProductOrderItemRequestedDeliveryDate`
- `MEFModifyProductOrderItemCompletionDateRef` - renamed to
  ` MEFModifyProductOrderItemRequestedDeliveryDateRef`
- `MEFModifyProductOrderItemCompletionDate_Create` - renamed to
  ` MEFModifyProductOrderItemRequestedDeliveryDate_Create`

- `MEFProductOrderCharge`:
  - added:
    - `productOrder`
    - `replacedCharge`
  - `modifyProductOrderItemCompletionDate` renamed to
    `modifyProductOrderItemRequestedDeliveryDate`
  - `productOrderItem` - marked not required
- `MEFProductOrderChargeItem`:
  - `chargeType` - marked as required
  - `description` - marked as required
  - `description` - dictionary introduced
    (https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK-extended/issues/60)
  - `activityType` - marked as required
  - `blocking` - marked as required
  - `price` - marked as required
  - `state` - marked as required
- `MEFChargeStateType`
  - `timeout` - added
- `MEFProductOrderRef`
  - `productOrderId` - made required

**productOrderNotification.yaml:**

Changed the url from `/productOrderNotification` to
`productOrderingNotification`

- `/listener/productSpecificProductOrderMilestoneEvent` - endpoint removed
- `/listener/productOrderExpectedCompletionDateSet` - endpoint removed
- `ProductOrderEventType`

  - `productSpecificProductOrderMilestoneEvent` - removed
  - `productOrderExpectedCompletionDateSet` - removed

- `Code` renamed to `Error400Code`
- `/listener/modifyProductOrderItemCompletionDateStateChangeEvent` renamed to
  `/listener/ModifyProductOrderItemRequestedDeliveryDateStateChangeEvent`
- `ModifyProductOrderItemCompletionDateEvent` renamed to
  `ModifyProductOrderItemRequestedDeliveryDateEvent`
- `ModifyProductOrderItemCompletionDateEventType` renamed to
  `ModifyProductOrderItemRequestedDeliveryDateEventType`
- `modifyProductOrderItemCompletionDateStateChangeEvent` renamed to
  `ModifyProductOrderItemRequestedDeliveryDateStateChangeEvent`
- `ModifyProductOrderItemCompletionDateEventPayload` renamed to
  `ModifyProductOrderItemRequestedDeliveryDateEventPayload`

## Release Billie:

**Readiness status**: Work in progress and is subject to change

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
    - `productOrderExpectedCompletionDateSet` =>
      `productOrderExpectedCompletionDateSetEvent`
    - `productOrderItemExpectedCompletionDateSet` =>
      `productOrderItemExpectedCompletionDateSetEvent`
- Added types
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
