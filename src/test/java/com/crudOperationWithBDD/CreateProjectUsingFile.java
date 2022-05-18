package com.crudOperationWithBDD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingFile {

	public void createprojectusingFile() throws FileNotFoundException
	{
		//read the file
		FileInputStream fis = new FileInputStream("./data.json");
		
		//request specification
		given().contentType(ContentType.JSON).body(fis)
		
		//actual request
		.when().post("http://localhost:8084/addProject")
		
		//validation
		.then().statusCode(201).log().all();
		
		
	}
}
