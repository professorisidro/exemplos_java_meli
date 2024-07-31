package br.com.melli.covid.model;

import java.util.List;

public class Pessoa {
	private Integer id;
	private String  nome;
	private String  sobrenome;
	private Integer idade;
	private List<Sintoma> sintomas;
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public List<Sintoma> getSintomas() {
		return sintomas;
	}
	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
	
	
}
