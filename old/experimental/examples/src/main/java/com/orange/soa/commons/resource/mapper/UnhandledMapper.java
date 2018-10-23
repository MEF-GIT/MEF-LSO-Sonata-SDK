package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.Technical;
import com.orange.soa.commons.resource.mapper.JsonError;
import org.glassfish.jersey.spi.ExtendedExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class UnhandledMapper implements ExtendedExceptionMapper<Throwable> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(com.orange.soa.commons.resource.mapper.UnhandledMapper.class);

	@Override
	public Response toResponse(Throwable exception) {
		LOGGER.error(
				"Code RED, this is an unhandled error, you have to fix your code, see below:",
				exception);
		com.orange.soa.commons.resource.mapper.JsonError error = new JsonError(Technical.GENERIC.getValue(),
				"We re sorry, things went very bad, help us by providing some feedback about the context, please contact us");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(error).type(MediaType.APPLICATION_JSON).build();
	}

	@Override
	public boolean isMappable(Throwable throwable) {
		return !(throwable instanceof WebApplicationException);
	}

}
