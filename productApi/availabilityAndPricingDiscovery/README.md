# Product Offering Availability and Pricing Discovery: Release notes

## Release Haley:

**Readiness status**: Resolved Call for Comments Ballot #2. This version is
subject to change.

**Summary:**

Most changes are renaming due to changes in Business Requirements or fixings to
follow standard naming patterns.

### List of changes in the API:

**productOfferingAvailabilityAndPricingDiscovery.api.yaml:**

- `PricingAndTerm`:
  - `productOffering` - removed
- `PricingDiscovery`:
  - `pricingAndTerms` - renamed to `pricingAndTerm`
- `PricingDiscovery_Request`:
  - `productConfigurationIdentifier` - renamed to
    `productOfferingConfigurationIdentifier`
- `ProductOfferingAvailability`:
  - `availableProductOfferingConfigurations` - renamed to
    `availableProductOfferingConfiguration`
- `ProductOfferingConfiguration`:
  - `productConfigurationIdentifier` - renamed to
    `productOfferingConfigurationIdentifier`
- `TimeUnit`:
  - `calendarMonths` - renamed to `months`
  - `calendarYears` - renamed to `years`

## Release Grace:

**Readiness status**: Resolved Call for Comments Ballot #1. This version is
subject to change.

**Summary:**

- Address and Site can only be provided by reference
- minor changes in `PricingAndTerm` and `TimeUnit`

### List of changes in the API:

**productOfferingAvailabilityAndPricingDiscovery.api.yaml:**

- `FieldedAddress` - removed
- `FormattedAddress` - removed
- `GeographicAddressLabel` - removed
- `GeographicSubAddress` - removed
- `MEFGeographicPoint` - removed
- `MEFSubUnit` - removed
- `PricingAndTerm`:
  - `firm` - removed
  - `validFor` - removed
- `PricingDiscovery_Common` - renamed to `PricingDiscovery_Request`
  - `place` - ref type changed from `RelatedPlaceRefOrValue` to
    `RelatedPlaceRef`
- `PricingDiscovery_Request` - merged to `PricingDiscovery_Common`
- `ProductOfferingAvailability_Common` - renamed to
  `ProductOfferingAvailability_Request`
  - `place` - ref type changed from `RelatedPlaceRefOrValue` to
    `RelatedPlaceRef`
- `ProductOfferingAvailability_Request` - merged to
  `ProductOfferingAvailability_Common`
- `RelatedPlaceRefOrValue` - replaced with `RelatedPlaceRef`
- `TimePeriod` - removed
- `TimeUnit`:
  - added:
    - `seconds`
    - `minutes`
    - `calendarYears`
  - removed:
    - `calendarMinutes`
    - `businessMinutes`

## Release Fergie:

First release of this API.
