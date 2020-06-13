package at.home.gabor.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPrefs();
        setContentView(R.layout.activity_top);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.top_players, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textName = findViewById(R.id.textViewTopPlayerName);
                TextView text = findViewById(R.id.textViewTopPlayerDescpription);
                switch (position) {
                    case 0:
                        Toast.makeText(TopActivity.this, R.string.player_not_selected, Toast.LENGTH_SHORT).show();
                        text.setVisibility(View.INVISIBLE);
                        textName.setVisibility(View.INVISIBLE);
                        text.setCompoundDrawables(null, null, null, null);
                        break;
                    case 1:
                        text.setText(R.string.description_puskas);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_puskas);
                        textName.setVisibility(View.VISIBLE);
                        Drawable pic1 = getApplicationContext().getResources().getDrawable(R.drawable.playerimg1puskas);
                        pic1.setBounds(0, 0, pic1.getIntrinsicWidth(), pic1.getIntrinsicHeight());
                        text.setCompoundDrawables(null, pic1, null, null);
                        break;
                    case 2:
                        text.setText(R.string.description_pele);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_pele);
                        textName.setVisibility(View.VISIBLE);
                        Drawable pic2 = getApplicationContext().getResources().getDrawable(R.drawable.playerimg2pele);
                        pic2.setBounds(0, 0, pic2.getIntrinsicWidth(), pic2.getIntrinsicHeight());
                        text.setCompoundDrawables(null, pic2, null, null);
                        break;
                    case 3:
                        text.setText(R.string.description_maradona);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_maradona);
                        textName.setVisibility(View.VISIBLE);
                        Drawable pic3 = getApplicationContext().getResources().getDrawable(R.drawable.playerimg3maradona);
                        pic3.setBounds(0, 0, pic3.getIntrinsicWidth(), pic3.getIntrinsicHeight());
                        text.setCompoundDrawables(null, pic3, null, null);
                        break;
                    case 4:
                        text.setText(R.string.description_ronaldo);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_ronaldo);
                        textName.setVisibility(View.VISIBLE);
                        Drawable pic4 = getApplicationContext().getResources().getDrawable(R.drawable.playerimg4ronaldo);
                        pic4.setBounds(0, 0, pic4.getIntrinsicWidth(), pic4.getIntrinsicHeight());
                        text.setCompoundDrawables(null, pic4, null, null);
                        break;
                    case 5:
                        text.setText(R.string.description_messi);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_messi);
                        textName.setVisibility(View.VISIBLE);
                        Drawable pic5 = getApplicationContext().getResources().getDrawable(R.drawable.playerimg5messi);
                        pic5.setBounds(0, 0, pic5.getIntrinsicWidth(), pic5.getIntrinsicHeight());
                        text.setCompoundDrawables(null, pic5, null, null);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
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
