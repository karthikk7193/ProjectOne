package com.example.projectone;

public class QuizQuestion {
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;

    // Constructor
    QuizQuestion() {
    }

    protected void setQuestion(String question) {
        this.question = question;
    }

    protected void setChoiceA(String answer) {
        choiceA = answer;
    }

    protected void setChoiceB(String answer) {
        choiceB = answer;
    }

    protected void setChoiceC(String answer) {
        choiceC = answer;
    }

    protected void setChoiceD(String answer) {
        choiceD = answer;
    }

    protected void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    protected String getQuestion() {
        return question;
    }


    protected String getChoiceA() {
        return choiceA;
    }

    protected String getChoiceB() {
        return choiceB;
    }

    protected String getChoiceC() {
        return choiceC;
    }

    protected String getChoiceD() {
        return choiceD;
    }

    protected boolean isCorrectAnswer(String answer) {
        if (this.correctAnswer == null) {
            // No correct answer has been set.
            return false;
        }

        if (correctAnswer.equals(answer)) {
            return true;
        }
//==
        return false;
    }
}