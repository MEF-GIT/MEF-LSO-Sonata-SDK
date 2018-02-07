package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ErrorBean;

/**
 *
 * @author maig7313
 */
public enum BadUsage {

	/**
	 * BAD_USAGE
	 */
	GENERIC(new com.orange.soa.commons.exception.ErrorBean(0, "Bad Usage")),
	/**
	 *
	 */
	SEARCH_QUERY(new com.orange.soa.commons.exception.ErrorBean(1, "Search query is not valid")),
	/**
	 *
	 */
	FLOW_TRANSITION(new com.orange.soa.commons.exception.ErrorBean(2, "Workflow, state transition is not valid")),
	/**
	 *
	 */
	FLOW_UNKNOWN_STATE(new com.orange.soa.commons.exception.ErrorBean(3, "Workflow, unknown state")),
	/**
	 *
	 */
	MANDATORY_FIELDS(new com.orange.soa.commons.exception.ErrorBean(4, "Missing mandatory field")),
	/**
	 *
	 */
	UNKNOWN_VALUE(new com.orange.soa.commons.exception.ErrorBean(5, "Unknown value")),
	/**
	 *
	 */
	OPERATOR(new com.orange.soa.commons.exception.ErrorBean(6, "Wrong operator")),
	/**
	 *
	 */
	FORMAT(new com.orange.soa.commons.exception.ErrorBean(7, "Wrong format"));

	private final com.orange.soa.commons.exception.ErrorBean value;

	BadUsage(com.orange.soa.commons.exception.ErrorBean code) {
		this.value = code;
	}

	@Override
	public String toString() {
		String out = String.format("%1$ - %2$", this.name(),
				this.getValue().toString());
		return out;
	}

	/**
	 *
	 * @return
	 */
	public ErrorBean getValue() {
		return value;
	}
}
