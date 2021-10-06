package com.example.energyconservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SummaryActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Toolbar toolbar = findViewById(R.id.summary_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.summary_fragment_container,new FirstSummaryFragment()).commit();


//        getSupportFragmentManager().beginTransaction().replace(R.id.summary_fragment_container,new FirstSummaryFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.summary_fragment_container,new FirstSummaryFragment()).commit();
                            break;

                        case R.id.favourites:
                            getSupportFragmentManager().beginTransaction().replace(R.id.summary_fragment_container,new SecondSummaryFragment()).commit();
                            break;
                        case R.id.search:
                            getSupportFragmentManager().beginTransaction().replace(R.id.summary_fragment_container,new ThirdSummaryFragment()).commit();
                            break;
                    }
                    return true;
                }
            };
}