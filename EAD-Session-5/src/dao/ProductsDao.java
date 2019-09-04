package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsDao {

	Connection connection;
	
	public ResultSet showProducts() {
		connection = SQLConnectionDao.getConnection();
		ResultSet rs = null;
		String query = "SELECT p_code, p_type, p_name, p_price FROM products;";
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
