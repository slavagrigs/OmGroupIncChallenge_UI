package com.omGroupInc.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class ApiTestBase {
    @BeforeAll
    public static void init(){

         baseURI = "http://18.119.130.103:8082";

    }

    @AfterAll
    public static void teardown(){

            reset();

    }
}
