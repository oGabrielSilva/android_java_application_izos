package com.silva.odevgabriel.izanamios.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.silva.odevgabriel.izanamios.R;
import com.silva.odevgabriel.izanamios.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.model = new ViewModelProvider(this).get(MainViewModel.class);

        this.setObserve();
        this.setAppReady();
    }

    private void setAppReady() {
        Runnable r = () -> this.model.forceAppReady();

        new Handler().postDelayed(r, 100);
    }

    private void setObserve() {
        this.model.isReady.observe(this, isReady -> {
            if (isReady) {
                Runnable r = () -> {
                    startActivity(new Intent(MainActivity.this, SignInActivity.class));
                    finish();
                };

                new Handler().postDelayed(r, 500);
            }
        });
    }
}