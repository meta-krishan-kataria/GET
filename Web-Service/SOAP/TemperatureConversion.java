package ws1;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class TemperatureConversion {
	
	/**
	 * converts Fahrenheit to celsius
	 * */
	@WebMethod
	public int  fahrenheitToCelsius(int fahrenheit){
		
		return (int)((fahrenheit-32)*(5.0/9.0));
		
	}
}
