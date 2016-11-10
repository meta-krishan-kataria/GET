package com.Metacube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.factory.FacadeFactory;
import com.Metacube.model.CarVO;

/**
 * controller class to view the list of the cars present in the database
 * calls viewCarsListUI.jsp with the data
 */
@Controller
public class ViewCarController {

	@Autowired
	FacadeFactory facadeFactory;

	/**
	 * It provides list of employees in model object 
	 * @return : Model Object
	 */
	@RequestMapping(value = "/viewCarList", method = RequestMethod.GET)  
	public ModelAndView viewCarList() {

		List<CarVO> list = facadeFactory.getFacade().getAllCars();

		ModelAndView model = new ModelAndView("viewCarsListUI");
		model.addObject("list",list);
		return model;  
	}
} 