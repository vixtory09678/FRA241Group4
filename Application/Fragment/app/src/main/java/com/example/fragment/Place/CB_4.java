package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CB_4 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CB_4(){
        name = "อาคารเรียนรวม 4";
        position = new LatLng(13.649414983186944, 100.49273259937763);
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