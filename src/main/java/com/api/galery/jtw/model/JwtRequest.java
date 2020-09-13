package com.api.galery.jtw.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String email;
	private String pass;

	public JwtRequest() {
	}

	public JwtRequest(String name, String pass) {
		this.setEmail(email);
		this.setPass(pass);
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	

}
