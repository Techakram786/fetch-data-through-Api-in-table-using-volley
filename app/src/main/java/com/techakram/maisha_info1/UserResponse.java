package com.techakram.maisha_info1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.techakram.maisha_info1.models.Response;

import java.util.List;

public class UserResponse
{
    @SerializedName("Response")
    @Expose
    private List<Response> response = null;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
