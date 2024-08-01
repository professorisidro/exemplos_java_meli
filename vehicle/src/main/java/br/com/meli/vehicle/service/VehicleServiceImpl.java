package br.com.meli.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.vehicle.model.Vehicle;
import br.com.meli.vehicle.repo.VehicleRepo;

@Service
public class VehicleServiceImpl implements IVehicleService {
	
	@Autowired
	private VehicleRepo repo;

	@Override
	public Vehicle saveVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
//		return (List<Vehicle>)repo.findAll();
		return repo.findByOrderByManufacturingDateDesc();
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public void deleteVehicle(Integer id) {
		repo.deleteById(id);
	}

}
