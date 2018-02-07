package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ApiExceptionAbstractImpl;
import com.orange.soa.commons.exception.Functional;

public class FunctionalException extends ApiExceptionAbstractImpl {

	private static final long serialVersionUID = -1286318486967465054L;

	public FunctionalException(Functional error) {
		super(error.getValue());
	}

	public FunctionalException(Functional error, String message) {
		super(error.getValue(), message);
	}

	@Override
	public int getCategory() {
		return 422;
	}

}
