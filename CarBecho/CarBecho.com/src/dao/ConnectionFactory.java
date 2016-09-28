package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton Class
public class ConnectionFactory {
	
	//static instance
	private static ConnectionFactory JDBCConnection;	
	
	//Connection instance
	private Connection con=null;
	
	//private constructor
	private ConnectionFactory(){}
	
	//driver url
	private final String DRIVERURL="com.mysql.jdbc.Driver";
	//DB url
	private final String DBURL="jdbc:mysql://localhost:3306/carbecho";
	//
	private final String user="root";
	private final String password="root";
	
	
	
	
	//
	public static ConnectionFactory getInstance(){
		if(JDBCConnection==null){
			JDBCConnection=new ConnectionFactory();
		}
		return JDBCConnection;
	}
	
	//
	public  Connection getConnection() throws SQLException, ClassNotFoundException{
		
		  
        Class.forName(DRIVERURL);  
        
        con= DriverManager.getConnection(DBURL,user, password);  
        
        return con; 
	}
	
	
	//
	public  void releaseConnection() throws SQLException{
		con.close();
	}
	
	
}