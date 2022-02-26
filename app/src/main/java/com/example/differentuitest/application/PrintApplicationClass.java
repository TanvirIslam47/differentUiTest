package com.example.differentuitest.application;

import android.app.Application;

import com.mazenrashed.printooth.Printooth;

public class PrintApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Printooth.INSTANCE.init(this);

    }
}
