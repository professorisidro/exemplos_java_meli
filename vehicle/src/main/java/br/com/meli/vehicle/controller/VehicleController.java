package br.com.meli.vehicle.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.vehicle.model.Vehicle;
import br.com.meli.vehicle.service.IVehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private IVehicleService service;
	
	@GetMapping("/api/v1/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehiclesFromDatabase(){
		return ResponseEntity.ok(service.getAllVehicles());
	}
	
	@PostMapping("/api/v1/vehicles")
	public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle vehicle){
		Vehicle res = service.saveVehicle(vehicle);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().build();
	}
	

	@PutMapping("/api/v1/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id){
		if (vehicle.getId() == null) {
			vehicle.setId(id);
		}
		Vehicle res = service.updateVehicle(vehicle);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/api/v1/vehicles/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable Integer id){
		service.deleteVehicle(id);
		return ResponseEntity.ok("Vehicle Deleted");
	}
	
	
	// exemplos de controllers para busca
	// como fica a url desse cabra?
	// http://localhost:8080/api/v1/vehicle/searchbybrand?brand=Fiat
	@GetMapping("/api/v1/vehicles/searchbybrand")
	public ResponseEntity<List<Vehicle>> buscarPorMarca(@RequestParam(name = "brand") String key){
		return ResponseEntity.ok(service.getByBrand(key));
	}
	
	// como fica a url desse cabra?
	// http://localhost:8080/api/v1/vehicle/searchbybrand?brand=Fiat&model=Uno
	@GetMapping("/api/v1/vehicles/searchbybrandandmodel")
	public ResponseEntity<List<Vehicle>> buscarPorMarcaEModelo(@RequestParam(name="brand") String marca,
			                                                   @RequestParam(name="model") String modelo){
		return ResponseEntity.ok(service.getByBrandAndModel(marca, modelo));
	}
	
	// como fica a url desse cabra?
	// http://localhost:8080/api/v1/vehicle/searchbydoors?number=xxx
	@GetMapping("/api/v1/vehicles/searchbydoors")
	public ResponseEntity<List<Vehicle>> buscarPorNumeroDePortas(@RequestParam(name="number") Integer number){
		return ResponseEntity.ok(service.getByNumberOfDoors(number));
	}
	
	// como fica a url desse cabra?
	// http://localhost:8080/api/v1/vehicle/searchbydate?ini=2000-01-01&fim=2010-12-31
	@GetMapping("/api/v1/vehicles/searchbydate")
	public ResponseEntity<List<Vehicle>> buscarPorData(@RequestParam(name="ini") LocalDate ini,
			                                           @RequestParam(name="fim") LocalDate fim)	{
		return ResponseEntity.ok(service.getByManufacturingInterval(ini, fim));
	}










}
