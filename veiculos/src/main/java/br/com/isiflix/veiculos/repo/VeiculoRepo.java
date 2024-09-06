package br.com.isiflix.veiculos.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.isiflix.veiculos.entity.VeiculoEntity;

@Repository
public class VeiculoRepo {
	
	private List<VeiculoEntity> database;
	
	public VeiculoRepo() {
		System.out.println("Initializing database...");
		this.database = new ArrayList<VeiculoEntity>();
	}
	
	public VeiculoEntity save(VeiculoEntity novoVeiculo) {
		this.database.add(novoVeiculo);
		return novoVeiculo;
	}
	public List<VeiculoEntity> findAll(){
		return this.database;
	}

}
