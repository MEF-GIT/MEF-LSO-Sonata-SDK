This is an example implementation that demonstrates how a postman client (buyer) can use the APIs below to perform address validation, product offering qualification, post and get a product order from a SP (seller) site.  

- POST /addressValidation,
- POST /productOfferingQualification
- POST /productOrder
- GET   /productOrder

*2018.01.03*

---
- [Address validation](#Address validation)
- [ProductOfferingQualification](#ProductOfferingQualification)
- [Product order](#Product order)
---


## Address validation

### Usage

send a POST message to

	https://{api_url}/addressValidation
	
with the following body

	{
	  "provideaAlternative": false,
	  "validAddress": {
	    "streetNr": "2",
	    "streetName": "Pierre Marzin",
	    "streetType": "avenue",
	    "postcode": "22300",
	    "city": "Lannion,",
	    "country": "France"
	  }
	}
	
Wait for a synchronous response from the server with the following characteristics

- Response Code 201-Created
- location header in the body set to /addressValidation/{xxx} where {xxx} indicates the identifier assigned by the server to the new addressValidation resource 
- Body:

	```
	{
	  "id": "xx",
	  "status": "done",
	  "validationDate": "2017-08-29T07:29:26.360Z",
	  "validationResult": "success",
	  "provideaAlternative": false,
	  "validAddress": {
	    "id": "1",
	    "streetNr": "2",
	    "streetName": "Pierre Marzin",
	    "streetType": "avenue",
	    "postcode": "22300",
	    "city": "Lannion",
	    "country": "France"
	   }
	}
	
Rainy day (not supposed to occur in the POC) If for any reason the address provided in the request did not match pre-defined address the response will be:

	{
	  "id": "xx",
	  "status": "done",
	  "validationDate": "2017-08-29T07:29:26.360Z",
	  "validationResult": "fail",
	  "provideaAlternative": false
	}
	
## ProductOfferingQualification


### Usage

send a POST message to /productOfferingQualification with the following contents in the BODY

	{
	    "provideAlternative": false,
	    "expectedResponseDate": "2017-08-29",
	    "projectId": "MEF POC",
	    "relatedParty": [
	        {
	            "id": "100",
	            "name": "AT&T",
	            "role": "Buyer",
	            "number": "455-896-8556"
	        }
	    ],
	    "productOfferingQualificationItem": [
	        {
	            "id": "1",
	            "desiredActivationDate": "2017-08-29",
	            "product": {
	                "productSpecificationRef": {
	                    "id": "UNISpec",
	                    "describing": {
	                        "@type": "UNISpec",
	                        "@schemaLocation": "to be defined"
	                    },
	                    "portSpeed": {
	                        "amount": 10,
	                        "unit": "Mbps"
	                    },
	                    "accessTechnology": "DIRECT_FIBER",
	                    "interfaceType": "ELECTRICAL",
	                    "accessMedium": "FIBER",
	                    "physicalLayer": "100BASE-TX"
	                },
	                "relatedParty": [
	                    {
	                        "id": "101",
	                        "name": "Joe Smith",
	                        "role": "UNI Site Contact",
	                        "number": "0645897425"
	                    }
	                ],
	                "geographicAddress": [
	                    {
	                        "id": "1",
	                        "role": "UNI Site"
	                    }
	                ]
	            }
	        }
	    ]
	}
	
Wait for a synchronous response from the server with the following characteristics
- Response Code 201-Created
- Include a location header in the body set to {apiRoot}/productOfferingQualification/{xxx} where {xxx} indicates the identifier assigned by the server to the new productOfferingQualification
- Body:

    ```
	{
	    "id": "xx",
	    "state": "COMPLETED",
	    "provideAlternative": false,
	    "expectedResponseDate": "2017-08-29",
	    "projectId": "MEF POC",
	    "expirationDate": "2017-08-29",
	    "relatedParty": [
	        {
	            "id": "100",
	            "name": " AT&T ",
	            "role": "Buyer",
	            "number": "455-896-8556"
	        }
	    ],
	    "productOfferingQualificationItem": [
	        {
	            "id": "1",
	            "desiredActivationDate": "2017-08-29",
	            "state": "COMPLETED",
	            "serviceabilityConfidence": "GREEN",
	            "estimatedResponseDate": "2017-08-29",
	            "installationInterval": {
	                "amount": 30,
	                "timeUnit": "SECS"
	            },
	            "product": {
	                "productSpecificationRef": {
	                    "id": "UNISPec",
	                    "describing": {
	                        "@type": "UNISpec",
	                        "@schemaLocation": "to be defined"
	                    },
	                    "portSpeed": {
	                        "amount": 10,
	                        "unit": "Mbps"
	                    },
	                    "accessTechnology": "DIRECT_FIBER",
	                    "interfaceType": "ELECTRICAL",
	                    "accessMedium": "FIBER",
	                    "physicalLayer": "100BASE-TX"
	                },
	                "relatedParty": [
	                    {
	                        "id": "101",
	                        "name": "Joe Smith",
	                        "role": "UNI Site contact",
	                        "number": "0645897425"
	                    }
	                ],
	                "geographicAddress": [
	                    {
	                        "id": "1",
	                        "role": "UNI Site"
	                    }
	                ]
	            }
	        }
	    ]
	}

## Product order


### Assumptions

- Sls information are not described in the order and we assume it has been set-up during onboarding
- Product attributes used are a subset of the ones defined in MEF Ethernet Ordering Interface Profile Spec – proposal:

	"buyerId": "xxxxxxxxxxx",
	"physicalLayer": "100BASE-TX ",
	"numberOfLinks": 1,
	"maxAggBw": {
	    "amount": 10,
	    "unit": "Mbps"
	     }
	
UNISPec attributes (+value) for ordering:

	"buyerId":"xxxxxxxxxxx",
	"physicalLayer":"100BASE-TX ",
	"numberOfLinks":1,
	"maxAggBw":{
	               "amount":10,
	               "unit":"Mbps"
	            }
	
eLineSPec attributes (+value) for ordering:

	"buyerId":"xxxxxxxxxxx",
	"mtuSize": 1350
	
UNICEEndPoint attributes (+value) for ordering:

	"cvlanId": [
	      		20
	   		 ],
	"ingressBWProfile":[
	           {
	              "cosId":"Gold",
	              "cir":{
	                     "amount":10,
	                     "unit":"Mbps"
	                      }
	            }
	]
	
ENNISPec attributes (+value) for ordering:

	"svlanId": [
	      	 100
	        ],
	"ingressBWProfile":[
	          {
	             "cosId":"Gold",
	             "cir":{
	                     "amount":10,
	                     "unit":"Mbps"
	                     }
	           }
	]
	
### ProductOrder creation

send a POST message to /productOrder with the following contents

	{
	   "externalId":"AT&T-XX ",
	   "requestedCompletionDate":"2017-08-29T11:38:21.501Z ",
	   "requestedStartDate":"2017-08-29T11:38:21.501Z ",
	   "expeditePriority":0,
	   "projectId":"MEF POC",
	   "relatedParty":[
	      {
	         "id":"100",
	         "name":"AT&T",
	         "role":"Buyer",
	         "number":"455-896-8556"
	      }
	   ],
	   "orderItem":[
	      {
	         "id":"1",
	         "action":"add",
	         "productOffering":{
	            "id":"UNI_Offering"
	         },
	         "product":{
	            "productSpecification":{
	               "id":"UNISpec",
	               "describing":{
	                  "@type":"UNISpec",
	                  "@schemaLocation":" https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/UNISpec.json"
	               }
	            },
	            "buyerId":"AT&T UNI id ",
	            "physicalLayer":"100BASE-TX ",
	            "numberOfLinks":1,
	            "maxAggBw":{
	               "amount":10,
	               "unit":"Mbps"
	            }, 
	            "relatedParty":[
	               {
	                  "id":"101",
	                  "name":"Joe Smith",
	                  "role":"UNI Site contact ",
	                  "number":"0645897425"
	               }
	            ],
	            "geographicAddress":[
	               {
	                  "id":"1 ",
	                  "role":"UNI Site"
	               }
	            ]
	         },
	         "qualificationRef":[
	            {
	               "id":"xx ",
	               "qualificationItem":"1"
	            }
	         ]
	      },
	      {
	         "id":"2",
	         "action":"add",
	         "productOffering":{
	            "id":"ELINE_Offering"
	         },
	         "product":{
	            "productSpecification":{
	               "id":"eLineSpec",
	               "describing":{
	                  "@type":"eLineSpec",
	                  "@schemaLocation":" https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/ELineSpec.json"
	               }
	            },
	            "buyerId":"AT&T ELine id", 
			 "mtuSize": 1350,
	            "relatedParty":[
	               {
	                  "id":"102",
	                  "name":"Paul Douglas",
	                  "role":"Technical Contact",
	                  "number":"569-544-7789"
	               }
	            ]
	         }
	      },
	      {
	         "id":"3",
	         "action":"add",
	         "productOffering":{
	            "id":"ELINE_EP_UNI_Offering"
	         },
	         "product":{
	            "productSpecification":{
	               "id":"UNICEEndPoint",
	               "describing":{
	                  "@type":"UNICEEndPoint",
	                  "@schemaLocation":" https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/UNICEEndPointSpec.json"
	               }
	            },
	            "cvlanId": [
	      		20
	   		 ],
	            "ingressBWProfile":[
	               {
	                  "cosId":"Gold",
	                  "cir":{
	                     "amount":10,
	                     "unit":"Mbps"
	                  }
	               }
	            ] 
	         },
	         "orderItemRelationship":[
	            {
	               "type":"reliesOn",
	               "id":"1"
	            },
	            {
	               "type":"reliesOn",
	               "id":"2"
	            }
	         ]
	      },
	      {
	         "id":"4",
	         "action":"add",
	         "productOffering":{
	            "id":"ELINE_EP_ENNI_Offering"
	         },
	         "product":{
	            "productSpecification":{
	               "id":"ENNICEEndPoint",
	               "describing":{
	                  "@type":"ENNICEEndPoint",
	                  "@schemaLocation":" https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/ENNICEEndPointSpec.json"
	               }
	            },
	            "svlanId": [
	      	   100
	    		 ],
	            "ingressBWProfile":[
	               {
	                  "cosId":"Gold",
	                  "cir":{
	                     "amount":10,
	                     "unit":"Mbps"
	                  }
	               }
	            ],
	         "productRelationship":[
	            {
	               "type":"reliesOn",
	               "product":{
	                  "id":"ENNI"
	               }
	            }
	         ]
	         },
	         "orderItemRelationship":[
	            {
	               "type":"reliesOn",
	               "id":"2"
	            }
	         ]
	      }
	   ]
	}

Wait for a synchronous response from the server with the following characteristics

- Response Code 201-Created
- Location header set to /productOrder/{zz} where {zz} indicates the identifier assigned by the server to the new productOrder
- Body

    ```
    {
        "id": " zz",
        "externalId": "AT&T-XX",
        "orderDate": "2017-08-29T11:38:21.501Z",
        "state": "acknowledge",
        "requestedCompletionDate": "2017-08-29T11:38:21.501Z",
        "requestedStartDate": "2017-08-29T11:38:21.501Z",
        "completionDate": "",
        "expeditePriority": 0,
        "projectId": "MEF POC",
        "relatedParty": [{
            "id": "100",
            "name": "AT&T",
            "role": "Buyer",
            "number": "455-896-8556"
        }],
        "orderItem": [{
                "id": "1",
                "action": "add",
                "state": "acknowledge",
                "productOffering": {
                    "id": "UNI_Offering"
                },
                "product": {
                    "productSpecification": {
                        "id": "UNISpec",
                        "describing": {
                            "@type": "UNISpec",
                            "@schemaLocation": "https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/UNISpec.json"
                        }
                    },
                    "buyerId": "AT&T UNI id",
                    "physicalLayer": "100BASE-TX ",
                    "numberOfLinks": 1,
                    "maxAggBw": {
                        "amount": 10,
                        "unit": "Mbps"
                    },
                    "relatedParty": [{
                        "id": "101",
                        "name": "Joe Smith",
                        "role": "UNI Site contact ",
                        "number": "0645897425"
                    }],
                    "geographicAddress": [{
                        "id": "1",
                        "role": "UNI Site"
                    }]
                },
                "qualificationRef": [{
                    "id": "xx",
                    "qualificationItem": "1"
                }]
            },
            {
                "id": "2",
                "action": "add",
                "state": "acknowledge",
                "productOffering": {
                    "id": "ELINE_Offering"
                },
                "product": {
                    "productSpecification": {
                        "id": "eLineSpec",
                        "describing": {
                            "@type": "eLineSpec",
                            "@schemaLocation": "https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/ELineSpec.json"
                        }
                    },
                    "buyerId": "AT&T ELine id",
                    "mtuSize": 1350,
                    "relatedParty": [{
                        "id": "102",
                        "name": "Paul Douglas",
                        "role": "Technical Contact",
                        "number": "569-544-7789"
                    }]
                }
            },
            {
                "id": "3",
                "action": "add",
                "state": "acknowledge",
                "productOffering": {
                    "id": "ELINE_EP_UNI_Offering"
                },
                "product": {
                    "productSpecification": {
                        "id": "UNICEEndPoint",
                        "describing": {
                            "@type": "UNICEEndPoint",
                            "@schemaLocation": "https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/UNICEEndPointSpec.json"
                        }
                    },
                    "cvlanId": [
                        20
                    ],
                    "ingressBWProfile": [{
                        "cosId": "Gold",
                        "cir": {
                            "amount": 10,
                            "unit": "Mbps"
                        }
                    }]
                },
                "orderItemRelationship": [{
                        "type": "reliesOn",
                        "id": "1"
                    },
                    {
                        "type": "reliesOn",
                        "id": "2"
                    }
                ]
            },
            {
                "id": "4",
                "action": "add",
                "state": "acknowledge",
                "productOffering": {
                    "id": "ELINE_EP_ENNI_Offering"
                },
                "product": {
                    "productSpecification": {
                        "id": "ENNICEEndPoint",
                        "describing": {
                            "@type": "ENNICEEndPoint",
                            "@schemaLocation": "https://github.com/MEF-GIT/MEF-LSO-Sonata-SDK/blob/master/experimental/api/ProductSpecDescription/Ordering/ENNICEEndPointSpec.json"
                        }
                    },
                    "svlanId": [
                        100
                    ],
                    "ingressBWProfile": [{
                        "cosId": "Gold",
                        "cir": {
                            "amount": 10,
                            "unit": "Mbps"
                        }
                    }]
                },
                "productRelationship": [{
                    "type": "reliesOn",
                    "product": {
                        "id": "ENNI"
                    }
                }],
                "orderItemRelationship": [{
                    "type": "reliesOn",
                    "id": "2"
                }]
            }
        ]
    }
	
### ProductOrder retrieval

In order to get a status on the productOrder delivery progress, you could use a GET operation to retrieve order detail.

send a GET message to /{productOrder/{zz}  with {zz} as the productOrder id (id provided in the POST response.

Wait for a response from the server with the following characteristics
- response Code 200-OK
- The body of the response includes one productOrder resource referring to {zz}. you could check the status at the order level and orderItem level to get update on the delivery progress.
