package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class ChemDeparment implements PlaceKmutt {

    private String name;
    private LatLng position;


    public ChemDeparment(){
        name = "อาคารภาควิชาเคมี";
        position = new LatLng(13.652567798440824, 100.49504734575747);
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