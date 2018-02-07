package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.ApiException;
import com.orange.soa.commons.resource.mapper.JsonError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author maig7313
 */
public class ErrorResponse {

	private ErrorResponse() {

	}

	public final static Response build(ApiException ex) {
		JsonError error = new JsonError(ex);
		return Response.status(ex.getCategory()).entity(error)
				.type(MediaType.APPLICATION_JSON).build();
	}

}
