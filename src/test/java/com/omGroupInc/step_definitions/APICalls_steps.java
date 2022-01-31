package com.omGroupInc.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.reset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APICalls_steps {


    @Given("Swagger documentation")
    public void swagger_documentation() {
        System.out.println("User is using Swagger documentation");
    }

    @Then("user can verify API get request")
    public void user_can_verify_api_get_request() {
        Response response =
                given().
                        accept(ContentType.JSON)
                        .queryParam("identifier", 1)
                        .when()
                        .get("/user/%7Bidentifier%7D")
                        .prettyPeek();
                     // .get("users").prettyPeek();

        // Verify status code // Assert.assertEquals
        assertEquals(200, response.statusCode());
        // Verify content type - Json
        assertEquals("application/json", response.contentType());
        //verify specific header (date)
        System.out.println(response.header("Date"));
        assertTrue(response.headers().hasHeaderWithName("date"));

        //Verify body (Payload) contains "john.smith@omgroup.com"
        Assertions.assertTrue(response.body().asString().contains("john.smith@omgroup.com"));
    }
}
