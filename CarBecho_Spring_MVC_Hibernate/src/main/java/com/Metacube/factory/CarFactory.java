package com.Metacube.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Metacube.model.CarVO;

/**
 * Factory class to get the car objects
 */
@Service
public class CarFactory {

	/**
	 * method to get the CarVO bean from the applicationContect.xml
	 * @return : CarVO bean
	 */
	public CarVO getCar() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CarVO carVO = (CarVO) context.getBean("carVO");
		((ClassPathXmlApplicationContext)context).close();
		return carVO;
	}
}