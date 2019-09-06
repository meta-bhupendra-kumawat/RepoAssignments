package factory;

import java.sql.Connection;

import controller.CartController;
import controller.ProductsController;
import dao.CartDao;
import dao.ProductsDao;
import dao.SQLConnectionDao;
import fascade.CartFascade;
import fascade.ProductsFascade;
import model.Cart;
import model.Products;
import view.DisplayOutput;

/**
 * This is the factory class. It provides component objects which are used by other components.
 * @author Bhupendra
 */
public class Factory {
	static CartDao cartDao;
	static ProductsDao productsDao;
	static DisplayOutput displayOutput;
	static Products products;
	static Cart cart;
	static CartFascade cartFascade;
	static ProductsFascade productsFascade;
	static ProductsController productsController;
	static CartController cartController;
	
	static {
		cartDao = new CartDao();
		productsDao = new ProductsDao();
		products = new Products();
		cart = new Cart();
		cartFascade = new CartFascade();
		productsFascade = new ProductsFascade();
		productsController = new ProductsController();
		cartController = new CartController();
	}

	public static CartDao getCartsDao() {
		return cartDao;
	}
	
	public static ProductsDao getProductsDao() {
		return productsDao;
	}
	
	public static Connection getConnection() {
		return SQLConnectionDao.getConnection();
	}
	
	public static DisplayOutput getDisplayOutput() {
		return displayOutput;
	}
	
	public static Products getProducts() {
		return new Products();
	}
	
	public static Cart getCart() {
		return cart;
	}
	
	public static CartFascade getCartFascade() {
		return cartFascade;
	}
	
	public static ProductsFascade getProductsFascade() {
		return productsFascade;
	}
	
	public static ProductsController getProductsController() {
		return productsController;
	}
	
	public static CartController getCartController() {
		return cartController;
	}
}
