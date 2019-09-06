package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factory.Factory;
import model.Cart;

/**
 * This is the component class. This class performs CRUD operations on the database using JDBC.
 * @author Bhupendra
 */
public class CartDao {

	// Instance variable.
	Connection connection;

	// Constructor.
	public CartDao() {
		connection = SQLConnectionDao.getConnection();
	}

	
	/**
	 * This method directly contacts with the database to perform query operations. 
	 * This method fetches the products present inside cart.
	 * @return list of cart objects.
	 */
	public List<Cart> getCart() {
		List<Cart> list = new ArrayList<Cart>();
		ResultSet rs = null;
		String query = "SELECT productCode, quantity, productPrice " 
						+ "FROM cart;";
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Cart cart = Factory.getCart();
				cart.setProductCode(rs.getInt(1));
				cart.setQuantity(rs.getInt(2));
				cart.setProductprice(rs.getDouble(3));
				list.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * This method directly contacts with the database to perform query operations. This method
	 * performs insert operation into the database.
	 * @return message.
	 */
	public String addProductToCart(int productCode, int quantity) {
		try {
			Statement st = connection.createStatement();
			String querySelect = " SELECT p_price " 
								 + "FROM products " 
								 + "WHERE p_code=" 
								 + productCode + ";";
			ResultSet rs = st.executeQuery(querySelect);
			rs.next();
			
			String query = "INSERT INTO cart (productCode, quantity, productPrice) " + "VALUES(?, ?, ?);";
			PreparedStatement prepStmt = connection.prepareStatement(query);

			prepStmt = connection.prepareStatement(query);
			prepStmt.setInt(1, productCode);
			prepStmt.setInt(2, quantity);
			prepStmt.setDouble(3, rs.getDouble(1));
			if(prepStmt.execute())
				return "Product successfully added to cart!!";
		} catch (SQLException e) {
			return "Product not available. Can't be added to cart!!";
		}
		return "";
	}
	
	/**
	 * This method directly contacts with the database to perform query operations. This method
	 * performs delete operation into the database.
	 * @return message.
	 */
	public String deleteProductFromCart(int productCode) {
		String query = "DELETE FROM cart "
						+ "WHERE productCode = " + productCode + ";";
		try {
			Statement st = connection.createStatement();
			if(st.execute(query))
				return "Product successfully deleted from cart!!";
		} catch (SQLException e) {
			return "No such product available to delete from cart.";
		}
		return "";
	}
	
	/**
	 * This method directly contacts with the database to perform query operations. This method
	 * performs update operation into the database.
	 * @return message.
	 */
	public String updateProductQuantity(int productCode, int quantity) {
		String query = "UPDATE cart "
						+ "SET quantity = " + quantity
						+ " WHERE productCode = " + productCode + ";";
		try {
			Statement st = connection.createStatement();
			if(st.execute(query))
				return "Product quantity updated successfully!!.";
			} catch (SQLException e) {
			return "No such product available in cart!";
		}
		return "";
	}
}
