package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CB_2 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CB_2(){
        name = "อาคารเรียนรวม 2";
        position = new LatLng(13.65144375928168, 100.49402743577957);
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