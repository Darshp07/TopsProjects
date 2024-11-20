package com.Project.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Login {

	@Email(message = "Must be a well-formed email address")
	private String email;

	@NotBlank(message = "Password must not be blank")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
