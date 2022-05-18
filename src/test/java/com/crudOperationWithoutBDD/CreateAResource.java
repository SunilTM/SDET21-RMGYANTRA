package com.crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateAResource {

	@Test
	public void create() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "rmgyantra");
		jobj.put("projectName", "rmgyantra_007");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 12);

		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);

		Response res = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType("application/json");
		validate.log().all();

	}
}