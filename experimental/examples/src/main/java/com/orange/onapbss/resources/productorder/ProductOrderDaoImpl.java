package com.orange.onapbss.resources.productorder;

import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.soa.commons.jpa.dao.JpaDao4StringId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Component("productOrderDao")
public class ProductOrderDaoImpl extends JpaDao4StringId<ProductOrderEntity> {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public ProductOrderDaoImpl() {
        super(ProductOrderEntity.class);
    }

    @Override
    protected ProductOrderRepository getRepository() {
        return productOrderRepository;
    }

}
