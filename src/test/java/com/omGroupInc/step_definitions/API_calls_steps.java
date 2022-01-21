package com.omGroupInc.step_definitions;

import com.omGroupInc.utils.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;


public class API_calls_steps {

    @BeforeAll
    public static void setup(){
       baseURI = "http://18.119.130.103:8082/odos3-api/user";
       basePath= "{identifier}";
    }
    @AfterAll
    public static void tearDown(){
        reset();
    }


    @Given("swagger documentation")
    public void swagger_documentation() {
        System.out.println("hello");
    }

    @DisplayName("Get ")
    @Test
    @Then("user should be able to perform several api calls for the app status code")
    public void user_should_be_able_to_perform_several_api_calls_for_the_app_status_code() {
    Response response=
         given().
                accept(ContentType.JSON)
                .queryParam("identifier",1)
         .when()
                .get("/{identifier}");
        System.out.println(response.prettyPrint());;

//        Assert.assertEquals(200,response.statusCode());
//        Assert.assertEquals("application/json",response.contentType());

//        System.out.println(response.path("identifier").toString());
//        System.out.println(response.path("name").toString());
//        System.out.println(response.path("emailAddress").toString());
//        System.out.println(response.path("deleted").toString());
//
//        List<String> names = response.path("name");
//        System.out.println("======================================================");
//        System.out.println(names);
//        for (String n : names){
//            System.out.println(n);
        }
}
