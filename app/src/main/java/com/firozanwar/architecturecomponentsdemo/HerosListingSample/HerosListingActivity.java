package com.firozanwar.architecturecomponentsdemo.HerosListingSample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firozanwar.architecturecomponentsdemo.R;

import java.util.List;

public class HerosListingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;

    HeroesViewModel heroesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heros_listing);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel.class);
        heroesViewModel.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> heroes) {
                adapter = new HeroesAdapter(HerosListingActivity.this, heroes);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
