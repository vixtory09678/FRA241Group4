package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class SciLabBuilding implements PlaceKmutt {

    private String name;
    private LatLng position;


    public SciLabBuilding(){
        name = "อาคารปฏิบัติการพื้นฐานทางวิทยาศาสตร์";
        position = new LatLng(13.6535745277100925, 100.49498297274111);
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