package at.home.gabor.footballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


}
