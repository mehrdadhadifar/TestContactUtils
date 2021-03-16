package com.hfad.contactutils.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.hfad.contactutils.R;


public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, createFragment())
                    .commit();
        }
    }
}