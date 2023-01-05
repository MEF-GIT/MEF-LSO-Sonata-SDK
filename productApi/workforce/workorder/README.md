# Workorder Management: Release notes

## Release Ella:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard without further changes.

**Summary** - The following updates introduced:

- added support for MEF 113:
  -  added `plannedExecutionDate` attribute to `WorkOrder`
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
