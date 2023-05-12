# Billing Management: Release notes

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
