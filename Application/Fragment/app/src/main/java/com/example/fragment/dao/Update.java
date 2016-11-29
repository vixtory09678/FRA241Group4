package com.example.fragment.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 11/27/16 AD.
 */
public class Update {
    @SerializedName("api_key") private String apiKey;
    @SerializedName("field1") private String data;

    public Update (String apiKey,String data){
        this.apiKey = apiKey;
        this.data = data;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
