package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class SciCenter implements PlaceKmutt {

    private String name;
    private LatLng position;


    public SciCenter(){
        name = "อาคารศูนย์เครื่องมือวิทยาศาสตร์";
        position = new LatLng(13.653111, 100.494363);
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