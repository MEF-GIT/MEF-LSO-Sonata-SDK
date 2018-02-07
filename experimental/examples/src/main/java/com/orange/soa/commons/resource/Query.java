package com.orange.soa.commons.resource;

import com.orange.soa.commons.json.JsonRepresentation;
import com.orange.soa.commons.utils.URIParserUtils;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

public class Query {

	private MultivaluedMap<String, String> criteria;

	private JsonRepresentation jsonRepresentation;

	public Query(UriInfo uriInfo) {
		this.criteria = new MultivaluedHashMap<String, String>(
				uriInfo.getQueryParameters());
		this.jsonRepresentation = new JsonRepresentation(
				URIParserUtils.getFields(criteria));
	}

	public MultivaluedMap<String, String> getQueryParameters() {
		return criteria;
	}

	public JsonRepresentation getRepresentation() {
		return jsonRepresentation;
	}

}
