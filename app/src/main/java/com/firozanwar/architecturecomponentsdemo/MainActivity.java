package com.firozanwar.architecturecomponentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.firozanwar.architecturecomponentsdemo.HerosListingSample.HerosListingActivity;
import com.firozanwar.architecturecomponentsdemo.WordSample.views.WordListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWordSample;
    Button btnHeroListingSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnWordSample = findViewById(R.id.btnWordSample);
        btnWordSample.setOnClickListener(this);

        btnHeroListingSample = findViewById(R.id.btnHeroListingSample);
        btnHeroListingSample.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWordSample:
                startActivity(new Intent(MainActivity.this, WordListActivity.class));
                break;

            case R.id.btnHeroListingSample:
                startActivity(new Intent(MainActivity.this, HerosListingActivity.class));
                break;
        }
    }
}
