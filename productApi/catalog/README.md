# Product Catalog: Release notes

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
  - `lifecycleStatus` - query paremeter:
    - `active` - removed
    - `endOfSale` - removed
    - `endOfSupport` - removed
    - `onHold` - removed
    - `orderable` - removed
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
  - `statusTransitions` - renamed to `statusTransition`
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
  - `orderable` - removed
  - `inTest` - removed
  - `rejected` - removed
  - `published` - added
- `ProductSpecificationRelationship` - renamed to
  `ProductRelationshipConstraint`

**productCatalogNotification.api.yaml:**

None.

## Release Fergie:

First release of this API
