package br.com.meli.jpaexample.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.jpaexample.model.MiniSerie;

public interface MiniSerieRepo extends CrudRepository<MiniSerie,Integer>{

}
