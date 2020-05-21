package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_era);
    }

    public void startEra1(View view) {
        Intent intent = new Intent(this, OneActivity.class);
        startActivity(intent);
    }

    public void startEra2(View view) {
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }

    public void startEra3(View view) {
        Intent intent = new Intent(this, ThreeActivity.class);
        startActivity(intent);
    }

    public void startEra4(View view) {
        Intent intent = new Intent(this, FourActivity.class);
        startActivity(intent);
    }

    public void startEra5(View view) {
        Intent intent = new Intent(this, FiveActivity.class);
        startActivity(intent);
    }

    public void startEra6(View view) {
        Intent intent = new Intent(this, SixActivity.class);
        startActivity(intent);
    }
}
