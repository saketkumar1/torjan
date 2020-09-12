package com.example.torjan.Contact_Helpline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getContacts {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private dAta data;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("lastOriginUpdate")
    @Expose
    private String lastOriginUpdate;

    public Boolean getSuccess() {
        return success;
    }

    public dAta getData() {
        return data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }
}
