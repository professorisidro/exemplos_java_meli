
public class MainClass {
	public static void main(String[] args) {
		MinhaInterface it = new MinhaInterface(){
			public void meuMetodo(Integer parametro) {
				System.out.println(parametro * 10);
			}
		};
		
		MinhaInterface it2 = new MinhaInterface() {
			public void meuMetodo(Integer parametro1) {
				System.out.println(parametro1 + 1);				
			}
		};
		
		MinhaInterface it3 = (parametro1)->{
			System.out.println(parametro1 * 100);
		};
		
		it.meuMetodo(10);
		it2.meuMetodo(10);
		it3.meuMetodo(10);
		
		
		Matematica soma = (a,b)->{
			return a + b;
		};
		Matematica subt = (a, b) -> a - b;
		Matematica mult = (a, b) -> a * b;
		Matematica divi = (a, b) -> a / b;
		
		System.out.println(exibir(10,5, soma));
		System.out.println(exibir(10,5, subt));
		System.out.println(exibir(10,5, mult));
		System.out.println(exibir(10,5, divi));
	}
	
	public static int exibir(int valor1, int valor2, Matematica mat) {
		return mat.op(valor1, valor2);
	}
}
