package com.example.ilcarroappl.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ilcarroappl.R;
import com.example.ilcarroappl.SearchFragment;
import com.example.ilcarroappl.presentation.auth.view.AuthFrag;
import com.example.ilcarroappl.presentation.main.view.MainFrag;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MY_TAG";
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, new MainFrag())
                .commit();
        setContentView(R.layout.activity_main);
        init();
        toolbarSetting();
        navigationSetting();

    }

    private void navigationSetting() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void toolbarSetting() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        searchItem = findViewById(R.id.search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.drawer_layout, new SearchFragment())
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.close_nav_btn:
                drawerLayout.closeDrawer((GravityCompat.START));
                break;
            case R.id.nav_search:
                Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_favorites:
                Toast.makeText(this, "Favorites", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_login:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.root, new AuthFrag(true),"AuthFrag")
                        .addToBackStack("AuthFrag")
                        .commit();
                drawerLayout.closeDrawer((GravityCompat.START));
                break;
            case R.id.nav_sign_up:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.root, new AuthFrag(false),"AuthFrag")
                        .addToBackStack("AuthFrag")
                        .commit();
                drawerLayout.closeDrawer((GravityCompat.START));
                break;
            case R.id.nav_terms_of_use:
                Toast.makeText(this, "Terms of use", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_work:
                Toast.makeText(this, "Work", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}




