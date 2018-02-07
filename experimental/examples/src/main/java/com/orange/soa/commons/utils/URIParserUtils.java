package com.orange.soa.commons.utils;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author deyb6792
 */
public class URIParserUtils {

	public static final String ALL_FIELDS = "all";

	public static final String ID_FIELD = "id";

	private static final String QUERY_KEY_FIELD = "fields";

	private static final String QUERY_KEY_FIELD_ESCAPE = ":";

	private URIParserUtils() {
	}

	/**
	 *
	 * @param queryParameters
	 * @return
	 */
	public static Set<String> getFields(
			MultivaluedMap<String, String> queryParameters) {

		Set<String> fieldSet = new HashSet<>();
		if (queryParameters != null) {
			// search for "all" parameter
			if (queryParameters.containsKey(ALL_FIELDS)) {
				queryParameters.remove(ALL_FIELDS);
				fieldSet.add(ALL_FIELDS);
			}
			// search for "fields" parameters
			List<String> queryParameterField = queryParameters
					.remove(QUERY_KEY_FIELD_ESCAPE + QUERY_KEY_FIELD);
			if (queryParameterField == null) {
				queryParameterField = queryParameters.remove(QUERY_KEY_FIELD);
			}
			if (queryParameterField != null && !queryParameterField.isEmpty()) {
				String queryParameterValue = queryParameterField.get(0);
				if (queryParameterValue != null) {
					String[] tokenArray = queryParameterValue.split(",");
					fieldSet.addAll(Arrays.asList(tokenArray));
				}
			}
		}
		return fieldSet;
	}

	public static MultivaluedMap<String, String> extractCriteria(
			MultivaluedMap<String, String> queryParameters) {
		Set<Entry<String, List<String>>> entrySet = queryParameters.entrySet();
		MultivaluedMap<String, String> criterias = new MultivaluedHashMap<String, String>();

		entrySet.stream().forEach(entry -> {
			final List<String> tempValues = new ArrayList<String>();
			entry.getValue().stream().forEach(value -> tempValues
					.addAll(Arrays.asList(value.split(","))));
			criterias.put(entry.getKey(), tempValues);
		});

		return criterias;
	}

}
