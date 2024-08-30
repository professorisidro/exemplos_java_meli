package br.com.meli.demoelastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.demoelastic.documents.Paciente;
import br.com.meli.demoelastic.repo.PacienteRepo;

@RestController
public class PacienteController {

	@Autowired
	private PacienteRepo repo;
	
	
	@GetMapping("/pacientes")
	public List<Paciente> recuperarTodos(){
		return repo.findAll(PageRequest.of(0, 100)).toList();
	}
	
	@GetMapping("/pacientes/tratamento")
	public List<Paciente> recuperarPorTratamento(@RequestParam(name="t") String tratamento){
		return repo.findByTratamentoContaining(tratamento);
	}
}
