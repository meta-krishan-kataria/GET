package com.Metacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Metacube.daoLayer.CarDAOImpl;
import com.Metacube.model.CarVO;

/**
 * Service Class
 * This class interact with DAO classes
 */
@Service
public class CarServiceImpl{

	private CarDAOImpl carDAOImpl;

	/**
	 * method to get CarDAOImpl object
	 * @return : CarDAOImpl object
	 */
	public CarDAOImpl getCarDAOImpl() {
		return carDAOImpl;
	}

	/**
	 * method to set CarDAOImpl object
	 * @param carDAOImpl
	 */
	@Autowired(required=true)
	public void setCarDAOImpl(CarDAOImpl carDAOImpl) {
		this.carDAOImpl = carDAOImpl;
	}

	/**
	 * method to find the data of all cars from the database
	 * @return : list of CarVO objects
	 */
	@Transactional
	public List<CarVO> getAllCars(){

		//calls the DAO method to get the list of cars
		return this.carDAOImpl.selectAllCarsDAO();
	}

	/**
	 * method to update the car's features
	 * @param car : CarVO object sent by CarUpdateController class
	 */
	@Transactional
	public void updateCar(CarVO carVO){

		//calls the DAO method to update the car's features
		this.carDAOImpl.updateCarDAO(carVO);
	}

	/**
	 * method to add cars in the database
	 * @param car : CarVO object sent by AddCarController class
	 */
	@Transactional
	public void addCar(CarVO carVO){

		//calls the DAO method to add the car
		this.carDAOImpl.addCarDAO(carVO);
	}

	/**
	 * method to find cars from the database
	 * @param car : CarVO object sent by FindCarController class
	 */
	@Transactional
	public CarVO findCar(String companyName, String modelName) {

		//calls the DAO method to find the car
		CarVO carVO = this.carDAOImpl.findCarDAO(companyName, modelName);
		return carVO;
	}
}