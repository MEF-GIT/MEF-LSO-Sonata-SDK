package com.orange.onapbss.serviceproductmapping;

import com.orange.soa.commons.dao.Dao;
import com.orange.soa.commons.service.ServiceBase;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Service("serviceOrderProductOrderService")
public class ServiceOrderProductOrderServiceImpl extends ServiceBase<ServiceOrderProductOrderMappingEntity> implements ServiceOrderProductOrderService {


    private static final Logger LOGGER = LoggerFactory
            .getLogger(ServiceOrderProductOrderServiceImpl.class);

    @Autowired
    private Dao<ServiceOrderProductOrderMappingEntity> serviceOrderProductOrderMappingEntityDao;

    @Override
    public String getId(ServiceOrderProductOrderMappingEntity resource) {
        return resource.getProductOrderId() + resource.getServiceOrderId();
    }

    @Override
    protected Dao<ServiceOrderProductOrderMappingEntity> getDao() {
        return this.serviceOrderProductOrderMappingEntityDao;
    }

    @Override
    public void setId(ServiceOrderProductOrderMappingEntity resource) {
    }


    public String getServiceOrderId(String productOrderId) {
        MultivaluedMap<String, String> params = new MultivaluedHashMap<>();
        params.add("productOrderId", productOrderId);

        List<ServiceOrderProductOrderMappingEntity> serviceOrderProductOrderMappingEntities = this.find(params);
        // on est censé en avoir 1 et 1 seul
        if (CollectionUtils.isEmpty(serviceOrderProductOrderMappingEntities) || serviceOrderProductOrderMappingEntities.size() > 1) {
            LOGGER.error("Unable to get the serviceorder Id from productorderId" + productOrderId);
            return null;
        }
        return serviceOrderProductOrderMappingEntities.get(0).getServiceOrderId();
    }

}
