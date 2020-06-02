package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_started);
    }

    public void startResultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
