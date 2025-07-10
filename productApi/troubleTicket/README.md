# Trouble Ticket Management: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard in this form.

**Summary**:

- Common schemas consistency applied.

**troubleTicketManagement.yaml:**

- `RelatedEntity`:
  - `@referredType` - removed `default: Product` - its defined as required, so
    default is obsolete.
- `MEFByteSize`:
  - `amount` - marked as required, removed `default: 1`
  - `units` - marked as required

**troubleTicketNotification.yaml:**

No changes.

## Release Irene:

**Readiness status**: Work in progress and is subject to change. Ready for
CfC#1.

**Summary:**

- Implementing new Address model introduced by MEF 150
- Attachment allowed only with use of URL
- Revised, fully specialized Event model.
- State change events now carry the value of the new `status`
- `buyerId` and `sellerId` in notification now carried via query params
  (consistent with seller side API)

### List of changes in the API:

**troubleTicketManagement.api.yaml:**

- `GET /incident`:
  - `422` - response code added
- `GET /troubleTicket`:
  - `422` - response code added
- `POST /hub`:
  - `422` - response code added
- `AttachmentValue`:
  - `attachmentId` - removed
  - `content` - removed
  - `url` - made required
- `FieldedAddress` - replaced with `FieldedAddressRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `buildingName` - added
  - `country` - removed
  - `countryCode` - added
  - `geographicSubAddress` - removed
  - `language` - added
  - `poBox` - added
  - `privateStreetName` - added
  - `privateStreetNumber` - added
  - `streetPreDirection` - added
  - `streetPostDirection` - added
  - `streetSuffix` - removed
  - no attribute is required anymore
- `GeographicSubAddress` - removed
- `Incident`:
  - `statusChange` - clarified to be required
- `MEFSubUnit` - renamed to `SubUnit`
- `RelatedContactInformation`:
  - `postalAddress` - changed ref type to `FieldedAddressRepresentation`
- `TroubleTicket`:
  - `statusChange` - clarified to be required

**troubleTicketNotification.api.yaml:**

- `buyerId` and `sellerId` added to parameters to all endpoints
  ProductOrderEventPayload
- `buyerId` and `sellerId` removed from all payloads
- all listener endpoint changed the `requestBody` content schema to their
  respective events.

- `408` - response code removed
- `Error408` - removed

- `Event` - made a generic Event

  - `eventType` - added
  - `event` - added

- `IncidentAttributeValueChangeEvent` - added
- `IncidentCreateEvent` - added
- `IncidentEvent` - removed
- `IncidentEventType` - removed
- `IncidentStatusChangeEvent` - added
- `IncidentStatusChangeEventPayload` - added
- `IncidentStatusType` - added
- `TroubleTicketAttributeValueChangeEvent` - added
- `TroubleTicketEventType` - removed
- `TroubleTicketEvent` - removed
- `TroubleTicketInformationRequiredEvent` - added
- `TroubleTicketResolvedEvent` - added
- `TroubleTicketStatusChangeEventPayload` - added
- `TroubleTicketStatusType` - added

## Release Haley:

**Readiness status**: MEF Published Standard

No changes.

## Release Grace:

**Readiness status**: MEF Published Standard

No changes.

## Release Fergie:

**Readiness status**: MEF Published Standard

No changes.

## Release Ella:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard without further changes.

**Summary:**

- added `observedImpact` to Trouble Ticket search criteria
- introduced `impact` attribute to Incident, aligned with Trouble Ticket's
  `observedImpact`
- added `/hub/{id}/get` operation

### List of changes in the API:

**troubleTicketManagement.api.yaml:**

- `TroubleTicket_Update`
  - `observedImpact` - added
- `/incident/`
  - `get`
    - `impact` query parameter added
- `/hub/{id}`
  - `get` - operation added
- `Incident`
  - `impact` - added, required
- `Incident_Find`
  - `impact` - added, required
- `IncidentType`
  - removed from enumeration (used by `impact` attribute):
    - `degraded`
    - `down`
    - `intermittent`
  - added:
    - `repair`
    - `installation`

**troubleTicketNotification.api.yaml:**

None

## Release Dolly:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #2

### List of changes in the API:

**troubleTicketManagement.api.yaml:**

The "Get Workorder" use case moved to Appointment API -
`workOrderManagement.yaml` (MEF W137)

- moved endpoint `/workOrder/{id}`
- moved entities:
  - `WorkOrder`
  - `WorkOrderStateType`
  - `AppointmentRef`
  - `FormattedAddress`
  - `GeographicAddressLabel`
  - `GeographicAddressRef`
  - `GeographicSiteRef`
  - `GeographicSubAddress`
  - `MEFGeographicPoint`
  - `RelatedPlaceRefOrValue`
- Added support for MEF 113 Use Cases:
  - Use Case 15: Retrieve Incident List
  - added endpoint `/incident`
  - added `Incident_Find`
- `TroubleTicket_Find`
  - `observedImpact` added, required
- `FieldedAddress` no longer extends `RelatedPlaceRefOrValue`
- `AttachmentValue`
  - `creationDate` - set as required
- `Incident`
  - `issueStartDate` renamed to `situationStartDate`

**troubleTicketNotification.api.yaml:**

- server URL: `mefApi/sonata/troubleTicket/` changed to
  `mefApi/sonata/troubleTicketNotification/`
- removed endpoint: `/listener/incidentClosedEvent`
- renamed endpoint: ` /listener/incidentCreatedEvent:` to
  ` /listener/incidentCreateEvent:`
- `IncidentEventType`:
  - removed `incidentClosedEvent`
  - renamed `incidentCreatedEvent` to `incidentCreateEvent`

## Release Celine:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #1

### List of changes in the API:

- Added support for MEF 113 Use Cases:
  - Use Case 12. Retrieve Workorder by Workorder Identifier
  - Use Case 13: Retrieve Incident List
  - Use Case 14: Retrieve Incident by Incident Identifier
  - Use Case 17: Send Incident Notification

**troubleTicketManagement.api.yaml:**

- Added endpoints:
  - `/incident:`
    - `get`
  - `/incident/{id}:`
    - `get`
  - `/workOrder/{id}:`
    - `get`
- Added Types:
  - `Incident`
  - `Incident_Find`
  - `IncidentStatusChange`
  - `IncidentStatusType`
  - `IncidentType`
  - `WorkOrder`
  - `WorkOrderStateType`
  - `RelatedPlaceRefOrValue`
  - `FormattedAddress`
  - `GeographicAddressLabel`
  - `GeographicAddressRef`
  - `GeographicSiteRef`
  - `AppointmentRef`
  - `WorkOrderRef`
  - `MEFObservedImpactType`
  - `IssueRelationship`
- Removed Types:
  - `Error405` (not used)
  - `TroubleTicketRelationship` - removed (replaced with `IssueRelationship`)
- `TroubleTicket`
  - added:
    - `workorder`
    - `observedImpact`
    - `relatedIssue`
  - removed:
    - `troubleTicketRelationship` (replaced with `relatedIssue`)
    - `lastUpdate`
- `TroubleTicketType`
  - removed:
    - `degraded`
    - `down`
    - `failure`
  - added:
    - `information`
- `FieldedAddress`
  - added `allOF` to `RelatedPlaceRefOrValue`
- `AttachmentValue`
  - set as required:
    - `author`
    - `name`
    - `source`

**troubleTicketNotification.api.yaml:**

- Changed the request body type to `TroubleTicketEvent` in:
  - `/listener/troubleTicketAttributeValueChangeEvent`
  - `/listener/troubleTicketStatusChangeEvent`
  - `/listener/troubleTicketResolvedEvent`
  - `/listener/troubleTicketInformationRequiredEvent`
- Added endpoints:
  - `/listener/incidentCreatedEvent`
  - `/listener/incidentAttributeValueChangeEvent`
  - `/listener/incidentClosedEvent`
  - `/listener/incidentStatusChangeEvent`
- Renamed `TroubleTicketEvent` to `TroubleTicketEventPayload`
- Added `TroubleTicketEvent`
- Added `IncidentEvent`
- Added `IncidentEventType`
- Added `IncidentEventPayload`

## Release Billie:

First release of this API.
