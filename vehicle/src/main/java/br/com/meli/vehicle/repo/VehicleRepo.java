package br.com.meli.vehicle.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.vehicle.model.Vehicle;

public interface VehicleRepo extends CrudRepository<Vehicle, Integer>{
	// declarar nossos próprios métodos para queries (consultas) 
	// customizada
	public List<Vehicle> findByOrderByManufacturingDateDesc();
	
	// quero buscar por nome de marca
	public List<Vehicle> findByBrandContaining(String marca);
	
	// quero buscar por marca e modelo
	public List<Vehicle> findByBrandContainingIgnoreCaseAndModelContainingIgnoreCase(String marca, String modelo);
	
	// quero buscar por numero de portas
	public List<Vehicle> findByDoors(Integer doors);
	
	// quero buscar por intervalo de data de fabricação
	public List<Vehicle> findByManufacturingDateBetween(LocalDate ini, LocalDate fim);
	
}
