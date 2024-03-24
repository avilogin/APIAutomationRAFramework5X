package org.example.tests.Integration;

import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.payloads.pojos.Booking;
import org.example.payloads.response.BookingRes;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Integration002 extends BaseTest {
    String token;
    String BookingIdPojo;

    @Test(groups = "Avijeet")
    public void getAuthToken()
    {
        assertThat("avijeet").isEqualTo("avijeet");

    }

    @Test(groups = "Avijeet")
    public void CreateBooking()
    {

        token = getToken();
        System.out.println(token);

        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(PayloadManager. createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        String bookingId = jsonPath.getString("bookingid");
//        System.out.println(bookingId);

        BookingRes bookingRespons = payloadManager.bookingResponseJava(response.asString());
         BookingIdPojo = bookingRespons.getBookingid().toString();

        System.out.println(BookingIdPojo);


    }


    @Test(groups = "Avijeet")
    public void updateBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingIdPojo);
        response = RestAssured.given().spec(requestSpecification).cookie("token",token)
                .when().body(payloadManager.updatePayload()).put();

        validatableResponse = response.then().log().all();
        //validatableResponse.body("firstname", Matchers.is("Amit"));

        //Booking booking = payloadManager.bookingResponsePUTReqJava(response.asString());
//        assertThat(booking.getFirstname()).isEqualTo("Amit");
//        assertThat(booking.getLastname()).isEqualTo("Dutta");
    }


    @Test(groups = "Avijeet")
    public void deleteBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingIdPojo).cookie("token",token);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);

    }


    @Test(groups = "Avijeet")
    public void verifyBooking()
    {
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingIdPojo);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().get().then().log().all();
        validatableResponse.statusCode(404);



    }


}
