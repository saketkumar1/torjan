package com.example.torjan.Webservice;
import com.example.torjan.Contact_Helpline.getContacts;
import com.example.torjan.Hospitals_Dashboards.getHospitalbeds;
import com.example.torjan.Notification_Advisiroy.getAdvisory;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppAPI {
    @GET("contacts")
    Call<getContacts> getContacts();

    @GET("notifications")
    Call<getAdvisory> getAdvisory();

    @GET("hospitals/beds")
    Call<getHospitalbeds> getHospitalbeds();
}
