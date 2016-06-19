package com.example.lavish.drawer_lay;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout dl;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl= (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,dl,toolbar,R.string.drawer_open,R.string.drawer_close);
        dl.addDrawerListener(actionBarDrawerToggle);
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new MapFragmnet());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("MAP FRAGMENT");
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.map:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new MapFragmnet());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("MAP Fragment");
                        item.setChecked(true);
                        break;
                    case R.id.about_us:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AboutUs());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About US Fragment");
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }



}
