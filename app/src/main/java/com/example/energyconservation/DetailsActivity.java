package com.example.energyconservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    LinearLayout  item2, item3, item4, item5, item6, item7, item8, item9;
    TextView detailsToSummary;

    FrameLayout frameLayout, secondFrameLayout;

    public static boolean detailsFragment = false;
    public static boolean secondDetailsFragment=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        secondFrameLayout = findViewById(R.id.behind_fragment_container);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        secondFrameLayout.setVisibility(View.GONE);
        frameLayout = findViewById(R.id.details_fragment);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        item6 = findViewById(R.id.item6);
        item7 = findViewById(R.id.item7);
        item8 = findViewById(R.id.item8);
        item9 = findViewById(R.id.item9);
        detailsToSummary=findViewById(R.id.details_to_summary);

        detailsToSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this,SummaryActivity.class);
                startActivity(intent);
            }
        });


        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new FirstItemFragment());
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SecondItemFragment());
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ThirdItemFragment());
            }
        });
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new FourthItemFragment());
            }
        });
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new FifthItemFragment());
            }
        });
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SixthItemFragment());
            }
        });
        item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SeventhItemFragment());
            }
        });
        item9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new EigthItemFragment());
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home){
            if (detailsFragment){
                detailsFragment=false;
                secondFrameLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
            }else{
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment) {
        //means if user is in home fragment and still clicks to go to home fragment
//            then this code will not run
        detailsFragment = true;
        frameLayout.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(secondFrameLayout.getId(), fragment);
        fragmentTransaction.commit();

        secondFrameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (detailsFragment) {
            detailsFragment=false;
            secondFrameLayout.setVisibility(View.GONE);

            frameLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}