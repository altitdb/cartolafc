package com.globo.cartolafc.domain;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 23L;
	private String email;
	private String password;
	private Integer serviceId = 438;

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

	public Integer getServiceId() {
		return serviceId;
	}

}