package com.example.torjan.Notification_Advisiroy;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class data {
    public ArrayList<notification> getNotification() {
        return notification;
    }

    @SerializedName("notifications")
    private ArrayList<notification> notification;
}
