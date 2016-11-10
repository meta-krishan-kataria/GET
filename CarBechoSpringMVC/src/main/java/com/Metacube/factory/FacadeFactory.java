package com.Metacube.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Metacube.model.CarFacade;

/**
 * Factory class to get the CarFacade objects
 */
@Service
public class FacadeFactory {

	/**
	 * method to get the CarFacade bean from the applicationContect.xml
	 * @return : CarFacade bean
	 */
	public CarFacade getFacade() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarFacade carFacade = context.getBean("carFacade",CarFacade.class);
		((ClassPathXmlApplicationContext)context).close();
		return carFacade;
	}
}