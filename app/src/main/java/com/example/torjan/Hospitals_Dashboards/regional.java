package com.example.torjan.Hospitals_Dashboards;

import com.google.gson.annotations.SerializedName;

public class regional {
    @SerializedName("state")
    private String state;

    @SerializedName("ruralHospitals")
    private String ruralHospitals;

    @SerializedName("ruralBeds")
    private String ruralBeds;

    @SerializedName("urbanHospitals")
    private String urbanHospitals;

    @SerializedName("urbanBeds")
    private String urbanBeds;

    @SerializedName("totalHospitals")
    private String totalHospitals;

    @SerializedName("totalBeds")
    private String totalBeds;

    @SerializedName("asOn")
    private String asOn;

    public String getState() {
        return state;
    }

    public String getRuralHospitals() {
        return ruralHospitals;
    }

    public String getRuralBeds() {
        return ruralBeds;
    }

    public String getUrbanHospitals() {
        return urbanHospitals;
    }

    public String getUrbanBeds() {
        return urbanBeds;
    }

    public String getTotalHospitals() {
        return totalHospitals;
    }

    public String getTotalBeds() {
        return totalBeds;
    }

    public String getAsOn() {
        return asOn;
    }
}
