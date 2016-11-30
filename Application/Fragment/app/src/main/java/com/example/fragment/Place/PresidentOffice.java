package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class PresidentOffice implements PlaceKmutt {

    private String name;
    private LatLng position;


    public PresidentOffice(){
        name = "อาคารสำนักงานอธิการบดี";
        position = new LatLng(13.651956265697496,100.49502991139889);
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}