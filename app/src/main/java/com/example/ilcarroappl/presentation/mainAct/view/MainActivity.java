package com.example.ilcarroappl.presentation.mainAct.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ilcarroappl.R;
import com.example.ilcarroappl.SearchFragment;
import com.example.ilcarroappl.presentation.auth.view.AuthFrag;
import com.example.ilcarroappl.presentation.main.view.MainFrag;
import com.example.ilcarroappl.presentation.mainAct.presentation.MainActivityPresenter;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends MvpAppCompatActivity implements MainActView, NavigationView.OnNavigationItemSelectedListener, LocationListener {

    private static final String TAG = "MY_TAG";

    @InjectPresenter
    MainActivityPresenter presenter;

    @BindView(R.id.rootMain)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private LocationManager manager;
    MenuItem searchItem;
    AlertDialog dialog;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root, new MainFrag())
                .commitNow();

        setContentView(R.layout.activity_main);
        checkPermissions();
        unbinder = ButterKnife.bind(this, this);

        toolbarSetting();
        navigationSetting();
    }

    @Override
    public void showError(String error) {
        dialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error)
                .setCancelable(false)
                .setPositiveButton("OK", null)
                .create();
        dialog.show();
    }

    public void checkPermissions() {
        presenter.check(this);
    }//OK!

    public void navigationSetting() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void toolbarSetting() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
                    .add(R.id.rootMain, new SearchFragment())
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: 123456");
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }

    }

    //Navigation
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
                        .add(R.id.rootMain, new AuthFrag(true), "AuthFrag")
                        .addToBackStack(null)
                        .commit();
                drawerLayout.closeDrawer((GravityCompat.START));
                break;
            case R.id.nav_sign_up:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.rootMain, new AuthFrag(false), "AuthFrag")
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

    //Location
    @Override
    public void getLocationUpd() {
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }//OK

    @Override
    public void onLocationChanged(Location location) {
        presenter.onSaveLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(TAG, "onStatusChanged: ");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d(TAG, "onProviderEnabled: ");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d(TAG, "onProviderDisabled: ");
    }
}




