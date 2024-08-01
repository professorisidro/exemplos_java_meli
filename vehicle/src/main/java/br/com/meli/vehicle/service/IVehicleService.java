package br.com.meli.vehicle.service;

import java.util.List;

import br.com.meli.vehicle.model.Vehicle;

public interface IVehicleService {
	public Vehicle saveVehicle(Vehicle v);   // create
	public List<Vehicle> getAllVehicles();   // read
	public Vehicle updateVehicle(Vehicle v); // update
	public void deleteVehicle(Integer id);   // delete
}
