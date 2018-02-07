package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ErrorBean;

/**
 *
 * @author maig7313
 */
public enum Forbidden {

	/**
	 * GENERIC
	 */
	GENERIC(new ErrorBean(0, "Forbidden error")),

	OPERATION_NOT_ALLOWED(new ErrorBean(1, "Access to operation denied"));

	private final ErrorBean value;

	Forbidden(ErrorBean code) {
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
		return this.value;
	}
}
