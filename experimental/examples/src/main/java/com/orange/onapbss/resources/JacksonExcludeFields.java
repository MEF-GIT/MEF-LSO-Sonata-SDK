package com.orange.onapbss.resources;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.soa.commons.resource.JacksonJaxbFormatProvider;

@Provider
public class JacksonExcludeFields implements ContextResolver<ObjectMapper> {

	
	private static JacksonJaxbFormatProvider jfp = new JacksonJaxbFormatProvider();
//	@Autowired
//	private static JacksonFormatProvider jfp;
	

	@Override
	public ObjectMapper getContext(final Class<?> type) {
		ObjectMapper mapper = jfp.getContext(type);


		// no null or empty collection
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		mapper.addMixIn(Object.class,MixIn.class);  

		return mapper;
	}

}
