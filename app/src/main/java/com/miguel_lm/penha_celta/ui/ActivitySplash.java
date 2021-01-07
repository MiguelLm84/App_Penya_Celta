package com.miguel_lm.penha_celta.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel_lm.penha_celta.R;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(() -> startActivity(new Intent(com.miguel_lm.penha_celta.ui.ActivitySplash.this, MainActivity.class)), 1500);

        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
    }
}