package com.example.torjan.Hospitals_Dashboards;

import com.google.gson.annotations.SerializedName;

public class sources {
    @SerializedName("url")
    private String url;

    @SerializedName("lastUpdated")
    private String lastUpdated;

    public String getUrl() {
        return url;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
