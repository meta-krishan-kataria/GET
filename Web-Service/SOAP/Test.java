package ws1;

import javax.xml.rpc.ServiceException;

public class ClientTest {

	public static void main(String[] args) {
		TemperatureConversionServiceLocator temp = new TemperatureConversionServiceLocator();
		temp.setTemperatureConversionEndpointAddress("http://localhost:8080/WebService1/services/TemperatureConversion");
		
		try {
			TemperatureConversion tc= temp.getTemperatureConversion();
			System.out.println(tc.fahrenheitToCelsius(98));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
