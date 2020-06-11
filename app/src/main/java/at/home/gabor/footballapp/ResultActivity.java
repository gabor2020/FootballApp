package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textView24);
        TextView textViewMessage = findViewById(R.id.textView25);
        ImageView imageView = findViewById(R.id.imageViewResult);
        GifImageView gifImageView = findViewById(R.id.gifImage);
        int result = getIntent().getIntExtra("Result",0);
        int questionTotal = 5;
        textViewResult.setText(result + getString(R.string.divider) + questionTotal);
        if (result == 0 || result == 1 || result == 2){
            imageView.setImageResource(R.drawable.checkboxred);
            textViewMessage.setText(R.string.text_result_bad);
        } else if (result == 3){
            imageView.setImageResource(R.drawable.checkboxyellow);
            textViewMessage.setText(R.string.text_result_ok);
        } else if (result == 4){
            imageView.setImageResource(R.drawable.checkboxyellow);
            textViewMessage.setText(R.string.text_result_good);
        } else {
            imageView.setImageResource(R.drawable.checkboxgreen);
            textViewMessage.setText(R.string.text_result_perfect);
            gifImageView.setVisibility(View.VISIBLE);
        }
    }

    public void startQuizActivity(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
