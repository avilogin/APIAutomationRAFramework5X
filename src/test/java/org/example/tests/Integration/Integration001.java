package org.example.tests.Integration;

import io.qameta.allure.Owner;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.payloads.response.BookingRes;
import static org.assertj.core.api.Assertions.*;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class Integration001 extends BaseTest {

    // Create A Booking, Create a Token
    // Get booking
    // Update the Booking
    // Delete the Booking
    // Check deleted Booking


    @Test(groups = "integration", priority = 1)
    @Owner("Avijeet")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void createBooking(ITestContext iTestContext)
    {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        BookingRes bookingRespons = payloadManager.bookingResponseJava(response.asString());
        assertThat(bookingRespons.getBookingid()).isNotNull();
        iTestContext.setAttribute("bookingid", bookingRespons.getBookingid());
        iTestContext.setAttribute("token", getToken());
    }

    @Test(groups = "integration", priority = 2)
    @Owner("Avijeet")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testVerifyBookingId(ITestContext iTestContext) {
        // GET Req
        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);
    }




}
