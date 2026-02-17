# Internet Access: Release notes

## Release Kylie:

**Readiness status**: Done. Ready for Letter Ballot.

**Summary:**

- Pricing part of Billing Model moved to standard Quote API pricing.
- Simplified Bgp model
- Clarification of required attributes
- Extraction of enumerations

**Changes**

- `BgpExtendedCommunity`:
  - `regularOrExtended` - added
  - `regularType` - removed
  - `regularValue` - removed
  - `extendedType` - removed
  - `extendedValue` - removed
- `BgpRegularType` - added
- `BgpExtendedType` - added
- `BiDirSimpleBandwidth`:
  - `downstream` - made required
  - `upstream` - made required
- `FourOctetInteger`:
  - added `format: int64`
-`InternetAccess`:
  - `variant` - added
-`InternetAccessAssistanceLevel` - added
- `InternetAccessBgp` - added to simplify Bgp model - it removes `peerAsNumber`, `damping`, and `administrativeDistance` attributes
- `InternetAccessAutonomousSystemNumber`:
  - `asnType` - made required
- `InternetAccessBillingModel` - Removed pricing parameters. The standard Quote process shall be used and will be extended in future to accommodate requirements for new billing types. renamed to `InternetAccessBilling`
  - `billingModelPlanName` - added
  - `billingModelType` - enum extracted to `InternetAccessBillingModelType`
  - `nonRecurringPrice` - removed
  - `recurringPrice` - removed
  - `discriminator` - removed
- `InternetAccessBillingModelType` - added
- `InternetAccessBurstablePercentileBilling` - removed
- `InternetAccessDataTransferBilling` - removed
- `InternetAccessDataTransferTier` - removed
- `InternetAccessDhcpStaticListEntry`:
  - `staticIpAddress` - changed ref type to `Ipv4OrIpv6Address`
- `InternetAccessFeatureAssistance`:
  - `assistanceLevel` - enum extracted to `InternetAccessAssistanceLevel`
- `InternetAccessFeatureDedicatedFirewall`:
  - `firewallType`:
    - renamed to `firewallCapability`
    - enum value `COMPLEX` renamed to `ADVANCED`
    - made required
    - enum extracted to `InternetAccessFirewallCapability`
- `InternetAccessFeatureFacilityDiversity` - removed. Using Product Relationship when feature is enabled.
- `InternetAccessFeatureDns`:
  - `searchDomain` - not required
- `InternetAccessFeatureRouting`:
  - `bgp` - changed ref type from `../../../common/ip/ipRoutingProtocolsCommon.yaml#/definitions/Bgp` to `#/definitions/InternetAccessBgp`
- `InternetAccessFirewallCapability` - added
- `InternetAccessFlatBilling` - removed
- `InternetAccessFeatureLayer3Resiliency`:
  - `layer3Resiliency` - enum extracted to `InternetAccessLayer3Resiliency`
- `InternetAccessFeatureMonitoring`:
  - `monitoringType` - enum extracted to `InternetAccessMonitoringType`
- `InternetAccessFeatureRouting`:
  - `routingType` - enum extracted to `InternetAccessRoutingType`
- `InternetAccessLocalNetworkAddresses`:
  - `dhcpEnd` - changed ref type to `Ipv4OrIpv6Address`
  - `dhcpStart` - changed ref type to `Ipv4OrIpv6Address`
  - `dhcpStatus` - made required
  - `nat`:
    - renamed to `natAddress`
    - changed ref type to `Ipv4OrIpv6Address`
  - `natStatus` - added
- `InternetAccessNonRecurringPrice` - removed
- `InternetAccessPhysicalInterface`:
  - `physicalLayer` - made required
  - `connectorType` - made required
- `InternetAccessPublicAddressBlock`:
  - `ipv4` - removed `nullable: true`
  - `ipv6` - removed `nullable: true`
- `InternetAccessServiceAccessInterfaceType`:
  - `physical`:
    - renamed to `physicalInterface`
    - added `minItems: 1`
    - made required
  - `resiliency` - made required
- `InternetAccessTransitAddresses`:
  - `ipv4TransitAddressPrefixLength` - renamed to `requestedIpv4TransitAddressPrefixLength`
  - `ipv6TransitAddressPrefixLength` - renamed to `requestedIpv6TransitAddressPrefixLength`
  - `ipv4TransitAddressBlock` - replaced with `serviceProviderIpv4TransitAddress`
  - `ipv6TransitAddressBlock` - replaced with `serviceProviderIpv6TransitAddress`
- `InternetAccessVariantName` - added
- `SaiEthernetPhysicalLayer` - enum based on Mplify 165 Table 6


## Release Janis:

**Readiness status**: Work in progress. Ready for Call for Comments #1

First release of the model. Superseding MEF 139.
