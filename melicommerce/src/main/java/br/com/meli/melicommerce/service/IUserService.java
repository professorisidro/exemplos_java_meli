package br.com.meli.melicommerce.service;

import java.util.List;

import br.com.meli.melicommerce.model.User;

public interface IUserService {
	public List<User> getAllUsers();
	public User getUserById(Integer id);
}
