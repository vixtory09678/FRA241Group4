package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class MathDepartment implements PlaceKmutt {

    private String name;
    private LatLng position;


    public MathDepartment(){
        name = "อาคารภาควิชาคณิตศาสตร์";
        position = new LatLng(13.652869491687582, 100.49437612295152);
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