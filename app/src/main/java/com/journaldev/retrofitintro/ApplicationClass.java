package com.journaldev.retrofitintro;

import android.app.Application;

import com.squareup.otto.Bus;

public class ApplicationClass extends Application {

    private static Bus bus;
    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();
    }

    public static Bus getEventBus(){
        return bus;
    }
}
