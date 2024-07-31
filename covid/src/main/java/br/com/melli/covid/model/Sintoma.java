package br.com.melli.covid.model;

public class Sintoma {
	private Integer codigo;
	private String  nome;
	private Integer nivelDeGravidade;
	
	
	
	public Sintoma() {
		super();
	}
	public Sintoma(Integer codigo, String nome, Integer nivelDeGravidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nivelDeGravidade = nivelDeGravidade;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNivelDeGravidade() {
		return nivelDeGravidade;
	}
	public void setNivelDeGravidade(Integer nivelDeGravidade) {
		this.nivelDeGravidade = nivelDeGravidade;
	}
}
