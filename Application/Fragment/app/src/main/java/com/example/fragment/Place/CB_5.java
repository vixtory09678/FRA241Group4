package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CB_5 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CB_5(){
        name = "อาคารเรียนรวม 5";
        position = new LatLng(13.649686380432438, 100.49358788877726);
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