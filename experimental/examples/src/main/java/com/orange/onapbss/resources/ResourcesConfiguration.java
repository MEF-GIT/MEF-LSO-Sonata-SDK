package com.orange.onapbss.resources;

import com.orange.onapbss.resources.addressvalidation.AddressValidationResourceImpl;
import com.orange.onapbss.resources.addressvalidation.AdminAddressValidationResourceImpl;
import com.orange.onapbss.resources.productofferingq.ProductOfferingQualificationResourceImpl;
import com.orange.soa.commons.resource.JerseyJaxbConfiguration;
import com.orange.onapbss.resources.productorder.ProductOrderResourceImpl;
import com.orange.onapbss.resources.status.StatusResourceImpl;

import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v1")
public class ResourcesConfiguration extends JerseyJaxbConfiguration {

	public ResourcesConfiguration() {
		super();
                this.register(JacksonExcludeFields.class);
                this.register(ProductOrderResourceImpl.class);
				this.register(ProductOfferingQualificationResourceImpl.class);
				this.register(AddressValidationResourceImpl.class);
				this.register(AdminAddressValidationResourceImpl.class);
				this.register(StatusResourceImpl.class);
	}
}
