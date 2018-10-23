/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.soa.commons.resource.mapper;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.orange.soa.commons.exception.BadUsage;
import com.orange.soa.commons.resource.mapper.JsonError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonMappingMapper
		implements ExceptionMapper<JsonMappingException> {
	@Override
	public Response toResponse(JsonMappingException ex) {
		com.orange.soa.commons.resource.mapper.JsonError error = new JsonError(BadUsage.UNKNOWN_VALUE.getValue(),
				ex.getMessage());
		return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
				.entity(error).type(MediaType.APPLICATION_JSON).build();
	}
}
