package br.com.meli.demoelastic.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.meli.demoelastic.documents.Paciente;

public interface PacienteRepo  extends ElasticsearchRepository<Paciente, Integer>{
	public List<Paciente> findByTratamentoContaining(String s);
}
