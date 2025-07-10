# Appointment Management: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

**Summary**:

- Common schemas consistency applied.

**appointmentManagement.api.yaml:**

- `MEFByteSize`:
  - `amount` - marked as required, removed `default: 1`
  - `units` - marked as required

**appointmentNotification.api.yaml:**

No changes

## Release Irene:

**Readiness status**: Call for Comments Ballot #1. Work in progress and is
subject to change.

**Summary:**

- Updating Address model according to new definition in MEF 150
- Revised, fully specialized Event model.
- State change event now carries the value of the new `state`
- `buyerId` and `sellerId` in notification now carried vie query params
  (consistent with seller side API)

### List of changes in the API:

**appointmentManagement.api.yaml:**

- `GET /appointment`:
  - `422` - response code added
- `POST /hub`:

  - `422` - response code added

- `AttachmentValue`:
  - `content` - removed
  - `url` - made required
- `ContactInformation` - added
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
- `FormattedAddress` - replaced with `FormattedAddressRepresentation`
  - `addrLine1` - renamed to `formattedAddress`
  - `allOf` with `GeographicAddress` - removed
  - `addrLine2` - removed
  - `city` - removed
  - `country` - removed
  - `language` - added
  - `locality` - removed
  - `postcode` - removed
  - `postcodeExtension` - removed
  - `stateOrProvince` - removed
- `GeographicAddress_Query` - added
- `GeographicAddressLabel` - replaced with `LabelRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `externalReferenceId` - renamed to `label`
  - `externalReferenceType` - renamed to `administrativeAuthority`
  - `language` - added
- `GeographicAddressRef`
  - does not extend the `GeographicAddressRefOrValue`
  - `@type` - added with constant `GeographicAddressRef` value
- `GeographicSiteRef`
  - does not extend the `GeographicAddressRefOrValue`
  - `@type` - added with constant `GeographicSiteRef` value
- `GeographicSubAddress` - removed
- `MEFGeographicPoint` - replaced with `GeographicPointRepresentation`
  - `allOf` with `GeographicAddress` - removed
  - `x` - renamed to `longitude`
  - `y` - renamed to `latitude`
  - `z` - renamed to `elevation`
- `MEFSubUnit` - renamed to `SubUnit`
- `PlaceRefOrQuery` - added, now using `oneOf` instead of `allOf` for refOrValue
  pattern

**appointmentNotification.api.yaml:**

- `buyerId` and `sellerId` added to parameters to all endpoints
  ProductOrderEventPayload
- `buyerId` and `sellerId` removed from all payloads
- all listener endpoint changed the `requestBody` content schema to their
  respective events.


- `408` - response code removed
- `Error408` - removed
- `Event` - made a generic Event
  - `eventType` - changed to `string`
  - `event` - changed to `object`
- `AppointmentAttributeValueChangeEvent` - added
- `AppointmentAttributeValueChangeEventPayload` - added
- `AppointmentEvent` - removed
- `AppointmentEventPayload` - removed
- `AppointmentEventType` - removed
- `AppointmentStatusChangeEvent` - added
- `AppointmentStatusChangeEventPayload` - added
- `AppointmentStatusType` - added

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

**Summary** - The following updates introduced:

- added support for change MEF 113 :
  - added `inProgress` to `AppointmentStatusType`
- `get` operation in `/hub/{id}` endpoint added,
- API errors fixed

**appointmentManagement.api.yaml:**

- server URL : `https://{serverBase} mefApi/sonata/appointment/v1/` changed to
  `https://{serverBase}/mefApi/sonata/appointment/v2/`
- added operation
  - `/hub/{id}`
    - `get`
- `/appointment` endpoint
  - change return type to `Appointment_Find`
- modified types:
  - `AppointmentStatusType`
    - `inProgress` added
  - `Appointment`
    - set as required:
      - `id`
      - `relatedPlace`
      - `relatedContactInformation`
      - `status`
      - `validFor`
      - `workorder`
  - `Appointment_Create`
    - added:
      - `attachment`
      - `note`
      - `validFor`
    - set as required:
      - `relatedContactInformation`
      - `validFor`
      - `workOrder`
  - `Appointment_Create`
    - `relatedPlace` removed
  - `Appointment_Find`
    - `href` removed from required
  - `Appointment_Update`
    - `relatedPlace` added
  - `SearchTimeSlot`
    - `workOrder` added
    - `relatedEntity` removed
    - set as required:
      - `availableTimeSlot`
      - `workOrder`
      - `requestedTimeSlot`
  - `SearchTimeSlot_Create`
    - `workOrder` added
    - `relatedEntity` removed
    - set as required:
      - `workOrder`
      - `requestedTimeSlot`
  - `TimePeriod`
    - set as required:
      - `endDateTime`
      - `startDateTime`
- removed types:
  - `Error501`
  - `RelatedEntity`

**appointmentNotification.api.yaml:**

- server URL : `https://{serverBase}/mefApi/sonata/appointmentNotification/v1/`
  changed to `https://{serverBase}/mefApi/sonata/appointmentNotification/v2/`

## Release Dolly:

First release of this API.
