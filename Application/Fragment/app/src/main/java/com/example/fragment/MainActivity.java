package com.example.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fragment.dao.PhotoItemCollectionDao;
import com.example.fragment.dao.PhotoItemDao;
import com.example.fragment.fragment.FourthFragment;
import com.example.fragment.fragment.MainFragment;
import com.example.fragment.fragment.SecondFragment;
import com.example.fragment.fragment.ThirdFragment;
import com.example.fragment.manager.HttpManager;
import com.example.fragment.manager.PhotoListManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Button mapsButton;
    Button second_Page;
    Button third_Page;
    Button fourth_Page;
    PhotoItemCollectionDao dao;
    MainFragment fragment;
    ImageView AdsImage;
    Toolbar toolbar;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
        onCoachMark();
        if (savedInstanceState == null){
            //First create
            //Place Fragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,new MainFragment().newInstance(123)
                            , "MainFragment" )
                    .commit();


        }
    }

    private void initInstances() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
            MainActivity.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mapsButton = (Button) findViewById(R.id.mapButton);
        mapsButton.setOnClickListener(this);

        second_Page = (Button) findViewById(R.id.second_Page);
        second_Page.setOnClickListener(this);

        third_Page = (Button) findViewById(R.id.third_Page);
        third_Page.setOnClickListener(this);

        fourth_Page = (Button) findViewById(R.id.fourth_Page);
        fourth_Page.setOnClickListener(this);

        AdsImage = (ImageView) findViewById(R.id.AdsImage);


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
        if (savedInstanceState == null ){
            fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Who hooooooo");

            Call<PhotoItemCollectionDao> call = HttpManager.getInstance().getService().loadPhotoList();
            call.enqueue(new Callback<PhotoItemCollectionDao>() {
                @Override
                public void onResponse(Call<PhotoItemCollectionDao> call, Response<PhotoItemCollectionDao> response) {
                    if(response.isSuccessful()){
                        dao = response.body();


                        Glide.with(MainActivity.this)
                                .load(dao.getData().get(0).getImageUrl())
                                .placeholder(R.drawable.ic_directions_bus_black_48dp)
                                .error(R.mipmap.ic_launcher)
                                .into(AdsImage);

                        // TODO : put setText + URL
                        fragment.setNameText(dao.getData().get(0).getCaption());
                        //fragment.setImageUrl(dao.getData().get(0).getImageUrl());

                    }else{

                    }
                }

                @Override
                public void onFailure(Call<PhotoItemCollectionDao> call, Throwable t) {

                }
            });

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        if(v == mapsButton){
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof MainFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                MainFragment.newInstance(123))
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this,"Maps",Toast.LENGTH_SHORT).show();

        }
        if(v == second_Page){
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof SecondFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            onCoachMark();
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this,"Second Fragment",Toast.LENGTH_SHORT).show();

        }
        if(v == third_Page ){

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof ThirdFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                ThirdFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this,"Third Fragment",Toast.LENGTH_SHORT).show();

        }
        if (v== fourth_Page){
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof FourthFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                FourthFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this,"Fourth Fragment",Toast.LENGTH_SHORT).show();

        }
    }
    public void onCoachMark(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.coach_mark);
        dialog.setCanceledOnTouchOutside(true);
        //for dismissing anywhere you touch
        View masterView = dialog.findViewById(R.id.coach_mark_master_view);
        masterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
