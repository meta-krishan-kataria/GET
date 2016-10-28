package restServer;

import java.util.List;
import Model.EmployeeVO;
import com.google.gson.Gson;

/**
 * class to convert one type of data format to another
 */
public class DataFormatConversion {

	/**
	 * method to convert an EmployeeVO object to a JSON object
	 * @param employee : EmployeeVO object
	 * @return : JSON object as String
	 */
	public String convertToJson(EmployeeVO employee) {
		
		String employeeInJson = null;		
		try {

			Gson gson = new Gson();
			employeeInJson = gson.toJson(employee);
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
		return employeeInJson;
	}

	/**
	 * method to convert list of EmployeeVO objects into a JSON object
	 * @param employees : list of EmployeeVO objects
	 * @return : JSON object as String
	 */
	public String convertToJson(List<EmployeeVO> employees) {
		
		String employeeInJson = null;		
		try {

			Gson gson = new Gson();
			employeeInJson = gson.toJson(employees);
		} catch(Exception exp) {
			
			exp.printStackTrace();
		}
		return employeeInJson;
	}
}