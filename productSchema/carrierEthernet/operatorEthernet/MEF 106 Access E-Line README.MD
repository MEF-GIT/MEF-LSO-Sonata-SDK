# Access E-Line Product: Release notes

## Release Fergie:

**Readiness status**: MEF Published Standard

No changes.


## Release Ella:

| Rev # |    Date    |                                   File/Class/Property                                   | Description                                                                                     |
| :---: | :--------: | :-------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------- |
|  395  | 2022-10-13 |          accessElineOvcCommon.yaml / AccessElineOvcCommon / availableMegLevel           | Changed referenced class from AvailableMegList to AvailableMegLevel                             |
|  394  | 2022-10-13 |                   carrierEthernetEnums.yaml / AvailableMegList / ---                    | Changed name from AvailableMegList to AvailableMegLevel                                         |
|  392  | 2022-10-13 |   accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / maintenanceIntermediatePoint   | Changed referenced class from MegList to MegLevel                                               |
|  391  | 2022-10-13 |                        carrierEthernetEnums.yaml / MegList / ---                        | Changed name from MegList to MegLevel                                                           |
|  390  | 2022-10-13 |                    carrierEthernetEnums.yaml / MegList / megListEnum                    | Changed name to megLevelEnum                                                                    |
|  387  | 2022-09-06 |                                     --- / --- / ---                                     | Organized schema files into subscriberEthernet and operatorEthernet subfolders                  |
|  386  | 2022-08-23 |                    ovcClassOfService.yaml / CosStagPcpMapEntry / ---                    | Moved from carrierEthernetClassOfService.yaml to ovcClassOfService.yaml                         |
|  385  | 2022-08-23 |                    ovcClassOfService.yaml / CosNameFromStagPcp / ---                    | Moved from carrierEthernetClassOfService.yaml to ovcClassOfService.yaml                         |
|  384  | 2022-08-23 |                           ovcClassOfService.yaml / --- / ---                            | New Schema file ovcClassOfService.yaml                                                          |
|  383  | 2022-08-22 |                   ovcExternalInterfaces.yaml / EnniPhysicalLink / ---                   | Class moved from CarrierEthernetExternalInterfaces to ovcExternalInterfaces.yaml                |
|  382  | 2022-08-22 |                         ovcExternalInterfaces.yaml / --- / ---                          | New schema file ovcExternalInterfaces.yaml                                                      |
|  381  | 2022-08-09 |              carrierEthernetUtilityClasses.yaml / DataSize / dataSizeUnits              | Changed explicit enum to reference to common enum file                                          |
|  380  | 2022-08-09 |             carrierEthernetUtilityClasses.yaml / InformationRate / irUnits              | Changed explicit enum to reference to common enum file                                          |
|  379  | 2022-08-09 |                          carrierEthernetTypes.yaml / --- / ---                          | Changed carrierEthernetTypes.yaml to carrierEtherenetEnums                                      |
|  377  | 2022-08-09 |                                     --- / --- / ---                                     | Changed name of /ovcSuperClasses to /ovcProductComponents                                       |
|  375  | 2022-08-09 |                                     --- / --- / ---                                     | Changed URN versions to 5.0.0 for Access E-Line schemas                                         |
|  374  | 2022-07-26 | carrierEthernetExternalInterfaces.yaml / CarrierEthernetPhysicalLink / autoNegotiation  | Moved this from the CarrierEthernetPhysicalLink class to the UNISpecifAttributes class          |
|  370  | 2022-07-21 |                             ovcEgressMaps.yaml / --- / ---                              | Moved ovcEgressMaps.yaml into /operatorEthernetCommon                                           |
|  369  | 2022-07-21 |                            ovcEndPointMaps.yaml / --- / ---                             | Moved ovcEndPointMaps.yaml into /operatorEthernetCommon                                         |
|  367  | 2022-07-21 |                                     --- / --- / ---                                     | Added new folder "operatorEthernetCommon"                                                       |
|  366  | 2022-07-21 |                                     --- / --- / ---                                     | Renamed "common" folder to "carrierEthernetCommon"                                              |
|  365  | 2022-07-14 |             carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / ---             | Moved all properties from OperatorUniCommon to OperatorUNI (and removed OperatorUNICommon file) |
|  361  | 2022-06-28 | accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / egressEquivalenceClassIdentifier | Changed object references to new Class names "CosName..."                                       |
|  360  | 2022-06-28 |     accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / ingressClassOfServiceMap     | Changed object references to new Class names "CosName..."                                       |
|  359  | 2022-06-28 |                 carrierEthernetClassOfService.yaml / CosFromDscp / ---                  | Changed Class name to CosNameFromDscp                                                           |
|  358  | 2022-06-28 |                carrierEthernetClassOfService.yaml / CosFromCtagPcp / ---                | Changed Class name to CosNameFromCtagPcp                                                        |
|  357  | 2022-06-28 |                carrierEthernetClassOfService.yaml / CosFromStagPcp / ---                | Changed Class name to CosNameFromStagPcp                                                        |
|  356  | 2022-06-28 |                  carrierEthernetClassOfService.yaml / CosFromEp / ---                   | Changed Class name to CosNameFromEp                                                             |
|  354  | 2022-06-27 |               carrierEthernetClassOfService.yaml / CosFromStagPcp / map_M               | Changed object reference to CosStagPcpMapEntry                                                  |
|  353  | 2022-06-27 |              carrierEthernetClassOfService.yaml / CosEnniPcpMapEntry / ---              | Change class name to CosStagPcpMapEntry                                                         |
|  348  | 2022-06-21 |                      carrierEthernetEndPointMaps.yaml / --- / ---                       | Rename this file to ovcEndPointMaps                                                             |
|  344  | 2022-06-21 |                       carrierEthernetEgressMaps.yaml / --- / ---                        | Renamed this file to ovcEgressMaps                                                              |

## Release Dolly:

| Rev # |    Date    |                                  File/Class/Property                                   | Description                                                                      |
| :---: | :--------: | :------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------- |
|  339  | 2022-05-30 | carrierEthernetBandwidthProfile.yaml / BandwidthProfilePerClassOfServiceName / bwpFlow | Changed this from a List of 0...1 to a simple reference to a Bandwidth Profile   |
|  337  | 2022-05-27 |                        ethernetPrivateLineEvc.yaml / --- / ---                         | Set URN version for all Access E-Line Products to 4.0.0                          |
|  331  | 2022-05-24 |                     accessElineOvc.yaml / AccessElineOvc / enniEp                      | This Attribute has been marked "Required"                                        |
|  330  | 2022-05-24 |                      accessElineOvc.yaml / AccessElineOvc / uniEp                      | This Attribute has been marked "Required"                                        |
|  329  | 2022-03-23 |         carrierEthernetUtilityClasses.yaml / SourceMacAddressLimit / interval          | Changed reference to ShortDuration to TimeDuration                               |
|  328  | 2022-03-23 |               carrierEthernetServiceLevelSpecification.yaml / --- / ---                | Changed all references to ShortDuration and LongDuration to TimeDuration         |
|  327  | 2022-03-23 |         carrierEthernetUtilityClasses.yaml / ShortDuration, LongDuration / ---         | Removed classes ShortDuration and LongDuration and created combined TimeDuration |
|  326  | 2022-02-18 | carrierEthernetExternalInterfaces.yaml / CarrierEthernetPhysicalLink / autoNegotiation | Added new Auto Negotation physical link property                                 |
|  325  | 2022-02-14 |     carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / startTime     | Change reference to class Time to a formatted string                             |
|  323  | 2022-02-14 |                    carrierEthernetUtilityClasses.yaml / Time / ---                     | Removed this Class.                                                              |
|  322  | 2022-02-14 |   carrierEthernetExternalInterfaces.yaml / UniSpecificAttributes / uniConnectorType    | Removed FC and D4 from the list of connectors                                    |

## Release Celine:

| Rev # |    Date    |                                         File/Class/Property                                         | Description                                                                                               |
| :---: | :--------: | :-------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------- |
|  319  | 2022-01-10 |                            carrierEthernetEnniSpSo.yaml / EnniSpso / ---                            | The three referenced schema files are now in the ovcSuperclasses folder                                   |
|  318  | 2022-01-10 |                  operatorMultilateralAttributes.yaml / OperatorMultilateral / ---                   | Moved this schema into ovcSuperClasses folder                                                             |
|  317  | 2022-01-10 |                          carrierEthernetEnniCommon.yaml / EnniCommon / ---                          | Moved this schema into ovcSuperClasses folder                                                             |
|  316  | 2022-01-10 |                    carrierEthernetEnniServiceAttributes.yaml / EnniService / ---                    | Moved this schema into ovcSuperClasses folder                                                             |
|  315  | 2022-01-09 |                carrierEthernetColorIdentifier.yaml / ColorFromPCPMapEntry / pcpValue                | Changed this from enum to type reference                                                                  |
|  314  | 2022-01-09 |                  carrierEthernetClassOfService.yaml / CosEnniPcpMapEntry / pcpVal                   | Changed this from enum to type reference                                                                  |
|  313  | 2022-01-09 |                         carrierEthernetTypes.yaml / PcpValue / pcpValueEnum                         | Created PCP Value type from PCPonly Enum                                                                  |
|  312  | 2022-01-09 |                 carrierEthernetTypes.yaml / AvailableMegList / availableMegListEnum                 | Created AvailableMeg type from MEGAvail enum                                                              |
|  310  | 2022-01-09 |                accessElineOvcCommon.yaml / AccessElineOvcCommon / availableMegLevel                 | Changed this from enum to type reference                                                                  |
|  309  | 2022-01-09 |         accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / maintenanceIntermediatePoint         | Changed this from enum to type reference                                                                  |
|  307  | 2022-01-09 |                          carrierEthernetTypes.yaml / MegList / megListEnum                          | Created MegList type form MEG Enum                                                                        |
|  305  | 2022-01-09 |             carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / l2cpAddressSet              | Changed this from enum to type reference                                                                  |
|  304  | 2022-01-09 |                accessElineOvcCommon.yaml / AccessElineOvcCommon / ovcL2cpAddressSet                 | Changed this from enum to type reference                                                                  |
|  303  | 2022-01-09 |                          carrierEthernetTypes.yaml / L2cpAddressSet / ---                           | Created L2cpAddressSet type for L2CPAS Enum                                                               |
|  302  | 2022-01-08 |                carrierEthernetColorIdentifier.yaml / ColorFromDscpEntry / ipv6Color                 | Changed this from enum to type reference                                                                  |
|  301  | 2022-01-08 |                carrierEthernetColorIdentifier.yaml / ColorFromDscpEntry / ipv4Color                 | Changed this from enum to type reference                                                                  |
|  300  | 2022-01-08 |                     carrierEthernetColorIdentifier.yaml / ColorFromEp / epColor                     | Changed this from enum to type reference                                                                  |
|  299  | 2022-01-08 |                carrierEthernetColorIdentifier.yaml / ColorFromPCPMapEntry / pcpColor                | Changed this from enum to type reference                                                                  |
|  298  | 2022-01-08 |                            carrierEthernetTypes.yaml / FrameColor / ---                             | Created FrameColor type for Color enum                                                                    |
|  297  | 2022-01-07 |                                carrierEthernetTypes.yaml / \* / ---                                 | Moved all "types" from utilityClassesAndTypes.yaml to CarrierEthernetTypes.yaml                           |
|  296  | 2022-01-07 |                            carrierEthernetUtilityClasses.yaml / \* / ---                            | Changed name of schema file from utilityClassesAndTypes.yaml to carrierEthernetUtilityClasses.yaml        |
|  294  | 2022-01-07 |             carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / linkAggregation             | Changed explicit enum to type reference                                                                   |
|  293  | 2022-01-07 |                    carrierEthernetEnniCommon.yaml / EnniCommon / linkAggregation                    | Added type definition for LinkAggType enum and changed this property from explicit enum to type reference |
|  292  | 2022-01-04 |                                           \* / --- / ---                                            | Global change: All properties for all classes are now optional. None are required                         |
|  291  | 2021-11-04 | carrierEthernetServiceLevelSpecification.yaml / OneWayFrameDelayRangePmMetric / oneWayFdrPercentile | Fixed property name oneWayFdrPecentile oneWayFdrPercentile (fixed in earlier edit but not recorded)       |
|  290  | 2021-10-19 |             carrierEthernetExternalInterfaces.yaml / UniPhysicalLink / uniPhysicalLink              | Changed reference from UniSpecifcAttributes to UniSpecificAttributes                                      |
|  289  | 2021-10-19 |                      carrierEthernetClassOfService.yaml / CosFromDscp / l2cp_P                      | Changed usage from Optional to Required                                                                   |
|  288  | 2021-10-19 |                    carrierEthernetClassOfService.yaml / CosFromCtagPcp / l2cp_P                     | Changed usage from Optional to Required                                                                   |
|  287  | 2021-10-19 |                    carrierEthernetClassOfService.yaml / CosFromStagPcp / l2cp_P                     | Changed usage from Optional to Required                                                                   |
|  286  | 2021-10-19 |                       carrierEthernetClassOfService.yaml / CosFromEp / l2cp_P                       | Changed usage from Optional to Required                                                                   |
|  285  | 2021-10-19 |              carrierEthernetServiceLevelSpecification.yaml / SlsCosNameEntry / deltaT               | Made this a minimum of 1                                                                                  |
|  284  | 2021-10-12 |                carrierEthernetExternalInterfaces.yaml / UniSpecificAttributes / ---                 | Fixed spelling error in JSON name (was UniSpecifcAttributes)                                              |
|  283  | 2021-10-01 |             carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / l2cpAddressSet              | Usage changed from NNRR to OORR                                                                           |
|  282  | 2021-09-29 |           carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / startTime            | Non-coding change: Time and date are UTC in the Time class                                                |
|  281  | 2021-09-27 |          carrierEthernetServiceLevelSpecification.yaml / CarrierEthernetSls / timeDuration          | Name of this property changed from timeInterval to timeDuration.                                          |
|  280  | 2021-09-27 |                   carrierEthernetClassOfService.yaml / CosDscpMapEntry / ipv6List                   | Usage changed from Optional to Required                                                                   |
|  279  | 2021-09-27 |                   carrierEthernetClassOfService.yaml / CosDscpMapEntry / ipv4List                   | Usage changed from Optional to Required                                                                   |
|  278  | 2021-09-27 |                    carrierEthernetClassOfService.yaml / DscpValues / dscpValues                     | Usage changed from Optional to Required                                                                   |
|  277  | 2021-09-27 |       carrierEthernetBandwidthProfile.yaml / BandwidthProfilePerClassOfServiceName / bwpFlow        | Changed from a Bandwidth Profile to a list [0...1] of Bandwidth Profiles                                  |
|  275  | 2021-09-27 |                                           \* / --- / ---                                            | Changed all properties that were single $ref to remove type:object                                        |
|  264  | 2021-09-19 |             accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / ovcEndPointEnvelopes             | Usage changed from OOOR to OORR                                                                           |
|  263  | 2021-09-19 |           accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / maintenanceEndPointList            | Usage changed from OOOR to OORR                                                                           |
|  262  | 2021-09-19 |            accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / sourceMacAddressLimit             | Usage changed from OOOO to OORR                                                                           |
|  261  | 2021-09-19 |      accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / egressBandwidthProfilePerEndPoint       | Usage changed from OOOR to OORR and updated description                                                   |
|  260  | 2021-09-19 |                accessElineOvcCommon.yaml / AccessElineOvcCommon / carrierEthernetSls                | Changed edit 247, make the usage OORR                                                                     |
|  259  | 2021-09-11 |           carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / listOfPhysicalLinks           | List of [ 0... \* ] changed to list of [ 1 ... \* ]                                                       |
|  258  | 2021-09-07 |                      carrierEthernetClassOfService.yaml / CosFromDscp / l2cp_P                      | This should be a list of [0...\* ] L2CP entries rather than a single entry                                |
|  257  | 2021-09-07 |                    carrierEthernetClassOfService.yaml / CosFromStagPcp / l2cp_P                     | This should be a list of [0...\* ] L2CP entries rather than a single entry                                |
|  256  | 2021-09-07 |                    carrierEthernetClassOfService.yaml / CosFromCtagPcp / l2cp_P                     | This should be a list of [0...\* ] L2CP entries rather than a single entry                                |
|  255  | 2021-09-07 |                       carrierEthernetClassOfService.yaml / CosFromEp / l2cp_P                       | This should be a list of [0...\* ] L2CP entries rather than a single entry                                |
|  254  | 2021-09-07 |                           ovcsuperclasses/_ and evcsuperclasses/_ / / ---                           | In all ovcsuperclasses and evcsuperclasses $refs to classes in the common folder were incorrect           |
|  253  | 2021-09-06 | carrierEthernetServiceLevelSpecification.yaml / OneWayFrameDelayRangePmMetric / oneWayFdrPercentile | JSON name was spelled incorrectly, was oneWayFdrPecentile                                                 |
|  252  | 2021-09-04 |                 accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / ovcEgressMap                 | This was "Optional" for inventory, should have been "Required"                                            |
|  251  | 2021-09-03 |                  carrierEthernetEnniCommon.yaml / EnniCommon / serviceFrameFormat                   | This attribute has been removed. It should not have been in the Schema in the first place.                |
|  250  | 2021-09-03 |             carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / defaultCeVlanId             | This was "Optional" for inventory, should have been "Required"                                            |
|  249  | 2021-09-03 |           carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / aggregationLinkMap            | This was "Optional" for inventory, should have been "Required"                                            |
|  248  | 2021-09-03 | accessElineOvcEpCommon.yaml / AccessElineOvcEpCommon / ingressBandwidthProfilePerClassOfServiceName | Changed from List of [0..\*] to List of [1..\*]                                                           |
|  247  | 2021-09-03 |                accessElineOvcCommon.yaml / AccessElineOvcCommon / carrierEthernetSls                | Changed "Optional" to "Required" for POQ, Quote, Order. It is an array of [0..1]                          |
|  246  | 2021-09-03 |                                             / --- / ---                                             | Remove revision 244 and return URNs to original format                                                    |
|  245  | 2021-09-02 |                              carrierEthernetEnniSpSo.yaml / --- / ---                               | URN version number changed to 2.1.0 for Access E-Line-related classes                                     |
|  244  | 2021-09-02 |                                             / --- / ---                                             | URNs have changed. Product IDs with dashes are now lowerCamelCase (e.g. access-eline to accessEline)      |
|  243  | 2021-09-02 |                      carrierEthernetColorIdentifier.yaml / ColorFromDscp / ---                      | Change Class Name from ColorFromDSCP to ColorFromDscp                                                     |
|  242  | 2021-09-02 |           carrierEthernetOperatorUniCommon.yaml / OperatorUniCommon / listOfPhysicalLinks           | Change JSON name from listofPhysicalLinks to listOfPhysicalLinks                                          |
|  241  | 2021-09-02 |              carrierEthernetEndPointMaps.yaml / EndPointMapFormE / ovcEndPointMapFormE              | Changed JSON name from EndPointMapFormE to ovcEndPointMapFormU                                            |
