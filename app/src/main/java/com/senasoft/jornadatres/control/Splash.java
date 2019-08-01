package com.senasoft.jornadatres.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.senasoft.jornadatres.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash.this, PerfilActivity.class);
                startActivity(intent);
                finish();

            }
        };

        timer.schedule(timerTask, 3000);

    }
}