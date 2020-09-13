package com.example.torjan.Notification_Advisiroy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getAdvisory {
    @Expose
    private Boolean success;
    @Expose
    private data data;
    @Expose
    private String lastRefreshed;
    @Expose
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

