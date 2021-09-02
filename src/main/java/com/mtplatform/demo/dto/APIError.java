package com.mtplatform.demo.dto;

import java.io.Serializable;

public class APIError implements Serializable {

	private static final long serialVersionUID = 6155331314790446480L;
	private String errorCode;
	private String errorMessage;
	private String cancelMessage;

	public APIError(String status, String message) {
		this.errorCode = status;
		this.errorMessage = message;
	}

	public APIError(String errorCode, String errorMessage, String cancelMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.cancelMessage = cancelMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDeveloperMessage() {
		return cancelMessage;
	}

	public void setDeveloperMessage(String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}
}