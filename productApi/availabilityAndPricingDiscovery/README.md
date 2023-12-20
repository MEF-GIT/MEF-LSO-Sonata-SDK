# Product Offering Availability and Pricing Discovery: Release notes

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
- `ProductOfferingAvailability_Common` - renamed to `ProductOfferingAvailability_Request`
  - `place` - ref type changed from `RelatedPlaceRefOrValue` to
    `RelatedPlaceRef`
- `ProductOfferingAvailability_Request` - merged to `ProductOfferingAvailability_Common`
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
