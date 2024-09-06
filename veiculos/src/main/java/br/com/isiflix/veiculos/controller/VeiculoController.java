package br.com.isiflix.veiculos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.veiculos.dto.VeiculoDTO;
import br.com.isiflix.veiculos.service.IVeiculoService;

@RestController
public class VeiculoController {
	
	private IVeiculoService service;
	
	public VeiculoController(IVeiculoService service) {
		this.service = service;
	}
	
	@GetMapping("/veiculos")
	public ResponseEntity<?> recuperarTodos(){
		return new ResponseEntity<List<VeiculoDTO>>(this.service.recuperarTodos(), HttpStatus.OK);
	}
	
	@PostMapping("/veiculos")
	public ResponseEntity<?> adicionarNovo(@RequestBody VeiculoDTO novo){
		return new ResponseEntity<VeiculoDTO>(this.service.adicionarNovo(novo), HttpStatus.CREATED);
	}

}
