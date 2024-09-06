package br.com.meli.jpaexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.jpaexample.model.Genero;
import br.com.meli.jpaexample.model.MiniSerie;
import br.com.meli.jpaexample.repo.MiniSerieRepo;

@RestController
@RequestMapping("/api")
public class MiniSerieController {
	
	
	@Autowired
	private MiniSerieRepo repo;

	@PostMapping("/miniseries")
	public ResponseEntity<?> cadastrarNovaSerie(@RequestBody MiniSerie nova){
		var res = repo.save(nova);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/miniseries")
	public ResponseEntity<List<MiniSerie>> recuperarTodas(){
		return ResponseEntity.ok((List<MiniSerie>)repo.findAll());
	}
	
	@GetMapping("/miniseries/{id}")
	public ResponseEntity<?> recuperarPeloId(@PathVariable Integer id){
		var res = repo.findById(id).orElse(null);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/miniseries/search")
	public ResponseEntity<?> recuperarPorPalavraChave(@RequestParam(name="key") String palavraChave){
		return ResponseEntity.ok(repo.findByNameContaining(palavraChave));
	}
	
	@GetMapping("/miniseries/best")
	public ResponseEntity<?> recuperarMelhoresMinisseries(){
		return ResponseEntity.ok(repo.findByOrderByRatingDesc());
	}
	
	@GetMapping("/miniseries/genero/{id}") 
	public ResponseEntity<?> recuperarPeloGenero(@PathVariable Integer id){
		Genero g = new Genero();
		g.setId(id);
		return ResponseEntity.ok(repo.findByGenero(g));
	}
	
	@GetMapping("/miniseries/nomegenero")
	public ResponseEntity<?> recuperarPeloNomeDoGenero(@RequestParam(name = "key") String name){
		return ResponseEntity.ok(repo.findByGeneroNameContaining(name));
	}
	
}
