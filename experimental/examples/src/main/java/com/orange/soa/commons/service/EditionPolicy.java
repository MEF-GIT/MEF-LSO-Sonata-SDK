package com.orange.soa.commons.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EditionPolicy {

	private Map<String, Set<String>> whiteList = new HashMap<>();

	private final Set<String> defaultOperations = Stream.of("add", "replace")
			.collect(Collectors.toSet());

	public com.orange.soa.commons.service.EditionPolicy auth(String attributePath) {
		whiteList.put(attributePath, defaultOperations);
		return this;
	}

	public com.orange.soa.commons.service.EditionPolicy add(String attributePath,
                                                            String... allowedOperations) {
		Set<String> operations = Stream.of(allowedOperations)
				.collect(Collectors.toSet());
		whiteList.put(attributePath, operations);
		return this;
	}

	public Map<String, Set<String>> getWhiteList() {
		return whiteList;
	}

}
