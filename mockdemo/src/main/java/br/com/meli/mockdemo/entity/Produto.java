package br.com.meli.mockdemo.entity;

public class Produto {
	private Integer id;
	private String nome;
	private Double price;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, Double price) {
		super();
		this.id = id;
		this.nome = nome;
		this.price = price;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
