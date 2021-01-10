package com.miguel_lm.penha_celta.ui;

import com.google.firebase.database.FirebaseDatabase;

public class MyFarebaseApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
