package model;

/**
 * This is a POJO class. It maintains the details of Cart object.
 * @author Bhupendra
 */
public class Cart {
	
	// Instance variables.
	int productCode;
	int quantity;
	double productPrice;

	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProductprice() {
		return productPrice;
	}
	public void setProductprice(double productprice) {
		this.productPrice = productprice;
	}
}