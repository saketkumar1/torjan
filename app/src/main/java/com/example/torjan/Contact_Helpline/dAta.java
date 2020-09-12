package com.example.torjan.Contact_Helpline;

import com.example.torjan.Contact_Helpline.Contact;
import com.google.gson.annotations.SerializedName;

public class dAta {

    @SerializedName("contacts")
    private Contact contacts;
    public Contact getContacts() {
        return contacts;
    }
}
