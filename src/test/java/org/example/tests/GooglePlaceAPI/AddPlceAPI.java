package org.example.tests.GooglePlaceAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class AddPlceAPI {

    RequestSpecification req = RestAssured.given();
    Response res;

    ValidatableResponse valRes;


    @Test
    public void addPlace() {

        String payload = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Susrut Mohanty\",\n" +
                "  \"phone_number\": \"(+91) 983 894 3937\",\n" +
                "  \"address\": \"11, side layout, cohen 99\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

                req.baseUri("https://rahulshettyacademy.com")
                .basePath("/maps/api/place/add/json")
                        .queryParam("key","qaclick123").log().all()
                        .header("Content-Type","application/json")
                        ;
                req.body(payload).log().all();

                res = req.when().post();

                valRes = res.then().log().all();
                valRes.statusCode(200);
                valRes.body("status", Matchers.equalTo("OK"));






    }


}
