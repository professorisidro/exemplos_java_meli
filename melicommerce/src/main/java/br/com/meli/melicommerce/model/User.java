package br.com.meli.melicommerce.model;

import java.util.List;

public class User {
	private Integer userId;
	private String  userName;
	
	private List<Follower> followers;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}
	
	

}
