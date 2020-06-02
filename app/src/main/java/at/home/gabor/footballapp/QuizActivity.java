package at.home.gabor.footballapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

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

        }
        return true;
    }


    public void startQuizActivity(View view) {
        Intent intent = new Intent(this, QuizStartedActivity.class);
        startActivity(intent);
    }
}


