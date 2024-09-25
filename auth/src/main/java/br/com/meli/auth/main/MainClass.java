package br.com.meli.auth.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.meli.auth.model.Usuario;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Usuario u = new Usuario();
		
		// cadastrando...
		System.out.println("Digite o ID");
		u.setId(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o Login");
		u.setLogin(teclado.nextLine());
		System.out.println("Digite a senha");
		String pass = teclado.nextLine();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String newPass = encoder.encode(pass);
		u.setPassword(newPass);
		
		System.out.println(u);
		
		
		// para logar
		
		System.out.println("--------------------------");
		System.out.println("Digite a senha para identificar-se");
		String currentPass = teclado.nextLine();
		if (encoder.matches(currentPass, u.getPassword())) {
			System.out.println("Bem vindo ao sistema");
		}
		else {
			System.out.println("ACESSO NEGADO!");
		}
		

	}

}
