# Product Catalog: Release notes

## Release Janis:

**Readiness status**: Call for Comments #3 resolved. Ready to start the Letter Ballot. It will be most likely published
as a standard in this form.

**Summary:**

- Attachment only allowed with use of `url`.
- Common schemas consistency applied.

### List of changed requirements:

- Added:
  - **[R105]**
  - **[R106]**
  - **[R107]**
- Modified:
  - 
- Removed:
  - **[*R80]**
  - **[*R81]**
  - **[*R95]**
  
The numbers with (*) refer to the numbering from previous version of the document.

### List of changes in the API:

**productCatalog.api.yaml:**

- `GET /productSpecification/`:
  - `agreement` - added to query params


- `AttachmentValue`:
  - `attachmentId` - removed
  - `content` - removed
  - `url` - marked as required
- `FieldedAddress`:
  - `poBox` - added (missing in previous version)
- `MEFByteSize`:
  - `amount` - removed `default: 1`
- `PriceModifier`:
  - `minimumQuantity` - `minimum` changed from `0` to `1`
  - `minimumQuantity` - no longer required
- `ProductOffering_Find`:
  - `agreement` - no longer required 
- `ProductOfferingBundleRelationship`:
  - `isModifiable` - added
- `ProductOfferingRef`:
  - `href` - removed `format: uri`
- `ProductSpecification_Common`:
  - `agreement` - added
- `ProductSpecificationRef`:
  - `href` - removed `format: uri`

**productCatalogNotification.api.yaml:**

- `ProductOfferingLifecycleStatusType`:
  - `announced` - renamed to `active`

## Release Irene:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #2

**Summary:**

- Introducing new use cases defined by MEF W127.1:
  - Bundling
  - Pricing
- Updating Fielded Address according to new definition in MEF 150
- Revised, fully specialized Event model.
- State change events now carry the value of the new `state`
- `buyerId` and `sellerId` in notification now carried via query params
  (consistent with seller side API)

### List of changes in the API:

**productCatalog.api.yaml:**

- `GET /category/`:
  - `422` - response code added
- `GET /productOffering/`:
  - `isBundle` - query param added
  - `isSellable` - query param added
  - `region.country` - query param renamed to `region.countryCode`
  - `422` - response code added
- `GET /productSpecification/`:
  - `422` - response code added
- `POST /hub/`:

  - `422` - response code added

- `Context`:
  - `businessFunction` - marked as required
- `Duration`:
  - `amount` - added `minimum:0`
- `Error422` - added
- `Error422Code` - added
- `FieldedAddress` - replaced with `FieldedAddressRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `buildingName` - added
  - `country` - removed
  - `countryCode` - added
  - `geographicSubAddress` - removed
  - `language` - added
  - `privateStreetName` - added
  - `privateStreetNumber` - added
  - `streetPreDirection` - added
  - `streetPostDirection` - added
  - `streetSuffix` - removed
  - no attribute is required anymore
- `GeographicSubAddress` - removed
- `MEFPriceType` - added
- `MEFSubUnit` - renamed to `SubUnit`
- `Money` - added
- `PlaceRelationshipConstraint`:
  - `isModifiable` - added
- `Price` - added
- `PriceModifier` - added
- `ProductOffering`:
  - `agreement` - marked as not required
  - `bundledProductOffering` - added
  - `category` - marked as not required
  - `channel` - marked as not required
  - `description` - marked as required
  - `isBundle` - marked as required
  - `isSellable` - marked as required
  - `marketSegment` - marked as not required
  - `productOfferingSpecification` - renamed to
    `productOfferingSpecificationSchema`
  - `productOfferingTerm` - ref type changed to `ProductOfferingTerm`
  - `productRelationship` - renamed to `productRelationshipConstraint`
  - `placeRelationship` - renamed to `placeRelationshipConstraint`
  - `region` - marked as not required
- `ProductOffering_Common`:
  - `isBundle` - added
  - `isSellable` - added
- `ProductOfferingBundleRelationship` - added
- `ProductOfferingLifecycleStatusTransition`:
  - `transitionLifecycleStatus` - renamed to `lifecycleStatus`
  - `statusReason` - added
- `ProductOfferingLifecycleStatusType`:
  - `announced` - renamed to `active`
- `ProductOfferingPrice` - added
- `ProductOfferingTerm` - added
- `ProductRelationshipConstraint`:
  - `id` - renamed to `productSpecification`
  - `isModifiable` - added
- `Region`:
  - `city` - added
  - `country` - renamed to `countryCode`
- `RelatedContactInformation`:
  - `postalAddress` - changed ref type to `FieldedAddressRepresentation`
- `TimePeriod` - added
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

**productCatalogNotification.api.yaml:**

- `buyerId` and `sellerId` added to parameters to all endpoints
  ProductOrderEventPayload
- `buyerId` and `sellerId` removed from all payloads
- all listener endpoint changed the `requestBody` content schema to their
  respective events.

- `/listener/categoryStatusChangeEvent` - removed
- `/listener/productOfferingStatusChangeEvent` - renamed to
  `/listener/productOfferingStateChangeEvent`

- `408` - response code removed
- `Error408` - removed
- `Event` - made a generic Event
  - `eventType` - changed to `string`
  - `event` - changed to `object`
- `ProductCategoryAttributeValueChangeEvent` - added
- `ProductCategoryEvent` - removed
- `ProductCategoryEventType` - removed
- `ProductCategoryCreateEvent` - added
- `ProductOfferingAttributeValueChangeEvent` - added
- `ProductOfferingCreateEvent` - added
- `ProductOfferingEvent` - removed
- `ProductOfferingEventType` - removed
- `ProductOfferingStateChangeEvent` - added
- `ProductOfferingStateChangeEventPayload` - added
- `ProductSpecificationAttributeValueChangeEvent` - added
- `ProductSpecificationCreateEvent` - added
- `ProductSpecificationEvent` - removed
- `ProductSpecificationEventType` - removed
- `ProductSpecificationStateChangeEvent` - added
- `ProductSpecificationStateChangeEventPayload` - added

## Release Haley:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #1

No changes.

## Release Grace:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #1

**Summary:** Major changes:

- Simplification of `ProductSpecification.lifecycleStatus`
- Added possibility to define and constrain:
  - `productRelationship`
  - `placeRelationship`
  - `milestone`

### List of changes in the API:

**productCatalog.api.yaml:**

- `GET /category`:
  - `lifecycleStatus` - removed from parameters
  - `parentCategory.name` - changed to `parentCategory.id`
- `GET /productOffering`:
  - `productSpecification.id` - added to parameters
- `GET /productSpecification`:
  - `lifecycleStatus` - query parameter:
    - `active` - removed
    - `endOfSale` - removed
    - `endOfSupport` - removed
    - `onHold` - removed
    - `launched` - removed
    - `inTest` - removed
    - `rejected` - removed
    - `published` - added
  - `brand` - removed
- `CategoryRef` - renamed to `ProductCategoryRef`
- `CategoryLifecycleStatusType` - removed
- `MEFProductAction` - renamed to `ProductActionMask`
- `MEFBusinessFunction` - renamed to `BusinessFunctionMask`
  - `productOfferingQualification` - changed to `poq`
- `PlaceRelationshipConstraint` - added
- `ProductCategory`:
  - `lifecycleStatus` - removed
- `ProductMilestoneDefinition` - added
- `ProductOffering`:
  - `milestone` - added
  - `placeRelationship` - added
  - `productRelationship` - added
  - `productOfferingStatusReason` - renamed to `statusReason`
  - `relatedContactInformation` - changed from array to a single attribute
  - `statusTransitions` - renamed to `statusTransition` and made required
  - `productSpecification` - moved to `ProductOffering_Find`
- `ProductOffering_Find`:
  - `productSpecification` - added, moved from `ProductOffering`
- `ProductOfferingLifecycleStatusType`:
  - `active` - removed
  - `announced` - added
- `ProductRelationshipConstraint` - added
- `ProductSpecification`:
  - `brand` - removed
  - `milestone` - added
  - `productNumber` - removed
  - `productSpecificationRelationship` - renamed to `productRelationship`
  - `productRelationship` - added
  - `placeRelationship` - added
- `ProductSpecificationLifecycleStatusType`:
  - `active` - removed
  - `endOfSale` - removed
  - `endOfSupport` - removed
  - `onHold` - removed
  - `launched` - removed
  - `inTest` - removed
  - `rejected` - removed
  - `published` - added
- `ProductSpecificationRelationship` - renamed to
  `ProductRelationshipConstraint`

**productCatalogNotification.api.yaml:**

None.

## Release Fergie:

First release of this API
