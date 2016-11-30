package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CB_1 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CB_1(){
        name = "อาคารเรียนรวม 1";
        position = new LatLng(13.65159006205979, 100.4934886470437);
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