package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.BadUsageException;
import com.orange.soa.commons.resource.mapper.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadUsageMapper implements ExceptionMapper<BadUsageException> {

	@Override
	public Response toResponse(BadUsageException ex) {
		return ErrorResponse.build(ex);
	}

}
