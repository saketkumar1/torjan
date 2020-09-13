package com.example.torjan.Hospitals_Dashboards;

import com.google.gson.annotations.SerializedName;

public class medicalColleges {
    @SerializedName("state")
    private String state;

    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("ownership")
    private String ownership;

    @SerializedName("admissionCapacity")
    private String admissionCapacity;

    @SerializedName("hospitalBeds")
    private String hospitalBeds;

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getAdmissionCapacity() {
        return admissionCapacity;
    }

    public String getHospitalBeds() {
        return hospitalBeds;
    }
}
