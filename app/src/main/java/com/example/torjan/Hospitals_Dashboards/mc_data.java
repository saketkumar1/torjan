package com.example.torjan.Hospitals_Dashboards;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class mc_data {
    @SerializedName("medicalColleges")
    private ArrayList<medicalColleges> medicalColleges;

    @SerializedName("sources")
    private ArrayList<String> mc_sources;

    public ArrayList<com.example.torjan.Hospitals_Dashboards.medicalColleges> getMedicalColleges() {
        return medicalColleges;
    }

    public ArrayList<String> getMc_sources() {
        return mc_sources;
    }
}
