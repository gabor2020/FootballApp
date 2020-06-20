package at.home.gabor.footballapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_LANGUAGE = "keyLanguage";


    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPrefs();
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_with_language_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemEn:
                setEnglish();
                break;
            case R.id.itemGe:
                setGerman();
                break;
            case R.id.itemHu:
                setHungarian();
                break;
        }
        return true;
    }

    String localeCode;

    public void setHungarian() {
        localeCode = "hu";
        setAppLocale(localeCode);
    }

    public void setEnglish() {
        localeCode = "en";
        setAppLocale(localeCode);
    }

    public void setGerman() {
        localeCode = "de";
        setAppLocale(localeCode);
    }

    public void setAppLocale(String localeCode) {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_LANGUAGE, localeCode);
        editor.apply();

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public void loadPrefs() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        localeCode = prefs.getString(KEY_LANGUAGE, "de");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        //here is the main place where we need to work on.
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_home:
                Intent h = new Intent(MainActivity.this, MainActivity.class);
                startActivity(h);
                break;
            case R.id.nav_era:
                Intent i = new Intent(MainActivity.this, EraActivity.class);
                startActivity(i);
                break;
            case R.id.nav_top5:
                Intent s = new Intent(MainActivity.this, TopActivity.class);
                startActivity(s);
                break;
            case R.id.nav_media:
                Intent g = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(g);
                break;
            case R.id.nav_quiz:
                Intent t = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(t);
                break;
            case R.id.nav_info:
                Intent k = new Intent(Intent.ACTION_VIEW, Uri.parse("https://antalgabor.squarespace.com"));
                if (k.resolveActivity(getPackageManager()) != null){
                    startActivity(k);
                }
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

