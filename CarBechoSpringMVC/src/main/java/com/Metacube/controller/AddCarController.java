package com.Metacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.factory.FacadeFactory;
import com.Metacube.model.CarVO;

/**
 * controller class to add the car details in the database
 */
@Controller
public class AddCarController {

	@Autowired
	FacadeFactory facadeFactory;

	@Autowired
	CarVO carVO;

	/**
	 * method to send a CarVO object in the UI
	 * @return : Model Object
	 */
	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public ModelAndView addCar() {

		return new ModelAndView("addCarUI", "carVO", carVO);
	}

	/**
	 * method to add car in the database
	 * @param carVO : CarVO object to be added in the database
	 * @param bindResult : BindingResult object to validate the parameters
	 * @return : Model Object
	 */
	@RequestMapping(value = "/addcar", method = RequestMethod.POST)
	public ModelAndView addcar(@ModelAttribute("carVO")CarVO carVO, BindingResult bindResult) {

		String message = "";
		//add car in the database
		int result = facadeFactory.getFacade().addCar(carVO);

		if(result == 1) {

			message = "Car Already Present";
		} else if(result == 2) {

			message = "Car Added Succesfully";
		} else {

			message = "You did something wrong";
		}
		return new ModelAndView("ResultPage", "message", message);
	}
}