package Model;

import java.util.List;
import DAOLayer.DatabaseConnection;
import DAOLayer.EmployeeDAO;

/**
 * Facade Class to serve as Model
 * This class interact with DAO classes
 */
public class EmployeeFacade {
	
	/**
	 * method to find the data of all employees from the database
	 * @return : list of EmployeeVO objects
	 */
	public List<EmployeeVO> getAllEmployees(){
		
		List<EmployeeVO> listOfEmployees = null;
		DatabaseConnection db = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());
			
			//calls the DAO method to get the list of employees
			listOfEmployees = employeeDAO.selectAllEmployeesDAO();
			
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return listOfEmployees;
	}
		
	/**
	 * method to add employees in the database
	 * @param employee : EmployeeVO object
	 * @return : Integer
	 */
	public int addEmployee(EmployeeVO employee){

		int result = 0;		
		DatabaseConnection db = null;

		try{

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());
			
			//check if the employee is already present or not
			if(employeeDAO.findEmployeeByIdDAO(employee)) {
				
				result = 1;
			}else if(employeeDAO.addEmployeeDAO(employee)){					//calls the DAO method to add the employee

				result = 2;;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * method to find employees based on id from the database
	 * @param employee : EmployeeVO object
	 * @return : Boolean
	 */
	public EmployeeVO getEmployeeById(int id){

		DatabaseConnection db = null;
		EmployeeVO employee = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());

			//calls the DAO method to find the employee
			employee=employeeDAO.getEmployeeByIdDAO(id);

		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return employee;
	}
	
	/**
	 * method to find employees based on id from the database
	 * @param employee : EmployeeVO object
	 * @return : Boolean
	 */
	public int findEmployeeById(EmployeeVO employee){

		DatabaseConnection db = null;
		int result = 0;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());

			//calls the DAO method to find the employee
			if(employeeDAO.findEmployeeByIdDAO(employee)){

				result = 1;
			} else {
				
				result = 2;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * method to find employees based on name from the database
	 * @param employee : EmployeeVO object
	 * @return : list of EmployeeVO objects
	 */
	public List<EmployeeVO> findEmployeeByName(EmployeeVO employee){

		DatabaseConnection db = null;
		List<EmployeeVO> listOfEmployees = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());

			//calls the DAO method to get the list of all employees with the specific name
			listOfEmployees = employeeDAO.findEmployeesByNameDAO(employee);

		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return listOfEmployees;
	}
	
	/**
	 * method to delete employees based on id from the database
	 * @param employee : EmployeeVO object
	 * @return : Boolean
	 */
	public int deleteEmployeeById(EmployeeVO employee){

		int result = 0;
		DatabaseConnection db = null;

		try {

			//database connection
			db = DatabaseConnection.getInstance();
			EmployeeDAO employeeDAO = new EmployeeDAO(db.createConnection());

			//calls the DAO method to delete the employee
			if(employeeDAO.deleteEmployeeByIdDAO(employee)){

				result = 1;
			} else {
				
				result = 2;
			}
		} catch(Exception ex){

			ex.printStackTrace();
		} finally{
			
			try {
				
				db.closeConnection();
			} catch(Exception ex){
				
				ex.printStackTrace();
			}
		}
		return result;
	}
}