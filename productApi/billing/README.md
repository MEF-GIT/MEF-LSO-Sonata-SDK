# Billing Management: Release notes

## Release Janis:

**Readiness status**: Requested Letter Ballot. It will be most likely published as a standard in this form.

**Summary**:

- Fixed error return types to be specific instead of `Error`.

**billingManagement.api.yaml:**

- `/customerBill/{id}`
  - `GET` - Fixed error return types to be specific instead of `Error`.
- `/customerBillItem/{id}`
  - `GET` - Fixed error return types to be specific instead of `Error`.

## Release Irene:

**Readiness status**: Work in progress and is subject to change. Ready for
CfC#1.

**Summary:**

- Implementing new Address model introduced by MEF 150
- Revised, fully specialized Event model.
- State change event now carry the value of the new `state`
- `buyerId` and `sellerId` in notification now carried via query params
  (consistent with seller side API)

### List of changes in the API:

**billingManagement.api.yaml:**

- `GET /customerBill`:

  - `422` - response code added

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
- `GeographicSubAddress` - removed
- `MEFSubUnit` - renamed to `SubUnit`
- `RelatedContactInformation`:
  - `postalAddress` - changed ref type to `FieldedAddressRepresentation`

**billingNotification.api.yaml:**

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

- `CustomerBillCreateEvent` - added
- `CustomerBillCreateEventPayload` - added
- `CustomerBillEvent` - removed
- `CustomerBillEventPayload` - removed
- `CustomerBillEventType` - removed
- `CustomerBillStateChangeEvent` - added
- `CustomerBillStateChangeEventPayload` - added
- `CustomerBillStateType` - added

## Release Haley:

**Readiness status**: MEF Published Standard

No changes.

## Release Grace:

**Readiness status**: MEF Published Standard

No changes.

## Release Fergie:

**Readiness status**: Requested Letter Ballot. It will be most likely published
as a standard without further changes.

**Summary** - Only small updates found during the CfC process.

### List of changes in the API:

**billingManagement.api.yaml:**

- `/hub/`:
  - added `Error501` to possible responses
- `CustomerBillItem`:
  - `type` - renamed to `customerBillItemType`
  - `unitQuantity` - type set to number
  - `product` - marked as nullable
  - `productOrderItem` - marked as nullable
- `Error`:
  - `code` - removed (still present in all extending error types)
  - `status` - removed
- `Error501` - added
- `GeographicSubAddress`:
  - `id` - removed

**billingNotification.api.yaml**

- `CustomerBillEventType`:
  - `CustomerBillCreateEvent` - renamed to `customerBillCreateEvent`
  - `CustomerBillStateChangeEvent` - renamed to `customerBillStateChangeEvent`

## Release Ella:

First release of this API.
