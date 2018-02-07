package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.UnauthorizedException;
import com.orange.soa.commons.resource.mapper.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorizedMapper
		implements ExceptionMapper<UnauthorizedException> {

	@Override
	public Response toResponse(UnauthorizedException ex) {
		return ErrorResponse.build(ex);
	}
}
