package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class DarunSchool implements PlaceKmutt {

    private String name;
    private LatLng position;


    public DarunSchool(){
        name = "โรงเรียนดรุณสิกขาลัย";
        position = new LatLng(13.65001805155226, 100.49528237432241);
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