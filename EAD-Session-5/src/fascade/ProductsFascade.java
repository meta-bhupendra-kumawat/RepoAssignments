package fascade;

import java.util.List;

import factory.Factory;
import model.Products;

/**
 * This is a component class. Its operates the data received from controller or dao layer of the application.
 * @author Bhupendra
 */
public class ProductsFascade {
	
	/**
	 * This method is used get all the products available in products catalogue.
	 * @return List of products.
	 */
	public List<Products> getProducts() {
		List<Products> productList = Factory.getProductsDao().getProducts();
		return productList;
	}
}


