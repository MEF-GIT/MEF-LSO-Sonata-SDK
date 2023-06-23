# Internet Access Product: Release notes

## Release Fergie:

**Readiness status**: Working Draft with implemented feedback from Call for
Comments Ballot #2

**Summary**: Lots of small improvements.

- Simplified Routing Protocols constructs
- The `relationshipType` name pointing to `EthernetUniAccessLinkTrunk` changed from
  `PROVIDED_BY` to `CARRIED_OVER_TRUNK`
- Reused simple data types extracted to common definition
- Many small updates

**ipCommon.yaml:**

- `Addressing` - renamed to `ControlProtocolAddressing`
- `Bgp`:
  - `holdTime` - used `TwoOctetInteger` as attribute definition
  - `subscriberAsNumber` - set type to `FourOctetInteger`
  - `peerAsNumber` - set type to `FourOctetInteger`
  - `administrativeDistance` - changed `minimum` to `1`
- `BgpCommunity`:
  - `autonomousSystemNumber` - used `TwoOctetInteger` as attribute definition
  - `autonomousSystemDefined` - used `TwoOctetInteger` as attribute definition
- `BgpExtendedCommunity`:
  - `extendedType` - used `TwoOctetInteger` as attribute definition
- `ClassOfServiceMapEntry`:
  - `destinationL4Port` - used `TwoOctetInteger` as attribute definition
  - `sourceL4Port` - used `TwoOctetInteger` as attribute definition
- `CloudDns`:
  - `dnsType` - made not required
  - `dnsServerIpv4List` and `dnsServerIpv6List` - merged to `dnsServerIpList`
    and set as nullable
- `Damping`:
  - `reuseListMemoryReuseListMax` - renamed to `reuseListMemory`
- `Demux`:
  - `utpt` and `vlanId` - marked as mutually exclusive
- `DhcpRelay`
  - `dhcpServerList` and `ipvcEndPointIdentifier` - no longer mutually exclusive
  - `dhcpServerList` - changed ref type from `DhcpServer` to `Ipv4OrIpv6Address`
- `DscpMapping` - removed, replaced by simplification of `DscpValue`
- `DscpValue` - added
- `EgressClassOfServiceMapUni` - removed and replaced by simplification of
  `DscpValue`
- `EthernetPhysicalLink`:
  - `identifier` - changed to ref type `IdentifierString`
- `FourOctetInteger` - added
- `IpBwpFlow`:
  - `flowIdentifier` - changed `minimum` to `1`
- `IpUniAccessLinkTrunk` - moved to ipUniCommon.yaml
- `IpUniAccessLinkIdentifier` - replaced by `IdentifierString`
- `IpUniAccessLinkTrunkIdentifier` - removed
- `Ipv4SecondarySubnet`:
  - `ipv4Prefix` - made not required
- `Ipv4Subnet` - renamed to `Ipv4SecondarySubnet`
- `Ipv6Subnet`:
  - `ipv6Prefix` - made not required
- `IpvcEndPointIdentifier` - replaced with `IdentifierString`
- `LacpVersion` - changed type to `string`
- `L2Technology`:
  - `trunkId` - removed
- `Ospf`:
  - `areaId` - changed to `Ipv4Address` (IPv4 formatted string)
  - `helloInterval` - used `TwoOctetInteger` as attribute definition
  - `administrativeDistance` - changed `minimum` to `1`
- `RoutingProtocols`:
  - `static` - changed ref type from `RoutingProtocolsStaticOptions` to `Static`
- `RoutingProtocolsBgpIpv4AndIpv6` - removed
- `RoutingProtocolsBgpOptions`:
  - `both` - not mutually exclusive with other attributes
  - `ipv4` - not mutually exclusive with other attributes
  - `ipv4AndIpv6` - removed
  - `ipv6` - not mutually exclusive with other attributes
- `RoutingProtocolsOspfIpv4AndIpv6` - removed
- `RoutingProtocolsOspfOptions`:
  - `ipv4` - not mutually exclusive with `ipv6`
  - `ipv6` - not mutually exclusive with `ipv4`
  - `ipv4AndIpv6` - removed
  - `both` - removed
- `RoutingProtocolsStaticIpv4AndIpv6` - removed
- `RoutingProtocolsStaticOptions` - removed
- `SubscriberPrefixList` - set type to `object`
- `StaticIpEntry`
  - `administrativeDistance` - changed `minimum` to `1`
- `TimeDuration`:
  - `timeDurationValue` - made not required
  - `timeDurationUnits` - made not required
- `TwoOctetInteger` - added
- `UniAccessLinkTrunkType` - removed
- `UniManagementType`:
  - `SUBSCRIBER_MANAGEMENT` - changed to `SUBSCRIBER_MANAGED`
  - `PROVIDER_MANAGEMENT` - changed to `PROVIDER_MANAGED`

**ipSls.yaml:**

- `IpSls`:
  - `locationList` - removed minItems: 1
- `IpvcEndPointRef` - removed.
- `Location`:
  - `ipvcEndPointIdentifier` - removed minItems: 1
  - removed `allOf` to `SlsReferencePoint`
- `OneWayMeanPacketDelay`:
  - `meanPacketDelayObjective` - changed type to `TimeDuration`
- `OneWayInterPacketDelayVariation`:
  - `packetArrivalTimeDifference` - changed type to `TimeDuration`
  - `interPacketDelayVariationObjective` - changed type to `TimeDuration`
- `OneWayPacketDelayPercentile`:
  - `packetDelayObjective` - changed type to `TimeDuration`
- `OneWayPacketDelayRange`:
  - `packetDelayRangeObjective` - changed type to `TimeDuration`
- `SlsReferencePoint`:
  - added:
    - `referencedType`
    - `identifier`

**ipUniCommon.yaml:** - added

- `IpUniAccessLinkTrunk` - moved from ipCommon.yaml
  - `trunkType` - removed
  - `identifier` - removed

**ipUniAccessLink.yaml:**

- `IpUniAccessLink`:
  - `bfd` - marked as nullable
  - `dhcpRelay` - marked as nullable

**internetAccessCommon.yaml:**

- `BasicIaUniIpv4ConnectionAddressing`:
  - `ipv4PrimarySubnet` - changed ref type to `Ipv4PrimarySubnet`
- `IaIpvcCloud`:
  - `networkAddressTranslation` - marked as nullable
- `IaIpvcEndPointCommon`:
  - `identifier` - string definition substituted with data type
    `IpvcEndPointIdentifier`
  - `egressClassOfServiceMap` - changed ref type to DSCP Value.
- `IaIpvcEndPointCommon`

**ethernetUniAccessLinkTrunk.yaml:**

- `EthernetUniAccessLinkTrunk`:
  - `ethernetLinkAggregation` - marked as nullable

## Release Ella:

**Readiness status**: Working Draft with implemented feedback from Call for
Comments Ballot #1

**Summary** - Very significant changes, including:

- added a new aggregated version of Advanced Internet Access -
  "ExclusiveAdvancedInternetAccess"
- introduced a "flat" model pattern to Basic and Exclusive Advanced Internet
  Access
- introduced specification of mutually exclusive attributes definitions
- merging ingress and egress bandwidth profiles

**ipCommon.yaml:**

- `AccessLinkBfd`
  - `detectMultiplier` - added minimum: 0
  - `transmissionInterval` - changed type to integer >0
- `Bgp`
  - `administrativeDistance` - added minimum: 0
  - `authentication` - changed type to `string`, marked as nullable
  - `peerAsNumber` - added minimum: 0
  - `subscriberAsNumber` - added minimum: 0
  - `damping` - marked as nullable
  - `ipPrefixes` - removed
- `BgpExtendedCommunity` - switched to use octets
- `BgpCommunity` - changed from enum to:
  - `autonomousSystemNumber` - added
  - `autonomousSystemDefined` - added
  - `semantics` - added
- `BgpExtendedCommunity`:
  - `regularType` - changed `maximum` to `255`
  - `semantics` - added
- `ClassOfServiceMapEntry`
  - `destinationL4Port` - added minimum: 0, maximum: 65535
  - `l4protocol` - added minimum: 0, maximum: 255
  - `sourceL4Port` - added minimum: 0, maximum: 65535
  - `destinationIpAddress` - changed ref type to `Ipv4OrIpv6Prefix`
  - `sourceIpAddress` - changed ref type to `Ipv4OrIpv6Prefix`
- `CloudDataLimit`
  - `download` - added minimum: 0
  - `upload` - added minimum: 0
- `ConnectorType` - added
- `Damping`
  - `cutoffThreshold` - added minimum: 0
  - `decayHalfLifeWhileReachable` - added minimum: 0
  - `decayHalfLifeWhileUnReachable` - added minimum: 0
  - `decayMemoryLimit` - added minimum: 0
  - `maxHoldDownTime` - added minimum: 0
  - `numberOfReuseLists` - added minimum: 0
  - `reuseListMemoryReuseListMax` - added minimum: 0
  - `reuseListTimeGranularity` - added minimum: 0
  - `reuseThreshold` - added minimum: 0
  - `timeGranularity` - added minimum: 0
  - `reuseIndexArraySize` - added
- `Demux` - added
- `DhcpRelay`
  - `dhcpServerList` and `ipvcEndPointIdentifier` - marked as mutually exclusive
  - `dhcpServerList` - changed ref type from `DhcpServer` to `Ipv4OrIpv6Address`
- `DnsType`:
  - `NONE` - added
- `EgressClassOfServiceMap` - renamed to `EgressClassOfServiceMapUni`
  - `pcpMapping` - removed
- `EndPointIdentifierAndCosName` - renamed to `IpvcEpAndCosName`
  - `ipvcEndPointIdentifier` - changed to ref type `IpvcEndPointIdentifier`
- `EthernetPhysicalLayer` - added
- `EthernetPhysicalLink` - added
- `ForwardingInformation`
  - `nextHopIpAddress` and `uniAccessLink` - marked as mutually exclusive
  - `nextHopIpAddress` - changed to ref type Ipv4OrIpv6Address
  - `uniAccessLink` - changed ref type to `IpUniAccessLinkIdentifier`
- `Gender` - added
- `IpBwpEnvelope`
  - `tE` - added minimum: 0
- `IpBwpFlow`
  - `flowIdentifier` - added minimum: 0
  - `weight` - specified type: integer, minimum: 0
- `IpUniEgressBwpAccessLink` - changed `allOf` reference to `IpBwpFlow` (was:
  `IpBwpEnvelope`)
  - `detectMultiplier` - added minimum: 0
- `IpUniEgressBwpIpvcEp`:
  - `ipvcEndPointIdentifier` - changed to ref type `IpvcEndPointIdentifier`
- `IpUniEgressBwpEnvelope` - replaced with `IpUniBwpEnvelope`
  - `ipUniEgressBwpAccessLink` - added minItems: 1
  - `ipUniEgressBwpIpvcEp` - added minItems: 1
  - `ipUniEgressBwpIpvcEpAccessLink` - added minItems: 1
  - `ipUniEgressBwpIpvcEpCos` - added minItems: 1
  - `ipUniEgressBwpIpvcEpCosAccessLink` - added minItems: 1
  - `ipUniEgressBwpAccessLink`, `ipUniEgressBwpIpvcEp`,
    `ipUniEgressBwpIpvcEpAccessLink`, `ipUniEgressBwpIpvcEpCos`,
    `ipUniEgressBwpIpvcEpCosAccessLink`, and `ipUniEgressBwpUni` - marked as
    mutually exclusive
- `IpUniEgressBwpIpvcEpCos` - changed `allOf` reference to `IpBwpFlow` (was:
  `IpBwpEnvelope`)
- `IpUniEgressBwpIpvcEpCosAccessLink` - added `allOf` reference to `IpBwpFlow`
- `IpUniEgressIpvcBwpIpvcEpAccessLink`
  - changed `allOf` reference to `IpBwpFlow` (was: `IpBwpEnvelope`)
  - `ipvcEndPointIdentifier` - changed to ref type `IpvcEndPointIdentifier`
  - `uniAccessLinkIdentifier` - changed to ref type `IpUniAccessLinkIdentifier`
- `IpUniIngressBwpAccessLink` - changed `allOf` reference to `IpBwpFlow` (was:
  `IpBwpEnvelope`)
- `IpUniIngressBwpIpvcEp`:
  - `ipvcEndPointIdentifier` - changed to ref type `IpvcEndPointIdentifier`
- `IpUniIngressBwpEnvelope` - replaced with `IpUniBwpEnvelope`
  - `IpUniIngressBwpAccessLink` - added minItems: 1
  - `IpUniIngressBwpIpvcEp` - added minItems: 1
  - `IpUniIngressBwpIpvcEpAccessLink` - added minItems: 1
  - `IpUniIngressBwpIpvcEpCos` - added minItems: 1
  - `IpUniIngressBwpIpvcEpCosAccessLink` - added minItems: 1
  - `IpUniIngressBwpAccessLink`, `IpUniIngressBwpIpvcEp`,
    `IpUniIngressBwpIpvcEpAccessLink`, `IpUniIngressBwpIpvcEpCos`,
    `IpUniIngressBwpIpvcEpCosAccessLink`, and `IpUniIngressBwpUni` - marked as
    mutually exclusive
- `IpUniIngressBwpIpvcEpCos` - changed `allOf` reference to `IpBwpFlow` (was:
  `IpBwpEnvelope`)
- `IpUniIngressBwpIpvcEpCosAccessLink` - added `allOf` reference to `IpBwpFlow`
- `IpUniIngressIpvcBwpIpvcEpAccessLink` - changed `allOf` reference to
  `IpBwpFlow` (was: `IpBwpEnvelope`)
  - `ipvcEndPointIdentifier` - changed to ref type `IpvcEndPointIdentifier`
- `Ipv4Prefix`
  - `prefixLength` - added minimum: 0, maximum: 31
- `Ipv6Prefix`
  - `prefixLength` - added minimum: 0, maximum: 127
- `Ipv4Subnet`
  - `reservedPrefixes` - added
  - `ipv4Prefix` - marked as required
- `Ipv6Subnet`
  - `reservedPrefixes` - added
  - `ipv6Prefix` - marked as required
  - `serviceProviderIpv6Addresses` - changed ref type to `Ipv6Address`
- `IpvcEpEgressBwpEnvelope` - replaced with `IpvcEpBwpEnvelope`
  - `IpvcEpEgressBwp` and `IpvcEpEgressBwpAll` - marked as mutually exclusive
- `IpvcEpIngressBwpEnvelope` - replaced with `IpvcEpBwpEnvelope`
  - `IpvcEpIngressBwp` and `IpvcEpIngressBwpAll` - marked as mutually exclusive
- `L2Technology` - added
- `OneWayMeanPacketDelay`:
  - `meanPacketDelayObjective` - added minimum: 0
- `OneWayInterPacketDelayVariation`:
  - `packetArrivalTimeDifference` - added minimum: 0
  - `interPacketDelayVariationObjective` - added minimum: 0
- `OneWayPacketDelayPercentile`:
  - `packetDelayRangeObjective` - added minimum: 0, renamed to
    `packetDelayObjective`
  - `packetDelayRangePercentile` - renamed to `packetDelayPercentile`
- `OneWayPacketDelayRange`:
  - `packetDelayRangeObjective` - added minimum: 0
- `Ospf`
  - `administrativeDistance` - added minimum: 0
  - `areaId` - added minimum: 0, maximum: 429967295
  - `deadInterval` - added minimum: 0, maximum: 429967295
  - `helloInterval` - added minimum: 0, maximum: 65535
  - `retransmissionInterval` - added minimum: 0
  - `retransmissionInterval` - renamed to `retransmitInterval`
  - `ipPrefixes` - removed
- `PeeringAddress`:
  - `connectionAddress` and `loopbacks` - removed and merged to
    `peeringAddressType`
  - `serviceProviderLoopback` and `subscriberLoopback` removed and merged to
    `subscriberAndSpLoopbackAddresses`
- `RoutingProtocols`:
  - `bgp` - added maxItems: 2
  - `ospf` - added maxItems: 2
  - `static` - added minItems: 1, maxItems: 2
  - `bgp`, `ospf`, and `static` - marked as mutually exclusive
- `StaticIpEntry`
  - `administrativeDistance` - added minimum: 0
  - `staticPrefix` - change ref type from `Ipv4Ipv6Prefixes` to
    `Ipv4OrIpv6Prefix`
- `SynchronousEthernet` - added
- `TimeDuration`
  - `timeDurationValue` - added minimum: 0
  - `timeDurationValue` - marked as required
  - `timeDurationUnits` - marked as required
- Added types:
  - `AddressFamilyIpv4Ipv6`
  - `AddressFamilyIpv4Ipv6Both`
  - `ConnectionType`
  - `ConversationIdRange`
  - `ConversationIdToAggregationLinkMap`
  - `EthernetUniAccessLinkTrunkCommon`
  - `IpBwpFlowAll`
  - `IpBwpFlowPerAccessLink`
    - `uniAccessLinkIdentifier` - changed type to `IpUniAccessLinkIdentifier`
  - `IpBwpFlowPerAccessLinkIpvcEpAndCosName`
    - `ipvcEpIdCosName` - renamed to `ipvcEpAndCosName`
  - `IpvcEpBwpEnvelope`
    - `ipvcEpEgressBwpAll` - renamed to `bwpFlowAll`
    - `ipvcEpEgressBwp` - renamed to `bwpFlowPerCosName`
  - `IpBwpFlowPerCosName`
  - `IpPrefixOrigin`
  - `IpUniAccessLinkTrunk`
  - `IpUniAccessLinkTrunkIdentifier`
  - `IpUniAccessLinkCommon`
    - `egressBandwidthProfileEnvelope` - renamed to `egressBwpEnvelope`
    - `egressBandwidthProfileEnvelope` - changed ref type from
      `IpUniEgressBwpEnvelope` to `IpUniAccessLinkEgressBwpEnvelope`
    - `ingressBandwidthProfileEnvelope` renamed to `ingressBwpEnvelope`
    - `ingressBandwidthProfileEnvelope` - changed ref type from
      `IpUniIngressBwpEnvelope` to `IpUniAccessLinkIngressBwpEnvelope`
    - `identifier` - added
  - `IpUniAccessLinkEgressBwpEnvelope`
  - `IpUniAccessLinkIngressBwpEnvelope`
  - `IpUniAccessLinkEgressBwpIpvcEp`
  - `IpUniAccessLinkEgressBwpIpvcEpCos`
  - `IpUniAccessLinkIngressBwpIpvcEp`
  - `IpUniAccessLinkIngressBwpIpvcEpCos`
  - `IpUniCommon`
  - `Ipv4Address` - applied as ref to every string field for Ipv4 Address
  - `Ipv6Address` - applied as ref to every string field for Ipv6 Address
  - `Ipv4OrIpv6Address`
  - `Ipv4OrIpv6Prefix`
    - `Ipv4AddressingType`
  - `Ipv6AddressingType`
  - `Ipv4ConnectionAddressing`
  - `Ipv6ConnectionAddressing`
  - `IpUniAccessLinkEgressBwpEnvelope` and `IpUniAccessLinkIngressBwpEnvelope` -
    merged to `IpUniAccessLinkBwpEnvelope`
  - `IpUniAccessLinkEgressBwpIpvcEp` and `IpUniAccessLinkIngressBwpIpvcEp` -
    merged to `IpUniAccessLinkBwpIpvcEp`
  - `IpUniAccessLinkEgressBwpIpvcEpCos` - renamed to
    `IpUniAccessLinkBwpIpvcEpCos`
  - `LacpVersion`
  - `PeeringAddressType`
  - `PortMap`
  - `UniAccessLinkEthernetLinkAggregation`
  - `UniAccessLinkTrunkType`
  - `SubscriberAndSpLoopbackAddresses`
  - `VlanId`
  - `UniIpv4ConnectionAddressing`
    - `uniAccessLinkIpv4AddressType` - renamed to `ipv4AddressingType`
    - `ipv4PrimarySubnet` - changed ref type to `Ipv4PrimarySubnet`
  - `UniIpv6ConnectionAddressing`
    - `uniAccessLinkIpv6AddressType` - renamed to `ipv6AddressingType`
    - `subscriberIpv6Address` - changed to ref type `Ipv6Address`
  - `IpvcEndPointIdentifier`
  - `Ipv4PrimarySubnet`
  - `IpUniAccessLinkIdentifier`
  - `IpBwpFlowPerIpvcEp`
  - `IpBwpFlowPerIpvcEpCosName`
  - `IpUniBwpEnvelope`
    - `ipUniEgressBwpAccessLink` - renamed to `bwpFlowPerAccessLink`
    - `ipUniEgressBwpIpvcEp` - renamed to `bwpFlowPerIpvcEp`
    - `ipUniEgressBwpIpvcEpAccessLink` - renamed to `bwpFlowPerIpvcEpAccessLink`
    - `ipUniEgressBwpIpvcEpCos` - renamed to `bwpFlowPerIpvcEpAndCosName`
    - `ipUniEgressBwpIpvcEpCosAccessLink` - renamed to
      `bwpFlowPerAccessLinkIpvcEpAndCosName`
    - `ipUniEgressBwpUni` - renamed to `bwpFlowAll`
  - `SubscriberPrefixList`
- Removed types:
  - `AddressFamilyIpv4Ipv6Both` - split to:
    - `AddressFamilyIpv4Ipv6`
    - `AddressFamilyIpv4Ipv6Both`
  - `BfdTransmissionInterval`
  - `BgpAuthentication`
  - `BgpCommunityListItem`
  - `DhcpServer`
  - `HeaderFieldTypes`
  - `Ipv4Ipv6Prefixes` - replaced by using `Ipv4OrIpv6Prefix` as a list
  - `PacketDelivery` - not needed as having only one usable value.
  - `RouteDistinguisherFields`
  - `IpUniAccessLinkIngressBwp` - replaced with `IpBwpFlowAll`
  - `IpUniAccessLinkEgressBwp` - replaced with `IpBwpFlowAll`
  - `IpvcEpIngressBwpAll` - replaced with `IpBwpFlowAll`
  - `IpvcEpEgressBwpAll` - replaced with `IpBwpFlowAll`
  - `IpUniEgressBwpUni` - replaced with `IpBwpFlowAll`
  - `IpUniIngressBwpUni` - replaced with `IpBwpFlowAll`
  - `IpUniAccessLinkBwpIpvcEp` - replaced with `IpBwpFlowPerIpvcEp`
  - `IpUniAccessLinkBwpIpvcEpCos` - replaced with `IpBwpFlowPerIpvcEpCosName`
  - `IpUniIngressBwpAccessLink` - replaced with `IpBwpFlowPerAccessLink`
  - `IpUniIngressBwpIpvcEp` - replaced with `IpBwpFlowPerIpvcEp`
  - `IpUniIngressBwpIpvcEpAccessLink` - replaced with
    `IpBwpFlowPerIpvcEpAccessLink`
  - `IpUniIngressBwpIpvcEpCos` - replaced with `IpBwpFlowPerIpvcEpAndCosName`
  - `IpUniIngressBwpIpvcEpCosAccessLink` - replaced with
    `IpBwpFlowPerAccessLinkIpvcEpAndCosName`
  - `IpUniEgressBwpAccessLink` - replaced with `IpBwpFlowPerAccessLink`
  - `IpUniEgressBwpIpvcEp` - replaced with `IpBwpFlowPerIpvcEp`
  - `IpUniEgressBwpIpvcEpAccessLink` - replaced with
    `IpBwpFlowPerIpvcEpAccessLink`
  - `IpUniEgressBwpIpvcEpCos` - replaced with `IpBwpFlowPerIpvcEpAndCosName`
  - `IpUniEgressBwpIpvcEpCosAccessLink` - replaced with
    `IpBwpFlowPerAccessLinkIpvcEpAndCosName`
  - `IpvcEpIngressBwp`- replaced with `IpBwpFlowPerCosName`
  - `IpvcEpEgressBwp`- replaced with `IpBwpFlowPerCosName`
  - `IpUniAccessLinkEgressIpvcBwpEpCos`
  - `PcpMapping`

**internetAccessCommon.yaml:**

- `BasicIaIpUni` - added
- `IaIpvcCloud` - added
  - `subscriberPrefixList` - changed type from `Ipv4Ipv6Prefixes` to
    `SubscriberPrefixList`
  - `ingressClassOfServiceMap` - removed
- `IaIpvcCommon`:
  - `maximumTransmitUnit` - renamed to `mtu`
  - `maximumNumberOfIpv4Routes` - marked as nullable
  - `maximumNumberOfIpv6Routes` - marked as nullable
  - `reservedPrefixes` - changed type from `Ipv4Ipv6Prefixes` to list of
    `Ipv4OrIpv6Prefix`
- `AdvancedIaIpvcCloud` and `AdvancedIaIpvcCloud` - merged to `IaIpvcCloud`
  - `dataLimit` - marked as nullable
- `BasicIaBwpEnvelope` - added to replace all Envelopes and Bw profiles for
  Basic Internet Access cases.
- `IaIpvcEndPointCommon`
  - added as an abstract class for `BasicIaIpvcEndPoint` and
    `AdvancedIaIpvcEndPoint`, gathering their common attributes
  - removed `allOf` pointing to `SlsReferencePoint`
  - `maximumNumberOfIpv4Routes` - marked as nullable
  - `maximumNumberOfIpv6Routes` - marked as nullable
  - `egressClassOfServiceMap` - marked as nullable
  - `ingressClassOfServiceMap` - removed
- `IaIngressClassOfServiceMap` - removed
- `IaIpSls` - moved to `ipSls.yaml` and renamed to `IpSls`

**advancedIaIpvc.yaml:** - renamed to `advancedInternetAccessIpvc.yaml`

- `AdvancedIaIpvc`
  - `maximumNumberOfIpv4Routes` - added minimum: 0
  - `maximumNumberOfIpv6Routes` - added minimum: 0
  - `advancedIaIpvcEndPoint` - renamed to `ipvcEndPoint`, marked as required
  - `serviceLevelSpecification` - marked as nullable
  - `packetDelivery` - removed
- `AdvancedIaIpvcEndPoint`
  - `maximumNumberOfIpv4Routes` - added minimum: 0
  - `maximumNumberOfIpv6Routes` - added minimum: 0
  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
  - `prefixMapping` - changed type from `Ipv4Ipv6Prefixes` to list of
    `Ipv4OrIpv6Prefix`

**advancedIaUni.yaml:**

renamed to `ipUni.yaml`

- `AdvancedIaUni` - renamed to `IpUni`
  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
  - `ipv4ConnectionAddressing` - marked as nullable
  - `ipv6ConnectionAddressing` - marked as nullable

**ipUniAccessLink.yaml**

renamed to `ipUni.yaml`

- `AdvancedIaUniAccessLink` - renamed to `IpUniAccessLink`
  - `connectionType` - added
  - `l2Technology` - added
- `IpUni`:

  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
  - `ipv4ConnectionAddressing` - changed ref type to
    `UniIpv4ConnectionAddressing`
  - `ipv6ConnectionAddressing` - changed ref type to
    `UniIpv6ConnectionAddressing`

- Removed types:
  - `AdvancedIaUniIpv4ConnectionAddressing` - replaced with
    `UniIpv4ConnectionAddressing`
  - `AdvancedIaUniIpv6ConnectionAddressing` - replaced with
    `UniIpv6ConnectionAddressing`

**basicIaIpvc.yaml:**

renamed to `basicInternetAccess.yaml`

- `BasicInternetAccess` - added
- `BasicIaIpvc`
  - `maximumNumberOfIpv4Routes` - added minimum: 0
  - `maximumNumberOfIpv6Routes` - added minimum: 0
  - `basicIaIpvcEndPoint` - renamed to `ipvcEndPoint`, marked as required
  - `serviceLevelSpecification` - added, marked as nullable
- `BasicIaIpvcEndPoint`
  - `maximumNumberOfIpv4Routes` - added minimum: 0
  - `maximumNumberOfIpv6Routes` - added minimum: 0
  - `ipUni` - moved to `BasicInternetAccess`
  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
- `BasicIaUni`
  - `ipUniAccessLink` - moved to `BasicInternetAccess`
  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
- `BasicIaUniAccessLink` - renamed to `BasicIaIpUniAccessLink`, moved to
  `internetAccessCommon.yaml`
  - `egressBandwidthProfileEnvelope` - marked as nullable
  - `ingressBandwidthProfileEnvelope` - marked as nullable
  - `ipv4ConnectionAddressing` - marked as nullable
  - `ipv6ConnectionAddressing` - marked as nullable
  - `l2Technology` - added
  - `connectionType` - added

**ethernetUniAccessLinkTrunk.yaml** - added

- `EthernetUniAccessLinkTrunk` - added to implement MEF 61.1.1

**ipSls.yaml**

- `IpSls` - added
  - `meanTimeToRepair` - added
  - `locationList` - added
- `Location` - added
- `MeanTimeToRepair` - added

## Release Dolly:

The first release of this Product Schema.
