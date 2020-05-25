package at.home.gabor.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        inflater.inflate(R.menu.test_menu, menu);
        return true;
    }


}
