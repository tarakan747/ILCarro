package com.example.ilcarroappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilcarroappl.adapters.ViewPagerAdapters;
import com.example.ilcarroappl.data.dto.CarForUsersDto;
import com.example.ilcarroappl.data.provider.web.Api;
import com.example.ilcarroappl.dto.CarDto;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MY_TAG";
    //    ImplHttpProvider httpProvider = new ImplHttpProvider();
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
        viewPagerStart();

        yalla.setOnClickListener(v -> {
            String a = location.getText().toString();
            String b = from.getText().toString();
            String c = till.getText().toString();
            Toast.makeText(this, a + " " + b + " " + c, Toast.LENGTH_LONG).show();
        });


        bestCars.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//               Log.d("MY_TAG", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
                //          Log.d("MY_TAG", "onPageSelected() called with: position = [" + position + "]");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:

                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:

                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:

                        break;

                }
            }
        });
    }

    private void viewPagerStart() {
        Api api = ApiProvider.getInstance().getApi();
        Disposable disposable = api.topCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((response, error) -> {
                    if (response != null) {
                        if (response.isSuccessful()) {
                            List<CarForUsersDto> list = new ArrayList<>(response.body());
                            ViewPagerAdapters adapter = new ViewPagerAdapters(getSupportFragmentManager(), list);
                            bestCars.setOffscreenPageLimit(3);
                            bestCars.setAdapter(adapter);

                        } else {
                            Log.d(TAG, "test3: " + response.errorBody().string());
                        }
                    } else if (error != null) {
                        error.printStackTrace();
                    }
                });
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

}




