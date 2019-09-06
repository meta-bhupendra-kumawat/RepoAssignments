package controller;

import java.util.List;

import factory.Factory;
import fascade.CartFascade;
import model.Cart;

/**
 * This is a component class. Its controls the operation on Cart object of the application.
 * @author Bhupendra
 */
public class CartController {

	/**
	 * This method is used to add product to cart.
	 * @param productCode
	 * @param quantity
	 * @return true if product is added successfully, false otherwise.
	 */
	public String addProductToCart(int productCode, int quantity) {
		CartFascade cartFascade = Factory.getCartFascade();
		return cartFascade.addProductToCart(productCode, quantity);
	}
	
	 
	/**
	 * This method is used get all the products available in cart.
	 * @return List of products.
	 */
	public List<Cart> getCart() {
		CartFascade cartFascade = Factory.getCartFascade();
		return cartFascade.getCart();
	}
	
	/**
	 * This method deleted the product from cart.
	 * @param productCode
	 * @return true if product is deleted successfully, false otherwise.
	 */
	public String deleteProductFromCart(int productCode) {
		CartFascade cartFascade = Factory.getCartFascade();
		return cartFascade.deleteProductFromCart(productCode);
	}
	
	/**
	 * This method updates the product in cart.
	 * @param productCode.
	 * @param quantity.
	 * @return message.
	 */
	public String updateProductQuantity(int productCode, int quantity) {
		CartFascade cartFascade = Factory.getCartFascade();
		return cartFascade.updateProductQuantity(productCode, quantity);
	}
	
	
	/**
	 * This method gets the total amount payable for products in cart.
	 * @return cart value.
	 */
	public double getCartValue() {
		CartFascade cartFascade = Factory.getCartFascade();
		return cartFascade.getCartValue();
	}
}
