package com.orange.soa.commons.resource.mapper;

import com.orange.soa.commons.exception.ApiException;
import com.orange.soa.commons.exception.ErrorBean;

public class JsonError {

	private String code;

	private String message;

	private String url;

	private String description;

	public JsonError() {
	}

	public JsonError(ApiException exception) {
		this.code = String.valueOf(exception.getCategory()) + "-"
				+ exception.getCode().getCode();
		this.message = exception.getCode().getMessage();
		this.url = exception.getCode().getUrl();
		this.description = exception.getMessage();
	}

	public JsonError(ErrorBean code) {
		this.code = String.valueOf(code.getCode());
		this.message = code.getMessage();
		this.url = code.getUrl();
		this.description = null;
	}

	public JsonError(ErrorBean code, String description) {
		this.code = String.valueOf(code.getCode());
		this.message = code.getMessage();
		this.url = code.getUrl();
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public String getUrl() {
		return this.url;
	}

	public String getDescription() {
		return this.description;
	}

}
