package com.metacube.get2019.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * It is a class to open connection with database;
 * @author Bhupendra
 * 
 *
 */
public class DatabaseConnection {
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "fruit_inventory";
	private static final String userId = "root";
	private static final String password = "root";
	private static final String driver="com.mysql.cj.jdbc.Driver";
	static Connection connection;
		/**
		 * It is a method used to open a connection with the database
		 * @return connection object
		 * @throws SQLException
		 */
		public static Connection connect() throws SQLException {
			String mysqlURL = host + dbName;
			try {
				Class.forName(driver);
				connection = (Connection)DriverManager.getConnection(mysqlURL, userId, password);
				return connection;
			} catch (ClassNotFoundException e) {
				System.out.println("Error loading driver");
			} catch (SQLException e) {
				System.out.println("SQL connection error");
			}
			return null;
		}
}
