package com.example.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fragment.dao.PhotoItemCollectionDao;
import com.example.fragment.dao.PhotoItemDao;
import com.example.fragment.dao.PromoteDao;
import com.example.fragment.fragment.FourthFragment;
import com.example.fragment.fragment.MainFragment;
import com.example.fragment.fragment.SecondFragment;
import com.example.fragment.fragment.ThirdFragment;
import com.example.fragment.manager.HttpManager;
import com.example.fragment.manager.PagerViewAdapter;
import com.example.fragment.manager.PhotoListManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Button mapsButton;
    Button second_Page;
    Button third_Page;
    Button fourth_Page;
    PromoteDao dao;
    MainFragment fragment;
    ImageView AdsImage;
    Toolbar toolbar;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView places;
    TextView tvPromote;

    ViewPager pager;
   /* private static final String[] Building = new String[] {
            "สถาบันวิทยาการหุ่นยนต์ภาคสนาม - ฟีโบ้",
            "Institude of Field Robotics - FIBO",
            "อาคารเรียนรวม 1",
            "Classroom Building 1",
            "อาคารเรียนรวม 2",
            "Classroom Building 2",
            "อาคารเรียนรวม 3",
            "Classroom Building 3",
            "อาคารเรียนรวม 4",
            "Classroom Building 4",
            "อาคารเรียนรวม 5",
            "Classroom Building 5",
            "อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี - โรงอาหาร",
            "King Mongkut Food Center",
            "โรงเรียนดรุณสิกขาลัย",
            "Darunsikkhalai School",
            "อาคารวิศววัฒนะ",
            "ตึกแดง",
            "Engineering Building",
            "อาคารวิศวกรรมเคมี",
            "Chemical Engineer Building",
            "บ้านธรรมรักษา 1 - หอชาย",
            "Domitory Male",
            "บ้านธรรมรักษา 2 - หอหญฺิง",
            "Domitory Female",
            "อาคารจอดรถสูง 14 ชั้น",
            "อาคารสำนักงานอธิการบดี",
            "Office of The President",
            "อาคารเรียนและปฏิบัติการคณะพลังงานและสิ่งแวดล้อมและวัสดุ",
            "School of Energy, Environment and Materials",
            "อาคารโรงประลองเทคโนโลยีและวัสดุ",
            "Energy and Materials Workshop",
            "อาคารอเนกประสงค์",
            "อาคารศิลปศาสตร์",
            "School of Liberal Arts",
            "อาคารภาควิชาเคมี",
            "Chemistry Department Building",
            "อาคารภาควิชาฟิสิกส์",
            "Department of Physics Building",
            "อาคารภาควิชาคณิตศาสตร์",
            "Department of Mathematics Building",
            "อาคารศูนย์เครื่องมือวิทยาศาสตร์",
            "Scientic Instrumentation Center",
            "อาคารภาควิชาจุลชีววิทยา",
            "Microbiology Building",
            "อาคารปฏิบัติการพื้นฐานทางวิทยาศาสตร์",
            "Fundamental Science Laboratory Building",
            "สำนักหอสมุด",
            "Library Building",
            "อาคารคณะเทคโนโลยีสารสนเทศ",
            "School of Information Technology - SIT"
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        onCoachMark();
    }

    private void initInstances() {
        PagerViewAdapter pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pagerViewAdapter);
        pager.setCurrentItem(1);
        tvPromote = (TextView)findViewById(R.id.tvContent);

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

        String[] Building = getResources().getStringArray(R.array.Building_Search);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Building);//crete list view to design dropdown
        places = (AutoCompleteTextView) findViewById(R.id.place_autocomplete_fragment);
        places.setAdapter(adapter);
        //places.setDropDownBackgroundResource(R.color.);
        places.setOnItemClickListener(this);


        AdsImage = (ImageView) findViewById(R.id.AdsImage);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Call<PromoteDao> call = HttpManager.getInstance().getService().loadPhotoList();
        call.enqueue(new Callback<PromoteDao>() {
            @Override
            public void onResponse(Call<PromoteDao> call, Response<PromoteDao> response) {
                if(response.isSuccessful()){
                    dao = response.body();
                    Log.i("Load Promote","success");

                    Glide.with(MainActivity.this)
                            .load(dao.getUrlPicture())
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .into(AdsImage);

                    tvPromote.setText(dao.getContent());

                    AdsImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri uri = Uri.parse("http://"+dao.getUrlLink()); // missing 'http://' will cause crashed
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });

                    // TODO : put setText + URL
                    //fragment.setImageUrl(dao.getData().get(0).getImageUrl());

                }else{

                }
            }

            @Override
            public void onFailure(Call<PromoteDao> call, Throwable t) {
                Log.e("Load Promote","fail");
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
        if (savedInstanceState == null ){
            fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");

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
            pager.setCurrentItem(1);
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this,"Maps",Toast.LENGTH_SHORT).show();

        }
        if(v == second_Page){
            onCoachMark();
            pager.setCurrentItem(1);
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this,"Second Fragment",Toast.LENGTH_SHORT).show();

        }
        if(v == third_Page ){
            pager.setCurrentItem(2);
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this,"Third Fragment",Toast.LENGTH_SHORT).show();

        }
        if (v== fourth_Page){
            pager.setCurrentItem(0);
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this,"Fourth Fragment",Toast.LENGTH_SHORT).show();

        }
    }

    public void setPage(int position){
        pager.setCurrentItem(position);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String NamePlace = parent.getItemAtPosition(position).toString();
        //Toast.makeText(getApplicationContext(),"page "+pager.getCurrentItem(),Toast.LENGTH_LONG).show();
        pager.setCurrentItem(1);
        Fragment fragment = getActivityFragment(pager,1);
        if(fragment == null){
            Log.e("error","errorrrrrrrr");
        }
        MainFragment mainFragment = (MainFragment) fragment;
        if(mainFragment != null) {
            mainFragment.SearchLocation(NamePlace);
        }
        places.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Hide:
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        drawerLayout.closeDrawer(GravityCompat.START);

    }

    public Fragment getActivityFragment(ViewPager container,int position){
        String name = "android:switcher:" + container.getId() + ":" + position;
        return getSupportFragmentManager().findFragmentByTag(name);
    }
}
