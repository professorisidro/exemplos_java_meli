package model;

public class Carro extends Veiculo{
	
	public Carro(Double velocidade, Double aceleracao, Double angulo, String placa) {
		super();
		super.aceleracao = aceleracao;
		super.anguloDeGiro = angulo;
		super.placa = placa;
		super.velocidade = velocidade;
		super.peso = 1000;
		super.rodas = 4;
	}

	@Override
	public String toString() {
		return "Carro [velocidade=" + velocidade + ", aceleracao=" + aceleracao + ", anguloDeGiro=" + anguloDeGiro
				+ ", placa=" + placa + ", peso=" + peso + ", rodas=" + rodas + "]";
	}

}
