package com.example.aplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.aplicativo.main.TelaHome;

import java.util.Timer;
import java.util.TimerTask;

public class TelaSplash extends AppCompatActivity {

    private final Timer timer = new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeMainActivity();
                    }
                });
            }
        };
        timer.schedule(timerTask, 3000);

    }

    private void homeMainActivity() {
        Intent intent = new Intent(getApplicationContext(), TelaHome.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}