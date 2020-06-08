package at.home.gabor.footballapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            outState.putString("my_text", getResources().getConfiguration().getLocales().get(0).getLanguage());
        }else outState.putString("my_text", getResources().getConfiguration().locale.getLanguage());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            setAppLocale(Objects.requireNonNull(savedInstanceState.getString("my_text")));}
    }


    public void startEra(View view) {
        Intent intent = new Intent(this, EraActivity.class);
        startActivity(intent);
    }

    public void startTop(View view) {
        Intent intent = new Intent(this, TopActivity.class);
        startActivity(intent);
    }

    public void startMedia(View view) {
        Intent intent = new Intent(this, MediaActivity.class);
        startActivity(intent);
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
            case R.id.itemMain1:
                Intent intent0 = new Intent(this, MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.itemEra1:
                Intent intent = new Intent(this, EraActivity.class);
                startActivity(intent);
                break;
            case R.id.itemTop51:
                Intent intent2 = new Intent(this, TopActivity.class);
                startActivity(intent2);
                break;
            case R.id.itemMedia1:
                Intent intent3 = new Intent(this, MediaActivity.class);
                startActivity(intent3);
                break;
            case R.id.itemQuiz1:
                Intent intent4 = new Intent(this, QuizActivity.class);
                startActivity(intent4);
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
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
        Toast.makeText(MainActivity.this, getResources().getConfiguration().locale.toString(), Toast.LENGTH_SHORT).show();
    }


}
