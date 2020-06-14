package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPrefs();
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

    String localeCode;

    public void loadPrefs (){
        SharedPreferences prefs = getSharedPreferences(MainActivity.SHARED_PREFS, MODE_PRIVATE);
        localeCode = prefs.getString(MainActivity.KEY_LANGUAGE, "de");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }

}
