package view;

import java.util.List;
import java.util.Scanner;

import model.Cart;
import model.Products;
import dao.SQLConnectionDao;
import factory.Factory;

/**
 * This is the main class from where the execution starts.
 * @author Bhupendra
 */
public class DisplayOutput {
	
	// Constructor.
	public DisplayOutput() {
		Scanner sc = new Scanner(System.in);
		String menu = "\n\nSelect an option to\n"
				+ "0. View Products.\n"
				+ "1. Add product to cart.\n"
				+ "2. Update cart.\n"
				+ "3. See cart.\n"
				+ "4. To exit.\n"
				+ "Enter input : ";
		int option;
		while(true) {
			System.out.print(menu);
			option = sc.nextInt();
			switch(option) {
			case 0:
				List<Products> productsList = Factory.getProductsController().getProducts();
				System.out.format("\n%5s%20s%20s%20s\n", "Product Code", "Product Type", "Product Name", "Product Price");
				System.out.println("--------------------------------------------------------------------------");
				for(Products p : productsList)
					System.out.format("\n%5s%20s%20s%20s\n", p.getProductCode(), p.getProductType(), 
							p.getProductName(), p.getProductPrice());
				System.out.println("--------------------------------------------------------------------------");
				break;
			case 1:
			{
				System.out.println("Enter product code to add it to cart.");
				int productCode = sc.nextInt();
				String message = Factory.getCartController().addProductToCart(productCode, 1);
				System.out.println("\n" + message);
				break;
			}
				
			case 2:
				String updateMenu = "\n\nEnter option to update cart\n"
						+ "1. To delete a product from cart.\n"
						+ "2. To update product quantity.\n"
						+ "Enter Input : ";
				int updateOption = sc.nextInt();
				switch(updateOption) {
				case 1:
				{
					System.out.print("Enter product code to delete product from cart : ");
					int productCode = sc.nextInt();
					String message = Factory.getCartController().deleteProductFromCart(productCode);
					System.out.println("\n" + message);
					break;
				}

				case 2:
				{
					System.out.print("Enter product code to update its quantity from cart : ");
					int productCode = sc.nextInt();
					System.out.print("Enter product quantity to update cart : ");
					int quantity = sc.nextInt();
					String message = Factory.getCartController().updateProductQuantity(productCode, quantity);
					System.out.println("\n" + message);
					break;
				}
			}

			case 3:
			{
				List<Cart> cartItemsList = Factory.getCartController().getCart();
				System.out.format("\n%10s%20s%20s\n", "Product Code", "Quantity", "Product price");
				System.out.println("-------------------------------------------------------------");
				for(Cart item : cartItemsList)
					System.out.format("\n%10s%20s%20s\n", item.getProductCode(), item.getQuantity(), item.getProductprice());
				System.out.println("-------------------------------------------------------------");
				System.out.println("Total cart amount : " + Factory.getCartController().getCartValue());
				System.out.println("-------------------------------------------------------------");
				break;
			}

			case 4:
			{
				SQLConnectionDao.close();
				System.exit(0);
				break;
			}

			default :
				System.out.println("Invalid Input.");
			}
		}
	}
	
	public static void main(String args[]) {
		DisplayOutput disOpt = new DisplayOutput();
	}
}
