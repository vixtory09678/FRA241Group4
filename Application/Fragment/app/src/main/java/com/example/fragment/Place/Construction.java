package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class Construction implements PlaceKmutt {

    private String name;
    private LatLng position;


    public Construction(){
        name = "พื้นที่ก่อสร้างอาคารเรียนรู้พหุวิทยาการ";
        position = new LatLng(13.65174970606427, 100.49425609409809);
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