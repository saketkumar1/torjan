package com.example.torjan.Notification_Advisiroy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getAdvisory {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("data")
    private data data;
    @SerializedName("lastRefreshed")
    private String lastRefreshed;
    @SerializedName("lastOriginUpdate")
    private String lastOriginUpdate;

    public Boolean getSuccess() {
        return success;
    }

    public data getData() {
        return data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }

}

