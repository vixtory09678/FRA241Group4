package com.example.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.Place.CB_1;
import com.example.fragment.Place.CB_2;
import com.example.fragment.Place.CB_3;
import com.example.fragment.Place.CB_4;
import com.example.fragment.Place.CB_5;
import com.example.fragment.Place.CarPark14;
import com.example.fragment.Place.ChemDeparment;
import com.example.fragment.Place.ChemEN;
import com.example.fragment.Place.Construction;
import com.example.fragment.Place.DarunSchool;
import com.example.fragment.Place.DomFemale;
import com.example.fragment.Place.DomMale;
import com.example.fragment.Place.EnBuilding;
import com.example.fragment.Place.FIBO;
import com.example.fragment.Place.KFC;
import com.example.fragment.Place.LiberalArts;
import com.example.fragment.Place.Library;
import com.example.fragment.Place.MathDepartment;
import com.example.fragment.Place.MicroBiology;
import com.example.fragment.Place.NewBuilding;
import com.example.fragment.Place.PhysicDepartment;
import com.example.fragment.Place.PlaceFactory;
import com.example.fragment.Place.PlaceKmutt;
import com.example.fragment.Place.PresidentOffice;
import com.example.fragment.Place.SIT;
import com.example.fragment.Place.SciLabBuilding;
import com.example.fragment.R;

import com.example.fragment.dao.FirebaseValue;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inthecheesefactory.thecheeselibrary.widget.AdjustableImageButton;


public class MainFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveListener, ValueEventListener {

    GoogleMap GMap;

    GroundOverlay mapOverlay,red_line,yellow_line,map_label;
    GroundOverlayOptions mapOverlayOptions, map_labelOverlayOptions;
    GroundOverlayOptions red_lineOptions, yellow_lineOptions;
    AdjustableImageButton ButtonCar1, ButtonCar2;
    SupportMapFragment map;
    DatabaseReference mgpsRef,mRef;

    View rootView;


    Marker mFIBO,mSlope,mMicro,mChem,mMath,mPHY,mLib,mSIT,mConstruction,mAthikan,mSoLa,mCB1,
            mCB2,mCB3,mCB4,mCB5,mKFC,mChemEng,mRed_Building,mLX,mDorm_Girl,mDorm_Boy,mNewBuilding,mCarpark
            ,station1,station2,station3,station4,station5;

    Marker ebus_car1;

    LatLngBounds kmuttbounds = new LatLngBounds(new LatLng(13.647080, 100.490774), new LatLng(13.655056, 100.497254)),
            mapbounds = new LatLngBounds(new LatLng(13.642637, 100.484570), new LatLng(13.659925, 100.504021));

    LatLng position_Initmap = new LatLng(13.65111348977032,100.49399703936434),
            position_Redline = new LatLng(13.65167348975617,100.49378103936965),
            position_Yellowline = new LatLng(13.651433489762228,100.4934210339381),
            Initial_pos = new LatLng(13.651122, 100.494654);

    float zoom;
    float map_wide = 685f , map_high = 884f,
            redline_wide = 378f,redline_high = 527f,
            yellowline_wide = 457f, yellowline_high = 504f;

    String S_Lat,S_Long;
    Double D_Lat,D_Long;
    int Users;

    int someVar;


    public static MainFragment newInstance(int someVar){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();//argument
        args.putInt("someVar",someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Read back from Argument
        someVar = getArguments().getInt("someVar");



    }


    private void initInstances(View rootView) {
        ButtonCar1 = (AdjustableImageButton) rootView.findViewById(R.id.Y_line);
        ButtonCar2 = (AdjustableImageButton) rootView.findViewById(R.id.R_line);
        setOverlay();
    }






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main,container,false);
        map = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        map.getMapAsync(this);

        initInstances(rootView);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save State
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){
            //REstore state
        }
    }


    /**
     *   setOverlay()
     *   Setting Image & line of the maps
     */

    private void setOverlay() {
        //Initial Map
        mapOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.kmuttmap))
                .position(position_Initmap, map_wide, map_high);

        //Red Line
        red_lineOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.red_line))
                .position(position_Redline, redline_wide, redline_high);

        //Yellow Line
        yellow_lineOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.yellow_line))
                .position(position_Yellowline, yellowline_wide, yellowline_high);

        //Map with label
        map_labelOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.kmuttmap_label2))
                .position(position_Initmap, map_wide, map_high);

    }

    /**
     *   onMapReady()
     *   This function is working when Map is showing on SmartPhone
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        GMap = googleMap;
        Declare_Marker();
        ButtonCar1.setOnClickListener(this);
        ButtonCar2.setOnClickListener(this);

        GMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        GMap.setLatLngBoundsForCameraTarget(mapbounds);    //Scoping Bounds
        GMap.setMinZoomPreference(16.5f);               //Minimum Zoom
        GMap.setMaxZoomPreference(18);                  //Maximum Zoom

        mapOverlay = GMap.addGroundOverlay(mapOverlayOptions);
        map_label = GMap.addGroundOverlay(map_labelOverlayOptions);
        yellow_line = GMap.addGroundOverlay(yellow_lineOptions);
        red_line = GMap.addGroundOverlay(red_lineOptions);
        yellow_line.setVisible(false);
        red_line.setVisible(false);

        GMap.setOnCameraIdleListener(this);
        GMap.setOnCameraMoveListener(this);

        ebus_car1 = GMap.addMarker(new MarkerOptions()
                        .position(Initial_pos)
                        //.title("0 คน")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.car_marker2))
                        .visible(false));

        mRef = FirebaseDatabase.getInstance().getReference();
        mgpsRef = mRef.child("gps");
        mgpsRef.addValueEventListener(this);

        boolean success = GMap.setMapStyle(new MapStyleOptions(getResources() //Set Map Style
                .getString(R.string.style_json)));
        if (!success) {
            Log.e("MapsActivityString", "Style parsing failed.");
        }

    }


    /**
     *   Under this comment OnClick()
     *   To Calibate each images include map, red&yellow line, map_label
     *   Calibate this value (Lattitute, Longitude, wide, high)
     */

    @Override
    public void onClick(View v) {
        if (v == ButtonCar1){
            if(red_line.isVisible()){
                red_line.setVisible(false);
            }
            if(yellow_line.isVisible()){
                yellow_line.setVisible(false);
            }
            else{
                yellow_line.setVisible(true);
            }
        }

        if( v == ButtonCar2) {
            if(yellow_line.isVisible()){
                yellow_line.setVisible(false);
            }
            if(red_line.isVisible()){
                red_line.setVisible(false);
            }
            else{
                red_line.setVisible(true);
            }
        }


    }

    /**
     *  This function work when Camera stop moving
     *  CameraLat = Get latitude of center of camera after camera stop moving
     *  CameraLong = Get longigude of center of camera after camera stop moving
     *  If CameraLat & CameraLong are outside 'kmuttmap', Camera will move to the center of 'mapbounds'
     */

    @Override
    public void onCameraIdle() {
        double CameraLat = GMap.getCameraPosition().target.latitude;
        double CameraLong = GMap.getCameraPosition().target.longitude;
        if (CameraLat <= 13.647080 || CameraLat >= 13.655056) {
            GMap.animateCamera(CameraUpdateFactory.newLatLng(mapbounds.getCenter()));
        }
        if (CameraLong <= 100.490774 || CameraLong >= 100.497254) {
            GMap.animateCamera(CameraUpdateFactory.newLatLng(mapbounds.getCenter()));
        }

    }

    /**
     *   Work when Camera is moving.
     *   zoom = Get camera's zoom
     *   Set Visibility of 'map_label'
     */
    @Override
    public void onCameraMove() {
        zoom = GMap.getCameraPosition().zoom;
        if(zoom >= 17.2f){
            map_label.setVisible(true);
            mapOverlay.setVisible(false);
        }
        else{
            map_label.setVisible(false);
            mapOverlay.setVisible(true);
        }

    }

    public void SearchLocation(String NamePlace){

        PlaceKmutt getplace = PlaceFactory.PlaceManager(NamePlace);

        if(getplace != null) {
            GMap.animateCamera(CameraUpdateFactory.newLatLngZoom(getplace.getPosition(), 18));

        }
    }

    public void Declare_Marker(){

        station1 =  GMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.651833, 100.495554))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.station1)));

        station2 =  GMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.649330, 100.494261))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.station2)));

        station3 =  GMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.650242, 100.491702))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.station3)));

        station4 =  GMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.652366, 100.493099))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.station4)));

        station5 =  GMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.653550, 100.494778))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.station5)));

        mCarpark = GMap.addMarker(new MarkerOptions()
                .position(new CarPark14().getPosition())
                .title(new CarPark14().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mNewBuilding = GMap.addMarker(new MarkerOptions()
                .position(new NewBuilding().getPosition())
                .title(new NewBuilding().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mFIBO = GMap.addMarker(new MarkerOptions()
                .position(new FIBO().getPosition())
                .title(new FIBO().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mSlope = GMap.addMarker(new MarkerOptions()
                .position(new SciLabBuilding().getPosition())
                .title(new SciLabBuilding().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mMicro = GMap.addMarker(new MarkerOptions()
                .position(new MicroBiology().getPosition())
                .title(new MicroBiology().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mChem = GMap.addMarker(new MarkerOptions()
                .position(new ChemDeparment().getPosition())
                .title(new ChemDeparment().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mMath = GMap.addMarker(new MarkerOptions()
                .position(new MathDepartment().getPosition())
                .title(new MathDepartment().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mPHY = GMap.addMarker(new MarkerOptions()
                .position(new PhysicDepartment().getPosition())
                .title(new PhysicDepartment().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mLib = GMap.addMarker(new MarkerOptions()
                .title(new Library().getName())
                .position(new Library().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lib)));

        mSIT = GMap.addMarker(new MarkerOptions()
                .title(new SIT().getName())
                .position(new SIT().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mConstruction = GMap.addMarker(new MarkerOptions()
                .title(new Construction().getName())
                .position(new Construction().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.construction)));

        mAthikan = GMap.addMarker(new MarkerOptions()
                .position(new PresidentOffice().getPosition())
                .title(new PresidentOffice().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mSoLa = GMap.addMarker(new MarkerOptions()
                .position(new LiberalArts().getPosition())
                .title(new LiberalArts().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mCB1 = GMap.addMarker(new MarkerOptions()
                .position(new CB_1().getPosition())
                .title(new CB_1().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mCB2 = GMap.addMarker(new MarkerOptions()
                .position(new CB_2().getPosition())
                .title(new CB_2().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mCB3 = GMap.addMarker(new MarkerOptions()
                .position(new CB_3().getPosition())
                .title(new CB_3().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mCB4 = GMap.addMarker(new MarkerOptions()
                .position(new CB_4().getPosition())
                .title(new CB_4().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mCB5 = GMap.addMarker(new MarkerOptions()
                .position(new CB_5().getPosition())
                .title(new CB_5().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mKFC = GMap.addMarker(new MarkerOptions()
                .title(new KFC().getName())
                .position(new KFC().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.canteen)));

        mChemEng = GMap.addMarker(new MarkerOptions()
                .position(new ChemEN().getPosition())
                .title(new ChemEN().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mRed_Building = GMap.addMarker(new MarkerOptions()
                .position(new EnBuilding().getPosition())
                .title(new EnBuilding().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));
        mLX = GMap.addMarker(new MarkerOptions()
                .position(new DarunSchool().getPosition())
                .title(new DarunSchool().getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.building)));

        mDorm_Girl = GMap.addMarker(new MarkerOptions()
                .title(new DomFemale().getName())
                .position(new DomFemale().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.dorm_f)));

        mDorm_Boy = GMap.addMarker(new MarkerOptions()
                .title(new DomMale().getName())
                .position(new DomMale().getPosition())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.dorm_m)));
    }

    /**
     * When Data on firebase change
     * There are 2 values ===> latitude & longtitude
     */

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        FirebaseValue value = dataSnapshot.getValue(FirebaseValue.class);
        S_Lat = value.getLat();
        S_Long = value.getLong();
        D_Lat = Double.parseDouble(S_Lat);
        D_Long = Double.parseDouble(S_Long);
        Users = Integer.parseInt(value.getUser());
        ebus_car1.setTitle(Users + " คน");
        if(ebus_car1.isVisible()){
            ebus_car1.setPosition(new LatLng(D_Lat,D_Long));
        }else{
            ebus_car1.setVisible(true);
            ebus_car1.setPosition(new LatLng(D_Lat,D_Long));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}

