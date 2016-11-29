package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class KFC implements PlaceKmutt {

    private String name;
    private LatLng position;


    public KFC(){
        name = "อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี(โรงอาหาร)";
        position = new LatLng(13.651026420118669, 100.49180220812559);
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