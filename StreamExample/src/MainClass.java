import java.util.Comparator;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		var listaProdutos = List.of(new Produto(1,"Computador",1500.0),
								    new Produto(2,"Mouse",50.0),
								    new Produto(3,"Teclado",100.0));
		
		var promo = listaProdutos.stream().sorted(Comparator.comparing(Produto::getNome)).toList();
		
		
		System.out.println(promo);
		promo.get(0).setPreco(200.0);
		System.out.println(promo);
		
		promo.add(new Produto(4,"Mesa Gamer",1000.0));
		System.out.println(promo);
		
		System.out.println(listaProdutos);
		
		
		Produto p1 = new Produto(5,"Cadeira Gamer que nao serve pra nada", 1500.0);
		System.out.println(p1);
		Produto p2 = p1;
		
		p2.setNome("Cadeira gamer verdinha");
		System.out.println(p1);
	}
	

}

