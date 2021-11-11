package com.swagger.libraries;

import com.swagger.POJOs.UserData;
import com.swagger.constants.Endpoints;
import com.swagger.utils.ConfigManager;
import com.swagger.utils.PrintLog;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {

	private final String baseUrl = ConfigManager.getInstance().getString("base_url");
	private Logger logger = LogManager.getLogger();
	private JsonParser parser = JsonParser.DEFAULT;
	private PrintLog printResponse = new PrintLog();

	public User() {
		RestAssured.baseURI = baseUrl;
	}

	/**
	 * Creates the users with list.
	 *
	 * @param userDataList the user data[]
	 * @return the user data[]
	 */
	public UserData[] createUsersWithList(UserData[] userDataList) {

		UserData[] responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(userDataList)
					.when()
					.post(Endpoints.CREATE_USER_LIST.getConstant())
					.then().assertThat()
					.statusCode(HttpStatus.SC_OK).and().extract().response();

			printResponse.printResponse(resp, Endpoints.CREATE_USER_LIST.getConstant(), null);

			responseData = parser.parse(resp.asString(), UserData[].class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
}
