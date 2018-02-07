package com.orange.soa.commons.dao;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public interface Dao<T> {

	T create(T resource);

	T get(String id);

	List<T> find();

	List<T> find(MultivaluedMap<String, String> criteria);

	T update(T resource);

	void delete(String id);

}
