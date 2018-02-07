package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ErrorBean;

/**
 *
 * @author maig7313
 */
public enum Functional {

	GENERIC(new ErrorBean(0, "Functional error")),

	REGISTRATION(new ErrorBean(1, "Registration error")),

	AUTHENTICATION(new ErrorBean(2, "Authentication error"));

	private final ErrorBean value;

	Functional(ErrorBean code) {
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
