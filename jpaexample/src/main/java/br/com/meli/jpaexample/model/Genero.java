package br.com.meli.jpaexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_genero")
public class Genero {
	@Id
	@Column(name = "id_genero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name_genero", length = 50)
	private String name;
	
	@OneToMany(mappedBy = "genero")
	@JsonIgnoreProperties("genero")
	private List<MiniSerie> series;
	
	
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
	public List<MiniSerie> getSeries() {
		return series;
	}
	public void setSeries(List<MiniSerie> series) {
		this.series = series;
	}
	
	

}
