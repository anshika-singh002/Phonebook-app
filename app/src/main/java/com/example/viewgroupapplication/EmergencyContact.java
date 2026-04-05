package com.example.viewgroupapplication;
public class EmergencyContact {
    private String title;
    private String phoneNumber;

    public EmergencyContact(String title, String phoneNumber) {
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}