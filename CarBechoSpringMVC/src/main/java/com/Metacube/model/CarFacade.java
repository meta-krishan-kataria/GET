package com.Metacube.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Metacube.daoLayer.CarDAO;

/**
 * Facade Class to serve as Model
 * This class interact with DAO classes
 */
@Service
public class CarFacade {

	@Autowired
	private CarDAO carDAO;

	/**
	 * method to find the data of all cars from the database
	 * @return : list of CarVO objects
	 */
	public List<CarVO> getAllCars(){

		List<CarVO> listOfCars = null;

		try {			

			//calls the DAO method to get the list of cars
			listOfCars = carDAO.selectAllCarsDAO();

		} catch(Exception ex){

			ex.printStackTrace();
		}
		return listOfCars;
	}

	/**
	 * method to update the car's features
	 * @param car : CarVO object sent by CarUpdateController class
	 * @return : Boolean
	 */
	public boolean updateCar(CarVO carVO){

		boolean flag = false;

		try {

			//calls the DAO method to update the car's features
			if(carDAO.updateCarDAO(carVO)){

				flag = true;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		}
		return flag;
	}

	/**
	 * method to add cars in the database
	 * @param car : CarVO object sent by AddCarController class
	 * @return : Integer
	 */
	public int addCar(CarVO carVO){

		int result = 0;

		try{

			//check if the car is already present or not
			if(carDAO.checkCarIsPresentDAO(carVO)) {

				result = 1;
			}else if(carDAO.addCarDAO(carVO)){					//calls the DAO method to add the car

				result = 2;;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * method to find cars from the database
	 * @param car : CarVO object sent by FindCarController class
	 * @return : Boolean
	 */
	public boolean findCar(CarVO carVO){

		boolean flag = false;

		try {

			//calls the DAO method to find the car
			if(carDAO.findCarDAO(carVO)){

				flag = true;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		}
		return flag;
	}
}