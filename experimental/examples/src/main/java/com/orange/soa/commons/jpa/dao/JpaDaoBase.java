package com.orange.soa.commons.jpa.dao;

import com.orange.soa.commons.dao.Dao;
import com.orange.soa.commons.exception.BadUsage;
import com.orange.soa.commons.exception.BadUsageException;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public abstract class JpaDaoBase<T> implements Dao<T> {

	protected abstract EntityManager getEntityManager();

	private final Class<T> entityClass;

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaDaoBase.class);

	private static final String CLASS_SUFFIX_EMBEDDED = "Embedded";

	public JpaDaoBase(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public List<T> find(MultivaluedMap<String, String> criteria) {
		List<T> entities = null;

		try {
			entities = this.findByCriteria(criteria);
		} catch (InvalidDataAccessApiUsageException e) {
			LOGGER.warn("Bad criteria", e);
			throw new BadUsageException(BadUsage.SEARCH_QUERY);
		}
		return entities;
	}

	protected List<T> findByCriteria(MultivaluedMap<String, String> criteria) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();

		// build query
		CriteriaQuery<T> query = builder.createQuery(this.entityClass);
		Root<T> root = query.from(this.entityClass);

		// adds predicates, based on criteria
		query = this.buildSearchQuery(builder, query, root, criteria);
		query.select(root);

		// Search query
		TypedQuery<T> tq = this.getEntityManager().createQuery(query);

		// search results
		List<T> res = tq.getResultList();

		// return results
		return res;

	}

	protected <V> CriteriaQuery<T> buildSearchQuery(CriteriaBuilder builder, CriteriaQuery<T> cq, Root<V> root,
			MultivaluedMap<String, String> criteria) {

		Predicate predicate = null;
		List<Predicate> predicates = new ArrayList<>();

		Set<Map.Entry<String, List<String>>> entrySet = criteria.entrySet();
		// building OR predicates (different values for one property)
		for (Map.Entry<String, List<String>> entry : entrySet) {
			String param = entry.getKey();
			Path<?> pathParam = this.getPath(param, root);
			Predicate pTemp = null;
			boolean first = true;

			// Loop values
			for (String value : entry.getValue()) {

				// Is this the first value ?
				if (first) {
					first = false;

					// Is this a list ?
					// Yes
					if (List.class.isAssignableFrom(pathParam.getJavaType())) {
						LOGGER.debug("parameter name: {} , type: List");
						pTemp = this.getPredicateForCollection(value, param, root, builder);

						// No it's not a list
					} else {
						pTemp = this.getPredicateForSingle(value, param, root, builder);
					}
				}

				// No it's not the first value
				else {

					// Is this a list ?
					// Yes
					if (List.class.isAssignableFrom(pathParam.getJavaType())) {
						LOGGER.debug("parameter name: {} , type: List");
						pTemp = builder.and(pTemp, this.getPredicateForCollection(value, param, root, builder));

						// No it's not a list
					} else {
						pTemp = builder.or(pTemp, this.getPredicateForSingle(value, param, root, builder));
					}
				}
			}

			// Add only not null predicate
			if (pTemp != null) {
				predicates.add(pTemp);
			}
		}

		// building AND predicates (different properties)
		boolean firstPredicate = true;
		for (Predicate other : predicates) {
			if (firstPredicate) {
				firstPredicate = false;
				predicate = other;
			} else {
				predicate = builder.and(predicate, other);
			}
		}
		if (predicate != null) {
			cq.where(predicate);
		}

		return cq;

	}

	protected <V> Path<?> getPath(final String name, final Root<V> root) {

		StringTokenizer st = new StringTokenizer(name, ".");
		Path<?> path = null;
		boolean first = true;
		String param = null;
		while (st.hasMoreElements()) {
			param = (String) st.nextElement();
			try {
				if (first) {
					path = this.getIntermediatePath(st, root, param);
					first = false;
				} else {
					path = this.getIntermediatePath(st, path, param);
				}

			} catch (final IllegalArgumentException e) {
				final String errorMessage = String.format("Attribute %s does not exist in entity %s", name,
						this.entityClass.getCanonicalName());
				LOGGER.error(errorMessage, e);
				throw new BadUsageException(BadUsage.SEARCH_QUERY, "Attribute " + name + " does not exist");
			}

		}
		return path;
	}

	/**
	 * @param st
	 * @param path
	 * @param param
	 * @return
	 */
	protected Path<?> getIntermediatePath(final StringTokenizer st, final Path<?> path, final String param) {

		// Is this path an embedded class ?
		Path<?> tmpPath = path.get(param);
		String name = tmpPath.getJavaType().getSimpleName();

		// Yes
		if (name.endsWith(CLASS_SUFFIX_EMBEDDED)) {
			return tmpPath.get((String) st.nextElement());

			// No
		} else {
			if (st.hasMoreElements()) {
				// join with another entity if more elements come after
				return ((From<?, ?>) path).join(param);
			} else {
				return path.get(param);
			}
		}

	}

	/**
	 * Build predicate for single property
	 * 
	 * 
	 * @param value
	 * @param param
	 * @param root
	 * @param builder
	 * @return
	 */
	protected <V> Predicate getPredicateForSingle(final String value, final String param, final Root<V> root,
			CriteriaBuilder builder) {

		Predicate predicate = null;

		Path<?> pathParam = this.getPath(param, root);

		Object object = convertValueToObject(value, pathParam.getJavaType());
		predicate = builder.equal(pathParam, object);

		return predicate;

	}

	/**
	 * Build predicate for collection property, such as List<String> or
	 * List<Enum> etc
	 * 
	 * 
	 * @param value
	 * @param param
	 * @param root
	 * @param builder
	 * @return
	 */
	protected <V> Predicate getPredicateForCollection(final String value, final String param, final Root<V> root,
			CriteriaBuilder builder) {

		Predicate predicate = null;
		Field field;

		try {

			// Retrieve field from Java Type
			field = root.getJavaType().getDeclaredField(param);
			Type listType = field.getGenericType();
			Type argType;

			if (listType instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) listType;

				// Only one arg List ex List<String>
				if (pt.getActualTypeArguments().length > 0) {
					argType = pt.getActualTypeArguments()[0];
					LOGGER.debug("First arg type: " + argType);

					// Should be always true, works also for Enum
					if (argType instanceof Class) {

						// Expression
						Path<?> pathParam = this.getPath(param, root);
						Expression<Collection<Object>> properties = (Expression) pathParam;

						// Get value as Object
						@SuppressWarnings("unchecked")
						Class<?> clazz = (Class<?>) argType;
						Object object = this.convertValueToObject(value, clazz);

						// Predicate
						predicate = builder.isMember(object, properties);
					}
				}
			}

		} catch (NoSuchFieldException | SecurityException e) {
			LOGGER.warn("unable to search in " + param + " values of " + root.getJavaType());
		}

		return predicate;
	}
	

	// safe Enum.valueOf without exception
	private Enum safeEnumValueOf(Class enumType, String value) {
		Enum matchedEnum = null;
		if (value != null) {
			try {
				List<Enum> enums = EnumUtils.getEnumList(enumType);
				for (Enum c : enums) {
					if (c.toString().equalsIgnoreCase(value)) {
						return c;
					}
				}
			} catch (Exception e) {
				matchedEnum = null;
			}
		}
		return matchedEnum;
	}

	@SuppressWarnings("unchecked")
	private <E extends Enum<E>, C> Object convertValueToObject(final String value, final Class<C> clazz)
			throws BadUsageException {
		Object convertedValue = null;

		// Enum
		if (clazz.isEnum()) {
			convertedValue = safeEnumValueOf((Class<E>) clazz, value);
			// boolean
		} else if (clazz.equals(boolean.class)) {
			convertedValue = Boolean.valueOf(value);
			// primitive
		} else if ((clazz.isPrimitive() && !clazz.equals(boolean.class)) || (Number.class.isAssignableFrom(clazz))) {
			try {
				convertedValue = NumberFormat.getInstance().parse(value);
			} catch (final ParseException ex) {
				convertedValue = null;
			}
		} else {
			convertedValue = value;
		}

		if (convertedValue != null) {
			return convertedValue;
		} else {
			throw new BadUsageException(BadUsage.FORMAT, "Wrong format for value " + value);
		}

	}	

}
