package com.example.torjan.Hospitals_Dashboards;

import com.example.torjan.Contact_Helpline.dAta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getHospitalbeds {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private hb_data data;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("lastOriginUpdate")
    @Expose
    private String lastOriginUpdate;

    public Boolean getSuccess() {
        return success;
    }

    public hb_data getData() {
        return data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }
}
