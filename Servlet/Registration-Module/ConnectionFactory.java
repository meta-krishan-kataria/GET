package web1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton Class
public class ConnectionFactory {
	
	//
	private static ConnectionFactory JDBCConnection;
	
	//
	private  Connection con=null;
	
	//private constructor
	private ConnectionFactory(){}
	
	//
	public static ConnectionFactory getInstance(){
		if(JDBCConnection==null){
			JDBCConnection=new ConnectionFactory();
		}
		return JDBCConnection;
	}
	
	//
	public  Connection getConnection() throws SQLException, ClassNotFoundException{
		
		  
        Class.forName("com.mysql.jdbc.Driver");  
        
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lis", "root", "root");  
        
        return con; 
	}
	
	//
	public  void releaseConnection() throws SQLException{
		con.close();
	}
	
	
}
