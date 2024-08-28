package br.com.meli.jpaexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_miniserie")
public class MiniSerie {
	@Id
	@Column(name = "id_serie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_serie", length = 100)
	private String name;
	
	@Column(name = "rating", nullable = false)
	private Double rating;
	
	@Column(name = "amount_of_awards", nullable = false)
	private Integer amountOfAwards;
	
	@ManyToOne
	@JoinColumn(name = "tbl_genero_id_genero")
	@JsonIgnoreProperties("series")
	private Genero genero;
	
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Integer getAmountOfAwards() {
		return amountOfAwards;
	}
	public void setAmountOfAwards(Integer amountOfAwards) {
		this.amountOfAwards = amountOfAwards;
	}	
}
