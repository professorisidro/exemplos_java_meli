package br.com.meli.mockdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.meli.mockdemo.entity.Produto;
import br.com.meli.mockdemo.exceptions.NegativePriceException;
import br.com.meli.mockdemo.exceptions.NoDataException;
import br.com.meli.mockdemo.exceptions.NullDescriptionException;
import br.com.meli.mockdemo.exceptions.ZeroPriceException;
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

	@Override
	public Produto adicionarProduto(Produto novo) {
		// TODO Auto-generated method stub
		if (novo.getPrice() != null && novo.getPrice() == 0.0) {
			System.out.println("ZERO PRICE");
			throw new ZeroPriceException("Preco Nao pode ser zero");
		}
		if (novo.getPrice() != null && novo.getPrice() < 0) {
			System.out.println("NEGATIVE PRICE");
			throw new NegativePriceException("Preco não pode ser negativo");
		}
		if (novo.getNome() == null && novo.getPrice() == null) {
			System.out.println("NO DATA");
			throw new NoDataException("Produto sem dados");
		}
		if (novo.getNome() == null) {
			System.out.println("NO NAME");
			throw new NullDescriptionException("Produto precisa ter descricao");
		}
			
		return novo;
	}

}
