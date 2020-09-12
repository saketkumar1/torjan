package com.example.torjan.Webservice;
import com.example.torjan.Contact_Helpline.getContacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppAPI {
    @GET("contacts")
    Call<getContacts> getContacts();
}
