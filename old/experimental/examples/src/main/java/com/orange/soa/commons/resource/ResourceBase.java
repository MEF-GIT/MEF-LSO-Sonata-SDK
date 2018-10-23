package com.orange.soa.commons.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.orange.soa.commons.exception.*;
import com.orange.soa.commons.json.Jackson;
import com.orange.soa.commons.json.JsonRepresentation;
import com.orange.soa.commons.json.MappingTable;
import com.orange.soa.commons.resource.Query;
import com.orange.soa.commons.resource.Resource;
import com.orange.soa.commons.service.EditionPolicy;
import com.orange.soa.commons.service.Service;
import com.orange.soa.commons.utils.URIParserUtils;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author user
 *
 * @param <T>
 */
public abstract class ResourceBase<T extends Object> implements Resource<T> {

	private static final org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(com.orange.soa.commons.resource.ResourceBase.class);

	protected abstract Service<T> getService();

	// Override if necessary
	protected MappingTable getMappingTable() {
		return new MappingTable();
	}

	protected EditionPolicy getEditionPolicy() {
		LOGGER.warn(
				"You seem to use merge/diff/patch operations using default editionPolicy which doesn't allow any modification, override getEditionPolicy with your own policy to allow modifications");
		return new EditionPolicy();
	}

	@Override
	public Response create(final UriInfo uriInfo, final T resource,
			final JsonRepresentation jsonRepresentation) {

		// Delegates to the business layer the resource creation
		this.getService().create(resource);

		return this.getResponse201(uriInfo, resource, jsonRepresentation);
	}

	@Override
	public Response create(final UriInfo uriInfo, final T resource) {

		Query query = new Query(uriInfo);

		return this.create(uriInfo, resource, query.getRepresentation());
	}

	@Override
	public Response get(final UriInfo uriInfo, final String id,
			final JsonRepresentation jsonRepresentation) {

		// Get entity
		T resource = this.getService().get(id);

		// Get representation
		final Object entity = this.getEntity(resource, jsonRepresentation);

		return Response.ok(entity).build();
	}

	@Override
	public Response get(final UriInfo uriInfo, final String id) {

		Query query = new Query(uriInfo);

		return this.get(uriInfo, id, query.getRepresentation());
	}

	/**
	 * As multivalue map parameters is immutable, you must extract
	 * queryParameters, use public find operation
	 * 
	 * @param uriInfo
	 * @param fields
	 * @param queryParameters
	 * @return
	 */
	private Response find(final UriInfo uriInfo,
			final JsonRepresentation jsonRepresentation,
			MultivaluedMap<String, String> queryParameters) {

		// extract criteria
		MultivaluedMap<String, String> criteria = URIParserUtils
				.extractCriteria(queryParameters);

		// change criteria names with known mapping
		this.getMappingTable().getRows()
				.forEach((oldCriterionName, newCriterionName) -> {
					List<String> criterionValues = criteria
							.get(oldCriterionName);
					if (criterionValues != null) {
						criteria.remove(oldCriterionName);
						criteria.put(newCriterionName, criterionValues);
					}
				});

		Set<Object> resultList = (Set<Object>) this.findByCriteria(criteria);

		// Get representation
		Object entities = this.getEntities(resultList, jsonRepresentation);

		return Response.ok(entities).build();
	}

	@Override
	public Response find(final UriInfo uriInfo,
			final JsonRepresentation jsonRepresentation) {

		Query query = new Query(uriInfo);

		return this.find(uriInfo, jsonRepresentation,
				query.getQueryParameters());

	}

	@Override
	public Response find(final UriInfo uriInfo) {

		Query query = new Query(uriInfo);

		return this.find(uriInfo, query.getRepresentation(),
				query.getQueryParameters());
	}

	@Override
	public Response update(final UriInfo uriInfo, final String id,
			final T resource, final JsonRepresentation jsonRepresentation) {

		T updatedResource = this.getService().update(resource);
                
                // Get representation
		final Object entity = this.getEntity(updatedResource, jsonRepresentation);

		return Response.ok(entity).build();
	}

	@Override
	public Response update(final UriInfo uriInfo, final String id,
			final T resource) {

		Query query = new Query(uriInfo);

		return this.update(uriInfo, id, resource, query.getRepresentation());

	}

	@Override
	public Response updateWithNotNull(final UriInfo uriInfo, final String id,
			final T resource, final JsonRepresentation jsonRepresentation) {
		T resourceToUpdate = this.getService().get(id);
		// copy all non null field from source to the updated source
		final String resourceId = this.getService().getId(resource);
		if ((resourceId != null) && !id.equals(resourceId)) {
			throw new FunctionalException(Functional.GENERIC,
					"Path id is not the same as source id");
		}
		T updatedResource = null;
		try {
			updatedResource = this.copyNonNullProperties(resource,
					resourceToUpdate);
			this.getService().update(updatedResource);
		}
		catch (Exception ex) {
			LOGGER.error("Can't update resource properties", ex);
			throw new TechnicalException(Technical.GENERIC,
					"Can't update resource properties");
		}

		                // Get representation
		final Object entity = this.getEntity(updatedResource, jsonRepresentation);

		return Response.ok(entity).build();
	}

	@Override
	public Response updateWithNotNull(final UriInfo uriInfo, final String id,
			final T resource) {

		Query query = new Query(uriInfo);

		return this.updateWithNotNull(uriInfo, id, resource,
				query.getRepresentation());

	}

	@Override
	public Response merge(final UriInfo uriInfo, final String id,
			final JsonNode jsonPartialTarget) {

		Query query = new Query(uriInfo);

		return this.merge(uriInfo, id, jsonPartialTarget,
				query.getRepresentation());
	}

	@Override
	public Response merge(final UriInfo uriInfo, final String id,
			final JsonNode jsonPartialTarget,
			JsonRepresentation jsonRepresentation) {

		// Check if id of the resource to patch is present
		if (id == null) {
			throw new BadUsageException(BadUsage.GENERIC,
					"Target id cannot be null or empty");
		}

		// Check if ids match
		final JsonNode idNode = jsonPartialTarget.get("id");
		final String partialResourceId = (idNode == null ? null
				: idNode.textValue());
		if (partialResourceId != null && !partialResourceId.equals(id)) {
			throw new BadUsageException(BadUsage.GENERIC,
					"Target id and resource representation id do not match");
		}

		// Get resource to patch
		T currentResource = this.getService().get(id);

		// Patch resource
		EditionPolicy editionPolicy = this.getEditionPolicy();
		currentResource = Jackson.merge(currentResource, jsonPartialTarget,
				editionPolicy);

		T patchedResource = this.getService().update(currentResource);
                
                // Get representation
		final Object entity = this.getEntity(patchedResource, jsonRepresentation);

		return Response.ok(entity).build();
	}

	@Override
	public Response diff(final UriInfo uriInfo, final String id,
			final JsonNode jsonTarget) {

		final T currentResource = this.getService().get(id);
		final JsonNode jsonPatch = Jackson.diff(currentResource, jsonTarget,
				this.getEditionPolicy());
		return Response.ok(jsonPatch).build();
	}

	@Override
	public Response patch(final UriInfo uriInfo, String id,
			final JsonNode jsonPatch) {

		Query query = new Query(uriInfo);

		return this.patch(uriInfo, id, jsonPatch, query.getRepresentation());

	}

	@Override
	public Response patch(final UriInfo uriInfo, String id,
			final JsonNode jsonPatch,
			final JsonRepresentation jsonRepresentation) {

		// Get resource to patch
		T currentResource = this.getService().get(id);

		// Patch resource
		currentResource = Jackson.patch(currentResource, jsonPatch,
				this.getEditionPolicy());

		// Commit changes in database
		T patchedResource = this.getService().update(currentResource);
                
                                // Get representation
		final Object entity = this.getEntity(patchedResource, jsonRepresentation);

		return Response.ok(entity).build();
	}

	protected T copyNonNullProperties(T source, T target)
			throws IntrospectionException, InvocationTargetException,
			IllegalAccessException {
		BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Method readMethod = propertyDescriptor.getReadMethod();
			if (readMethod != null) {
				if (!Modifier.isPublic(
						readMethod.getDeclaringClass().getModifiers())) {
					readMethod.setAccessible(true);
				}
				Object value = readMethod.invoke(source);
				if (null != value) {
					Method writeMethod = propertyDescriptor.getWriteMethod();
					if (writeMethod != null) {
						if (!Modifier.isPublic(writeMethod.getDeclaringClass()
								.getModifiers())) {
							writeMethod.setAccessible(true);
						}
						writeMethod.invoke(target, value);
					}
					else if (value instanceof List) {
						List<?> dest = (List<?>) readMethod.invoke(target);
						dest.clear();
						dest.addAll((List) value);
					}
				}
			}
		}
		return target;
	}

	@Override
	public Response delete(final UriInfo uriInfo, String id) {
		this.getService().delete(id);
		return this.getResponse204();
	}

	/**
	 * Get entity, as resource or jacksonNode depending fields value
	 * 
	 * @param resource
	 * @param fields
	 * @return
	 */
	protected Object getEntity(final Object resource,
			JsonRepresentation jsonRepresentation) {

		Object entity;

		Set<String> attributes = jsonRepresentation.getAttributes();

		if (attributes == null || attributes.isEmpty()
				|| attributes.contains(URIParserUtils.ALL_FIELDS)) {
			entity = resource;
		}
		else {
			entity = Jackson.createNode(resource, jsonRepresentation);
		}

		return entity;
	}

	protected Object getEntity(final Object resource, final UriInfo uriInfo) {

		Query query = new Query(uriInfo);

		return this.getEntity(resource, query.getRepresentation());
	}
	

	/**
	 * Get entities, as resource list or jacksonNode depending fields value
	 * 
	 * @param resources
	 * @param fields
	 * @return
	 */
	protected Object getEntities(final Set<Object> resources,
			JsonRepresentation jsonRepresentation) {

		Object entities;

		Set<String> attributes = jsonRepresentation.getAttributes();

		if (attributes == null || attributes.isEmpty()
				|| attributes.contains(URIParserUtils.ALL_FIELDS)) {
			entities = resources;
		}
		else {
			entities = Jackson.createNodes(resources, jsonRepresentation);
		}

		return entities;
	}
	
	/**
	 * Build 200 filtered response for a single resource
	 * 
	 * @param resource
	 * @param jsonRepresentation
	 * @return
	 */
	protected Response getResponse200(final Object resource,
			final JsonRepresentation jsonRepresentation) {

		// Get representation
		final Object entity = this.getEntity(resource, jsonRepresentation);

		return Response.ok(entity).build();
	}
	
	/**
	 * Build 200 filtered response for collection
	 * 
	 * @param resource
	 * @param jsonRepresentation
	 * @return
	 */	
	protected Response getResponse200 (final Set<Object> resources,
			JsonRepresentation jsonRepresentation) {

		// Get representation
		final Object entities = this.getEntities(resources, jsonRepresentation);

		return Response.ok(entities).build();
	}	

	/**
	 * Build default 201 filtered response for root resource
	 * 
	 * @param uriInfo
	 * @param resource
	 * @param jsonRepresentation
	 * @return
	 */
	protected Response getResponse201(final UriInfo uriInfo, final T resource,
			final JsonRepresentation jsonRepresentation) {

		final UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		final URI uri = ub
				.path(String.valueOf(this.getService().getId(resource)))
				.build();

		// Get entity representation
		final Object entity = this.getEntity(resource, jsonRepresentation);

		return Response.created(uri).entity(entity).build();
	}
	
	/**
	 * Build 201 filtered response with custom path, useful for sub resource or non relative resource
	 * 
	 * @param uriInfo
	 * @param resource
	 * @param resourcePath a relative path from base path
	 * @param jsonRepresentation
	 * @return
	 */
	protected Response getResponse201(
			final UriInfo uriInfo, final Object resource,
			final String resourcePath,
			final JsonRepresentation jsonRepresentation) {
		
		final UriBuilder ub = uriInfo.getBaseUriBuilder();
		final URI uri = ub.path(resourcePath).build();

		// Serialize entity
		final ObjectNode json = Jackson.createNode(resource, jsonRepresentation);

		return Response.created(uri).entity(json).build();
	}
	
	/**
	 * Build 204 Empty response
	 * 
	 * @param resource
	 * @param jsonRepresentation
	 * @return
	 */	
	protected Response getResponse204 () {		

		return Response.status(Response.Status.NO_CONTENT).build();
	}	

	/**
	 * return Set of unique elements to avoid List with same elements in case of
	 * join
	 * 
	 * @param criteria
	 * @return
	 */
	private Set<T> findByCriteria(MultivaluedMap<String, String> criteria) {

		List<T> resultList = null;
		if ((criteria != null) && !criteria.isEmpty()) {
			resultList = this.getService().find(criteria);
		}
		else {
			resultList = this.getService().find();
		}
		
		return this.convertList(resultList);

	}
	
	/**
	 * Convert list to set
	 */
	public Set<T> convertList(List<T> list) {
		if (list == null) {
			return new LinkedHashSet<>();
		} else {
			return new LinkedHashSet<>(list);
		}
	}

}
