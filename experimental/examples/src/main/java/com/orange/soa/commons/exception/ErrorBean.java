package com.orange.soa.commons.exception;

public class ErrorBean {

	private final int code;

	private final String message;

	private final String url;

	public ErrorBean(int code, String message) {
		this.code = code;
		this.message = message;
		this.url = null;
	}

	public ErrorBean(int code, String message, String url) {
		this.code = code;
		this.message = message;
		this.url = url;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		String out = String.valueOf(code) + " - " + message + " - " + url;
		return out;
	}

}
