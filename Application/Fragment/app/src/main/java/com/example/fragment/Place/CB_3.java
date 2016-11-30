package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CB_3 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CB_3(){
        name = "อาคารเรียนรวม 3";
        position = new LatLng(13.649782167621014, 100.49204394221307);
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