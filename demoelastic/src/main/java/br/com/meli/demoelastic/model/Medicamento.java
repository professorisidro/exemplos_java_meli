package br.com.meli.demoelastic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_medicamento")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_medicamento", length=100)
	private String nome;
	
	@Column(name = "qtde_estoque")
	private Double qtdEstoque;

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

	public Double getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	

}
