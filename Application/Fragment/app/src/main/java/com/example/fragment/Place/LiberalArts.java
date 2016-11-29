package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class LiberalArts implements PlaceKmutt {

    private String name;
    private LatLng position;


    public LiberalArts(){
        name = "อาคารศิลปศาสตร์";
        position = new LatLng(13.651971904274363, 100.49336023628713);
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