package com.crudOperationWithBDD;

import java.util.HashMap;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashmap {

		public void createprojectusingHashmap()
		{
			HashMap map = new HashMap();
			map.put("createdBy", "BHai");
			map.put("projectName", "Chrome");
			map.put("status", "completed");
			map.put("teamsize", 12);
			
			//request specification
			given().contentType(ContentType.JSON).body(map)
			
			//actual request
			.when().post("http://localhost:8084/addProject")
			
			//validate
			.then().statusCode(201).log().all();
		}
}
