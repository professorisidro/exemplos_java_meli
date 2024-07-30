package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Carro;
import model.Corrida;
import model.Moto;
import model.Veiculo;

public class MainClass {
	public static void main(String[] args) {
		Corrida corrida = new Corrida();
		corrida.setDistancia(5000);
		corrida.setNumeroDeVeiculos(50);
		corrida.setPremioEmDolares(500000.0);
		corrida.setNomeDoPremio("Taça Paris Dakar");
		List<Veiculo> lista = new ArrayList<Veiculo>();
		lista.add(new Carro(120.0, 5.0, 35.0, "ABC1234"));
		lista.add(new Moto(150.0, 6.0, 30.0, "XYZ1234"));
		lista.add(new Carro(160.0, 4.5, 32.0, "ABC9876"));
		lista.add(new Moto(180.0, 5.2, 28.0, "XYZ9876"));
		lista.add(new Carro(200.0, 8.0, 40.0, "ABC1010"));
		lista.add(new Moto(223.0, 8.7, 42.1, "XYZ1010"));

		corrida.setListaDeVeiculos(lista);

		for (Veiculo v : corrida.getListaDeVeiculos()) {
			System.out.println(v + " - " + v.obtainScore());
		}

		List<Veiculo> vencedorCarros = corrida.getListaDeVeiculos().stream().filter((v) -> v instanceof Carro)
				.sorted(Comparator.comparing((Veiculo v) -> v.obtainScore()).reversed()).collect(Collectors.toList());

		System.out.println(" ------ Classificacao dos carros! ");
		vencedorCarros.forEach(c -> System.out.println(c));

		System.out.println(" ------- Classificacao das motos!  ");
		List<Veiculo> vencedorMotos = corrida.getListaDeVeiculos().stream().filter((v) -> v instanceof Moto)
				.sorted(Comparator.comparing((Veiculo m) -> m.obtainScore()).reversed()).toList();
		vencedorMotos.forEach(m -> System.out.println(m));

		System.out.println(" --- classificacao Geral");
		corrida.getListaDeVeiculos().stream().sorted(Comparator.comparing((Veiculo v) -> v.obtainScore()).reversed())
				.toList().forEach(v -> System.out.println(v));

	}

}
