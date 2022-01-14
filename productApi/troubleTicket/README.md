# Trouble Ticket Management: Release notes

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
