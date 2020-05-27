package at.home.gabor.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                ImageView image = findViewById(R.id.imageViewTopPlayerImage);
                switch (position) {
                    case 0:
                        Toast.makeText(TopActivity.this, R.string.player_not_selected, Toast.LENGTH_SHORT).show();
                        image.setVisibility(View.INVISIBLE);
                        text.setVisibility(View.INVISIBLE);
                        textName.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.playerimg1puskas);
                        image.setVisibility(View.VISIBLE);
                        text.setText(R.string.description_puskas);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_puskas);
                        textName.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.playerimg2pele);
                        image.setVisibility(View.VISIBLE);
                        text.setText(R.string.description_pele);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_pele);
                        textName.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.playerimg3maradona);
                        image.setVisibility(View.VISIBLE);
                        text.setText(R.string.description_maradona);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_maradona);
                        textName.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.playerimg4ronaldo);
                        image.setVisibility(View.VISIBLE);
                        text.setText(R.string.description_ronaldo);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_ronaldo);
                        textName.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.playerimg5messi);
                        image.setVisibility(View.VISIBLE);
                        text.setText(R.string.description_messi);
                        text.setVisibility(View.VISIBLE);
                        textName.setText(R.string.player_messi);
                        textName.setVisibility(View.VISIBLE);
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
