package br.com.meli.profiles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepo {
	private List<Produto> listaProdutos;
	
	public ProdutoRepo() {
		this.listaProdutos = new ArrayList<Produto>();
		this.listaProdutos.add(new Produto(1,"Computador", 1500.0));
		this.listaProdutos.add(new Produto(2,"Mouse", 50.0));
		this.listaProdutos.add(new Produto(3,"Teclado", 100.0));
		this.listaProdutos.add(new Produto(4,"Monitor", 500.0));		
	}
	
	public List<Produto> findAll(){
		return listaProdutos;
	}
	
	public Produto create(Produto p) {
		this.listaProdutos.add(p);
		return p;
	}	
}
