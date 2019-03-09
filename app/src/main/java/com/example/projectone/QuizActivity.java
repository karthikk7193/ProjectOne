package com.example.projectone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private Button buttonSubmit = null;

    private ArrayList<QuizQuestion> quizQuestionList = null;
    QuizQuestion currentQuestion = null;
    int currentQuestionNumber = 1;

    private int currentScore = 0;
    private int maxQuestions = 3;

    TextView textViewQuestionTitle = null;
    TextView textViewQuestion = null;
    TextView textViewScore = null;

    RadioGroup radioGroupQuestion = null;
    RadioButton radioButtonA = null;
    RadioButton radioButtonB = null;
    RadioButton radioButtonC = null;
    RadioButton radioButtonD = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize widgets.
        this.textViewQuestionTitle = (TextView)findViewById(R.id.textViewQuestionTitle);    // The question title
        this.textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);              // The question asked.
        this.textViewScore = (TextView)findViewById(R.id.textViewScoreTitle);                    // The current score.

        // Intialize the radio buttons for question multiple choice answers.
        radioGroupQuestion = (RadioGroup)findViewById(R.id.radioGroupQuestion);             // Create a group for radio buttons.
        radioButtonA = (RadioButton)findViewById(R.id.radioButtonA);
        radioButtonB = (RadioButton)findViewById(R.id.radioButtonB);
        radioButtonC = (RadioButton)findViewById(R.id.radioButtonC);
        radioButtonD = (RadioButton)findViewById(R.id.radioButtonD);

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);

        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateAnswer()) {
                    if(currentQuestionNumber +1 < maxQuestions) {

                        currentQuestion = quizQuestionList.get(++currentQuestionNumber);
                        setQuestionView(currentQuestion);

                    }
                    else {
                        // No questions left to ask. Transition the user to the results page.

                        Intent intent = new Intent (QuizActivity.this,
                               com.example.projectone.ResultsActivity.class);
                        intent.putExtra("curScore", currentScore);
                        intent.putExtra("maxScore", maxQuestions);

                        startActivity(intent);



                    };
                }
            }
        });


        // Initiate all questions first.
        this.initQuestions();

        // Ask use the first question when this activity loads.
        this.setQuestionView(this.currentQuestion);

    }


    private void initQuestions() {
        // Create some questions to ask the questions.

        this.quizQuestionList = new ArrayList<QuizQuestion>();  // Initialize our question array.

        QuizQuestion newQuestion1 = new QuizQuestion();
        QuizQuestion newQuestion2 = new QuizQuestion();
        QuizQuestion newQuestion3 = new QuizQuestion();

        newQuestion1.setQuestion("What is the smallest state in the United States of America?");
        newQuestion1.setChoiceA("Texas");
        newQuestion1.setChoiceB("Rhode Island");
        newQuestion1.setChoiceC("Alaska");
        newQuestion1.setChoiceD("Massachusetts");
        newQuestion1.setCorrectAnswer("Rhode Island");

        this.quizQuestionList.add(0, newQuestion1);

        newQuestion2.setQuestion("What is the largest state in the United States of America");
        newQuestion2.setChoiceA("Texas");
        newQuestion2.setChoiceB("Rhode Island");
        newQuestion2.setChoiceC("Alaska");
        newQuestion2.setChoiceD("Massachusetts");
        newQuestion2.setCorrectAnswer("Alaska");

        this.quizQuestionList.add(1, newQuestion2);

        newQuestion3.setQuestion("Which of the following is not a president of the United States of America");
        newQuestion3.setChoiceA("Alexander  Hamilton");
        newQuestion3.setChoiceB("George Washington");
        newQuestion3.setChoiceC("Donald Trump");
        newQuestion3.setChoiceD("Thomas Jefferson");
        newQuestion3.setCorrectAnswer("Alexander  Hamilton");

        this.quizQuestionList.add(2, newQuestion3);

        this.currentQuestion = this.quizQuestionList.get(0);

        // Set the current, score, and total question size.
        this.currentQuestionNumber = 0;
        this.maxQuestions = this.quizQuestionList.size();
        this.currentScore = 0;
    }

    private void setQuestionView(QuizQuestion quizQuestion) {
        if(quizQuestion == null) {
            Log.d("[DEBUG]", "quizQuestion is null in setQuestionView.");
            return;
        }

        // Clear the radio button checks just encase it was been set previously.
        radioGroupQuestion.clearCheck();

        this.textViewQuestionTitle.setText("Question #" + (currentQuestionNumber + 1));
        this.textViewQuestion.setText(quizQuestion.getQuestion());
        this.radioButtonA.setText(quizQuestion.getChoiceA());
        this.radioButtonB.setText(quizQuestion.getChoiceB());
        this.radioButtonC.setText(quizQuestion.getChoiceC());
        this.radioButtonD.setText(quizQuestion.getChoiceD());
        this.textViewScore.setText("Score: " + currentScore);

    }

    private boolean validateAnswer() {
        // Validate the current answer selected.
        int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();
        if(selectedButtonId != -1) {
            String answerSelectedStr = ((RadioButton)findViewById(selectedButtonId)).getText().toString();

            if (currentQuestion.isCorrectAnswer(answerSelectedStr)) {
                // Answer is correct.
                Log.d("ANSWER: ", "Correct");
                currentScore++;
            }
            else {
                Log.d("ANSWER: ", "Incorrect");
            }
            return true; // Allow to continue to next question.
        }
        else {
            // No answer selected.
            Toast.makeText(getApplicationContext(), "Please Select An Answer",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}