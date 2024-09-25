package br.com.meli.profiles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements IProdutoService{
	
//	private ProdutoRepo repo;
	private ProdutoH2Repo repo;
	
	@Autowired
	public ProdutoServiceImpl(ProdutoH2Repo repo) {
		this.repo = repo;
    }

	@Override
	public List<Produto> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Produto>)repo.findAll();
	}

	@Override
	public Produto adicionarNovo(Produto p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}
}
