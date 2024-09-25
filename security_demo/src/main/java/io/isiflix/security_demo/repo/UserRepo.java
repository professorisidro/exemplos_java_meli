package io.isiflix.security_demo.repo;

import org.springframework.data.repository.CrudRepository;

import io.isiflix.security_demo.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	public User findByLogin(String login);

}
