package com.orange.onapbss.serviceproductmapping;


import java.io.Serializable;

public class ServiceOrderProductOrderMappingEntityId implements Serializable {
    protected String serviceOrderId;
    protected String productOrderId;

    public String getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(String serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }
}
