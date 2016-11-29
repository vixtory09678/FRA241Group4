package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class PhysicDepartment implements PlaceKmutt {

    private String name;
    private LatLng position;


    public PhysicDepartment(){
        name = "อาคารภาควิชาฟิสิกส์";
        position = new LatLng(13.652663584459466, 100.49469094723463);
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