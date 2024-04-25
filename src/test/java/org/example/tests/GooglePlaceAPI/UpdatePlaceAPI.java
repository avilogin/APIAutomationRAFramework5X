package org.example.tests.GooglePlaceAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UpdatePlaceAPI {

    RequestSpecification req = RestAssured.given();
    Response res;
    ValidatableResponse valres;
    String placeId = "b6aed79dfb4fc26b5eb92eebc7f1246d";

    @Test
    public void updatePlace()
    {
String payload = "{\n" +
        "\"place_id\":\""+placeId+"\",\n" +
        "\"address\":\"11, side layout, cohen 00\",\n" +
        "\"key\":\"qaclick123\"\n" +
        "}";

req.baseUri("https://rahulshettyacademy.com")
        .basePath("/maps/api/place/update/json")
        .queryParam("key","qaclick123");

req.body(payload).log().all();

res = req.when().put();

valres = res.then().log().all();
valres.statusCode(200);
valres.body("msg", Matchers.equalTo("Address successfully updated"));

    }
}
