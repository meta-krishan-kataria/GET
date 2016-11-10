package com.Metacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.model.CarVO;
import com.Metacube.service.CarServiceImpl;

/**
 * controller class to update the car details
 */
@Controller
public class UpdateCarController {

	private CarServiceImpl carServiceImpl;
	private CarVO carVO;
	
	/**
	 * method to get CarServiceImpl object
	 * @return : CarServiceImpl object
	 */
	public CarServiceImpl getCarServiceImpl() {
		return carServiceImpl;
	}
	
	/**
	 * method to set CarServiceImpl object
	 * @param carServiceImpl
	 */
	@Autowired(required=true)
	public void setCarServiceImpl(CarServiceImpl carServiceImpl) {
		this.carServiceImpl = carServiceImpl;
	}

	/**
	 * method to get CarVO object
	 * @return : CraVO object
	 */
	public CarVO getCarVO() {
		return carVO;
	}
	
	/**
	 * method to set CarVO object
	 * @param carVO
	 */
	@Autowired(required=true)
	public void setCarVO(CarVO carVO) {
		this.carVO = carVO;
	}

	/**
	 * method to take the car details from the UI and create a CarVO object which is returned to another UI
	 * @param companyName : Name of the car company
	 * @param modelName : Name of the car model
	 * @return : Model Object
	 */
	@RequestMapping(value="/updateCar/{companyName}/{modelName}",method = RequestMethod.GET)
	public ModelAndView updateCar(@PathVariable("companyName") String companyName, @PathVariable("modelName") String modelName) {

		//find the car from database
		carVO = this.carServiceImpl.findCar(companyName, modelName);

		//creating model object
		ModelAndView model = new ModelAndView("updateCarUI");
		model.addObject("car", carVO);
		return model;
	}

	/**
	 * method to update the car details in the database
	 * @param carVO : details of car to be inserted in database is wrapped in this object
	 * @param bindResult : BindingResult object to validate the parameters
	 * @return : Model Object
	 */
	@RequestMapping(value = "/updatecar", method = RequestMethod.POST)
	public ModelAndView updatecar(@ModelAttribute("carVO")CarVO carVO, BindingResult bindResult) {

		String message = "";
		//update car
		this.carServiceImpl.updateCar(carVO);

		message = "Car details updated successfully";
		return new ModelAndView("ResultPage", "message", message);
	}
}