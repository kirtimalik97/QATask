package com.swagger.libraries;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.PetData;
import com.swagger.constants.Endpoints;
import com.swagger.utils.ConfigManager;
import com.swagger.utils.PrintLog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Pet {

	private static final Object Status = null;
	private final String baseUrl = ConfigManager.getInstance().getString("base_url");
	private Logger logger = LogManager.getLogger();
	private JsonParser parser = JsonParser.DEFAULT;
	private PrintLog printResponse = new PrintLog();

	public Pet() {
		RestAssured.baseURI = baseUrl;
	}

	/**
	 * Upload pet image.
	 *
	 * @param id        the id
	 * @param uploadUrl the upload url
	 * @param url       the url
	 * @return the pet data
	 */
	public PetData uploadPetImage(int id, String uploadUrl, String url) {

		PetData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.MULTIPART)
					.accept(ContentType.JSON)
					.pathParam("petId", id)
					.when().post(Endpoints.UPLOAD_IMAGE.getConstant())
					.then()
					.assertThat()
					.statusCode(HttpStatus.SC_OK).assertThat()
					.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.UPLOAD_IMAGE.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}

	/**
	 * Adds the pet to inv.
	 *
	 * @param pet the pet
	 * @return the pet data
	 */
	public PetData addPetToInv(PetData pet) {

		PetData responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(pet)
					.when()
					.post(Endpoints.ADD_UPDATE_PET.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.assertThat()
					.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.ADD_UPDATE_PET.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;

	}

	/**
	 * Update pet.
	 *
	 * @param pet the pet
	 * @return the pet data
	 */
	public PetData updatePet(PetData pet) {

		PetData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(pet)
					.when()
					.put(Endpoints.ADD_UPDATE_PET.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.assertThat()
					.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.ADD_UPDATE_PET.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}

	/**
	 * Find pet by status.
	 *
	 * @param Status the status
	 * @return the pet data
	 */
	public PetData findPetByStatus(String Status) {

		PetData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("status", Status)
					.when()
					.get(Endpoints.GET_FINDPETBYSTATUS.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK).assertThat()
					.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.GET_FINDPETBYSTATUS.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}

	/**
	 * Find pet by ID.
	 *
	 * @param id  the id
	 * @return the pet data
	 */
	public PetData findPetByID(int id) {

		PetData responseData = null;
		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("petId", id)
					.when()
					.get(Endpoints.OPERATE_PET_BY_ID.getConstant())
					.then()
					.assertThat()
					.statusCode(HttpStatus.SC_OK).assertThat()
					.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.OPERATE_PET_BY_ID.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}

	/**
	 * Update pet by ID.
	 *
	 * @param petId   the pet id
	 * @param requestData the PetData object
	 * @return the pet data
	 */
	public PetData updatePetByID(int petId, String name, String status) {

		PetData responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.URLENC)
					.accept(ContentType.JSON)
					.when()
					.put(Endpoints.OPERATE_PET_BY_ID.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.assertThat()
				//	.body(JsonSchemaValidator.matchesJsonSchema(new File("jsonSchemas/Add_Update_Pet.json"))).and()
					.extract().response();

			printResponse.printResponse(resp, Endpoints.OPERATE_PET_BY_ID.getConstant(), null);

			responseData = parser.parse(resp.asString(), PetData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}

	/**
	 * Delete pet by id.
	 *
	 * @param id  the id
	 */
	public void deletePetById(int id) {

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("petId", id)
					.when().delete(Endpoints.OPERATE_PET_BY_ID.getConstant())
					.then().assertThat()
					.statusCode(HttpStatus.SC_OK).and().extract().response();

			printResponse.printResponse(resp, Endpoints.OPERATE_PET_BY_ID.getConstant(),
					"Deleted Pet Successfully with ID :: [" + id + "]");

		} catch (AssertionError e) {
			logger.error(e.getMessage());
		}
	}

}
