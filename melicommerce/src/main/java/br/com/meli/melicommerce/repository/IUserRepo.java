package br.com.meli.melicommerce.repository;

import java.util.List;

import br.com.meli.melicommerce.model.User;

public interface IUserRepo {
	public List<User> findAll();
	public User findById(Integer id);
}
