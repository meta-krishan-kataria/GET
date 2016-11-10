package com.Metacube.Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Metacube.Model.CarFacade;

/**
 * Factory class to get the CarFacade objects
 */
@Service
public class FacadeFactory {
	
	/**
	 * method to get the CarFacade bean from the ApplicationContect.xml
	 * @return : CarFacade bean
	 */
	public CarFacade getFacade() {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CarFacade facade = context.getBean("facade",CarFacade.class);
		((ClassPathXmlApplicationContext)context).close();
		return facade;
	}
}