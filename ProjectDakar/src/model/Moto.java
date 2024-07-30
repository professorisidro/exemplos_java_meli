package model;

public class Moto extends Veiculo {
	
	public Moto(Double velocidade, Double aceleracao, Double angulo, String placa) {
		super();
		super.velocidade = velocidade;
		super.aceleracao = aceleracao;
		super.anguloDeGiro = angulo;
		super.placa = placa;
		super.peso = 300;
		super.rodas = 2;
	}

	@Override
	public String toString() {
		return "Moto [velocidade=" + velocidade + ", aceleracao=" + aceleracao + ", anguloDeGiro=" + anguloDeGiro
				+ ", placa=" + placa + ", peso=" + peso + ", rodas=" + rodas + "]";
	}
	
	

}
