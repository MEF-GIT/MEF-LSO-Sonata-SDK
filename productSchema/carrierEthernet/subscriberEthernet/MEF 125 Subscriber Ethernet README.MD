# Subscriber Ethernet Products: Release notes

## Release Fergie:

**Readiness status**: MEF Published Standard

No changes.


## Release Ella:

| Rev # |    Date    |                                  File/Class/Property                                   | Description                                                                                           |
| :---: | :--------: | :------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------- |
|  396  | 2022-10-13 |      carrierEthernetEvcCommon.yaml / CarrierEthernetEvcCommon / availableMegLevel      | Changed referenced class from AvailableMegList to AvailableMegLevel                                   |
|  394  | 2022-10-13 |                   carrierEthernetEnums.yaml / AvailableMegList / ---                   | Changed name from AvailableMegList to AvailableMegLevel                                               |
|  393  | 2022-10-13 |     carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / subscriberMegMip      | Changed referenced class from MegList to MegLevel                                                     |
|  391  | 2022-10-13 |                       carrierEthernetEnums.yaml / MegList / ---                        | Changed name from MegList to MegLevel                                                                 |
|  390  | 2022-10-13 |                   carrierEthernetEnums.yaml / MegList / megListEnum                    | Changed name to megLevelEnum                                                                          |
|  389  | 2022-10-13 |              carrierEthernetSubscriberUni.yaml / SubscriberUni / linkOAM               | Changed JSON name from linkOAM to linkOam                                                             |
|  388  | 2022-09-08 |                   carrierEthernetEvcVirtualPrivate.yaml / --- / ---                    | Name changed from carrierEthernetVpEvcCommon                                                          |
|  387  | 2022-09-06 |                                    --- / --- / ---                                     | Organized schema files into subscriberEthernet and operatorEthernet subfolders                        |
|  381  | 2022-08-09 |             carrierEthernetUtilityClasses.yaml / DataSize / dataSizeUnits              | Changed explicit enum to reference to common enum file                                                |
|  380  | 2022-08-09 |             carrierEthernetUtilityClasses.yaml / InformationRate / irUnits             | Changed explicit enum to reference to common enum file                                                |
|  379  | 2022-08-09 |                         carrierEthernetTypes.yaml / --- / ---                          | Changed carrierEthernetTypes.yaml to carrierEtherenetEnums                                            |
|  378  | 2022-08-09 |                                    --- / --- / ---                                     | Changed name of /evcSuperClasses to /evcProductComponents                                             |
|  376  | 2022-08-09 |                                    --- / --- / ---                                     | Changed URN versions to 1.0.0 for Subscriber Ethernet schemas                                         |
|  374  | 2022-07-26 | carrierEthernetExternalInterfaces.yaml / CarrierEthernetPhysicalLink / autoNegotiation | Moved this from the CarrierEthernetPhysicalLink class to the UNISpecifAttributes class                |
|  373  | 2022-07-21 |                         evcExternalInterfaces.yaml / --- / ---                         | Moved evcExternalInterfaces.yaml into /subscriberEthernetCommon                                       |
|  372  | 2022-07-21 |                             evcEgressMaps.yaml / --- / ---                             | Moved evcEgressMaps.yaml into /subscriberEthernetCommon                                               |
|  371  | 2022-07-21 |                            evcEndPointMaps.yaml / --- / ---                            | Moved evcEndPointMaps.yaml into /subscriberEthernetCommon                                             |
|  368  | 2022-07-21 |                                    --- / --- / ---                                     | Added new folder "subscriberEthernetCommon"                                                           |
|  366  | 2022-07-21 |                                    --- / --- / ---                                     | Renamed "common" folder to "carrierEthernetCommon"                                                    |
|  364  | 2022-07-14 |                carrierEthernetSubscriberUni.yaml / SubscriberUni / ---                 | All properties have been moved from SubscriberUNICommon into SubscriberUNI                            |
|  363  | 2022-07-14 |          carrierEthernetSubscriberUniCommon.yaml / SubscriberUniCommon / ---           | Moved all properties from SubscriberUniCommon to SubscriberUNI (and removed SubscriberUNICommon file) |
|  362  | 2022-06-28 | carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / ingressClassOfServiceMap  | Changed object references to new Class names "CosName..."                                             |
|  359  | 2022-06-28 |                 carrierEthernetClassOfService.yaml / CosFromDscp / ---                 | Changed Class name to CosNameFromDscp                                                                 |
|  358  | 2022-06-28 |               carrierEthernetClassOfService.yaml / CosFromCtagPcp / ---                | Changed Class name to CosNameFromCtagPcp                                                              |
|  357  | 2022-06-28 |               carrierEthernetClassOfService.yaml / CosFromStagPcp / ---                | Changed Class name to CosNameFromStagPcp                                                              |
|  356  | 2022-06-28 |                  carrierEthernetClassOfService.yaml / CosFromEp / ---                  | Changed Class name to CosNameFromEp                                                                   |
|  355  | 2022-06-27 |        carrierEthernetEvcEpEline.yaml / CarrierEthernetEvcEpEline / identifier         | Fixed type in property name "indentifier" → "identifier"                                              |
|  352  | 2022-06-21 |                   evcExternalInterfaces.yaml / VirtualFrameMap / ---                   | Moved this clas into the new evcExternalInterfaces                                                    |
|  351  | 2022-06-21 |                         evcExternalInterfaces.yaml / --- / ---                         | New schema file evcExternalInterfaces                                                                 |
|  350  | 2022-06-21 |                      evcEndPointMaps.yaml / EvcEndPointMap / ---                       | Moved this class into the new evcEndPointMaps.yaml                                                    |
|  349  | 2022-06-21 |                            evcEndPointMaps.yaml / --- / ---                            | New schema file evcEndPointMaps                                                                       |
|  347  | 2022-06-21 |                      evcEgressMaps.yaml / EvcEgressMapEntry / ---                      | Moved this class into the new evcEgressMaps.yaml                                                      |
|  346  | 2022-06-21 |                        evcEgressMaps.yaml / EvcEgressMap / ---                         | Moved this class into the new evcEgressMaps.yaml                                                      |
|  345  | 2022-06-21 |                             evcEgressMaps.yaml / --- / ---                             | New schema file evcEgressMaps                                                                         |

## Release Dolly:

| Rev # |    Date    |                                      File/Class/Property                                      | Description                                                                                 |
| :---: | :--------: | :-------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------ |
|  343  | 2022-06-01 |               ethernetVirtualPrivateLineEvc.yaml / EvplEvcEndPoint / evplEvcEp                | Added reference to new EVC EP Eline Class                                                   |
|  342  | 2022-06-01 |                    ethernetPrivateLineEvc.yaml / EplEvcEndPoint / eplEvcEp                    | Added reference to new EVC EP Eline Class                                                   |
|  341  | 2022-06-01 |               carrierEthernetEvcEpEline.yaml / CarrierEthernetEvcEpEline / ---                | Added new property - identifier                                                             |
|  340  | 2022-06-01 |                          carrierEthernetEvcEpEline.yaml / --- / ---                           | Added new EVC Superclass File containing CarrierEthernetEvcEpEline Class                    |
|  339  | 2022-05-30 |    carrierEthernetBandwidthProfile.yaml / BandwidthProfilePerClassOfServiceName / bwpFlow     | Changed this from a List of 0...1 to a simple reference to a Bandwidth Profile              |
|  338  | 2022-05-27 |                            ethernetPrivateLineEvc.yaml / --- / ---                            | Set URN version for all Subscriber Ethernet Products to 0.3.0                               |
|  336  | 2022-05-27 |  carrierEthernetEvcEpVirtualPrivate.yaml / CarrierEthernetEvcEpNotEpl / evcEndPointEnvelopes  | Moved from the CarrierEthernetEvcEpNotEpl class to CarrierEthernetEvcEpVirtualPrivate class |
|  335  | 2022-05-24 |                  ethernetVirtualPrivateLineEvc.yaml / EvplEvc / evcEndPointZ                  | This Attribute has been marked "Required"                                                   |
|  334  | 2022-05-24 |                  ethernetVirtualPrivateLineEvc.yaml / EvplEvc / evcEndPointA                  | This Attribute has been marked "Required"                                                   |
|  333  | 2022-05-24 |                      ethernetPrivateLineEvc.yaml / EplEvc / evcEndPointZ                      | This Attribute has been marked "Required"                                                   |
|  332  | 2022-05-24 |                      ethernetPrivateLineEvc.yaml / EplEvc / evcEndPointA                      | This Attribute has been marked "Required"                                                   |
|  329  | 2022-03-23 |             carrierEthernetUtilityClasses.yaml / SourceMacAddressLimit / interval             | Changed reference to ShortDuration to TimeDuration                                          |
|  328  | 2022-03-23 |                   carrierEthernetServiceLevelSpecification.yaml / --- / ---                   | Changed all references to ShortDuration and LongDuration to TimeDuration                    |
|  327  | 2022-03-23 |            carrierEthernetUtilityClasses.yaml / ShortDuration, LongDuration / ---             | Removed classes ShortDuration and LongDuration and created combined TimeDuration            |
|  326  | 2022-02-18 |    carrierEthernetExternalInterfaces.yaml / CarrierEthernetPhysicalLink / autoNegotiation     | Added new Auto Negotation physical link property                                            |
|  325  | 2022-02-14 |        carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / startTime         | Change reference to class Time to a formatted string                                        |
|  323  | 2022-02-14 |                        carrierEthernetUtilityClasses.yaml / Time / ---                        | Removed this Class.                                                                         |
|  322  | 2022-02-14 |       carrierEthernetExternalInterfaces.yaml / UniSpecificAttributes / uniConnectorType       | Removed FC and D4 from the list of connectors                                               |
|  321  | 2022-02-04 | carrierEthernetEvcEpVirtualPrivate.yaml / CarrierEthernetEvcEpVirtualPrivate / evcEndPointMap | Changed reference to EvcEndPointMap (see edit 320)                                          |
|  320  | 2022-02-04 |                    carrierEthernetEndPointMaps.yaml / EvcEndPointMap / ---                    | Changed class EndPointMapEvc to EvcEndPointMap                                              |

## Release Celine:

| Rev # |    Date    |                                            File/Class/Property                                             | Description                                                                                          |
| :---: | :--------: | :--------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------- |
|  315  | 2022-01-09 |                   carrierEthernetColorIdentifier.yaml / ColorFromPCPMapEntry / pcpValue                    | Changed this from enum to type reference                                                             |
|  313  | 2022-01-09 |                            carrierEthernetTypes.yaml / PcpValue / pcpValueEnum                             | Created PCP Value type from PCPonly Enum                                                             |
|  312  | 2022-01-09 |                    carrierEthernetTypes.yaml / AvailableMegList / availableMegListEnum                     | Created AvailableMeg type from MEGAvail enum                                                         |
|  311  | 2022-01-09 |                carrierEthernetEvcCommon.yaml / CarrierEthernetEvcCommon / availableMegLevel                | Changed this from enum to type reference                                                             |
|  308  | 2022-01-09 |               carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / subscriberMegMip                | Changed this from enum to type reference                                                             |
|  307  | 2022-01-09 |                             carrierEthernetTypes.yaml / MegList / megListEnum                              | Created MegList type form MEG Enum                                                                   |
|  306  | 2022-01-09 |               carrierEthernetSubscriberUniCommon.yaml / SubscriberUniCommon / l2cpAddressSet               | Changed this from enum to type reference                                                             |
|  303  | 2022-01-09 |                              carrierEthernetTypes.yaml / L2cpAddressSet / ---                              | Created L2cpAddressSet type for L2CPAS Enum                                                          |
|  302  | 2022-01-08 |                    carrierEthernetColorIdentifier.yaml / ColorFromDscpEntry / ipv6Color                    | Changed this from enum to type reference                                                             |
|  301  | 2022-01-08 |                    carrierEthernetColorIdentifier.yaml / ColorFromDscpEntry / ipv4Color                    | Changed this from enum to type reference                                                             |
|  300  | 2022-01-08 |                        carrierEthernetColorIdentifier.yaml / ColorFromEp / epColor                         | Changed this from enum to type reference                                                             |
|  299  | 2022-01-08 |                   carrierEthernetColorIdentifier.yaml / ColorFromPCPMapEntry / pcpColor                    | Changed this from enum to type reference                                                             |
|  298  | 2022-01-08 |                                carrierEthernetTypes.yaml / FrameColor / ---                                | Created FrameColor type for Color enum                                                               |
|  297  | 2022-01-07 |                                    carrierEthernetTypes.yaml / \* / ---                                    | Moved all "types" from utilityClassesAndTypes.yaml to CarrierEthernetTypes.yaml                      |
|  296  | 2022-01-07 |                               carrierEthernetUtilityClasses.yaml / \* / ---                                | Changed name of schema file from utilityClassesAndTypes.yaml to carrierEthernetUtilityClasses.yaml   |
|  295  | 2022-01-07 |              carrierEthernetSubscriberUniCommon.yaml / SubscriberUniCommon / linkAggregation               | Changed explicit enum to type reference                                                              |
|  292  | 2022-01-04 |                                               \* / --- / ---                                               | Global change: All properties for all classes are now optional. None are required                    |
|  291  | 2021-11-04 |    carrierEthernetServiceLevelSpecification.yaml / OneWayFrameDelayRangePmMetric / oneWayFdrPercentile     | Fixed property name oneWayFdrPecentile oneWayFdrPercentile (fixed in earlier edit but not recorded)  |
|  290  | 2021-10-19 |                 carrierEthernetExternalInterfaces.yaml / UniPhysicalLink / uniPhysicalLink                 | Changed reference from UniSpecifcAttributes to UniSpecificAttributes                                 |
|  289  | 2021-10-19 |                         carrierEthernetClassOfService.yaml / CosFromDscp / l2cp_P                          | Changed usage from Optional to Required                                                              |
|  288  | 2021-10-19 |                        carrierEthernetClassOfService.yaml / CosFromCtagPcp / l2cp_P                        | Changed usage from Optional to Required                                                              |
|  287  | 2021-10-19 |                        carrierEthernetClassOfService.yaml / CosFromStagPcp / l2cp_P                        | Changed usage from Optional to Required                                                              |
|  286  | 2021-10-19 |                          carrierEthernetClassOfService.yaml / CosFromEp / l2cp_P                           | Changed usage from Optional to Required                                                              |
|  285  | 2021-10-19 |                  carrierEthernetServiceLevelSpecification.yaml / SlsCosNameEntry / deltaT                  | Made this a minimum of 1                                                                             |
|  284  | 2021-10-12 |                    carrierEthernetExternalInterfaces.yaml / UniSpecificAttributes / ---                    | Fixed spelling error in JSON name (was UniSpecifcAttributes)                                         |
|  282  | 2021-09-29 |               carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / startTime               | Non-coding change: Time and date are UTC in the Time class                                           |
|  281  | 2021-09-27 |             carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / timeDuration              | Name of this property changed from timeInterval to timeDuration.                                     |
|  280  | 2021-09-27 |                      carrierEthernetClassOfService.yaml / CosDscpMapEntry / ipv6List                       | Usage changed from Optional to Required                                                              |
|  279  | 2021-09-27 |                      carrierEthernetClassOfService.yaml / CosDscpMapEntry / ipv4List                       | Usage changed from Optional to Required                                                              |
|  278  | 2021-09-27 |                        carrierEthernetClassOfService.yaml / DscpValues / dscpValues                        | Usage changed from Optional to Required                                                              |
|  277  | 2021-09-27 |           carrierEthernetBandwidthProfile.yaml / BandwidthProfilePerClassOfServiceName / bwpFlow           | Changed from a Bandwidth Profile to a list [0...1] of Bandwidth Profiles                             |
|  275  | 2021-09-27 |                                               \* / --- / ---                                               | Changed all properties that were single $ref to remove type:object                                   |
|  274  | 2021-09-24 |                 carrierEthernetSubscriberUniCommon.yaml / SubscriberUniCommon / envelopes                  | Usage changed from OOOR to OORR                                                                      |
|  273  | 2021-09-24 |              carrierEthernetSubscriberUniCommon.yaml / SubscriberUniCommon / virtualFrameMap               | Usage changed from OOOO to OORR                                                                      |
|  272  | 2021-09-24 |            carrierEthernetEvcEpNotEpl.yaml / CarrierEthernetEvcEpNotEpl / sourceAddressMacLimit            | Changed to a list [0 ... 1] and usage changed from OOOO to OORR                                      |
|  271  | 2021-09-24 | carrierEthernetEvcEpNotEpl.yaml / CarrierEthernetEvcEpNotEpl / egressBandwidthProfilePerClassofServiceName | Changed to a list [0 ... 1] and usage changed from OOOO to OORR                                      |
|  270  | 2021-09-24 |                   carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / egressMap                   | Changed to a list [0 ... 1] and usage changed from OOOO to OORR                                      |
|  269  | 2021-09-24 | carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / ingressBandwidthProfilePerClassofServiceName  | This was supposed to be coded as an array. It wasn't.                                                |
|  268  | 2021-09-23 |            carrierEthernetEvcEpNotEpl.yaml / CarrierEthernetEvcEpNotEpl / evcEndPointEnvelopes             | New Service Attribute to potentially avoid a Change to the EVC when a new UNI is added               |
|  267  | 2021-09-23 |                     carrierEthernetEvcEpNotEpl.yaml / CarrierEthernetEvcEpNotEpl / ---                     | Added new property - EVC End Point Envelopes Service Attribute                                       |
|  266  | 2021-09-23 |                  ethernetVirtualPrivateTreeEvcEp.yaml / EvptreeEvcEndPoint / eptreeEvcEp                   | Removed reference to CarrierEthernetEvcEpNotEpl, the EP role is now a Relationship                   |
|  265  | 2021-09-23 |                      ethernetPrivateTreeEvcEp.yaml / EptreeEvcEndPoint / eptreeEvcEp                       | Removed reference to CarrierEthernetEvcEpEtree, the EP role is now a Relationship                    |
|  258  | 2021-09-07 |                         carrierEthernetClassOfService.yaml / CosFromDscp / l2cp_P                          | This should be a list of [0...\* ] L2CP entries rather than a single entry                           |
|  257  | 2021-09-07 |                        carrierEthernetClassOfService.yaml / CosFromStagPcp / l2cp_P                        | This should be a list of [0...\* ] L2CP entries rather than a single entry                           |
|  256  | 2021-09-07 |                        carrierEthernetClassOfService.yaml / CosFromCtagPcp / l2cp_P                        | This should be a list of [0...\* ] L2CP entries rather than a single entry                           |
|  255  | 2021-09-07 |                          carrierEthernetClassOfService.yaml / CosFromEp / l2cp_P                           | This should be a list of [0...\* ] L2CP entries rather than a single entry                           |
|  254  | 2021-09-07 |                              ovcsuperclasses/_ and evcsuperclasses/_ / / ---                               | In all ovcsuperclasses and evcsuperclasses $refs to classes in the common folder were incorrect      |
|  253  | 2021-09-06 |    carrierEthernetServiceLevelSpecification.yaml / OneWayFrameDelayRangePmMetric / oneWayFdrPercentile     | JSON name was spelled incorrectly, was oneWayFdrPecentile                                            |
|  246  | 2021-09-03 |                                                / --- / ---                                                 | Remove revision 244 and return URNs to original format                                               |
|  244  | 2021-09-02 |                                                / --- / ---                                                 | URNs have changed. Product IDs with dashes are now lowerCamelCase (e.g. access-eline to accessEline) |
|  243  | 2021-09-02 |                         carrierEthernetColorIdentifier.yaml / ColorFromDscp / ---                          | Change Class Name from ColorFromDSCP to ColorFromDscp                                                |
|  240  | 2021-09-01 |                               ethernetVirtualPrivateTreeEvc.yaml / --- / ---                               | Remove array of EVC EPs (moved to separate order item)                                               |
|  239  | 2021-09-01 |                              ethernetVirtualPrivateTreeEvcEp.yaml / --- / ---                              | Move VPTREE EPs into this separate (new) source file                                                 |
|  238  | 2021-09-01 |                                  ethernetPrivateTreeEvc.yaml / --- / ---                                   | Remove array of EVC EPs (moved to separate order item)                                               |
|  237  | 2021-09-01 |                                 ethernetPrivateTreeEvcEp.yaml / --- / ---                                  | Move EPTREE EPs into this separate (new) source file                                                 |
|  236  | 2021-09-01 |                              ethernetVirtualPrivateLanEvcEp.yaml / --- / ---                               | Remove array of EVC EPs (moved to separate order item)                                               |
|  235  | 2021-09-01 |                                  ethernetPrivateTreeEvc.yaml / --- / ---                                   | Move EVPLAN EPs into this separate (new) source file                                                 |
|  234  | 2021-09-01 |                                  ethernetPrivateLanEvcEp.yaml / --- / ---                                  | Remove array of EVC EPs (moved to separate order item)                                               |
|  233  | 2021-09-01 |                                  ethernetPrivateLanEvcEp.yaml / --- / ---                                  | Move EPLAN EPs into this separate (new) source file                                                  |
|  232  | 2021-09-01 |                      carrierEthernetEvcCommon.yaml / CarrierEthernetEvcEpCommon / ---                      | Delete property: UNI                                                                                 |
|  231  | 2021-09-01 |                                 ethernetPrivateLineEvc.yaml / EplEvc / ---                                 | Change evcEndpoints[2] to evcEndPointA and evcEndPointZ                                              |
