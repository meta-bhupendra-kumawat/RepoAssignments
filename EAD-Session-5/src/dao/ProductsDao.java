package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Products;
import factory.Factory;

/**
 * This is the component class. This class performs CRUD operations on the database using JDBC.
 * @author Bhupendra
 */
public class ProductsDao {

	// Instance variables.
	Connection connection;

	/**
	 * This method is used get all the products available in catalogue.
	 * @return List of products.
	 */
	public List<Products> getProducts() {
		connection = Factory.getConnection();
		List<Products> list = new ArrayList<Products>();
		ResultSet rs = null;
		String query = "SELECT  p_code, p_type, p_name, p_price "
				+ "FROM products;";
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				Products p = Factory.getProducts();
				p.setProductCode(rs.getInt(1));
				p.setProductType(rs.getString(2));
				p.setProductName(rs.getString(3));
				p.setProductPrice(rs.getDouble(4));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
