package com.techakram.maisha_info1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response
{

    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("address")
    @Expose
    private String address;

    public Response(String fname, String lname, String type, String number, String address) {
        this.fname = fname;
        this.lname = lname;
        this.type = type;
        this.number = number;
        this.address = address;
    }

    public Response(String type) {
        this.type = type;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
