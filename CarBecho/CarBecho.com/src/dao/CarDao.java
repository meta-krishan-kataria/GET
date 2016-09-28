package dao;

import model.CarVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
	
	//
	public List<CarVO> selectAllCar() throws DBConnectionFailedException, CarDataAccessException
	{
		ConnectionFactory factory=null;
		List<CarVO> listOfCars=null;
		
		try {
			//getting connection
			factory=ConnectionFactory.getInstance();
			Connection connection=factory.getConnection();
			
			//preparing sql statement
			String sqlQuery="SELECT id,model,company FROM cars";
			PreparedStatement selectAllCarNames=connection.prepareStatement(sqlQuery);
			
			//executing query and getting result
			ResultSet resultSet=selectAllCarNames.executeQuery();
			
			listOfCars=new ArrayList<CarVO>();
			
			while(resultSet.next()){
				CarVO car=new CarVO();
				car.setId( resultSet.getInt("id") );
				car.setModel( resultSet.getString("model") );
				car.setCompany(resultSet.getString("company"));
				
				listOfCars.add(car);
				
			}
			
			//return not working here
			//return listOfCars;
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBConnectionFailedException();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CarDataAccessException();
			
		}finally{
			
			try {
				factory.releaseConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBConnectionFailedException();
			}
		}
		
		
		return listOfCars;
		
		
	}
	
	//
	public CarVO selectCarDetailById(int id) throws DBConnectionFailedException, CarDataAccessException
	{
		
		ConnectionFactory factory=null;
		CarVO car=null;
		
		try {
			//getting connection
			factory=ConnectionFactory.getInstance();
			Connection connection=factory.getConnection();
			
			//preparing sql statement
			PreparedStatement selectCarDetails=connection.prepareStatement("SELECT * FROM cars WHERE id=?");
			selectCarDetails.setInt(1, id);
			
			//executing query and getting result
			ResultSet rs=selectCarDetails.executeQuery();
			
			
			while(rs != null){

				car=new CarVO(rs.getString("company"), rs.getString("model"), rs.getInt("engineInCC"),
						rs.getInt("fuelCapacity"),rs.getInt("mileage"),rs.getInt("price"),rs.getInt("roadTax"),
						rs.getInt("hasAC"),
						rs.getInt("hasPowerSteering"),
						rs.getInt("hasAccessoryKit"),
						rs.getInt("id"));
				
			}
			
			//return not working here
			//return listOfCars;
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBConnectionFailedException();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CarDataAccessException();
			
		}finally{
			
			try {
				factory.releaseConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBConnectionFailedException();
			}
		}
		
		//
		return car;
		
		
		
	}

	//
	public boolean addCar(CarVO car) throws DBConnectionFailedException, CarDataAccessException
	{
		
		ConnectionFactory factory=null;
		boolean result;
		
		
		try {
			//getting connection
			factory=ConnectionFactory.getInstance();
			Connection connection=factory.getConnection();
			
			//preparing sql statement
			PreparedStatement insertCar=connection.prepareStatement("INSERT INTO `cars` "+
			"(`id`,`model`,`company`,`engineincc`,`fuelcapacity`,`mileage`,`price`,`roadtax`,`ac`,`powersteering`,`accessorykit`)"+
			" VALUES (?,?,?,?,?,?,?,?,?,?,?);");
			
			insertCar.setInt(1, car.getId());
			insertCar.setString(2, car.getModel());
			insertCar.setString(3, car.getCompany());
			insertCar.setInt( 4, car.getEngineInCC());
			insertCar.setInt( 5, car.getFuelCapacity());
			insertCar.setInt( 6, car.getMileage());
			insertCar.setInt( 7, car.getPrice());
			insertCar.setInt( 8, car.getRoadTax());
			insertCar.setInt( 9, car.getAc());
			insertCar.setInt( 10, car.getPowerSteering());
			insertCar.setInt( 11, car.getAccessoryKit());
			
			//
			result=insertCar.execute();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBConnectionFailedException();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CarDataAccessException();
			
		}finally{
			
			try {
				factory.releaseConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBConnectionFailedException();
			}
		}
		
		//
		return result;
		
	}
	
	//
	public boolean editCar(CarVO car) throws DBConnectionFailedException, CarDataAccessException
	{
		
		ConnectionFactory factory=null;
		boolean result;
		
		try {
			//getting connection
			factory=ConnectionFactory.getInstance();
			Connection connection=factory.getConnection();
			
			//preparing sql statement
			PreparedStatement updateCar=connection.prepareStatement("UPDATE car SET "+
			"`model`=?,`company`=?,`engineincc`=?,`fuelcapacity`=?,`mileage`=?,`price`=?,"
			+"`roadtax`=?,`ac`=?,`powersteering`=?,`accessorykit`=? "
			+" WHERE id=?");
			
			
			updateCar.setString(1, car.getModel());
			updateCar.setString(2, car.getCompany());
			updateCar.setInt( 3, car.getEngineInCC());
			updateCar.setInt( 4, car.getFuelCapacity());
			updateCar.setInt( 5, car.getMileage());
			updateCar.setInt( 6, car.getPrice());
			updateCar.setInt( 7, car.getRoadTax());
			updateCar.setInt( 8, car.getAc());
			updateCar.setInt( 9, car.getPowerSteering());
			updateCar.setInt( 10, car.getAccessoryKit());
			updateCar.setInt(11, car.getId());
			
			//executing
			result=updateCar.execute();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBConnectionFailedException();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CarDataAccessException();
			
		}finally{
			
			try {
				factory.releaseConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBConnectionFailedException();
			}
		}
		
		//
		return result;
		
	}
	
}
