package br.com.meli.profiles;

import java.util.List;

public interface IProdutoService {
	public List<Produto> recuperarTodos();
	public Produto adicionarNovo(Produto p);
}
