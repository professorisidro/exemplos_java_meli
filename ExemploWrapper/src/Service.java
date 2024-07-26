
public class Service {
	
	public void multiplyBy10(Integer value) {
		value = value * 10;
	}

	public void aplicarDesconto(Produto pr, double percentual) {
		pr.preco = pr.preco - pr.preco * percentual / 100;
	}
}
