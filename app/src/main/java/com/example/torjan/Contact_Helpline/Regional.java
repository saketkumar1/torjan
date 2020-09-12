package com.example.torjan.Contact_Helpline;

import com.google.gson.annotations.SerializedName;

public class Regional {
    @SerializedName("loc")
    private String loc;

    @SerializedName("number")
    private String number;

    public String getLoc() {
        return loc;
    }

    public String getNumber() {
        return number;
    }
}
