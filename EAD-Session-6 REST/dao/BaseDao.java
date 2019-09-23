package com.metacube.get2019.dao;

import java.sql.ResultSet;
import java.util.List;

import com.metacube.get2019.model.*;

/**
 * @author Bhupendra
 *
 */
public interface BaseDao {
	
	List<Fruit> getAllFruits(String query);
	Fruit getFruitByName(String query, String fruitName);
	boolean updateFruit(String query);
	boolean deleteAllFruits(String query);
	boolean deleteFruitByName(String query, String fruitName);
	boolean updateFruit(String query, Fruit fruit);
}
