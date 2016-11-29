package com.example.fragment.dao;

/**
 * Created by Palmkongkiet on 11/28/2016.
 */

public class FirebaseValue {
    public String latitude;
    public String longtitude;
    public String total_user;

    public FirebaseValue(){}

    public FirebaseValue(String latitude,String longtitude,String total_user){
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.total_user = total_user;
    }

    public String getLat(){
        return latitude;
    }

    public String getLong(){
        return longtitude;
    }

    public String getUser(){return total_user;}
}
