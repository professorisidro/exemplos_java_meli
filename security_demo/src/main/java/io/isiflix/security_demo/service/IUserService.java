package io.isiflix.security_demo.service;

import io.isiflix.security_demo.dto.LoginDTO;
import io.isiflix.security_demo.model.User;
import io.isiflix.security_demo.security.IsiToken;

public interface IUserService {
	public User createUser(User user);
	public IsiToken login(LoginDTO dto);
}
