package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class ChemEN implements PlaceKmutt {

    private String name;
    private LatLng position;


    public ChemEN(){
        name = "อาคารวิศวกรรมเคมี";
        position = new LatLng(13.650411951127193, 100.49312822520733);
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