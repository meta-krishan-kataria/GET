/*
 * Part 1: For the part 1 create CarVO, CarTO CarDAO and ConnectionFactory Singleton class. Exposing API for following functionality on Facade layer.

Car Table with metadata fields like id, created by, created time, updated by, updated time.

VehicleVO - make, model, engineInCC, fuelCapacity, mileage, price, roadTax
Create calculateOnRoadPrice method to be overwritten by children
CarVO - AC, powerSteering, accessoryKit
 * */
/*
 * Doubts: constructor, getters setters in abstract class
 * changing signature of abstract method in derived class
 * */

package model;

public abstract class VehicleVO {
	
	protected String company;
	protected String model;
	protected int engineInCC;
	protected int fuelCapacity;
	protected int mileage;
	protected int price;
	protected int roadTax;
	

	public VehicleVO() {
		super();
	}

	public VehicleVO(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax) {
		super();
		this.company = company;
		this.model = model;
		this.engineInCC = engineInCC;
		this.fuelCapacity = fuelCapacity;
		this.mileage = mileage;
		this.price = price;
		this.roadTax = roadTax;
	}

	//abstract method
	public abstract void createCar(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax);
	
	//abstract method
	public abstract int calculateOnRoadPrice();
	
	//getters and setters
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEngineInCC() {
		return engineInCC;
	}
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRoadTax() {
		return roadTax;
	}
	public void setRoadTax(int roadTax) {
		this.roadTax = roadTax;
	}

	
}
