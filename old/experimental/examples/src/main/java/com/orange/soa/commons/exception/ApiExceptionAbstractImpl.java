package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ApiException;
import com.orange.soa.commons.exception.ErrorBean;

import java.io.Serializable;

/**
 *
 * @author maig7313
 */
public abstract class ApiExceptionAbstractImpl extends RuntimeException
		implements Serializable, ApiException {

	private static final long serialVersionUID = 6383516104802857951L;

	private ErrorBean code;

	protected ApiExceptionAbstractImpl(ErrorBean code) {
		super();
		this.code = code;
	}

	protected ApiExceptionAbstractImpl(ErrorBean code, String message) {
		super(message);
		this.code = code;
	}

	@Override
	public ErrorBean getCode() {
		return this.code;
	}

}
