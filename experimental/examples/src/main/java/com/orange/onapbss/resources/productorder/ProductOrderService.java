package com.orange.onapbss.resources.productorder;

import com.orange.onapbss.datamodel.productordering.ProductOrderEntity;
import com.orange.onapbss.datamodel.productordering.StateTypeEntity;
import com.orange.soa.commons.service.Service;
import org.json.simple.JSONObject;

public interface ProductOrderService extends Service<ProductOrderEntity> {
    ProductOrderEntity manageProductOrderStatus(ProductOrderEntity productOrder, JSONObject serviceOrder);

    void updateProductOrderStatus(ProductOrderEntity productOrder, StateTypeEntity productOrderState,StateTypeEntity productOrderItemState);


}
