package br.com.meli.mockdemo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.mockdemo.entity.Produto;

@Repository
public class ProdutoRepo {
	
	private List<Produto> produtos;
	public ProdutoRepo() {
		this.loadDatabase();
	}
	
	private void loadDatabase() {
		produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "Computador", 1500.0));
		produtos.add(new Produto(2, "Teclado", 100.0));				
	}
	
	public List<Produto> findAll(){
		return this.produtos;
	}
	
	public Produto findById(Integer id) {
		return produtos.stream().filter(p-> p.getId() == id).findFirst().orElse(null);
	}

}
