package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.FunctionalException;
import com.orange.soa.commons.resource.mapper.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FunctionalMapper implements ExceptionMapper<FunctionalException> {

	@Override
	public Response toResponse(FunctionalException ex) {
		return ErrorResponse.build(ex);
	}
}
