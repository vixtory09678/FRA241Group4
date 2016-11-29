package com.example.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fragment.R;
import com.example.fragment.dao.PhotoItemCollectionDao;
import com.example.fragment.manager.Contextor;
import com.example.fragment.manager.HttpManager;
import com.example.fragment.manager.PhotoListManager;

import org.w3c.dom.Text;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 11/6/16 AD.
 */

public class MainFragment extends Fragment {
    TextView tvHello;
    TextView loadText;
    ImageView loadImage;
    ImageView AdsImage;
    int x,y,z;


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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        //findViewById here
        tvHello = (TextView) rootView.findViewById(R.id.tvHello);
        loadText = (TextView) rootView.findViewById(R.id.loadText);
        loadImage = (ImageView)rootView.findViewById(R.id.loadImage);
        AdsImage = (ImageView) rootView.findViewById(R.id.AdsImage);

        //JSON Server
        Call<PhotoItemCollectionDao> call = HttpManager.getInstance().getService().loadPhotoList();
        call.enqueue(new Callback<PhotoItemCollectionDao>() {
            @Override
            public void onResponse(Call<PhotoItemCollectionDao> call,
                                   Response<PhotoItemCollectionDao> response) {
            //เมื่อติดต่อ Server สำเร็จ
                if (response.isSuccessful()){
                    PhotoItemCollectionDao dao = response.body();
                    PhotoListManager.getInstance().setDao(dao);
                    if (Contextor.getInstance().getContext() == null){
                        Log.i("String = ", "Nullllllllll");
                    }
                    Toast.makeText(Contextor.getInstance().getContext(),dao.getData().get(0).getCaption(),Toast.LENGTH_SHORT).show();
                } else{
                    //Handle
                    try {
                        Toast.makeText(Contextor.getInstance().getContext(),response.errorBody().string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<PhotoItemCollectionDao> call,
                                  Throwable t) {
                //Handle เมื่อConnect Server ไม่ได้
                Toast.makeText(Contextor.getInstance().getContext(),t.toString(),Toast.LENGTH_SHORT).show();


            }
        });
    }
    public void setHelloText(String text){
        tvHello.setText(text);
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



    public void setNameText(String text){
        loadText.setText(text);
    }

    public void setImageUrl(String url){
        // TODO: Load Image
        //Glide.with(getContext())
          //      .load(url)
             //   .placeholder(R.drawable.ic_directions_bus_black_48dp)
            //  .error(R.mipmap.ic_launcher)
             //   .into(AdsImage);
    }
}

