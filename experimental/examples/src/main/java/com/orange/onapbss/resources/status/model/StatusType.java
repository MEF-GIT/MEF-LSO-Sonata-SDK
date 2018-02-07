package com.orange.onapbss.resources.status.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {

	OK("ok"), KO("ko");
	private final String value;

	StatusType(String v) {
		this.value = v;
	}

	@JsonValue
	public String getValue() {
		return this.value;
	}

	@JsonCreator
	public static StatusType fromValue(String v) {
		for (StatusType c : StatusType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
