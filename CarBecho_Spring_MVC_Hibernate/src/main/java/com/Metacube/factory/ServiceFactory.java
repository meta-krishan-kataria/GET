package com.Metacube.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Metacube.service.CarServiceImpl;

/**
 * Factory class to get the CarFacade objects
 */
@Service
public class ServiceFactory {

	/**
	 * method to get the CarFacade bean from the applicationContect.xml
	 * @return : CarFacade bean
	 */
	public CarServiceImpl getService() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarServiceImpl carServiceImpl = (CarServiceImpl) context.getBean("carServiceImpl");
		((ClassPathXmlApplicationContext)context).close();
		return carServiceImpl;
	}
}