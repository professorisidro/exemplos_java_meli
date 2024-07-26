
public class Veiculo {
	private String marca;
	private String modelo;
	private Double preco;
	public Veiculo(String marca, String modelo, Double preco) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}
	
	public Veiculo() {
		super();
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", preco=" + preco + "]";
	}



}
