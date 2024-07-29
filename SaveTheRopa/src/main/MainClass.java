package main;

import java.util.Arrays;
import java.util.List;

import model.Roupa;
import service.GuardaRoupa;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("Save The Ropa SA");
		GuardaRoupa meuGuardaRoupa = new GuardaRoupa();
		
		Integer chave1 = meuGuardaRoupa
				.guardarRoupa(Arrays.asList(new Roupa("Hering","Camiseta"),
						                   new Roupa("Kichute","Chuteira"),
						                   new Roupa("Polo","Calça")));
		
		System.out.println("Armazenei no guarda roupa com a chave "+chave1);
		
		Integer chave2 = meuGuardaRoupa
				.guardarRoupa(Arrays.asList(new Roupa("Havaiana","Chinelo"),
						                    new Roupa("Lojao do Bras","Brusinha"),
						                    new Roupa("Ardidas","Pisante"),
						                    new Roupa("Mike","Agasalho")));
		System.out.println("Armazenei no guarda roupa com a chave "+chave2);
		
		meuGuardaRoupa.mostrarRoupas();
		
		List<Roupa> minhasRoupas = meuGuardaRoupa.consultarRoupas(chave1);
		
		System.out.println("Minhas roupas armazenadas");
		System.out.println(minhasRoupas);
		
		List<Roupa> retirada = meuGuardaRoupa.devolverRoupas(chave1);
		
		meuGuardaRoupa.mostrarRoupas();
		
		
		
	}
}
