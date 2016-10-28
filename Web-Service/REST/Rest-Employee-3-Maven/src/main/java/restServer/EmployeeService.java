package restServer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Model.EmployeeFacade;
import Model.EmployeeVO;

@Path("/service")
public class EmployeeService {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayWelcome() {
		return "Welcome";
	} 

	/**
	 * POST method to add an employee in the database
	 * @param json : JSON object as String
	 * @return : String message
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addEmployee")
	public String addEmployee(String json) {

		String resultStr = "";
		int result = 0;
		try {

			//JSON object is retrieved from the string
			Gson gson = new Gson();
			JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
		
			
			int id = Integer.parseInt(jsonObject.get("id").getAsString());
			String name = jsonObject.get("name").getAsString();
			int age = Integer.parseInt(jsonObject.get("age").getAsString());
			String gender = jsonObject.get("gender").getAsString();
			String address = jsonObject.get("address").getAsString();

			//EmployeeVO object is created
			EmployeeVO employee = new EmployeeVO();
			EmployeeFacade facade = new EmployeeFacade();

			employee.setId(id);
			employee.setName(name);
			employee.setAge(age);
			employee.setGender(gender);
			employee.setAddress(address);

			result = facade.addEmployee(employee);

			if(result == 1) {

				resultStr = "Employee is already present";
			} else if(result ==2) {

				resultStr = "Employee details are successfully added";
			} else {

				resultStr = "Something Went wrong.";
			}
		} catch(Exception exp) {

			exp.printStackTrace();
		}
		return resultStr;
	}

	/**
	 * POST method to retrieve employee of the given employee id
	 * @param employeeId : employee id
	 * @return : employee details
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEmployeeById/{id}")
	public String getEmployeeById(@PathParam("id") int employeeId) {


		EmployeeVO employee=null;
		String employeeJSON=null;

		try {



			EmployeeFacade facade = new EmployeeFacade();

			DataFormatConversion dataConversion = new DataFormatConversion();


			employee=facade.getEmployeeById(employeeId);

			employeeJSON=dataConversion.convertToJson(employee);



		} catch(Exception exp) {

			exp.printStackTrace();
		}
		return employeeJSON;
	}

	/**
	 * POST method to retrieve employees of employee name
	 * @param name : employee name
	 * @return : employee details
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/getEmployeeByName")
	public String getEmployeeByName(String name) {

		List<EmployeeVO> employeeList = null;
		String resultStr = "";
		try {

			name = name.trim();
			EmployeeVO employee = new EmployeeVO();
			EmployeeFacade facade = new EmployeeFacade();
			employee.setName(name);
			employeeList = facade.findEmployeeByName(employee);
			DataFormatConversion dataConversion = new DataFormatConversion();

			if(employeeList.size() > 0) {

				resultStr = dataConversion.convertToJson(employeeList);
			} else if(employeeList.size() == 0) {

				resultStr = "No employees with name : "+name+" found.";
			} else {

				resultStr = "Something went wrong.";
			}
		} catch(Exception exp) {

			exp.printStackTrace();
		}
		return resultStr;
	}

	/**
	 * GET method to retrieve all the employees
	 * @return : list of the employees
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/getAllEmployees")
	public String getAllEmployees() {

		List<EmployeeVO> employeeList = null;
		String resultStr = "";
		try {

			EmployeeFacade facade = new EmployeeFacade();
			employeeList = facade.getAllEmployees();
			DataFormatConversion dataConversion = new DataFormatConversion();

			if(employeeList.size() > 0) {

				resultStr = dataConversion.convertToJson(employeeList);
			} else if(employeeList.size() == 0) {

				resultStr = "No employees found.";
			} else {

				resultStr = "Something went wrong.";
			}
		} catch(Exception exp) {

			exp.printStackTrace();
		}
		return resultStr;
	}

	/**
	 * POST method to delete an employee of the given employee id
	 * @param employeeId : employee id
	 * @return : string message
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/deleteEmployeeById")
	public String deleteEmployeeById(String employeeId) {

		String resultStr = "";
		try {

			EmployeeVO employee = new EmployeeVO();
			EmployeeFacade facade = new EmployeeFacade();
			int id = Integer.parseInt(employeeId);
			employee.setId(id);

			int result = facade.deleteEmployeeById(employee); 

			if(result == 1) {

				resultStr = "Employee deleted successfully";
			} else if(result == 2) {

				resultStr = "Employee not found.";
			} else {

				resultStr = "Something went wrong.";
			}
		} catch(Exception exp) {

			exp.printStackTrace();
		}
		return resultStr;
	}


}
