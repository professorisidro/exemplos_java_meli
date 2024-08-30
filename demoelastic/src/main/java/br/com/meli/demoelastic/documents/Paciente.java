package br.com.meli.demoelastic.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(indexName = "idx_prontuario")
public class Paciente {

	@Id
	private Integer id;
	private String nome;
	private String diagnostico;
	private String descricao;
	private String tratamento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

}
