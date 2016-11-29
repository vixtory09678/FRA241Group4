package com.example.fragment;

import android.app.Application;

import com.example.fragment.manager.Contextor;

/**
 * Created by Admin on 11/19/16 AD.
 */
public class MainAplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
