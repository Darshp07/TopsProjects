package com.Project.Dio;

import java.util.List;

public class ApiErrorService {

	private boolean status;
	private String message;
	private List<String> errors;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public ApiErrorService(boolean status, String message, List<String> errors) {

		this.status = status;
		this.message = message;
		this.errors = errors;
	}

}
