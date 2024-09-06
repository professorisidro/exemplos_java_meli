package br.com.meli.jpaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.jpaexample.model.Genero;
import br.com.meli.jpaexample.repo.GeneroRepo;

@RestController
@CrossOrigin("*")
public class GeneroController {
	
	@Autowired
	private GeneroRepo repo;
	
	@PostMapping("/generos")
	public ResponseEntity<?> cadastrarNovoGenero(@RequestBody Genero novo){
		var res = repo.save(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/generos")
	public ResponseEntity<?> recuperarTodos(){
		return ResponseEntity.ok(repo.findAll());
	}
}
