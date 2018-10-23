package com.orange.soa.commons.jpa.dao;

import com.orange.soa.commons.dao.Dao;
import com.orange.soa.commons.exception.NotFound;
import com.orange.soa.commons.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author maig7313
 * @param <T>
 */
public abstract class JpaDao4StringId<T>
		extends JpaDaoBase<T> implements Dao<T> {

	@PersistenceContext
	private EntityManager em;

	public JpaDao4StringId(Class<T> entityClass) {
		super(entityClass);
	}

	protected abstract JpaRepository<T, String> getRepository();

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public T create(T entity) {
		return this.getRepository().save(entity);
	}

	@Override
	public T update(T entity) {
		return this.getRepository().save(entity);
	}

	@Override
	public T get(String id) throws NotFoundException {
		T entity = this.getRepository().findOne(id);
		if (null == entity) {
			throw new NotFoundException(NotFound.GENERIC);
		}
		return entity;
	}

	@Override
	public List<T> find() {
		return this.getRepository().findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(String id) throws NotFoundException {
		try {
			this.getRepository().delete(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(NotFound.GENERIC);
		}
	}

}
