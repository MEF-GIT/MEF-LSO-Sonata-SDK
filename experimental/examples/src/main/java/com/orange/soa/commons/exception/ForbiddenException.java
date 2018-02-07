package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ApiExceptionAbstractImpl;
import com.orange.soa.commons.exception.Forbidden;

/**
 *
 * @author maig7313
 */
public class ForbiddenException extends ApiExceptionAbstractImpl {

	private static final long serialVersionUID = 8671604109238149753L;

	public ForbiddenException(Forbidden error) {
		super(error.getValue());
	}

	public ForbiddenException(Forbidden error, String message) {
		super(error.getValue(), message);
	}

	@Override
	public int getCategory() {
		return 403;
	}

}
