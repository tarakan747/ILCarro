package com.example.ilcarroappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilcarroappl.adapters.ViewPagerAdapters;
import com.example.ilcarroappl.dto.CarDto;
import com.example.ilcarroappl.dto.CarListDto;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MY_TAG";
    ImplHttpProvider httpProvider = new ImplHttpProvider();
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem searchItem;
    EditText location, from, till;
    Button yalla;
    ViewPager bestCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        toolbarSetting();
        navigationSetting();

        yalla.setOnClickListener(v -> {
            String a = location.getText().toString();
            String b = from.getText().toString();
            String c = till.getText().toString();
            Toast.makeText(this, a + " " + b + " " + c, Toast.LENGTH_LONG).show();
        });

        new GetListBestCars().execute();

        bestCars.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("MY_TAG", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("MY_TAG", "onPageSelected() called with: position = [" + position + "]");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.d("MY_TAG", "onPageScrollStateChanged: IDLE");
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.d("MY_TAG", "onPageScrollStateChanged: DRAGGING");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.d("MY_TAG", "onPageScrollStateChanged: SETTLING");
                        break;

                }
            }
        });
    }

    private void viewPagerStart(List<CarDto> list) {
        ViewPagerAdapters adapter = new ViewPagerAdapters(getSupportFragmentManager(), list);
        bestCars.setAdapter(adapter);
        bestCars.setOffscreenPageLimit(2);

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

        location = findViewById(R.id.inputLocation);
        from = findViewById(R.id.inputFrom);
        till = findViewById(R.id.inputTill);

        yalla = findViewById(R.id.yallaBtnMain);

        bestCars = findViewById(R.id.bestCarsVP);

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
                        .add(R.id.drawer_layout, new LoginFragment())
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer((GravityCompat.START));
                break;
            case R.id.nav_sign_up:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.drawer_layout, new RegistrationFragment())
                        .addToBackStack(null)
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

    class GetListBestCars extends AsyncTask<Void, Void, List<CarDto>> {
        List<CarDto> list = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<CarDto> doInBackground(Void... voids) {
            String res = "OK!!!!!!!!!!!";
            try {
                list = httpProvider.topCar();
                Log.d(TAG, "doInBackground: " + list.size());
            } catch (IOException e) {
                res = "Error";
                Log.d(TAG, "doInBackground1: " + e + res);
                e.printStackTrace();
            } catch (RuntimeException e) {
                res = "Error1";
                Log.d(TAG, "doInBackground2: " + e + res);

                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: " + list.size());
            return list;
        }

        @Override
        protected void onPostExecute(List<CarDto> listDto) {
            super.onPostExecute(listDto);
            viewPagerStart(list);
        }
    }
}




