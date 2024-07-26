import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[] args) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		veiculos.add(new Veiculo("Ford", "Fiesta", 1000.0));
		veiculos.add(new Veiculo("Ford", "Focus", 1200.0));
		veiculos.add(new Veiculo("Ford", "Explorer", 2500.0));
		veiculos.add(new Veiculo("Fiat", "Uno", 500.0));
		veiculos.add(new Veiculo("Fiat", "Cronos", 1000.0));
		veiculos.add(new Veiculo("Fiat", "Torino", 1250.0));
		veiculos.add(new Veiculo("Chevrolet", "Aveo", 1250.0));
		veiculos.add(new Veiculo("Chevrolet", "Spin", 2500.0));
		veiculos.add(new Veiculo("Toyota", "Corolla", 1200.0));
		veiculos.add(new Veiculo("Toyota", "Fortuner", 3000.0));
		veiculos.add(new Veiculo("Renault", "Logan", 950.0));
		 
		Garagem garagem = new Garagem(1, veiculos);
		
		List<Veiculo> novaLista = 
			garagem.getLista()
			.stream()
			.sorted(Comparator.comparing(Veiculo::getPreco)
					          .thenComparing(Veiculo::getMarca))
			.toList();
								
		novaLista.forEach((v)-> { 
			System.out.println(v);
			System.out.println("------");
		});
		
	}
}
