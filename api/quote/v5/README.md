# Changes introduced since the SDK R4

Whole API is crafted with the use of TMF tooling. At this moment some descriptions might differ from previous version.
The details of descriptions will be worked on during the MEF 115 Quote Management Developer Guide project and will be updated in next release.

The API is based on newest TMF 648 rel. 19.0 (v4.0.0). The rules of Domain Context Specialization were followed. DCS rules are developed by the [MEF-TMF-ONAP-Collaboration](https://wiki.mef.net/pages/viewpage.action?pageId=106608028) project and ensure API compliance.

The list below highlights discrepancies between current version and:

* previous version of MEF Quote API - marked with (MEF)
* current version of TMF 648 - marked as (TMF)

## List of changes

* (MEF) All enums change to lowerCamelCase
* Quote - Modify
  * (TMF) QuoteStateType - Changed to MEFQuoteStateType
  * (MEF) expectedQuoteCompletionDate - changed type from date to dateTime
  * (MEF) relatedParty not mandatory
  * (MEF) requestedQuoteCompletionDate - not mandatory
  * (MEF) quoteItem - set minItems=1
  * (TMF, MEF) expectedFulfillmentStartDate - removed, Requested Quote Item Installation Interval used instead
  * (TMF) projectId - added
  * (MEF, TMF) state mapping
  * (MEF, TMF) quoteLevel - split to buyerRequestedQuoteLevel and sellerQuoteLevel
  * (MEF) buyerRequestedQuoteLevel - made mandatory
  * (MEF, TMF) instantSyncQuote - renamed to TMF from instantSyncQuoting, made mandatory
  * (MEF) requestedQuoteCompletionDate - made NOT mandatory
  * (MEF, TMF) stateChange - introduced a list pattern to store the history
  * (TMF) category - removed
  * (TMF) billingAccount - removed
  * (TMF) effectiveQuoteCompletionDate - removed
  * (TMF) authorization - removed
  * (TMF) quoteTotalPrice - removed
  * (TMF) productOfferingQualification - removed
  * (TMF) version - removed
  * (TMF,MEF) agreement - removed
  * (TMF) contactMedium - removed
* QuoteItem
  * (MEF, TMF) MEFQuoteItemExtension - added extension type
  * (MEF, TMF) state mapping
  * (TMF) id - made mandatory (Quote Item Reference Number)
  * (TMF) action - made mandatory
  * (TMF) action - restricted with enum: install, change, disconnect
  * (MEF) action - removed no_change as per MEF 80
  * (MEF, TMF) MEFQuoteItemActionType - added enum Type
  * (TMF) requestedQuoteItemTerm - added 
  * (MEF) requestedQuoteItemTerm (ItemTerm =>MEFItemTerm)
  * (MEF, TMF) added terminationError (List of termination errors, like in POQ)
  * (TMF, MEF) installationInterval - added
  * (TMF, MEF) requestedinstallationInterval- added
  * (MEF) product - change type from Product to ProductRefOrValue
  * (TMF) sellerQuoteItemLevel - added
  * (MEF, TMF) agreementName - changed to agreement for consistency
  * (MEF, TMF) State mapping
  * (MEF) qualification = back to TMF's productOfferingQualificationItem
  * (TMF) appointment - removed
  * (TMF) attachment - removed
  * (TMF) quantity - removed
  * (TMF) quoteItem[] - removed
  * (TMF) quoteItemAuthorization - removed
* QuoteItemPrice (TMF: QuotePrice)
  * (TMF) productOfferingPrice - removed
  * (TMF) priceType - narrowed to MEFPriceType enum
  * (TMF) recurringChargePeriod - narrowed to MEFChargePeriod enum
  * (TMF) priceAlteration - removed
* Product
  * (MEF) id - is not mandatory to allow passing product specification for install action
* QuoteItemRelationship
  * (MEF) type - renamed to relationshipType
  * (MEF) type - not mandatory
  * (MEF) id - not mandatory
* Note:
  * (MEF) id - added and made mandatory
  * (TMF) author - made mandatory
  * (TMF) date - made mandatory
* (TMF, MEF) MEFItemTerm - renamed from ItemTerm
* Duration
  * (TMF) narrowed units with TimeUnit enum
* CancelOrRejectQuote
  * (MEF) resource istead of previous "/quote/requestStateChange"
  * (TMF) added
  * (MEF) state - added

Notifications:

* (MEF) quoteInformationRequiredNotification - removed
* (MEF) quoteAttributeValueChangeNotification - removed
* (TMF, MEF) quoteLevelChangeEvent - added
* (MEF) changed path from notification to listener
* (MEF) changed endpoint naming (Notification to Event)

Errors:

• (MEF, TMF) Introduced a pattern of subclassing per error code.

## GitHub Issues:

### Global

* Introduce new PlaceReforValue specialization: PlaceRef
CHanges introduced as described #149
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/149
* Define several business errors 'behind' HTTP 422 #26
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/26
* Align API Error Code #127
* https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/127


### Order specific

#### Bugs

* Product.id should not be required on Quote INSTALL #146
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/146

* QuoteItem refers to Array/one POQ - inconsistency in definitions #145 
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/145

* Error Code 109 #154
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/154

#### Improvements

* Add INSUFICIENT_INFORMATION_PROVIDED statr for quote #44
https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/issues/44

