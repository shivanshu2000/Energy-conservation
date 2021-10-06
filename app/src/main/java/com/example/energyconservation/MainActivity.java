package com.example.energyconservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private FrameLayout frameLayout;
    public  NavigationView navigationView;
    private TextView toDetailsFragment, toSummaryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDetailsFragment=(TextView)findViewById(R.id.to_details_fragment);

        drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toSummaryActivity=findViewById(R.id.to_summary_activity);

        frameLayout=findViewById(R.id.fragment_container);

        toDetailsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                inDetailsActivity=true;
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

toSummaryActivity.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,SummaryActivity.class);
        startActivity(intent);
    }
});

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.getMenu().getItem(0).setChecked(true);
if (savedInstanceState==null) {
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OverviewFragment()).commit();
    navigationView.setCheckedItem(R.id.overview);

}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.overview:
                navigationView.setCheckedItem(R.id.overview);
                goToFragment("Energy Conservation", new OverviewFragment());
//                toDetailsFragment.setVisibility(View.VISIBLE);
                break;

            case R.id.details:
                Intent intent=new Intent(this,DetailsActivity.class);
                startActivity(intent);
//                toDetailsFragment.setVisibility(View.GONE);
                break;
            case R.id.summary:
                Intent summaryIntent=new Intent(this,SummaryActivity.class);
                startActivity(summaryIntent);
                break;

            case R.id.about:
                Intent infoIntent=new Intent(this,InfoActivity.class);
                startActivity(infoIntent);
                break;




        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void goToFragment(String title, Fragment fragment) {

//        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setFragment(fragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.top_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.about){
            Intent intent=new Intent(this,InfoActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment) {
         //means if user is in home fragment and still clicks to go to home fragment
//            then this code will not run
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
    }


}