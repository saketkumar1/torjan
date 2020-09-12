package com.example.torjan.Hospitals_Dashboards;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class hb_data {
    @SerializedName("summary")
    private summary Summary;

    @SerializedName("sources")
    private ArrayList<sources> Sources;

    public summary getSummary() {
        return Summary;
    }

    public ArrayList<sources> getSources() {
        return Sources;
    }

    public ArrayList<regional> getRegional() {
        return regional;
    }

    @SerializedName("regional")
    private ArrayList<regional> regional;
}
