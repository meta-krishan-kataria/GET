package com.Metacube.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

/**
 * class to create database connection
 */
@Service
public class ConnectionFactory {

	private static ConnectionFactory db;
	private Connection con = null;

	/**
	 * private unparameterized constructor
	 */
	private ConnectionFactory() {}

	/**
	 * method to create an instance of the class only one time (Singleton)
	 * @return : the object of this class
	 */
	public static ConnectionFactory getInstance() {

		if(db == null) {
			db = new ConnectionFactory();
		}
		return db;
	}

	/**
	 * method to establish the database connection
	 * @return : Connection object
	 * @throws ClassNotFoundException : throws a ClassNotFound exception
	 * @throws SQLException : throws a SQL Exception
	 */
	public Connection createConnection() {

		try {

			if(con == null || con.isClosed()) {													//executed if there is no Connection object

				Class.forName("com.mysql.jdbc.Driver");											//load the jdbc driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_details", "root", "root");	//creates a connection
			}
		} catch(ClassNotFoundException cnfe) {

			System.out.println("Error Loading Driver : "+cnfe);
		} catch(SQLException sqle) {

			sqle.printStackTrace();
		}
		return con;
	}

	/**
	 * method to close the connection
	 * @throws SQLException : throws a SQL Exception
	 */
	public void closeConnection() {

		try {

			if(!(con == null || con.isClosed())) {												//executed if the connection is not closed

				con.close();
			}
		} catch(SQLException sqle) {

			sqle.printStackTrace();
		}
	}
}