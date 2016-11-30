package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class EnergyWorkshop implements PlaceKmutt {

    private String name;
    private LatLng position;


    public EnergyWorkshop(){
        name = "อาคารโรงประลองเทคโนโลยีและวัสดุ";
        position = new LatLng(13.648899, 100.493832);
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