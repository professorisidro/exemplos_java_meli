package br.com.meli.mockdemo.service;

import java.util.List;

import br.com.meli.mockdemo.entity.Produto;

public interface IProdutoService {
	
	public List<Produto> readAllProducts();
	public Produto getProdutoById(Integer id);
	public Produto adicionarProduto(Produto novo);

}
