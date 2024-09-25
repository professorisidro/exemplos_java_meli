package io.isiflix.security_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.isiflix.security_demo.dto.LoginDTO;
import io.isiflix.security_demo.model.User;
import io.isiflix.security_demo.repo.UserRepo;
import io.isiflix.security_demo.security.IsiToken;
import io.isiflix.security_demo.security.TokenUtil;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private UserRepo repo;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setSenha(encoder.encode(user.getSenha()));		
		return repo.save(user);
	}
	@Override
	public IsiToken login(LoginDTO dto) {
		// TODO Auto-generated method stub
		User user = repo.findByLogin(dto.login());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (user != null) {
			if (encoder.matches(dto.password(), user.getSenha())) {
				return TokenUtil.encode(user);
			}
		}
		return null;
	}

}
