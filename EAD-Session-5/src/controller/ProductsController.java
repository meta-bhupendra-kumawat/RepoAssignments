package controller;

import java.util.List;

import factory.Factory;
import fascade.ProductsFascade;
import model.Products;

/**
 * This is a component class. Its controls the operation on Products object of the application.
 * @author Bhupendra
 */
public class ProductsController {
	
	/**
	 * This method is used get all the products available in products catalogue.
	 * @return List of products.
	 */
	public List<Products> getProducts() {
		ProductsFascade productsFascade = Factory.getProductsFascade();
		return productsFascade.getProducts();
	}
}
