package io.isiflix.security_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.isiflix.security_demo.dto.LoginDTO;
import io.isiflix.security_demo.model.User;
import io.isiflix.security_demo.security.IsiToken;
import io.isiflix.security_demo.service.IUserService;

@RestController
public class AuthController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/users")
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		User res = service.createUser(user);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<IsiToken> login(@RequestBody LoginDTO loginDto){
		IsiToken token = service.login(loginDto);
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(403).build();
		
	}

}
