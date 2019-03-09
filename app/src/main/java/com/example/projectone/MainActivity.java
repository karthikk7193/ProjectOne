package com.example.projectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStart = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonStart = findViewById(R.id.buttonStart);
        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    // Start the game.
                    startGame();
                }
                Intent intent = new Intent(MainActivity.this,
                        com.example.projectone.QuizActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startGame() {
        /*
                    // TO-DO: Start the game (start the question activity).
                         _____
                         1
                         1
                         1
                         1____1


        */
    }
}