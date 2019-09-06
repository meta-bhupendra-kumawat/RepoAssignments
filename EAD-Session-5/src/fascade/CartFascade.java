package fascade;

import java.util.List;

import dao.CartDao;
import factory.Factory;
import model.Cart;

/**
 * This is a component class. Its operates the data received from controller or dao layer of the application.
 * @author Bhupendra
 */
public class CartFascade {

	/**
	 * This method is used get all the products available in cart.
	 * @return List of products.
	 */
	public List<Cart> getCart() {
		CartDao cart = Factory.getCartsDao();
		return cart.getCart();
	}
	
	/**
	 * This method is used to add product to cart.
	 * @param productCode
	 * @param quantity
	 * @return true if product is added successfully, false otherwise.
	 */
	public String addProductToCart(int productCode, int quantity) {
		CartDao cart = Factory.getCartsDao();
		return cart.addProductToCart(productCode, quantity);
	}
	
	/**
	 * This method deleted the product from cart.
	 * @param productCode
	 * @return true if product is deleted successfully, false otherwise.
	 */
	public String deleteProductFromCart(int productCode) {
		CartDao cartDao = Factory.getCartsDao();
		return cartDao.deleteProductFromCart(productCode);
	}
	
	/**
	 * This method updates the product in cart.
	 * @param productCode.
	 * @param quantity.
	 * @return message.
	 */
	public String updateProductQuantity(int productCode, int quantity) {
		if(quantity < 1) 
			return "Quantity should be greater than or equal to 1";
		CartDao cartDao = Factory.getCartsDao();
		return cartDao.updateProductQuantity(productCode, quantity);
	}
	
	/**
	 * This method calculates the total cart value.
	 * @return cart value.
	 */
	public double getCartValue() {
		double totalAmount = 0;
		CartDao cart = Factory.getCartsDao();
		List<Cart> cartList = cart.getCart();
		for(Cart c : cartList)
			totalAmount += c.getQuantity() * c.getProductprice();
		return totalAmount;
	}
}
