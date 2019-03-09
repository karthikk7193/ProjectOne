package com.example.projectone;

import java.lang.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    int curScore = 0;
    int maxScore = 0;

    TextView textViewScore = null;
    TextView textViewResultDescription = null;

    Button buttonPlayAgain = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle bundle = getIntent().getExtras();

        //intent.getIntExtra("curScore", curScore);
        //getIntent().getIntExtra("maxScore", );
        curScore = bundle.getInt("curScore");
        maxScore = bundle.getInt("maxScore");

        this.textViewScore= findViewById(R.id.textViewScore);
        this.textViewScore.setText(curScore + "/" + maxScore);

        this.textViewResultDescription = findViewById(R.id.textViewResultDescription);
        this.textViewResultDescription.setText("You answered " + getPercentage(curScore, maxScore) + " of the quiz questions correctly");




        ///////////////////////////////////////////////////////////////////////////////////////////////////////
//You answered 0% of the quiz questions correctly.        // Hint: You can use the getPercentage() method provided to get the percentage correct value.
        ///////////////////////////////////////////////////////////////////////////////////////////////////////


        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        this.buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////////////////////////////////////////////////////////////////////////////////////////
                Intent intent = new Intent(ResultsActivity.this,
                        com.example.projectone.MainActivity.class);

                startActivity(intent);                ////////////////////////////////////////////////////////////////////////////////////////
            }
        });
    }

    private String getPercentage(int current, int total) {
        float fPercent = (float)current/(float)total;
        return Integer.toString((int)Math.ceil((fPercent) * 100)) + "%";
    }
}