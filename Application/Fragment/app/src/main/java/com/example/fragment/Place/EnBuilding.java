package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class EnBuilding implements PlaceKmutt {

    private String name;
    private LatLng position;


    public EnBuilding(){
        name = "อาคารวิศววัฒนะ";
        position = new LatLng(13.64998872897697, 100.49412097781898);
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