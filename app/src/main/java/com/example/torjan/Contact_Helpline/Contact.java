package com.example.torjan.Contact_Helpline;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Contact {
    @SerializedName("primary")
    private Primary primary;

    @SerializedName("regional")
    private ArrayList<Regional> regional;

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }


    public ArrayList<Regional> getRegional() {
        return regional;
    }

    public void setRegional(ArrayList<Regional> regional) {
        this.regional = regional;
    }


}
