package at.home.gabor.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.test_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMain:
                Intent intent0 = new Intent(this, MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.itemEra:
                Intent intent = new Intent(this, EraActivity.class);
                startActivity(intent);
                break;
            case R.id.itemTop5:
                Intent intent2 = new Intent(this, TopActivity.class);
                startActivity(intent2);
                break;
            case R.id.itemMedia:
                Intent intent3 = new Intent(this, MediaActivity.class);
                startActivity(intent3);
                break;
            case R.id.itemQuiz:
                Intent intent4 = new Intent(this, QuizActivity.class);
                startActivity(intent4);
                break;
            case R.id.itemTest:
                Intent intent5 = new Intent(this, TestActivity.class);
                startActivity(intent5);
                break;
        };
        return true;
    }

}
