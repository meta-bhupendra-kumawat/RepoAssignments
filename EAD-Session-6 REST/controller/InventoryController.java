package com.metacube.get2019.controller;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.get2019.factory.InventoryFacade;

@Path("/inventory")
public class InventoryController {

	/**
	 * This method is used to retrieve all fruits.
	 * @return json string of the retrieved fruits
	 * @throws SQLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllFruits() throws SQLException {	{
		String response=InventoryFacade.getFruits();
		return response;
	}
	
	/**
	 * This method is used to Retrieve fruit by name
	 * @param fruitName is the name of the fruit to be retrieved 
	 * @return json string of the retrieved book
	 * @throws SQLException
	 */
	@GET
	@Path("{fruitName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFruitByName(@PathParam("fruitName") String fruitName) throws SQLException { 
		System.out.println(fruitName);
		String response=InventoryFacade.getFruitByName(fruitName);
		return response;
	}

	/**
	 * This method is used to Delete all fruits
	 * @return text if the deletion has been performed successfully
	 */
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public String deleteInventory() {
		String response=InventoryFacade.deleteInventory();
		return response;
	}
	
	/**
	 * This method is used to delete fruit by name
	 * @param fruitName is the name of the book to be deleted
	 * @return text if the deletion has been performed successfully
	 * @throws SQLException
	 */
	@DELETE
	@Path("{fruitName}")
	@Produces(MediaType.TEXT_HTML)
	public String deleteBookById(@PathParam("fruitName") String fruitName) throws SQLException {
		String response=InventoryFacade.deleteFruitByName(fruitName);
		return response;
	}
	
	/**
	 * This method is used to create a new inventory record
	 * @param jsonString is the input json 
	 * @return text if the insertion has been performed successfully
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String postFruit(String jsonString) {
		String response=InventoryFacade.postFruit(jsonString);
		return response;
	}
	
	/**
	 * This method is used to Update fruit by name 
	 * @param jsonString is the input json in the body of the put request
	 * @return text if the updation has been performed successfully
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String putFruit(String jsonString) {
		String response=InventoryFacade.updateBook(jsonString);
		return response;
	}
}	
