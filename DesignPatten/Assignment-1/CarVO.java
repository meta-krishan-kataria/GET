package model;

public class CarVO extends VehicleVO {

	boolean hasAC, hasPowerSteering, hasAccessoryKit;
	
	
	//constructor
	public CarVO(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax,
			boolean hasAC, boolean hasPowerSteering, boolean hasAccessoryKit) {
		
		super(company, model, engineInCC, fuelCapacity, mileage, price, roadTax);
		
		this.hasAC = hasAC;
		this.hasPowerSteering = hasPowerSteering;
		this.hasAccessoryKit = hasAccessoryKit;
	}

	@Override
	public void createCar(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax) {
		
		this.company = company;
		this.model = model;
		this.engineInCC = engineInCC;
		this.fuelCapacity = fuelCapacity;
		this.mileage = mileage;
		this.price = price;
		this.roadTax = roadTax;

	}

	@Override
	public int calculateOnRoadPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isHasAC() {
		return hasAC;
	}

	public void setHasAC(boolean hasAC) {
		this.hasAC = hasAC;
	}

	public boolean isHasPowerSteering() {
		return hasPowerSteering;
	}

	public void setHasPowerSteering(boolean hasPowerSteering) {
		this.hasPowerSteering = hasPowerSteering;
	}

	public boolean isHasAccessoryKit() {
		return hasAccessoryKit;
	}

	public void setHasAccessoryKit(boolean hasAccessoryKit) {
		this.hasAccessoryKit = hasAccessoryKit;
	}
	
	
	

}
