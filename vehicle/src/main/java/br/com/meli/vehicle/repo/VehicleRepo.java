package br.com.meli.vehicle.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.vehicle.model.Vehicle;

public interface VehicleRepo extends CrudRepository<Vehicle, Integer>{
	// declarar nossos próprios métodos para queries (consultas) 
	// customizada
	public List<Vehicle> findByOrderByManufacturingDateDesc();
}
