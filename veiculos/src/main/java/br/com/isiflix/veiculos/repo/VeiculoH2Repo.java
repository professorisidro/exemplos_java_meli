package br.com.isiflix.veiculos.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.isiflix.veiculos.entity.VeiculoEntity;

public interface VeiculoH2Repo extends CrudRepository<VeiculoEntity, Integer>{

}
