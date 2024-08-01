package br.com.meli.vehicle.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_vehicle")
public class Vehicle {

	@Id		// chave primaria
	@Column(name="id_vehicle")
	private Integer id;	
	@Column(name = "brand", length = 100, nullable = false)
	private String  brand;
	@Column(name = "model", length = 100, nullable = false)
	private String  model;
	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	@Column(name = "kilometers", nullable = false)
	private Integer   numberOfKilometers;
	@Column(name = "doors")
	private Integer   doors;
	@Column(name = "price", nullable = false)
	private Double    price;
	@Column(name = "currency", length = 3)
	private String    currency;
	@Column(name = "count_of_owners")
	private Integer   countOfOwners;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Integer getNumberOfKilometers() {
		return numberOfKilometers;
	}
	public void setNumberOfKilometers(Integer numberOfKilometers) {
		this.numberOfKilometers = numberOfKilometers;
	}
	public Integer getDoors() {
		return doors;
	}
	public void setDoors(Integer doors) {
		this.doors = doors;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getCountOfOwners() {
		return countOfOwners;
	}
	public void setCountOfOwners(Integer countOfOwners) {
		this.countOfOwners = countOfOwners;
	}
	
}
