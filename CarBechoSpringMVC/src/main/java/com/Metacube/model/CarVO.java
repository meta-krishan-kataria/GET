package com.Metacube.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * class to get and set the details of the vehicles which are cars
 */
@Component
@Scope("prototype")
public class CarVO extends VehicleVO {

	private String companyName;
	private String modelName;
	private int engineInCC;
	private double fuelCapacity;
	private double mileage;
	private double price;
	private double roadTax;
	private double onRoadPrice;
	private String AC;
	private String powerSteering;
	private String accessoryKit;

	/**
	 * unparameterized constructor
	 */
	public CarVO() {

		companyName = null;
		modelName = null;
		engineInCC = 0;
		fuelCapacity = 0;
		mileage = 0;
		price = 0;
		roadTax = 0;
		onRoadPrice = 0;
		AC = null;
		accessoryKit = null;
		powerSteering = null;
	}

	/**
	 * get the company of the car
	 * @return String(name of the company)
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * set the company of the car
	 * @param companyName : name of the company
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * get the model of the car
	 * @return String(name of the model)
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * set the model of the car
	 * @param modelName : name of the model
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * get the engine's CC of the car
	 * @return Integer(engine's CC)
	 */
	public int getEngineInCC() {
		return engineInCC;
	}

	/**
	 * set the engine's CC of the car
	 * @param engineInCC : engine's CC
	 */
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	/**
	 * get the fuel capacity of the car
	 * @return Float(capacity of the fuel tank)
	 */
	public double getFuelCapacity() {
		return fuelCapacity;
	}

	/**
	 * set the fuel capacity of the car
	 * @param fuelCapacity : capacity of the fuel tank
	 */
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * get the mileage of the car
	 * @return Float(mileage of the car)
	 */
	public double getMileage() {
		return mileage;
	}

	/**
	 * set the mileage of the vehicle
	 * @param mileage : mileage of the car
	 */
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	/**
	 * get the price of the vehicle
	 * @return Float(price of the car)
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * set the price of the car
	 * @param price : price of the car
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * get the road tax of the car
	 * @return Float(road tax)
	 */
	public double getRoadTax() {
		return roadTax;
	}

	/**
	 * set the road tax of the car
	 * @param roadTax : road tax
	 */
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	/**
	 * calculate the on road price of the car
	 */
	public void calculateOnRoadPrice() {

		this.onRoadPrice = price + (price*roadTax)/100;
	}

	/**
	 * calculate and get the on road price of the car
	 * @return Float(on road price of the car)
	 */
	public double getOnRoadPrice() {

		return onRoadPrice;
	}

	/**
	 * set the on road price of the car
	 * @param onRoadPrice : calculated on road price of the car
	 */
	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

	/**
	 * get the status if the car has AC or not
	 * @return String
	 */
	public String getAC() {
		return AC;
	}

	/**
	 * set the status if the car has AC or not
	 * @param AC : car has AC or not
	 */
	public void setAC(String AC) {
		this.AC = AC;
	}

	/**
	 * get the status if the car has power steering or not
	 * @return String
	 */
	public String getPowerSteering() {
		return powerSteering;
	}

	/**
	 * set the status if the car has power steering or not
	 * @param powerSteering : car has Power Steering or not
	 */
	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}

	/**
	 * get the status if the car has Accessory kit or not
	 * @return String
	 */
	public String getAccessoryKit() {
		return accessoryKit;
	}

	/**
	 * set the status if the car has Accessory kit or not
	 * @param accessoryKit : car has Accessory kit or not
	 */
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
}