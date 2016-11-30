package com.example.fragment.Place;

import com.google.android.gms.maps.model.LatLng;

public class SIT implements PlaceKmutt {

    private String name;
    private LatLng position;


    public SIT(){
        name = "อาคารคณะเทคโนโลยีสารสนเทศ";
        position = new LatLng(13.652708871032964, 100.4936619848013);
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