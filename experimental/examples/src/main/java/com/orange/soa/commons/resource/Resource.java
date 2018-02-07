package com.orange.soa.commons.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.orange.soa.commons.json.JsonRepresentation;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @param <T>
 */
public interface Resource<T> {

	public Response create(UriInfo uriInfo, T resource);

	public Response create(UriInfo uriInfo, T resource,
                           JsonRepresentation jsonRepresentation);

	public Response get(UriInfo uriInfo, String id);

	// public T get(UriInfo uriInfo, String id) ;

	public Response get(UriInfo uriInfo, String id,
                        JsonRepresentation jsonRepresentation);

	public Response find(UriInfo uriInfo);

	public Response find(UriInfo uriInfo,
                         JsonRepresentation jsonRepresentation);

	public Response update(UriInfo uriInfo, String id, T resource);

	public Response update(UriInfo uriInfo, String id, T resource,
                           JsonRepresentation jsonRepresentation);

	@Deprecated
	public Response updateWithNotNull(UriInfo uriInfo, String id, T resource);

	@Deprecated
	public Response updateWithNotNull(UriInfo uriInfo, String id, T resource,
                                      JsonRepresentation jsonRepresentation);

	public Response patch(UriInfo uriInfo, String id, JsonNode jsonPatch);

	public Response patch(UriInfo uriInfo, String id, JsonNode jsonPatch,
                          JsonRepresentation jsonRepresentation);

	public Response merge(UriInfo uriInfo, String id,
                          JsonNode jsonPartialTarget);

	public Response merge(UriInfo uriInfo, String id,
                          JsonNode jsonPartialTarget, JsonRepresentation jsonRepresentation);

	public Response diff(UriInfo uriInfo, String id, JsonNode jsonTarget);

	public Response delete(UriInfo uriInfo, String id);
}
