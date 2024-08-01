package br.com.meli.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Vehicle> addNewVehicle(@RequestBody Vehicle vehicle){
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
}
