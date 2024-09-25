package io.isiflix.security_demo.security;

public class IsiToken {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public IsiToken(String token) {
		super();
		this.token = token;
	}

	public IsiToken() {
		super();
	}
	
}
