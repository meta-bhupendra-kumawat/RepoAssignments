package com.metacube.get2019.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.factory.InventoryFactory;
import com.metacube.get2019.model.Fruit;
/**
 * 
 * @author Bhupendra
 *
 */
public class InventoryDao implements BaseDao {

    
	@Override
	public List<Fruit> getAllFruits(String query) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs= preparedStatement.executeQuery();
			List<Fruit> fruitList=new ArrayList<Fruit>();
			Fruit fruit;
			while(rs.next()) {
				fruit=InventoryFactory.getInstanceOfFruit();
				fruit.setName(rs.getString("name"));
				fruit.setQuantity(rs.getInt("quantity"));
				fruitList.add(fruit);
			}
			return fruitList;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Fruit getFruitByName(String query, String fruitName) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,fruitName);
			ResultSet rs= preparedStatement.executeQuery();
			Fruit fruit;
			fruit=InventoryFactory.getInstanceOfFruit();
			while(rs.next()) {
				fruit.setName(rs.getString("name"));
				fruit.setQuantity(rs.getInt("quantity"));
			}
			return fruit;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAllFruits(String query) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			int rowsAffected= preparedStatement.executeUpdate();
			if( rowsAffected > 0){
				return true;
			}
		} catch(Exception e) {
				e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFruitByName(String query,String fruitName) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,fruitName);
			int rowsAffected= preparedStatement.executeUpdate();
			if( rowsAffected >0){
				return true;
			}
		} catch(Exception e) {
				e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean postFruit(String query, Fruit fruit) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,fruit.getName());
			preparedStatement.setString(2,book.getQuantity());
			int rowsAffected= preparedStatement.executeUpdate();
			if( rowsAffected > 0 ) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

  	@Override
	public boolean updateFruit(String query, Fruit fruit) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,book.getWriter());
			int rowsAffected= preparedStatement.executeUpdate();
			if(rowsAffected > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
