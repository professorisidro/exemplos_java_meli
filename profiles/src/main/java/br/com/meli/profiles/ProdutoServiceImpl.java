package br.com.meli.profiles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements IProdutoService{
	
	private ProdutoRepo repo;
	
	@Autowired
	public ProdutoServiceImpl(ProdutoRepo repo) {
		this.repo = repo;
    }

	@Override
	public List<Produto> recuperarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Produto adicionarNovo(Produto p) {
		// TODO Auto-generated method stub
		return repo.create(p);
	}
}
