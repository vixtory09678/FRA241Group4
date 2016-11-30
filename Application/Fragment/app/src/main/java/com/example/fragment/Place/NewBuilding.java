package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class NewBuilding implements PlaceKmutt {

    private String name;
    private LatLng position;


    public NewBuilding(){
        name = "อาคารอเนกประสงค์";
        position = new LatLng(13.652028, 100.492832);
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