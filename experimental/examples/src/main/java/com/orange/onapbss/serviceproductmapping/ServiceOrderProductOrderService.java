package com.orange.onapbss.serviceproductmapping;

import com.orange.soa.commons.service.Service;

public interface ServiceOrderProductOrderService extends Service<ServiceOrderProductOrderMappingEntity> {
    String getServiceOrderId(String productOrderId);

}
