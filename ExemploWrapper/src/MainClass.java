import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Scanner;
public class MainClass {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer a, b, c, d;
		a = 1;
		b = 2;
		c = a + b;
		d = a - b;

		System.out.println("valor de a = " + a);
		System.out.println("valor de b = " + b);
		System.out.println("valor de c = " + c);
		System.out.println("valor de d = " + d);

		Produto p = new Produto();
		p.id = 1234;
		p.nome = "Computador";
		p.preco = 1500;

		Service srv = new Service();

		System.out.println(p);
		srv.aplicarDesconto(p, 10);
		System.out.println(p);
		
		srv.multiplyBy10(a);
		System.out.println(a);

		
		List<Integer> listaDeInteiros = new Vector<Integer>();
		List<Double> listaDeDoubles = new ArrayList<Double>();
		List<Number> listaDeNumeros = new ArrayList<Number>();
		listaDeNumeros.add(1);
		listaDeNumeros.add(1.0);
		
		int outraLista[]= new int[10];
		
		
//		String s1 = new String("Oi, quer tc?");
//		String s2 = new String("Oi, quer tc?");
		
		String s1 = teclado.nextLine();
		String s2 = teclado.nextLine();
		
		if (s1.equals(s2)) {
			System.out.println("Iguais");
		}
		else {
			System.out.println("Diferentes");
		}
		
		
		
	}
}
