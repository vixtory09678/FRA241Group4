package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class MicroBiology implements PlaceKmutt {

    private String name;
    private LatLng position;


    public MicroBiology(){
        name = "อาคารภาควิชาจุลชีววิทยา";
        position = new LatLng(13.65338816859215, 100.49468927085401);
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