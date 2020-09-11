package com.api.galery.jtw.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String name;
	private String pass;

	public JwtRequest() {
	}

	public JwtRequest(String name, String pass) {
		this.setName(name);
		this.setPass(pass);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	

}
