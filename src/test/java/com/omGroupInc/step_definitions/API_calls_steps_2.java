package com.omGroupInc.step_definitions;

import com.omGroupInc.utils.ApiTestBase;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class API_calls_steps_2 extends ApiTestBase {


    @Test

    public void test1() {
        //get one user using query param
        //baseURI = "http://18.119.130.103:8082"
        //odos3-api/users/    - for all users
        //odos3-api/user/{identifier}?identifier=1 - one user


        Response response =
                given().
                        accept(ContentType.JSON)
                        .and().pathParam("identifier", 1)
                        .when()
                        .get("/odos3-api/users");
        System.out.println(response.prettyPrint());
        ;
        //The 405 Method Not Allowed error occurs when the web server
        // is configured in a way that does not allow you to perform a specific action for a particular URL

 /*
            assertEquals(200,response.statusCode());
            assertEquals("application/json",response.contentType());

            //print name with path method
            System.out.println(response.path("name").toString());

            //assigning response to jsonpath
            JsonPath jsonPath = response.jsonPath();

            int id = jsonPath.getInt("id");
            String name = jsonPath.getString("name");
            String gender =jsonPath.getString("gender");
            long phone = jsonPath.getLong("phone");

            System.out.println("id = " + id);
            System.out.println("name = " + name);
            System.out.println("gender = " + gender);
            System.out.println("phone = " + phone);*/
//
//        Assert.assertEquals(200,response.statusCode());
//        Assert.assertEquals("application/json",response.contentType());

//        System.out.println(response.path("identifier").toString());
//        System.out.println(response.path("name").toString());
//        System.out.println(response.path("emailAddress").toString());
//        System.out.println(response.path("deleted").toString());
//

    }
}
