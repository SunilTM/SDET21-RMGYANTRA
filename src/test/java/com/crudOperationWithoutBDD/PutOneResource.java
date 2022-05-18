package com.crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutOneResource {

	@Test
	public void putOneData()
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "rmgyantra");
		jobj.put("projectName", "rmgyantra_007");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 40);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		Response res = reqspec.put("http://localhost:8084/projects/TY_PROJ_609");
		
		System.out.println(res.getStatusCode());
			
	}
}