package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class DomMale implements PlaceKmutt {

    private String name;
    private LatLng position;


    public DomMale(){
        name = "บ้านธรรมรักษา 1(หอชาย)";
        position = new LatLng(13.649465483298274, 100.49456890672445);
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