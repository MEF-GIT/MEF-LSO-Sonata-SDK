package com.orange.onapbss.exception;

import com.orange.soa.commons.exception.*;


public class TechnicalException extends ApiExceptionAbstractImpl {
    private static final long serialVersionUID = 178410531552631462L;

    public TechnicalException(Technical error) {
        super(error.getValue());
    }

    public TechnicalException(Technical error, String message) {
        super(error.getValue(), message);
    }

    public int getCategory() {
        return 500;
    }
}