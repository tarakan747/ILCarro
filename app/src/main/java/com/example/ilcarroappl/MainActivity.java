package com.example.ilcarroappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MY_TAG";
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem searchItem;
    EditText location, from, till;
    Button yalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        location = findViewById(R.id.inputLocation);
        from = findViewById(R.id.inputFrom);
        till = findViewById(R.id.inputTill);

        yalla = findViewById(R.id.yallaBtnMain);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        yalla.setOnClickListener(v -> {
            String a = location.getText().toString();
            String b = from.getText().toString();
            String c = till.getText().toString();
            Toast.makeText(this, a + " " + b + " " + c, Toast.LENGTH_LONG).show();
        });
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

