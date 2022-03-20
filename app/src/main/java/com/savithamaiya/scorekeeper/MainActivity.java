package com.savithamaiya.scorekeeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int MAX_SCORE = 100;
    public static final int MIN_SCORE = 0;

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
        scoreSpinner.setDropDownViewResource(android.R.layout.simple_selectable_list_item);

        team1Spinner.setAdapter(scoreSpinner);
        team2Spinner.setAdapter(scoreSpinner);

        team1Increase = (Button) findViewById(R.id.team1increase);
        team2Increase = (Button) findViewById(R.id.team2increase);
        team1Decrease = (Button) findViewById(R.id.team1decrease);
        team2Decrease = (Button) findViewById(R.id.team2decrease);

        reset = (Button) findViewById(R.id.reset);

        //Listener for the button to increase score of team1
        team1Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team1Score.getText().toString());
                int spinnerValue = Integer.parseInt(team1Spinner.getSelectedItem().toString());
                if(currentScore + spinnerValue <= 100) {
                    team1Score.setText(Integer.toString(currentScore + spinnerValue));
                } else {
                    alert("Score cannot exceed max limit of 100!");
                }
            }
        });
        //Listener for the button to increase score of team2
        team2Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team2Score.getText().toString());
                int spinnerValue = Integer.parseInt(team2Spinner.getSelectedItem().toString());
                if(currentScore + spinnerValue <= 100) {
                    team2Score.setText(Integer.toString(currentScore + spinnerValue));
                } else {
                    alert("Score cannot exceed max limit of 100!");
                }
            }
        });
        //Listener for the Button to decrease score of team1
        team1Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team1Score.getText().toString());
                int spinnerValue = Integer.parseInt(team1Spinner.getSelectedItem().toString());
                if(currentScore - spinnerValue >= 0) {
                    team1Score.setText(Integer.toString(currentScore - spinnerValue));
                } else {
                    alert("Score cannot be less than 0!");
                }
            }
        });
        //Listener for the button to decrease score of team2
        team2Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentScore = Integer.parseInt(team2Score.getText().toString());
                int spinnerValue = Integer.parseInt(team2Spinner.getSelectedItem().toString());
                if(currentScore - spinnerValue >= 0) {
                    team2Score.setText(Integer.toString(currentScore - spinnerValue));
                } else {
                    alert("Score cannot be less than 0!");
                }
            }
        });
        //Reset team1 and team2 scores
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1Score.setText("0");
                team2Score.setText("0");
            }
        });
    }
    //To dispaly warning
    private void alert(String message){
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Warning")
                .setIcon(android.R.drawable.stat_sys_warning)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
            dialog.show();
            ImageView imageView = dialog.findViewById(android.R.id.icon);
            if (imageView != null)
                imageView.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
