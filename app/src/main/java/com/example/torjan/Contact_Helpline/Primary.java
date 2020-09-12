package com.example.torjan.Contact_Helpline;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Primary {
    @SerializedName("number")
    private String number;

    @SerializedName("number-tollfree")
    private String number_tf;

    @SerializedName("email")
    private String email;

    public String getNumber() {
        return number;
    }
    @SerializedName("twitter")
    private String twitter;

    @SerializedName("facebook")
    private String facebook;

    @SerializedName("media")
    private ArrayList<String> media;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber_tf() {
        return number_tf;
    }

    public void setNumber_tf(String number_tf) {
        this.number_tf = number_tf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public ArrayList<String> getmedia() {
        return media;
    }

    public void setMedia(ArrayList<String> media) {
        this.media = media;
    }


}
