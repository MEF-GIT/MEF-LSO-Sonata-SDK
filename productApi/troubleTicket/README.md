# Trouble Ticket Management: Release notes

## Release Dolly:

**Readiness status**: Work in progress and is subject to change. Completed and
resolved Call for Comments #2

### List of changes in the API:

**troubleTicketManagement.api.yaml:**

The "Get Workorder" use case moved to Appointment API - `workOrderManagement.yaml` (MEF W137)

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

- server URL: `mefApi/sonata/troubleTicket/` changed to `mefApi/sonata/troubleTicketNotification/`
- removed endpoint:  `/listener/incidentClosedEvent`
- renamed endpoint: ` /listener/incidentCreatedEvent:` to ` /listener/incidentCreateEvent:`
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
