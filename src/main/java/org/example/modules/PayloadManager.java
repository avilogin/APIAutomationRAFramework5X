package org.example.modules;

import com.google.gson.Gson;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.BookingDates;

public class PayloadManager {


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

}
