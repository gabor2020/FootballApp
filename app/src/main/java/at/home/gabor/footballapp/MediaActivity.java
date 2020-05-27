package at.home.gabor.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
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
