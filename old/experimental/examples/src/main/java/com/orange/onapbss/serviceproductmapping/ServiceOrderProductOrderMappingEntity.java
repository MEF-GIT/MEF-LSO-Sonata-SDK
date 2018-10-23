package com.orange.onapbss.serviceproductmapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@Entity(name = "ServiceProductOrderMappingEntity")
@Table(name = "SERVICE_PRODUCT_ORDER_MAPPING_ENTITY")
@IdClass(ServiceOrderProductOrderMappingEntityId.class)
public class ServiceOrderProductOrderMappingEntity
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @NotNull(message="serviceOrderId must be set")
    protected String serviceOrderId;
    @NotNull(message="productOrderId must be set")
    protected String productOrderId;


    /**
     * Gets the id of the serviceOrder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Id
    @Column(name = "SERVICE_ORDER_ID", length = 100)
    public String getServiceOrderId() {
        return serviceOrderId;
    }


    /**
     * Sets the id of the serviceOrder
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServiceOrderId(String value) {
        this.serviceOrderId = value;
    }


    /**
     * Gets the id of the productorder.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Id
    @Column(name = "PRODUCT_ORDER_ID", length = 100)
    public String getProductOrderId() {
        return productOrderId;
    }

    /**
     * Sets the id of the serviceOrder
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProductOrderId(String value) {
        this.productOrderId = value;
    }



}
