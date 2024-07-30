package model;

import java.util.List;

public class Corrida {
	private Integer distancia;
	private Double premioEmDolares;
	private String nomeDoPremio;
	private Integer numeroDeVeiculos;
	private List<Veiculo> listaDeVeiculos;
	
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	public Double getPremioEmDolares() {
		return premioEmDolares;
	}
	public void setPremioEmDolares(Double premioEmDolares) {
		this.premioEmDolares = premioEmDolares;
	}
	public String getNomeDoPremio() {
		return nomeDoPremio;
	}
	public void setNomeDoPremio(String nomeDoPremio) {
		this.nomeDoPremio = nomeDoPremio;
	}
	public Integer getNumeroDeVeiculos() {
		return numeroDeVeiculos;
	}
	public void setNumeroDeVeiculos(Integer numeroDeVeiculos) {
		this.numeroDeVeiculos = numeroDeVeiculos;
	}
	public List<Veiculo> getListaDeVeiculos() {
		return listaDeVeiculos;
	}
	public void setListaDeVeiculos(List<Veiculo> listaDeVeiculos) {
		this.listaDeVeiculos = listaDeVeiculos;
	}

}
