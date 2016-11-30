package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class CarPark14 implements PlaceKmutt {

    private String name;
    private LatLng position;


    public CarPark14(){
        name = "อาคารจอดรถสูง 14 ชั้น";
        position = new LatLng(13.650374, 100.495718);
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