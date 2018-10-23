package com.orange.onapbss.serviceproductmapping;

import com.orange.soa.commons.jpa.dao.JpaDao4StringId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("serviceProductOrderDao")
public class ServiceOrderProductOrderMappingDaoImpl extends JpaDao4StringId<ServiceOrderProductOrderMappingEntity> {

    @Autowired
    private ServiceOrderProductOrderMappingRepository serviceOrderProductOrderMappingRepository;

    public ServiceOrderProductOrderMappingDaoImpl() {
        super(ServiceOrderProductOrderMappingEntity.class);
    }

    @Override
    protected ServiceOrderProductOrderMappingRepository getRepository() {
        return serviceOrderProductOrderMappingRepository;
    }

}
