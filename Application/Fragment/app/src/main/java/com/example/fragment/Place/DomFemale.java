package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class DomFemale implements PlaceKmutt {

    private String name;
    private LatLng position;


    public DomFemale(){
        name = "บ้านธรรมรักษา 2(หอหญฺิง)";
        position = new LatLng(13.64885948124886, 100.49483176320791);
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