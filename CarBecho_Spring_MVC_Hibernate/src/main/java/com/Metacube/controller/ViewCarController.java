package com.Metacube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.model.CarVO;
import com.Metacube.service.CarServiceImpl;

/**
 * controller class to view the list of the cars present in the database
 * calls viewCarsListUI.jsp with the data
 */
@Controller
public class ViewCarController {
	
	private CarServiceImpl carServiceImpl;

	/**
	 * method to set CarServiceImpl object
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
	 * It provides list of employees in model object 
	 * @return : Model Object
	 */
	@RequestMapping(value = "/viewCarList", method = RequestMethod.GET)  
	public ModelAndView viewCarList() {

		List<CarVO> list = this.carServiceImpl.getAllCars();

		ModelAndView model = new ModelAndView("viewCarsListUI");
		model.addObject("list",list);
		return model;  
	}
} 