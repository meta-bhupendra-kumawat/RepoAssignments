package dao;
import java.sql.*;

/**
 * This is a component class. This class provides connection from the database i.e MySQL.
 * @author Bhupendra
 */
public class SQLConnectionDao {
	
	// Reference variables.
	private static Connection connection;
	
	// Constructor.
	static {
		String url = "jdbc:mysql://localhost/DB_shopping";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			System.out.println("\nConnection Established with Database.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* This method returns Connection class object.
	 * @return Connection to the database.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
