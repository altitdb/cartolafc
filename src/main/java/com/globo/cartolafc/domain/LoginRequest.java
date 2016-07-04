package com.globo.cartolafc.domain;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 23L;
	private Login payload = new Login();

	public Login getPayload() {
		return payload;
	}

	public void setPayload(Login payload) {
		this.payload = payload;
	}

	public void setEmail(String email) {
		this.payload.setEmail(email);
	}

	public void setPassword(String password) {
		this.payload.setPassword(password);
	}

}
