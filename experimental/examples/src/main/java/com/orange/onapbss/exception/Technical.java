package com.orange.onapbss.exception;

import com.orange.soa.commons.exception.ErrorBean;


public enum Technical {
    GENERIC(new ErrorBean(0, "Technical error")),
    NOT_IMPLEMENTED(new ErrorBean(1, "Operation not Implemented"));

    private final ErrorBean value;

    private Technical(ErrorBean code) {
        this.value = code;
    }

    public String toString() {
        String out = String.format("%1$ - %2$", new Object[]{this.name(), this.getValue().toString()});
        return out;
    }

    public ErrorBean getValue() {
        return this.value;
    }
}
