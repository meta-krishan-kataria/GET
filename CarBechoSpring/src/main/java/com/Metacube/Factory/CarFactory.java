package com.Metacube.Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Metacube.Model.CarVO;

/**
 * Factory class to get the car objects
 */
@Service
public class CarFactory {

	/**
	 * method to get the CarVO bean from the ApplicationContect.xml
	 * @return : CarVO bean
	 */
	public CarVO getCar() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CarVO car = context.getBean("car",CarVO.class);
		((ClassPathXmlApplicationContext)context).close();
		return car;
	}
}
