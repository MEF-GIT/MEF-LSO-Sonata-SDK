# MEF-LSO-Sonata-SDK

This repository contains the MEF LSO Sonata SDK. It includes API definitions for the following functional areas:
*  Product Order
*  Product Offering Qualification
*	Product Inventory
*	Trouble Ticket
*	Event
*  JSON representations for Product Spec description for Ordering & Serviceability
*  JSON representations for Place description

The MEF LSO Sonata SDK is released under the Apache 2.0 license.

More information about the LSO Sonata API reference point can be found here:
https://wiki.mef.net/display/CESG/LSO+Sonata

## Contents

This SDK contains the following items:

*	COPYRIGHT - Copyright 2017 MEF Forum
*	LICENSE - Contains a copy of the Apache 2.0 license
*	Experimental - SDK content that does not have associated published MEF Interface Profile Specifications
    *	api/R1/address – Contains the API definitions for Inter-carrier address validation service.
    * api/R1/productOfferingQualification - Contains the API definitions for inter-carrier product offering qualification service.
    * api/R1/site - Contains the API definitions for inter-carrier site validation service.
    * api/R1/productOrder - deprecated - Contains the API definitions for inter-carrier service ordering capability. These APIs are now superseded by the newer product order apis under the folder api/R2/productOrder.
    * api/R2/event - Contains the API definitions for a buyer to receive subscribed notifications from a seller.
    * api/R2/productInventory – Contains API definitions for Service Provider’s (Buyer) operational support system to retrieve from a Partner’s (Seller) Inventory management system for a set of product instances based upon a filter of product inventory attributes, or a specific product instance based upon a product identifier.
    * api/R2/productOrder - Contains the API definitions for inter-carrier service ordering capability.
    * api/R2/troubleTicket – Contains the API definitions for a Service Provider’s system to create and manage trouble tickets with a Partner’s system.
    * api/PlaceDescription – Contains reference JSON schemas for place description.
    * api/ProductSpecDescription – Contains reference JSON schemas for product specification description.
    *	examples – Contains example code that can be exercised via the associated postman collection to see the following APIs in action.Please note that the API definitions used in the example are from Sonata SDK Release R1 to be found under the api/R1 directory. We welcome contributions to enhance the example to include additional Sonata APIs under api/R1 and api/R2. To learn more please write to Bithika Khargharia
        * POST /addressValidation
        * POST /productOfferingQualification
        * POST /productOrder
        * GET /productOrder

*	Published - SDK content for that does have associated MEF Interface Profile Specifications
    *	None

## Reference Implementations
A reference implementation of the LSO Sonata APIs is expected to be available in the future. Please contact Bithika (bithika@mef.net) for more information.

## Related Projects

# Copyright

Copyright 2017 MEF Forum
