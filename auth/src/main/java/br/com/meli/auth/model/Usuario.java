package br.com.meli.auth.model;

public class Usuario {
	private Integer id;
	private String login;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	

}
