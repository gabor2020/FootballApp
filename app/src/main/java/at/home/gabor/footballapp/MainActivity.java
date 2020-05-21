package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}
