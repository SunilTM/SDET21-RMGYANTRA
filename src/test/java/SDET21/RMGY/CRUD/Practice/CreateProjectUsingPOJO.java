package SDET21.RMGY.CRUD.Practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import SDET21.POJO.Class.ProjectLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingPOJO {

	@Test
	public void createProjectUsingPOJO()
	{
		baseURI="http://localhost";
		port=8084;
		
		//Read Data through POJO Class
		ProjectLibrary plib = new ProjectLibrary("ABCD", "AccionLabs", "Completed", 10);
		
		//Request Specification
		given().contentType(ContentType.JSON).body(plib)
		
		//Request
		.when().post("/addProject")
		
		//Validation
		.then().assertThat().statusCode(201).log().all();
		
	}
}

