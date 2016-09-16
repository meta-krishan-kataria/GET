package ws1;

import javax.xml.rpc.ServiceException;

public class Test {

	public static void main(String[] args) {
		TemperatureConversionServiceLocator temp = new TemperatureConversionServiceLocator();
		temp.setTemperatureConversionEndpointAddress("http://localhost:8080/WebService1/services/TemperatureConversion");
		
		try {
			TemperatureConversion t = temp.getTemperatureConversion();
			System.out.println(t.fahrenheitToCelsius(98));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
