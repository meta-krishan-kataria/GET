package model;

public class CarVO extends VehicleVO {
	
	private int id;
	private int ac, powerSteering, accessoryKit;

	public CarVO(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax, int id,
			int ac, int powerSteering, int accessoryKit) {
		super(company, model, engineInCC, fuelCapacity, mileage, price, roadTax);
		this.id = id;
		this.ac = ac;
		this.powerSteering = powerSteering;
		this.accessoryKit = accessoryKit;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(int powerSteering) {
		this.powerSteering = powerSteering;
	}

	public int getAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(int accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	//constructor
	public CarVO() {
		super();
	}


	@Override
	public void createCar(String company, String model, int engineInCC,
			int fuelCapacity, int mileage, int price, int roadTax) {
		
		this.model = model;
		this.company = company;
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

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
