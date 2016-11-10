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
 * controller class to find a car from the database based on companyName and modelName
 */
@Controller
public class FindCarController {

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
	 * method to send a CarVO object to the UI
	 * @return : Model Object
	 */
	@RequestMapping(value = "/findCar", method = RequestMethod.GET)
	public ModelAndView findCar() {

		return new ModelAndView("findCarUI", "carVO", carVO);
	}

	/**
	 * method to find the car details from the database
	 * @param carVO : The object with the data of the car to find
	 * @param bindResult : BindingResult object to validate the parameters
	 * @return : Model Object
	 */
	@RequestMapping(value="/findcar", method = RequestMethod.GET)  
	public ModelAndView findcar(@ModelAttribute("carVO")CarVO carVO, BindingResult bindResult){ 

		String companyName = carVO.getCompanyName();
		String modelName = carVO.getModelName();
		
		//find car from the database
		carVO = this.carServiceImpl.findCar(companyName, modelName);
		
		if(carVO == null) {
			
			String message = "Car not found";
			return new ModelAndView("ResultPage", "message", message);
		}

		//calls detailed view UI to display the details of the car
		ModelAndView model = new ModelAndView("carDetailedViewUI");
		model.addObject("car", carVO);
		return model;
	}

	/**
	 * method to find the car based on  the parameters
	 * @param companyName : name of the car company
	 * @param modelName : name of the car model
	 * @return : Model Object
	 */
	@RequestMapping(value="/findcar/{companyName}/{modelName}",method = RequestMethod.GET)  
	public ModelAndView findcar(@PathVariable("companyName") String companyName, @PathVariable("modelName") String modelName) {

		//find the car details
		CarVO car = this.carServiceImpl.findCar(companyName, modelName);

		//calls detailed view UI to display the details of the car
		ModelAndView model = new ModelAndView("carDetailedViewUI");
		model.addObject("car", car);
		return model;
	}
}