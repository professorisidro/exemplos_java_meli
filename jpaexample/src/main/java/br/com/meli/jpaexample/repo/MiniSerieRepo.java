package br.com.meli.jpaexample.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.jpaexample.model.Genero;
import br.com.meli.jpaexample.model.MiniSerie;

public interface MiniSerieRepo extends CrudRepository<MiniSerie,Integer>{

	public List<MiniSerie> findByNameContaining(String name);
	public List<MiniSerie> findByOrderByRatingDesc();
	public List<MiniSerie> findByGenero(Genero genero);
	public List<MiniSerie> findByGeneroNameContaining(String name);
}

