package com.Metacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.model.CarVO;
import com.Metacube.service.CarServiceImpl;

/**
 * controller class to add the car details in the database
 */
@Controller
public class AddCarController {

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
	 * @return : CarVO object
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
	 * method to send a CarVO object in the UI
	 * @return : Model Object
	 */
	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public ModelAndView addCar(CarVO carVO) {

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
		
		String message = "You did something wrong";
		//find car in the database
		CarVO car = carServiceImpl.findCar(carVO.getCompanyName(), carVO.getModelName());
		
		//add car in the database
		if(car == null){
			
			this.carServiceImpl.addCar(carVO);
			message="Car details added succesfully";
		}else{
			
			message = "Car is already present";
		}
		return new ModelAndView("ResultPage", "message", message);
	}
}