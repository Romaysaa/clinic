package com.mtplatform.demo.dto;

public enum Errors {

	GENERAL_ERROR("0000", "An error occured please contact support team"), 
	OBJECT_NO_DATA_FOUND("0003", "No data found");
	
	private final String code;
	private final String message;

	private Errors(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
