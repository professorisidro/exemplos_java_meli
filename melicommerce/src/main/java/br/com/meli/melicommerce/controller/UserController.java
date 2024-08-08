package br.com.meli.melicommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.melicommerce.model.User;
import br.com.meli.melicommerce.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/users")
	public ResponseEntity<?> recuperarUsuarios(){
		return ResponseEntity.ok(service.getAllUsers());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> recuperarPeloId(@PathVariable Integer id){
		User res = service.getUserById(id);
		if (res != null)
			return ResponseEntity.ok(res);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(value = {"/users/{userId}/follow/{userIdToFollow}",
			              "/users/{userId}/follow/"})
	public ResponseEntity<?> seguir(@PathVariable(required = false) Optional<Integer> userId,
									@PathVariable(required = false) Optional<Integer> userIdToFollow){
		
		if (userIdToFollow.isPresent()) {
			return ResponseEntity.ok("Valores presentes:" + userId.get()+ " / "+userIdToFollow.get());
		}
		return ResponseEntity.badRequest().body("Faltando o bendito do UserIdToFollow");
	}
}
