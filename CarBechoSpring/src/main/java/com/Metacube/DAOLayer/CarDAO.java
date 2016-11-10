package com.Metacube.DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Metacube.Factory.CarFactory;
import com.Metacube.Factory.ConnectionFactory;
import com.Metacube.Model.CarVO;

/**
 * DAO class to execute the query on car
 */
@Repository
public class CarDAO {

	//CarFacatory reference autowired by the bean in ApplicationContext.xml
	@Autowired
	CarFactory carFactory;

	private List<CarVO> listOfCars;
	private ConnectionFactory db = null;

	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public CarDAO() {

		listOfCars = new ArrayList<CarVO>();
		//getting database instance
		db = ConnectionFactory.getInstance();
	}

	/**
	 * method to return all the list of the cars present in the database 
	 * @return : list of cars
	 */
	public List<CarVO> selectAllCarsDAO(){

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		
		try{
			
			//create connection
			con = db.createConnection();
			
			String query = "SELECT CompanyName, ModelName, EngineInCC, FuelCapacity, Mileage, Price, RoadTax, AC, "
					+ "PowerSteering, AccessoryKit, OnRoadPrice FROM car;";

			if(con != null){

				pstmt = con.prepareStatement(query);

				if(pstmt != null){

					rst = pstmt.executeQuery();

					if(rst != null){

						while(rst.next()){

							//getting CarVO objects for every iteration
							CarVO car = carFactory.getCar();

							car.setCompany(rst.getString(1));
							car.setModel(rst.getString(2));
							car.setEngineInCC(rst.getInt(3));
							car.setFuelCapacity(rst.getDouble(4));
							car.setMileage(rst.getDouble(5));
							car.setPrice(rst.getDouble(6));
							car.setRoadTax(rst.getDouble(7));
							car.setAC(rst.getInt(8));
							car.setPowerSteering(rst.getInt(9));
							car.setAccessoryKit(rst.getInt(10));
							car.setOnRoadPrice(rst.getDouble(11));
							listOfCars.add(car);
							System.out.println("lenght: "+listOfCars.size());
						}
					}
				}
			}
		} catch(SQLException sqle) {

			sqle.printStackTrace();
		} finally {

			try {

				pstmt.close();
				//close connection
				db.closeConnection();
			} catch(SQLException sqle) {

				sqle.printStackTrace();
			} catch(Exception exp) {

				exp.printStackTrace();
			}
		}
		return listOfCars;
	}

	/**
	 * method to update the car details
	 * @param car : CarVO object whose data is to be updated
	 * @return : Boolean
	 */
	public boolean updateCarDAO(CarVO car) {

		boolean flag = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try{
			
			//create connection
			con = db.createConnection();
			
			String query = "UPDATE car SET EngineInCC = ?, FuelCapacity = ?, Mileage = ?, Price = ?, RoadTax = ?, AC = ?, "
					+ "PowerSteering = ?, AccessoryKit = ?, OnRoadPrice = ? WHERE CompanyName = ? AND ModelName = ?;";
			
			if(con != null){
				
				pstmt = con.prepareStatement(query);

				if(pstmt != null){

					pstmt.setInt(1, car.getEngineInCC());
					pstmt.setDouble(2, car.getFuelCapacity());
					pstmt.setDouble(3, car.getMileage());
					pstmt.setDouble(4, car.getPrice());
					pstmt.setDouble(5, car.getRoadTax());
					pstmt.setInt(6, car.getAC());
					pstmt.setInt(7, car.getPowerSteering());
					pstmt.setInt(8, car.getAccessoryKit());
					car.calculateOnRoadPrice();
					pstmt.setDouble(9, car.getOnRoadPrice());
					pstmt.setString(10, car.getCompany());
					pstmt.setString(11, car.getModel());

					pstmt.executeUpdate();
					flag = true;
				}
			}

		} catch(SQLException sqle) {

			sqle.printStackTrace();
		} finally {

			try {

				pstmt.close();
				//close connection
				db.closeConnection();	
			} catch(SQLException sqle) {

				sqle.printStackTrace();
			} catch(Exception exp) {

				exp.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * method to execute the query to add the car details in the database
	 * @param car : CarVO object from which car details to be added in database
	 * @return : Boolean to indicate the success of the process
	 */
	public boolean addCarDAO(CarVO car) {

		PreparedStatement pstmt = null;
		boolean flag = false;
		Connection con = null;
		
		try {
			
			//create connection
			con = db.createConnection();
			
			String query = "INSERT INTO car(CompanyName, ModelName, EngineInCC, FuelCapacity, Mileage, Price, RoadTax, "
					+ "AC, PowerSteering, AccessoryKit, OnRoadPrice) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			if(con != null) {

				pstmt = con.prepareStatement(query);

				if(pstmt != null){

					pstmt.setString(1, car.getCompany());
					pstmt.setString(2, car.getModel());
					pstmt.setInt(3, car.getEngineInCC());
					pstmt.setDouble(4, car.getFuelCapacity());
					pstmt.setDouble(5, car.getMileage());
					pstmt.setDouble(6, car.getPrice());
					pstmt.setDouble(7, car.getRoadTax());
					pstmt.setInt(8, car.getAC());
					pstmt.setInt(9, car.getPowerSteering());
					pstmt.setInt(10, car.getAccessoryKit());
					car.calculateOnRoadPrice();
					pstmt.setDouble(11, car.getOnRoadPrice());

					pstmt.executeUpdate();
					flag = true;
				}
			}		
		} catch(SQLException sqle) {

			sqle.printStackTrace();
		} finally {

			try {

				pstmt.close();
				//close connection
				db .closeConnection();
			} catch(SQLException sqle) {

				sqle.printStackTrace();
			} catch(Exception exp) {

				exp.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * method to check if the car is present in the database
	 * @param car : CarVO object which is to be checked
	 * @return : Boolean
	 */
	public boolean checkCarIsPresentDAO(CarVO car) {

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;

		try{

			//create connection
			con = db.createConnection();
			
			String query = "SELECT EngineInCC, FuelCapacity, Mileage, Price, RoadTax, AC, PowerSteering, AccessoryKit, "
					+ "OnRoadPrice FROM car WHERE CompanyName = ? AND ModelName = ?;";

			if(con != null){

				pstmt = con.prepareStatement(query);

				if(pstmt != null){

					pstmt.setString(1, car.getCompany());
					pstmt.setString(2, car.getModel());

					rst = pstmt.executeQuery();

					//check if car is present or not
					if(rst != null){

						if(rst.next()){ 

							flag = true;
						}
					}
				}
			}

		} catch(SQLException sqle) {

			sqle.printStackTrace();
		} finally {

			try {

				pstmt.close();
				//close connection
				db.closeConnection();
			} catch(SQLException sqle) {

				sqle.printStackTrace();
			} catch(Exception exp) {

				exp.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * method to find the car from the database
	 * @param car : CarVO object which is to be deleted
	 * @return : Boolean
	 */
	public boolean findCarDAO(CarVO car) {

		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;

		try{

			//create connection
			con = db.createConnection();
			
			String query = "SELECT EngineInCC, FuelCapacity, Mileage, Price, RoadTax, AC, PowerSteering, "
					+"AccessoryKit, OnRoadPrice FROM car WHERE CompanyName = ? AND ModelName = ?;";

			if(con != null){

				pstmt = con.prepareStatement(query);

				if(pstmt != null){

					pstmt.setString(1, car.getCompany());
					pstmt.setString(2, car.getModel());

					rst = pstmt.executeQuery();

					if(rst != null){

						//getting the car data
						if(rst.next()){ 

							car.setEngineInCC(rst.getInt(1));
							car.setFuelCapacity(rst.getDouble(2));
							car.setMileage(rst.getDouble(3));
							car.setPrice(rst.getDouble(4));
							car.setRoadTax(rst.getDouble(5));
							car.setAC(rst.getInt(6));
							car.setPowerSteering(rst.getInt(7));
							car.setAccessoryKit(rst.getInt(8));
							car.setOnRoadPrice(rst.getDouble(9));
							flag = true;
						}
					}
				}
			}

		} catch(SQLException sqle) {

			sqle.printStackTrace();
		} finally {

			try {

				pstmt.close();
				//close connection
				db.closeConnection();	
			} catch(SQLException sqle) {

				sqle.printStackTrace();
			} catch(Exception exp) {
				
				exp.printStackTrace();
			}
		}
		return flag;
	}
}