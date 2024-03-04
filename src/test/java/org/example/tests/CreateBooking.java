package org.example.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.restassured.response.Response;

import static io.restassured.RestAssured.requestSpecification;

public class CreateBooking extends BaseTest {

    @Test
    @Owner("Avijeet")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void postCreateBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(PayloadManager. createPayload()).post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
