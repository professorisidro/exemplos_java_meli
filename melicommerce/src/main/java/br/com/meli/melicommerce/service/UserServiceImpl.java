package br.com.meli.melicommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.melicommerce.model.User;
import br.com.meli.melicommerce.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
