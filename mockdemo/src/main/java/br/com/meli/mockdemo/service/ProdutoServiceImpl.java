package br.com.meli.mockdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.meli.mockdemo.entity.Produto;
import br.com.meli.mockdemo.repo.ProdutoRepo;

@Component
public class ProdutoServiceImpl implements IProdutoService{
	
	@Autowired
	private ProdutoRepo repo;

	@Override
	public List<Produto> readAllProducts() {
		// TODO Auto-generated method stub
		System.out.println("READ ALL");
		return repo.findAll();
	}

	@Override
	public Produto getProdutoById(Integer id) {
		System.out.println("GET BY ID");
		// TODO Auto-generated method stub
		if (id <= 0) {
			throw new RuntimeException("Invalid ID");
		}
		return repo.findById(id);
	}

}
