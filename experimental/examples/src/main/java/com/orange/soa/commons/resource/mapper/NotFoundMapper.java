package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.NotFoundException;
import com.orange.soa.commons.resource.mapper.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException ex) {
		return ErrorResponse.build(ex);
	}
}
