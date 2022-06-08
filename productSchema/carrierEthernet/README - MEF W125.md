 Rev # | Date | File/Class/Property | Standard | Description |
| :-:   | :-:  | :-:  | :-: | :------------------------- |
| 343 | 2022-06-01 | ethernetVirtualPrivateLineEvc.yaml / EvplEvcEndPoint / evplEvcEp | 125 | Added reference to new EVC EP Eline Class |
| 342 | 2022-06-01 | ethernetPrivateLineEvc.yaml / EplEvcEndPoint / eplEvcEp | 125 | Added reference to new EVC EP Eline Class |
| 341 | 2022-06-01 | carrierEthernetEvcEpEline.yaml / CarrierEthernetEvcEpEline / --- | 125 | Added new property - identifier |
| 340 | 2022-06-01 | carrierEthernetEvcEpEline.yaml / --- / --- | 125 | Added new EVC Superclass File containing CarrierEthernetEvcEpEline Class |
| 339 | 2022-05-30 | carrierEthernetBandwidthProfile.yaml / BandwidthProfilePerClassOfServiceName / bwpFlow | 106, 125 | Changed this from a List of 0...1 to a simple reference to a Bandwidth Profile |
| 338 | 2022-05-27 | ethernetPrivateLineEvc.yaml / --- / --- | 125 | Set URN version for all Subscriber Ethernet Products to 0.3.0 |
| 336 | 2022-05-27 | carrierEthernetEvcEpVirtualPrivate.yaml / CarrierEthernetEvcEpNotEpl / evcEndPointEnvelopes | 125 | Moved from the CarrierEthernetEvcEpNotEpl class to CarrierEthernetEvcEpVirtualPrivate class |
| 335 | 2022-05-24 | ethernetVirtualPrivateLineEvc.yaml / EvplEvc / evcEndPointZ | 125 | This Attribute has been marked "Required" |
| 334 | 2022-05-24 | ethernetVirtualPrivateLineEvc.yaml / EvplEvc / evcEndPointA | 125 | This Attribute has been marked "Required" |
| 333 | 2022-05-24 | ethernetPrivateLineEvc.yaml / EplEvc / evcEndPointZ | 125 | This Attribute has been marked "Required" |
| 332 | 2022-05-24 | ethernetPrivateLineEvc.yaml / EplEvc / evcEndPointA | 125 | This Attribute has been marked "Required" |
| 329 | 2022-03-23 | carrierEthernetUtilityClasses.yaml / SourceMacAddressLimit / interval | 106, 125 | Changed reference to ShortDuration to TimeDuration |
| 328 | 2022-03-23 | carrierEthernetServiceLevelSpecification.yaml / --- / --- | 106, 125 | Changed all references to ShortDuration and LongDuration to TimeDuration |
| 327 | 2022-03-23 | carrierEthernetUtilityClasses.yaml / ShortDuration, LongDuration / --- | 106, 125 | Removed classes ShortDuration and LongDuration and created combined TimeDuration |
| 326 | 2022-02-18 | carrierEthernetExternalInterfaces.yaml / CarrierEthernetPhysicalLink / autoNegotiation | 106, 125 | Added new Auto Negotation physical link property |
| 325 | 2022-02-14 | carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / startTime | 106, 125 | Change reference to class Time to a formatted string |
| 324 | 2022-02-14 |  /  /  |  | changed deleted |
| 323 | 2022-02-14 | carrierEthernetUtilityClasses.yaml / Time / --- | 106, 125 | Removed this Class. |
| 322 | 2022-02-14 | carrierEthernetExternalInterfaces.yaml / UniSpecificAttributes / uniConnectorType | 106, 125 | Removed FC and D4 from the list of connectors |
| 321 | 2022-02-04 | carrierEthernetEvcEpVirtualPrivate.yaml / CarrierEthernetEvcEpVirtualPrivate / evcEndPointMap | 125 | Changed reference to EvcEndPointMap (see edit 320) |
| 320 | 2022-02-04 | carrierEthernetEndPointMaps.yaml / EvcEndPointMap / --- | 125 | Changed class EndPointMapEvc to EvcEndPointMap |