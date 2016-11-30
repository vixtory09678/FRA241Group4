package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class FIBO implements PlaceKmutt {

    private String name;
    private LatLng position;


    public FIBO(){
        name = "สถาบันวิทยาการหุ่นยนต์ภาคสนาม(ฟีโบ้)";
        position = new LatLng(13.654651298468655, 100.49434728920461);
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