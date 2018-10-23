package com.orange.soa.commons.resource;

import com.orange.soa.commons.resource.JacksonJaxbFormatProvider;
import com.orange.soa.commons.resource.mapper.*;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public abstract class JerseyJaxbConfiguration extends ResourceConfig {

	public JerseyJaxbConfiguration() {

		register(JacksonFeature.class);
		
		register(JacksonJaxbFormatProvider.class);

		register(BadUsageMapper.class);
		register(FunctionalMapper.class);
		register(JsonMappingMapper.class);
		register(NotFoundMapper.class);
		register(TechnicalMapper.class);
		register(UnauthorizedMapper.class);
		register(UnhandledMapper.class);

	}

}
