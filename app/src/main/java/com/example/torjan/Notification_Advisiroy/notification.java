package com.example.torjan.Notification_Advisiroy;

import com.google.gson.annotations.SerializedName;

public class notification {
    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
