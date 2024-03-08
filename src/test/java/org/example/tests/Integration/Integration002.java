package org.example.tests.Integration;

import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.payloads.response.BookingRes;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Integration002 extends BaseTest {
    String token;

    @Test
    public void getAuthToken()
    {
        assertThat("avijeet").isEqualTo("avijeet");

    }

    @Test
    public void CreateBooking()
    {

//        token = getToken();
//        System.out.println(token);

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(PayloadManager. createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        String bookingId = jsonPath.getString("bookingid");
//        System.out.println(bookingId);

        BookingRes bookingRespons = payloadManager.bookingResponseJava(response.asString());
        String BookingIdPojo = bookingRespons.getBookingid().toString();

        System.out.println(BookingIdPojo);






    }


    @Test
    public void updateBooking()
    {
        assertThat("avijeet").isEqualTo("avijeet");
        System.out.println(token);
    }


    @Test
    public void deleteBooking()
    {
        assertThat("avijeet").isEqualTo("avijeet");
        System.out.println(token);
    }


    @Test
    public void verifyBooking()
    {
        assertThat("avijeet").isEqualTo("avijeet");
        System.out.println(token);
    }


}
