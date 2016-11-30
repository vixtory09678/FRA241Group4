package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class EnergySchool implements PlaceKmutt {

    private String name;
    private LatLng position;


    public EnergySchool(){
        name = "อาคารเรียนและปฏิบัติการคณะพลังงานและสิ่งแวดล้อมและวัสดุ";
        position = new LatLng(13.648934, 100.493356);
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