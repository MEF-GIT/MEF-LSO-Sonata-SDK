package com.orange.soa.commons.service;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

/**
 *
 */
public interface Service<R> {

	String getId(R resource);
	
	void setId(R resource);

	R create(R resource);

	R get(String id);

	List<R> find();

	List<R> find(MultivaluedMap<String, String> criteria);

	R update(R resource);

	void delete(String id);

}
