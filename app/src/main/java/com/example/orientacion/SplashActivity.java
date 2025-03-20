package com.example.orientacion;


import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SplashActivity extends AppCompatActivity {
    private ScheduledExecutorService scheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(new MyRunnable(), 1, TimeUnit.SECONDS);
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            runOnUiThread(() -> {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // cerrar la actividad actual
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }
}

