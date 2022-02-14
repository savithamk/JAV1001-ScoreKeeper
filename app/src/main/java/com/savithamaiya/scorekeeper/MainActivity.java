package com.savithamaiya.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView team1Score;
    TextView team2Score;

    Button reset;

    Button team1Increase;
    Button team2Increase;
    Button team1Decrease;
    Button team2Decrease;

    Spinner team1Spinner;
    Spinner team2Spinner;

    String[] arraySpinner = new String[] {
            "1", "2", "3", "4", "6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1Score = (TextView) findViewById(R.id.team1score);
        team2Score = (TextView) findViewById(R.id.team2score);

        team1Spinner = (Spinner) findViewById(R.id.team1spinner);
        team2Spinner = (Spinner) findViewById(R.id.team2spinner);

        ArrayAdapter<String> scoreSpinner = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        scoreSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        team1Spinner.setAdapter(scoreSpinner);
        team2Spinner.setAdapter(scoreSpinner);

        team1Increase = (Button) findViewById(R.id.team1increase);
        team2Increase = (Button) findViewById(R.id.team2increase);
        team1Decrease = (Button) findViewById(R.id.team1decrease);
        team2Decrease = (Button) findViewById(R.id.team2decrease);

        reset = (Button) findViewById(R.id.reset);

        team1Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team1Score.getText().toString());
                int spinnerValue = Integer.parseInt(team1Spinner.getSelectedItem().toString());
                team1Score.setText(Integer.toString(currentScore+spinnerValue));
            }
        });
        team2Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team2Score.getText().toString());
                int spinnerValue = Integer.parseInt(team2Spinner.getSelectedItem().toString());
                team2Score.setText(Integer.toString(currentScore+spinnerValue));
            }
        });
        team1Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team1Score.getText().toString());
                int spinnerValue = Integer.parseInt(team1Spinner.getSelectedItem().toString());
                team1Score.setText(Integer.toString(currentScore - spinnerValue  > 0 ? currentScore-spinnerValue : 0));
            }
        });
        team2Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team2Score.getText().toString());
                int spinnerValue = Integer.parseInt(team2Spinner.getSelectedItem().toString());
                team2Score.setText(Integer.toString(currentScore - spinnerValue  > 0 ? currentScore-spinnerValue : 0));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1Score.setText("0");
                team2Score.setText("0");
            }
        });

    }
}