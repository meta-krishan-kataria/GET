package com.Metacube.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Metacube.factory.CarFactory;
import com.Metacube.factory.ConnectionFactory;
import com.Metacube.model.CarVO;

/**
 * DAO class to execute the query on car
 */
@Repository
public class CarDAO {

	@Autowired
	CarFactory carFactory;

	private List<CarVO> listOfCars;
	private ConnectionFactory db = null;

	/**
	 * Unparameterized constructor
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
							CarVO carVO = carFactory.getCar();

							carVO.setCompanyName(rst.getString(1));
							carVO.setModelName(rst.getString(2));
							carVO.setEngineInCC(rst.getInt(3));
							carVO.setFuelCapacity(rst.getDouble(4));
							carVO.setMileage(rst.getDouble(5));
							carVO.setPrice(rst.getDouble(6));
							carVO.setRoadTax(rst.getDouble(7));
							carVO.setAC(rst.getString(8));
							carVO.setPowerSteering(rst.getString(9));
							carVO.setAccessoryKit(rst.getString(10));
							carVO.setOnRoadPrice(rst.getDouble(11));
							listOfCars.add(carVO);
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
	public boolean updateCarDAO(CarVO carVO) {

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

					pstmt.setInt(1, carVO.getEngineInCC());
					pstmt.setDouble(2, carVO.getFuelCapacity());
					pstmt.setDouble(3, carVO.getMileage());
					pstmt.setDouble(4, carVO.getPrice());
					pstmt.setDouble(5, carVO.getRoadTax());
					pstmt.setString(6, carVO.getAC());
					pstmt.setString(7, carVO.getPowerSteering());
					pstmt.setString(8, carVO.getAccessoryKit());
					carVO.calculateOnRoadPrice();
					pstmt.setDouble(9, carVO.getOnRoadPrice());
					pstmt.setString(10, carVO.getCompanyName());
					pstmt.setString(11, carVO.getModelName());

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
	public boolean addCarDAO(CarVO carVO) {

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

					pstmt.setString(1, carVO.getCompanyName());
					pstmt.setString(2, carVO.getModelName());
					pstmt.setInt(3, carVO.getEngineInCC());
					pstmt.setDouble(4, carVO.getFuelCapacity());
					pstmt.setDouble(5, carVO.getMileage());
					pstmt.setDouble(6, carVO.getPrice());
					pstmt.setDouble(7, carVO.getRoadTax());
					pstmt.setString(8, carVO.getAC());
					pstmt.setString(9, carVO.getPowerSteering());
					pstmt.setString(10, carVO.getAccessoryKit());
					carVO.calculateOnRoadPrice();
					pstmt.setDouble(11, carVO.getOnRoadPrice());

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
	public boolean checkCarIsPresentDAO(CarVO carVO) {

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

					pstmt.setString(1, carVO.getCompanyName());
					pstmt.setString(2, carVO.getModelName());

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
	public boolean findCarDAO(CarVO carVO) {

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

					pstmt.setString(1, carVO.getCompanyName());
					pstmt.setString(2, carVO.getModelName());

					rst = pstmt.executeQuery();

					if(rst != null){

						//getting the car data
						if(rst.next()){ 

							carVO.setEngineInCC(rst.getInt(1));
							carVO.setFuelCapacity(rst.getDouble(2));
							carVO.setMileage(rst.getDouble(3));
							carVO.setPrice(rst.getDouble(4));
							carVO.setRoadTax(rst.getDouble(5));
							carVO.setAC(rst.getString(6));
							carVO.setPowerSteering(rst.getString(7));
							carVO.setAccessoryKit(rst.getString(8));
							carVO.setOnRoadPrice(rst.getDouble(9));
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