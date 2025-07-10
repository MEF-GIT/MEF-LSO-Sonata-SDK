# Workorder Management: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

**Summary**:

No changes

**appointmentManagement.api.yaml:**

No changes

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

**workorderManagement.api.yaml:**

- `GET /workorder`:
  - `422` - response code added
- `POST /hub`:

  - `422` - response code added

- `ContactInformation` - added
- `Error422` - added
- `Error422Code` - added
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

**workorderNotification.api.yaml:**

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
- `WorkOrderAppointmentRequiredEvent` - added
- `WorkOrderCreateEvent` - added
- `WorkorderEvent` - removed
- `WorkorderEventType` - removed
- `WorkOrderStateChangeEvent` - added
- `WorkOrderStateChangeEventPayload` - added
- `WorkOrderStateType` - added


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

- added support for MEF 113:
  - added `plannedExecutionDate` attribute to `WorkOrder`
- `get` operation in `/hub/{id}` endpoint added,
- API errors fixed

**workorderManagement.api.yaml:**

- server URL : `https://{serverBase}/mefApi/sonata/WorkOrder/v2/` changed to
  `https://{serverBase}/mefApi/sonata/workOrderManagement/v2/`
- added operation
  - `/hub/{id}`
    - `get`
- changed endpoint:
  - `/workorder`
    - added query parameter `relatedEntityType`
    - removed query parameter `id`
- changed endpoint:
  - `/workorder/{id}`
    - parameter `id`
      - changed from `query` to `path`
      - set `required` to `true`
- modified types:
  - `Workorder`
    - `plannedExecutionDate` added
  - `TimeDuration`
    - set as required:
      - `timeDurationValue`
      - `timeDurationUnits`
  - `WorkOrder`
    - set as required:
      - `duration`
      - `place`
      - `task`
  - `WorkOrder_Find`
    - set to required:
      - `place`
    - removed from required:
      - `relatedContactInformation`
      - `tasks`
- removed types:
  - `Error409`
  - `Error422`
  - `Error422Code`
  - `Error501`
  - `DataSizeUnit`
  - `MEFByteSize`
  - `MEFObservedImpactType`
  - `WorkOrderRef`

**workorderNotification.api.yaml:**

- server URL : `https://{serverBase}/mefApi/sonata/workOrderNotification/v1/`
  changed to `https://{serverBase}/mefApi/sonata/workOrderNotification/v2/`

## Release Dolly:

First release of this API.
