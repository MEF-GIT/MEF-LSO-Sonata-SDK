# Working Draft MEF W87 - Release notes

**This draft represents MEF work in progress and is subject to change.**

MEF W87 consist of:
- API definition for Product Offering Specification:
  - management: `productOfferingQualificationManagement.api.yaml`
  - notifications: `productOfferingQualificationNotification.api.yaml`
- Developer Guide document that is assisted implementation of Product Offering Qualification

## POQ Management API release notes

API definitions were subject to CFC process but up to date no draft standard or standard was released.

This version comes with a resolution of the majority of the comments.

The API is based on the newest TMF 679 rel. 19.0 (v4.0.0). The rules of Domain Context Specialization were followed. 
DCS rules are developed by the [MEF-TMF-ONAP-Collaboration](https://wiki.mef.net/pages/viewpage.action?pageId=106608028) project and ensure API compliance.

The changes to API are not backward compatible due to breaking changes in APIs. 

List of the most important changes:

- `MEFProductConfiguration` introduced as an extension point for Product Specifications
- `ProductOfferingQualification_Common` introduced to accommodate commonalities between `ProductOfferingQualification_Create` and `ProductOfferingQualification`
- `ProductOfferingQualificationItem_Common` introduced to accommodate commonalities between `ProductOfferingQualificationItem_Create` and `ProductOfferingQualificationItem`
- `ProductActionType` : rename of enumeration values
- `ProductActionType` : rename of enumeration values, removal of `noChange` state
- `AlternateProductProposal` : refactored into `AlternateProductOfferingProposal`
- `ProductOfferingQualificationStateType` renamed to `MEFPOQTaskStateType`, the new `accepted` state introduced, rename of other states
- `ProductOfferingQualificationItemStateType` renamed to `MEFPOQItemTaskStateType`, the new `accepted` state introduced, rename of other states
- `ErrorRepresentation` model refactor into `Error` types hierarchy
- Addressing model improved:
  - adding `PlaceRef`
  - refactoring `ReferencedAddress` into `GlobalAddressId`, attributes renaming
  - refactoring of `GeographicLocation` into `MEFGeographicLocation` and aligning its structure with TMF counterpart
- state change log patter was introduced into `ProductOfferingQualification` and `ProductOfferingQualificationItem` types
- `basepath` aligned to match latest MEF guidelines

These changes were introduced to achieve:

- the compatibility with TMF 679 rel 19.0 according to DCS rules.
- the functional compatibility to the previous version of MEF POQ API is maintained.  
- the functional compatibility with MEF 79 and MEF 79.0.1 is maintained.
- the structural compatibility across all Sonata IRP APIs

**Readiness status**: Work in progress and is subject to change

## Developer Guide document

The standard document was subject to CFC process but up to date no draft standard or standard was released.
A significant part of this document was rewritten and as such was not reviewed in MEF process.

The content of the document is in sync with API definitions as well as with requirement defined in MEF 79 and MEF 79.0.1

Sections 1 to 6 are considered as early draft. Section 7 is considered work in progress.
Section 7 focuses mostly on the description of a data model of POQ Management API and aims 
to provide a mapping between Developer Guide and MEF 79 and MEF 79.0.1 specifications.
Section 7 does not cover data models for POQ Notification API. 
Section 7 might contain more consistencies than previous sections as it was not subject to CFC process. 

The document defines requirements for implementers which are marked as [R XXX].
The list of requirements is not final. 
In the final version of the standard all requirements will be properly numbered.
Document refers to MEF 79 requirements. These are marked as **[MEF79 Rnn]** where `Rnn` stand for a valid MEF79 requirement number.

**Readiness status**: Work in progress and is subject to change