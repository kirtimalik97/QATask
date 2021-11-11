package com.swagger.libraries;

import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.GetInventory;
import com.swagger.POJOs.OrderPlacedData;
import com.swagger.constants.Endpoints;
import com.swagger.utils.ConfigManager;
import com.swagger.utils.PrintLog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Store {
	
	private final String baseUrl = ConfigManager.getInstance().getString("base_url");
	private Logger logger = LogManager.getLogger();
	private JsonParser parser = JsonParser.DEFAULT;
	private PrintLog printResponse = new PrintLog();

	
	public Store() {
		RestAssured.baseURI = baseUrl;
	}
	
	/**
	 * Gets the store inventory.
	 *
	 * @return the store inventory
	 */
	public GetInventory getStoreInventory() {

		GetInventory responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get(Endpoints.GET_STORE_INVENTORY.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.GET_STORE_INVENTORY.getConstant(), null);

			responseData = parser.parse(resp.asString(), GetInventory.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	/**
	 * Gets the store inventory.
	 *
	 * @param orderData the order data
	 * @return the store inventory
	 */
	public OrderPlacedData getStoreInventory(OrderPlacedData orderData) {

		OrderPlacedData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(orderData)
					.when()
					.post(Endpoints.ADD_ORDER.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.ADD_ORDER.getConstant(), null);

			responseData = parser.parse(resp.asString(), OrderPlacedData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Gets the order by id.
	 *
	 * @param orderId the order id
	 * @return the order by id
	 */
	public OrderPlacedData getOrderById(int orderId) {

		OrderPlacedData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("orderId", orderId)
					.when()
					.get(Endpoints.GET_ORDER_BY_ID.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.GET_ORDER_BY_ID.getConstant(), null);

			responseData = parser.parse(resp.asString(), OrderPlacedData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Delete order by id.
	 *
	 * @param orderId the order id
	 */
	public void deleteOrderById(int orderId) {

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("orderId", orderId)
					.when()
					.delete(Endpoints.DELETE_ORDER.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();
			
			printResponse.printResponse(resp, Endpoints.GET_ORDER_BY_ID.getConstant(), "Deleted Order Successfully with Order ID :: ["+orderId+"]");

		} catch (AssertionError e) {
			logger.error(e.getMessage());
		}
	}
	
}
