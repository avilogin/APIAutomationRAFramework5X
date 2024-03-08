package org.example.modules;

import com.beust.ah.A;
import com.google.gson.Gson;
import org.example.payloads.pojos.Auth;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.BookingDates;
import org.example.payloads.pojos.TokenResponse;
import org.example.payloads.response.BookingRes;

public class PayloadManager {
    Gson gson;


    public static String createPayload()
    {
        Booking postPayload = new Booking();
        postPayload.setFirstname("Avijeet");
        postPayload.setLastname("Jana");
        postPayload.setTotalprice(200);
        postPayload.setDepositpaid(false);

        //Setting the data for Booking dates class
        BookingDates dates = new BookingDates();
        dates.setCheckin("2018-01-01");
        dates.setCheckout("2020-01-01");
        postPayload.setBookingdates(dates);
        postPayload.setAdditionalneeds("Biryani");
        System.out.println(postPayload);


        //Serializing the Object to JSON String using GSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(postPayload);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        //return objectMapper.writterWithDefaultPrettyPrinter().writeValueAsString(auth);
        gson = new Gson();
        String jsonStringBooking = gson.toJson(auth);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return  tokenResponse1.getToken();
    }

    public BookingRes bookingResponseJava(String responseString){
        gson = new Gson();
        BookingRes bookingRespons = gson.fromJson(responseString,BookingRes.class);
        return bookingRespons;

    }

}
