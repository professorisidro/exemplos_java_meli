package br.com.melli.covid.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.melli.covid.dto.ErrorResponseDTO;
import br.com.melli.covid.dto.PessoaResponseDTO;
import br.com.melli.covid.dto.SintomaResponseDTO;
import br.com.melli.covid.util.FakeBD;

@RestController
public class SintomasController {
	
	@GetMapping("/findSymptom")
	public List<SintomaResponseDTO> recuperarTodos(){
		return FakeBD.getAllSintomas();
	}
	
	@GetMapping("/findSymptom/{name}")
	public ResponseEntity<?> recuperarPessoaComSintoma(@PathVariable String name) {
		var res = FakeBD.encontrarSintomaNaPessoa(name);
		if (res != null) {
		   return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404)
			   .body(new ErrorResponseDTO(1234,"Recurso nao encontrado"));
	}
	

}
