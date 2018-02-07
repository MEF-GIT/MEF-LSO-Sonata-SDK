/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.soa.commons.service;

import com.orange.soa.commons.dao.Dao;
import com.orange.soa.commons.service.Service;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

/**
 *
 */
public abstract class ServiceBase<R> implements Service<R> {

	protected abstract Dao<R> getDao();

	@Override
	public R create(R resource) {
		this.setId(resource);
		return this.getDao().create(resource);
	}

	@Override
	public R get(String id) {
		return this.getDao().get(id);
	}

	@Override
	public List<R> find() {
		return this.getDao().find();
	}

	@Override
	public List<R> find(MultivaluedMap<String, String> criteria) {
		return this.getDao().find(criteria);
	}

	@Override
	public R update(R resource) {
		return this.getDao().update(resource);
	}

	@Override
	public void delete(final String id) {
		this.getDao().delete(id);
	}

}
