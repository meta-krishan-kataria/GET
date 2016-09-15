package web1;

import java.sql.Connection;
import java.sql.DriverManager;
/*import java.sql.ResultSet;*/
import java.sql.SQLException;
import java.sql.Statement;

import web1.DBConnectionFailedException;
import web1.DataInsertionException;
import web1.Student;

/**
 *
 * @author Krishan
 */
public class DataAccessObject {
    
    private Connection connection=null;
    private Statement statement=null;
   /* private ResultSet rs = null;  */
    
    
    /**
     * private method 
     * creates connection with DB
     * @throws DBConnectionFailedException
     * */
    private void createConnection() throws DBConnectionFailedException{
        try {
        	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			connection=DriverManager.getConnection("jdbc:odbc:Exam2");
			statement=connection.createStatement();
			
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new DBConnectionFailedException();
			
		}
        
    }
    
    /**
     * inserts student record to DB
     * @throws DataInsertionException
     * */
    public void insertStudentRecord(Student student) throws DataInsertionException{

    	
    	String name=student.getName();
        String pswd=student.getPswd();
        String gender=student.getGender();
        String college=student.getCollege();
        String year=student.getYear();
        String regno=student.getRegno();
    	
    	
    	String query="insert into student values( '"+regno+"','"+name+ "','" +pswd+ "','" +gender
                + "','" +college+ "','" +year+ "'); "; 
                 
    	try {
    		
    		//connecting with DB
    		createConnection();
    		//executing query
			statement.executeUpdate(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DataInsertionException();
			
		} finally{
			
			try {
				
				releaseConnection();	// it also throws exception !! 
				
			} catch (DBConnectionFailedException e) {
				
				//  ???
			
			}	
			
		
		}

    }
    
    /**
     * private method
     * releases db connection
     * @throws DBConnectionFailedException
     * */
    private void releaseConnection() throws DBConnectionFailedException{
    	try {
			statement.close();
			connection.close();
		} catch (SQLException e) {

			throw new DBConnectionFailedException("Unable to close Connection");
		}
    	
    }
    
    
}
