package com.orange.soa.commons.exception;

import com.orange.soa.commons.exception.ErrorBean;

/**
 *
 * @author maig7313
 */
public interface ApiException {

	int getCategory();

	ErrorBean getCode();

	String getMessage();

}
