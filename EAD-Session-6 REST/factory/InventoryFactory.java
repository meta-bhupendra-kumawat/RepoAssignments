package com.metacube.get2019.factory;

import com.metacube.get2019.dao.InventoryDao;
import com.metacube.get2019.model.Fruit;

public class InventoryFactory {
	public static Fruit getInstanceOfFruit()
	{
		return new Fruit();
		
	}
	public static InventoryDao getInstanceOfInventoryDao()
	{
		return new InventoryDao();
		
	}

}
