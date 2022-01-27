package com.omGroupInc.step_definitions;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;



public class API_calls {

    @BeforeAll
    public static void setup(){
        baseURI = "http://18.119.130.103:8082/";
        basePath= "odos3-api";
    }
    @AfterAll
    public static void tearDown(){
        reset();
    }


    @DisplayName("Get method")
    @Test
    public void API_test () {
         Response response=
                given().
                        accept(ContentType.JSON)
                        //.queryParam("identifier",1) didn't worked -  how to call one user from "user" with identifier 1?
                        .when()
                        .get("users"); // - please try with "/user/{identifier}" and "users" to be able to call specific user
                        //.get("/{identifier}");  didn't worked
         System.out.println(response.prettyPrint());;

         Assert.assertEquals(200,response.statusCode());
         Assert.assertEquals("application/json",response.contentType());

        /** System.out.println(response.path("identifier").toString());
         System.out.println(response.path("name").toString());
         System.out.println(response.path("emailAddress").toString());
         System.out.println(response.path("deleted").toString()); */

    }
}

