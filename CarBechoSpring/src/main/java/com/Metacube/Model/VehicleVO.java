package com.Metacube.Model;

import org.springframework.stereotype.Component;

/**
 * abstract class to get and set the details of the vehicles and to be overridden by different types of vehicles class
 */
@Component
public abstract class VehicleVO {
		
	public abstract String getCompany();							//get the company of the vehicle
		
	public abstract void setCompany(String companyName);			//set the company of the vehicle
	
	public abstract String getModel();								//get the model of the vehicle
	
	public abstract void setModel(String modelName);				//set the model of the vehicle
	
	public abstract int getEngineInCC();							//get the engine's CC of the vehicle
	
	public abstract void setEngineInCC(int engineInCC);				//set the engine's CC of the vehicle
	
	public abstract double getFuelCapacity();						//get the fuel capacity of the vehicle
	
	public abstract void setFuelCapacity(double fuelCapacity);		//set the fuel capacity of the vehicle
	
	public abstract double getMileage();							//get the mileage of the vehicle
	
	public abstract void setMileage(double milage);					//set the mileage of the vehicle
	
	public abstract double getPrice();								//get the price of the vehicle
		
	public abstract void setPrice(double price);					//set the price of the vehicle
	
	public abstract double getRoadTax();							//get the road tax of the vehicle
	
	public abstract void setRoadTax(double roadTax);				//set the road tax of the vehicle
	
	public abstract double getOnRoadPrice();						//get the on road price of the vehicle
	
	public abstract void setOnRoadPrice(double onRoadPrice);		//set the on road price of the vehicle
	
	public abstract void calculateOnRoadPrice();					//calculate the on road price of the vehicle
}