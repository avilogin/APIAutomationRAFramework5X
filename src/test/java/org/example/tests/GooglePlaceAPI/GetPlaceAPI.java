package org.example.tests.GooglePlaceAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetPlaceAPI {
    RequestSpecification req = RestAssured.given();
    Response res;

    ValidatableResponse valRes;
    String placeId = "9efff5b43f41b5c5dc54795859b7737e";

    @Test
    public void getPlace()
    {

        req.baseUri("https://rahulshettyacademy.com")
                .basePath("/maps/api/place/get/json")
                .queryParam("key","qaclick123")
                .queryParam("place_id", placeId).log().all();

        res= req.when().get();

        valRes = res.then().log().all();
        valRes.statusCode(200);
        valRes.body("name", Matchers.equalTo("Susrut Mohanty"));



    }
}
