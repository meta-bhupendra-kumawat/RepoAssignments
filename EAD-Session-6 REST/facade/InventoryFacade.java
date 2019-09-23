package com.metacube.get2019.factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.metacube.get2019.dao.InventoryDao;
import com.metacube.get2019.model.Fruit;

public class InventoryFacade {
	static InventoryDao inventory=InventoryFactory.getInstanceOfInventoryDao();
	private static final String QUERY_GET_FRUITS = "SELECT * FROM inventory";
	private static final String QUERY_GET_FRUITS_BY_NAME = "SELECT * FROM inventory WHERE name = ?";
	private static final String QUERY_DELETE_FRUITS = "DELETE FROM inventory";
	private static final String QUERY_DELETE_FRUIT_BY_NAME = "DELETE FROM inventory WHERE name = ?";
	private static final String QUERY_POST_FRUIT ="INSERT INTO inventory(name, quantity) VALUES(?,?)";
	private static final String QUERY_PUT_FRUIT="UPDATE fruit SET quantity=? WHERE name=?";
	
	/**
	 * This method is used to retrieve all fruits.
	 * @return json string of the retrieved fruits
	 * @throws SQLException
	 */
	public static String getFruits() throws SQLException{
		List<Fruit> fruitList=inventory.getAllFruits(QUERY_GET_FRUITS);
		if(fruitList.size() > 0) {
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(fruitList);
			return inventoryJson;
		}else {
			return "No Inventory Found";
		}
	}
	
	/**
	 * This method is used to Retrieve fruit by name
	 * @param fruitName is the name of the fruit to be retrieved 
	 * @return json string of the retrieved fruits
	 * @throws SQLException
	 */
	public static String getFruitByName(String fruitName) throws SQLException{
		Fruit fruit=inventory.getFruitByName(QUERY_GET_FRUITS_BY_NAME,fruitName);
		if( fruit.getName() != null ){
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(fruit);
			return inventoryJson;
		}else{
			return "No Fruit Found";
		}
	}

	/**
	 * This method is used to Delete all fruits
	 * @return text if the deletion has been performed successfully
	 */
	public static String deleteInventory() {
		boolean deleted=inventory.deleteAllFruits(QUERY_DELETE_FRUITS);
		if(deleted){
			return "Successfully deleted";
		}
		else{
		return "Error in deletion...";
		}
	}

	/**
	 * This method is used to delete fruit by name
	 * @param fruitName is the name of the fruit to be deleted
	 * @return text if the deletion has been performed successfully
	 * @throws SQLException
	 */
	public static String deleteFruitByName(String fruitName) {
		boolean deleted=inventory.deleteFruitByName(QUERY_DELETE_FRUIT_BY_NAME,fruitName);
		if(deleted){
			return "Successfully deleted";
		}
		else{
		return "Error in deletion...";
		}
	}

	/**
	 * This method is used to create a new fruit record
	 * @param jsonString is the input json 
	 * @return text if the insertion has been performed successfully
	 */
	public static String postFruit(String jsonString) {
		Gson gson = new Gson();
		TypeToken<Fruit> token = new TypeToken<Fruit>() {};
		Fruit fruit = gson.fromJson(jsonString, token.getType());
		boolean inserted=inventory.postFruit(QUERY_POST_FRUIT,fruit);
		if(inserted) {
			return "Successfully inserted";
		} else{
			return "Error in insertion....";
		}	
	}

	/**
	 * This method is used to Update fruit by name
	 * @param jsonString is the input json in the body of the put request
	 * @return text if the updation has been performed successfully
	 */
	public static String updateFruit(String jsonString) {
		Gson gson = new Gson();
		TypeToken<Fruit> token = new TypeToken<Fruit>() {};
		Fruit fruit = gson.fromJson(jsonString, token.getType());
		boolean inserted = inventory.updateFruit(QUERY_PUT_FRUIT,fruit);
		if(inserted){
			return "Successfully updated";
		}else{
			return "Error in updation....";
		}
	}
}

