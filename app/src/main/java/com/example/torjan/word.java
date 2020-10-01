package com.example.torjan;

public class word {
// testing
    private String state_name;
    private String state_no;

    public word(String state_name, String state_no) {
        this.state_name = state_name;
        this.state_no = state_no;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_no() {
        return state_no;
    }

    public void setState_no(String state_no) {
        this.state_no = state_no;
    }
}
