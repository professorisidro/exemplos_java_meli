package br.com.meli.mockdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.mockdemo.entity.Produto;
import br.com.meli.mockdemo.service.IProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private IProdutoService service;
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<?> recuperarProduto(@PathVariable Integer id){
		try {
			Produto p = service.getProdutoById(id);
			if (p != null) {
				return ResponseEntity.ok(p);
			}
			return ResponseEntity.notFound().build();
		}
		catch (RuntimeException ex) {
			return ResponseEntity.badRequest().build();
		}		
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<?> adicionarProduto(@RequestBody Produto p){
		try {
			Produto res = service.adicionarProduto(p);
			return ResponseEntity.status(201).body(res);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

}
