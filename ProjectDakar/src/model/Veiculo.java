package model;

public abstract class Veiculo {
	protected Double  velocidade;
	protected Double  aceleracao;
	protected Double  anguloDeGiro;
	protected String  placa;
	protected Integer peso;
	protected Integer rodas;
	
	
	public Double obtainScore() {
		return (velocidade * aceleracao/2) / (anguloDeGiro * (peso - rodas * 100));
	}
	
	public Double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}
	public Double getAceleracao() {
		return aceleracao;
	}
	public void setAceleracao(Double aceleracao) {
		this.aceleracao = aceleracao;
	}
	public Double getAnguloDeGiro() {
		return anguloDeGiro;
	}
	public void setAnguloDeGiro(Double anguloDeGiro) {
		this.anguloDeGiro = anguloDeGiro;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public Integer getRodas() {
		return rodas;
	}
	public void setRodas(Integer rodas) {
		this.rodas = rodas;
	}
	
}
