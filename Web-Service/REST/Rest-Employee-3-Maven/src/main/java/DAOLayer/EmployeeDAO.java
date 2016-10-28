package DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.EmployeeVO;

/**
 * DAO class to execute the query on employee
 */
public class EmployeeDAO {

	private Connection con;
	
	/**
	 * parameterized constructor
	 * @param con : Connection object
	 */
	public EmployeeDAO(Connection con) {
	
		this.con = con;
	}
	
	/**
	 * method to return the list of all the employees present in the database 
	 * @return : list of employees
	 */
	public List<EmployeeVO> selectAllEmployeesDAO(){

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		List<EmployeeVO> listOfEmployees = new ArrayList<EmployeeVO>();
		
		try{

			String query = "SELECT ID, name, age, gender, address FROM employee;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){

					rst = pstmt.executeQuery();
			
					if(rst != null){

						while(rst.next()){

							EmployeeVO employee = new EmployeeVO();
							employee.setId(rst.getInt(1));
							employee.setName(rst.getString(2));
							employee.setAge(rst.getInt(3));
							employee.setGender(rst.getString(4));
							employee.setAddress(rst.getString(5));
							listOfEmployees.add(employee);
						}
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return listOfEmployees;
	}	
	
	/**
	 * method to execute the query to add the employee details in the database
	 * @param employee : EmployeeVO object from which employee details to be added in database
	 * @return : Boolean to indicate the success of the process
	 */
	public boolean addEmployeeDAO(EmployeeVO employee) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		try {
			
			String query = "INSERT INTO employee(ID, name, age, gender, address) Values (?, ?, ?, ?, ?);";
			
			if(con != null){
			
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){

					pstmt.setInt(1, employee.getId());
					pstmt.setString(2, employee.getName());
					pstmt.setInt(3, employee.getAge());
					pstmt.setString(4, employee.getGender());
					pstmt.setString(5, employee.getAddress());
				
					pstmt.executeUpdate();
					flag = true;
				}
			}		
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}	

	/**
	 * method to find the employee based on ID from the database
	 * @param id : id of the  employee
	 * @return : EmployeeVO
	 */
	public EmployeeVO getEmployeeByIdDAO(int id) {
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		EmployeeVO employee=new EmployeeVO();
		
		try{

			String query = "SELECT name, age, gender, address FROM employee WHERE ID = ?;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){
				
					pstmt.setInt(1, id);
					rst = pstmt.executeQuery();
					
					if(rst != null){

						if(rst.next()){ 
							
							employee.setId(id);
							System.out.println( rst.getString(1) );
							
							employee.setName(rst.getString(1));
							employee.setAge(rst.getInt(2));
							employee.setGender(rst.getString(3));
							employee.setAddress(rst.getString(4));
							
						}
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		
		//
		return employee;
	}
	
	
	/**
	 * method to find the employee based on ID from the database
	 * @param employee : EmployeeVO object 
	 * @return : Boolean
	 */
	public boolean findEmployeeByIdDAO(EmployeeVO employee) {
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		try{

			String query = "SELECT name, age, gender, address FROM employee WHERE ID = ?;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){
				
					pstmt.setInt(1, employee.getId());
					rst = pstmt.executeQuery();
					
					if(rst != null){

						if(rst.next()){ 

							employee.setName(rst.getString(1));
							employee.setAge(rst.getInt(2));
							employee.setGender(rst.getString(3));
							employee.setAddress(rst.getString(4));
							flag = true;
						}
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}
	
	
	/**
	 * method to return the list of all the employees of a specific name in the database 
	 * @return : list of employees
	 */
	public List<EmployeeVO> findEmployeesByNameDAO(EmployeeVO employee){

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		List<EmployeeVO> listOfEmployees = new ArrayList<EmployeeVO>();
		
		try{

			String query = "SELECT ID, name, age, gender, address FROM employee WHERE name = ?;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){

					pstmt.setString(1, employee.getName());
					rst = pstmt.executeQuery();
			
					if(rst != null){

						while(rst.next()){

							EmployeeVO employeeTemp = new EmployeeVO();
							employeeTemp.setId(rst.getInt(1));
							employeeTemp.setName(rst.getString(2));
							employeeTemp.setAge(rst.getInt(3));
							employeeTemp.setGender(rst.getString(4));
							employeeTemp.setAddress(rst.getString(5));
							listOfEmployees.add(employeeTemp);
						}
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return listOfEmployees;
	}
	
	/**
	 * method to delete an employee based on ID from the database
	 * @param employee : EmployeeVO object which is to be deleted
	 * @return : Boolean
	 */
	public boolean deleteEmployeeByIdDAO(EmployeeVO employee) {
		
		boolean flag = false;
		PreparedStatement pstmt = null;
		
		try{

			String query = "DELETE FROM employee WHERE ID = ?;";

			if(con != null){
				
				pstmt = con.prepareStatement(query);
			
				if(pstmt != null){
				
					pstmt.setInt(1, employee.getId());
					if(pstmt.executeUpdate() > 0) {
						
						flag = true;
					}
				}
			}
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
		} finally {
			
			try {

				pstmt.close();	
			} catch(SQLException sqle) {
				
				sqle.printStackTrace();
			}
		}
		return flag;
	}
}