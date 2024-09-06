package br.com.isiflix.veiculos.service;

import java.util.List;

import br.com.isiflix.veiculos.dto.VeiculoDTO;

public interface IVeiculoService {
	public VeiculoDTO adicionarNovo(VeiculoDTO novo);
	public List<VeiculoDTO> recuperarTodos();
}
