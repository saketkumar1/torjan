package com.example.torjan;

public class HospitalModel {

    private String state;
    private String ruralHospitals;
    private String ruralBeds;
    private String urbanHospitals;
    private String urbanBeds;
    private String totalHospitals;
    private String totalBeds;
    private String asOn;

    public HospitalModel(String state, String ruralHospitals, String ruralBeds, String urbanHospitals, String urbanBeds, String totalHospitals, String totalBeds, String asOn) {
        this.state = state;
        this.ruralHospitals = ruralHospitals;
        this.ruralBeds = ruralBeds;
        this.urbanHospitals = urbanHospitals;
        this.urbanBeds = urbanBeds;
        this.totalHospitals = totalHospitals;
        this.totalBeds = totalBeds;
        this.asOn = asOn;
    }

    public HospitalModel(){

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRuralHospitals() {
        return ruralHospitals;
    }

    public void setRuralHospitals(String ruralHospitals) {
        this.ruralHospitals = ruralHospitals;
    }

    public String getRuralBeds() {
        return ruralBeds;
    }

    public void setRuralBeds(String ruralBeds) {
        this.ruralBeds = ruralBeds;
    }

    public String getUrbanHospitals() {
        return urbanHospitals;
    }

    public void setUrbanHospitals(String urbanHospitals) {
        this.urbanHospitals = urbanHospitals;
    }

    public String getUrbanBeds() {
        return urbanBeds;
    }

    public void setUrbanBeds(String urbanBeds) {
        this.urbanBeds = urbanBeds;
    }

    public String getTotalHospitals() {
        return totalHospitals;
    }

    public void setTotalHospitals(String totalHospitals) {
        this.totalHospitals = totalHospitals;
    }

    public String getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(String totalBeds) {
        this.totalBeds = totalBeds;
    }

    public String getAsOn() {
        return asOn;
    }

    public void setAsOn(String asOn) {
        this.asOn = asOn;
    }
}
