package com.Metacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.factory.FacadeFactory;
import com.Metacube.model.CarVO;

/**
 * controller class to update the car details
 */
@Controller
public class UpdateCarController {

	@Autowired
	FacadeFactory facadeFactory;

	@Autowired
	CarVO carVO;

	/**
	 * method to take the car details from the UI and create a CarVO object which is returned to another UI
	 * @param companyName : Name of the car company
	 * @param modelName : Name of the car model
	 * @return : Model Object
	 */
	@RequestMapping(value="/updateCar/{companyName}/{modelName}",method = RequestMethod.GET)
	public ModelAndView updateCar(@PathVariable("companyName") String companyName, @PathVariable("modelName") String modelName) {

		//setting data in CarVO object
		carVO.setCompanyName(companyName);
		carVO.setModelName(modelName);
		//find the car from database
		facadeFactory.getFacade().findCar(carVO);

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
		Boolean flag = facadeFactory.getFacade().updateCar(carVO);

		if(flag) {

			message = "Car Updated";
		} else {

			message = "You did something wrong";
		}
		return new ModelAndView("ResultPage", "message", message);
	}
}