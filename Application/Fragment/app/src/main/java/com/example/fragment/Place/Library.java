package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class Library implements PlaceKmutt {

    private String name;
    private LatLng position;


    public Library(){
        name = "สำนักหอสมุด";
        position = new LatLng(13.653128830282432, 100.49396473914383);
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