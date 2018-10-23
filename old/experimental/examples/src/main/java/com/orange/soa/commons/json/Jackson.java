package com.orange.soa.commons.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.diff.JsonDiff;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.orange.soa.commons.exception.BadUsage;
import com.orange.soa.commons.exception.BadUsageException;
import com.orange.soa.commons.exception.Technical;
import com.orange.soa.commons.exception.TechnicalException;
import com.orange.soa.commons.json.JsonRepresentation;
import com.orange.soa.commons.service.EditionPolicy;
import com.orange.soa.commons.utils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

public class Jackson {

	private final static List<String> SKIPPED_FIELDS = Arrays
			.asList("internalId");
	
	
	public static <R> List<ObjectNode> createNodes(List<R> list,
                                                   com.orange.soa.commons.json.JsonRepresentation jsonRepresentation) {

		Set<R> set;
		if (list == null) {
			set = new LinkedHashSet<>();
		} else {
			set = new LinkedHashSet<>(list);
		}
		return createNodes(set, jsonRepresentation);
	}

	public static <R> List<ObjectNode> createNodes(Collection<R> collection,
                                                   com.orange.soa.commons.json.JsonRepresentation jsonRepresentation) {
		List<ObjectNode> nodeList = new ArrayList<>();
		for (R element : collection) {
			ObjectNode node = createNode(element, jsonRepresentation);
			nodeList.add(node);
		}
		return nodeList;
	}

	public static <R> ObjectNode createNode(R bean,
                                            JsonRepresentation jsonRepresentation) {
		ObjectMapper mapper = new ObjectMapper();
		return createNode(mapper, bean,
				jsonRepresentation.getAttributes());
	}

	private static <R> ObjectNode createNode(ObjectMapper mapper, R bean,
                                             Set<String> names) {
		// split fieldNames in 2 categories :
		// simpleFields for simple property names with no '.'
		// nestedFields for nested property names with a '.'
		Set<String> simpleFields = new LinkedHashSet<String>();
		MultivaluedStringMap nestedFields = new MultivaluedStringMap();
		for (String name : names) {
			int index = name.indexOf('.');
			boolean isNestedField = (index > 0) && (index < name.length());
			if (isNestedField) {
				String rootFieldName = name.substring(0, index);
				String subFieldName = name.substring(index + 1);
				nestedFields.add(rootFieldName, subFieldName);
			}
			else {
				simpleFields.add(name);
			}
		}

		// create a simple node with only one level containing all simples
		// properties
		ObjectNode rootNode = createNodeWithSimpleFields(mapper, bean,
				simpleFields);

		// create nested nodes with deeper levels
		Set<Map.Entry<String, List<String>>> entrySet = nestedFields.entrySet();
		// for each nested value, create recursively a node
		for (Map.Entry<String, List<String>> entry : entrySet) {
			String rootFieldName = entry.getKey();
			// add in current node only if full value is not already present in
			// 1st level
			if (!simpleFields.contains(rootFieldName)) {
				Object nestedBean = BeanUtils.getNestedProperty(bean,
						rootFieldName);
				// add only non null fields
				if (nestedBean == null) {
					continue;
				}
				Set<String> nestedFieldNames = new LinkedHashSet<String>(
						entry.getValue());
				// current node is an array or a list
				if ((nestedBean.getClass().isArray()) || (Collection.class
						.isAssignableFrom(nestedBean.getClass()))) {
					Object[] array = null;
					if ((nestedBean.getClass().isArray())) {
						array = (Object[]) nestedBean;
					}
					else {
						Collection<?> collection = (Collection<?>) nestedBean;
						array = collection.toArray();
					}
					if (array.length > 0) {
						// create a node for each element in array
						// and add created node in an arrayNode
						Collection<JsonNode> nodes = new LinkedList<JsonNode>();
						for (Object object : array) {
							ObjectNode nestedNode = createNode(mapper,
									object, nestedFieldNames);
							if ((nestedNode != null)
									&& (nestedNode.size() > 0)) {
								nodes.add(nestedNode);
							}
						}
						ArrayNode arrayNode = mapper.createArrayNode();
						arrayNode.addAll(nodes);
						if (arrayNode.size() > 0) {
							rootNode.set(rootFieldName, arrayNode);
						}
					}
				}
				else {
					// create recursively a node and add it in current root node
					ObjectNode nestedNode = createNode(mapper,
							nestedBean, nestedFieldNames);
					if ((nestedNode != null) && (nestedNode.size() > 0)) {
						rootNode.set(rootFieldName, nestedNode);
					}
				}
			}
		}
		return rootNode;
	}

	private static <R> ObjectNode createNodeWithSimpleFields(
            ObjectMapper mapper, R bean, Set<String> names) {
		ObjectNode node = mapper.createObjectNode();
		for (String name : names) {
			// Prevent getting value of some fields
			if (SKIPPED_FIELDS.contains(name)) {
				continue;
			}

			nodePut(node, name,
					BeanUtils.getNestedProperty(bean, name));
		}
		return node;
	}

	private static void nodePut(ObjectNode node, String name, Object value) {
		if (value instanceof Boolean) {
			node.put(name, (Boolean) value);
		}
		else if (value instanceof Integer) {
			node.put(name, (Integer) value);
		}
		else if (value instanceof Long) {
			node.put(name, (Long) value);
		}
		else if (value instanceof Float) {
			node.put(name, (Float) value);
		}
		else if (value instanceof Double) {
			node.put(name, (Double) value);
		}
		else if (value instanceof BigDecimal) {
			node.put(name, (BigDecimal) value);
		}
		else if (value instanceof String) {
			node.put(name, (String) value);
		}
		else {
			node.putPOJO(name, value);
		}
	}

	public static <B> JsonNode diff(B currentBean, final JsonNode targetNode,
                                    final EditionPolicy editionPolicy) {

		// Check if all required fields are provided
		final List<String> missingFields = getMissingRequiredFields(targetNode,
				editionPolicy.getWhiteList());
		if (!missingFields.isEmpty()) {
			throw new BadUsageException(BadUsage.MANDATORY_FIELDS,
					MessageFormat.format(
							"The JSON patch must provide those fields : {0}",
							missingFields));
		}

		final ObjectMapper mapper = new ObjectMapper();

		// Marshall bean to patch
		final JsonNode currentNode = mapper.convertValue(currentBean,
				JsonNode.class);

		// Create JSON Patch with diff between target and source nodes
		final JsonNode jsonPatch = JsonDiff.asJson(currentNode, targetNode);

		final JsonNode filteredJsonPatch = filterJsonPatch(jsonPatch,
				editionPolicy);

		return filteredJsonPatch;

	}

	private static <B> B patch(B currentBean, final JsonNode jsonPatchNode,
                               final EditionPolicy editionPolicy, final boolean filterJsonPatch) {

		final ObjectMapper mapper = new ObjectMapper();

		// Marshall bean to patch
		final JsonNode currentNode = mapper.convertValue(currentBean,
				JsonNode.class);

		// Filter JSON Patch
		JsonNode filteredJsonPatch = jsonPatchNode;
		if (filterJsonPatch) {
			filteredJsonPatch = filterJsonPatch(jsonPatchNode, editionPolicy);
		}

		try {
			// Transform JSON Patch format and apply it to the current bean as
			// JSON
			final JsonPatch jsonPatch = JsonPatch.fromJson(filteredJsonPatch);
			final JsonNode patchedNode = jsonPatch.apply(currentNode);

			// Unmarshall JSON to new bean
			return mapper.reader(currentBean.getClass()).readValue(patchedNode);
		}
		catch (final JsonPatchException | IOException e) {
			throw new TechnicalException(Technical.GENERIC,
					MessageFormat.format(
							"Unable to patch JSON, original error is : {0}",
							e.getMessage()));
		}
	}

	public static <B> B patch(B currentBean, final JsonNode jsonPatchNode,
			final EditionPolicy editionPolicy) {
		return patch(currentBean, jsonPatchNode, editionPolicy, true);
	}

	public static <B> B merge(B currentBean, final JsonNode targetNode,
			final EditionPolicy editionPolicy) {
		return patch(currentBean, diff(currentBean, targetNode, editionPolicy),
				null, false);
	}

	private static List<String> getMissingRequiredFields(final JsonNode node,
			final Map<String, Set<String>> whiteList) {

		final List<String> missingFields = new ArrayList<>();

		// Iterate over each allowed property
		for (final String property : whiteList.keySet()) {
			final Iterator<String> fieldNames = node.fieldNames();
			boolean found = false;

			// Check if property is part of the JSON fields
			while (fieldNames.hasNext() && !found) {
				if (property.equals(fieldNames.next())) {
					found = true;
				}
			}

			if (!found) {
				missingFields.add(property);
			}
		}

		return missingFields;
	}

	private static JsonNode filterJsonPatch(final JsonNode jsonPatch,
                                            final EditionPolicy editionPolicy) {

		// Rewrite allowed properties to path format (format "a.b.c" to
		// "/a/b/c")
		final Map<String, Set<String>> whiteListCopy = new HashMap<>(
				editionPolicy.getWhiteList());
		for (final String property : editionPolicy.getWhiteList().keySet()) {
			final String path = "/" + StringUtils.replace(property, ".", "/");
			whiteListCopy.put(path, whiteListCopy.remove(property));
		}

		// Only keep nodes relative to an allowed property and its allowed
		// operations
		final List<JsonNode> filteredNodes = Lists.newArrayList(
				Iterables.filter(ImmutableList.copyOf(jsonPatch.elements()),
						new Predicate<JsonNode>() {

							@Override
							public boolean apply(final JsonNode node) {
								// Rewrite path of JSON nodes representing an
								// array, by
								// removing
								// their last "/-" or "/[number]"
								final String rewrittenPath = node.get("path")
										.textValue()
										.replaceFirst("/\\d+$|/-$", "");

								// Does the rewritten path starts with one of
								// the
								// properties ?
								final String propertyMatch = Iterables.find(
										whiteListCopy.keySet(),
										new Predicate<String>() {

											@Override
											public boolean apply(
													final String property) {
												return StringUtils.startsWith(
														rewrittenPath,
														property);
											}
										}, null);

								// If so, check if the operation of the node is
								// allowed
								// for this
								// property
								boolean keepNode = false;
								if (propertyMatch != null) {
									keepNode = whiteListCopy.get(propertyMatch)
											.contains(
													node.get("op").textValue());
								}

								return keepNode;
							}
						}));

		// Create new JSON Patch node from them
		return new ObjectMapper().createArrayNode().addAll(filteredNodes);
	}

}
