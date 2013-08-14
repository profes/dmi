package com.profes.meteo;

import android.app.Application;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

@EApplication
public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        initSomeStuff();
    }

    @Background
    void initSomeStuff() {

    }
}