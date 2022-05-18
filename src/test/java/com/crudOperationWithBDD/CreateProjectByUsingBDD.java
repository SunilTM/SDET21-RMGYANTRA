package com.crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectByUsingBDD {

	@Test
	public void createProjectByUsingBDD() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "rmgyantra");
		jobj.put("projectName", "rmgyantra_111");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 30);

		given().
		contentType(ContentType.JSON)
		.body(jobj)

		.when()
		.post("http://localhost:8084/addproject")

		.then()
		.assertThat()
		.statusCode(201)
		.log().all();

	}
}
