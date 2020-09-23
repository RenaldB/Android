package com.cesi.topqizz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cesi.topqizz.R;
import com.cesi.topqizz.model.Question;
import com.cesi.topqizz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE" ;
    private static final String BUNDLE_STATE_SCORE = "BUNDLE_STATE_SCORE";
    private static final String BUNDLE_STATE_QUESTION = "BUNDLE_STATE_QUESTION";
    private TextView mTextQuestion;
    private Button mPlayButton_answer1;
    private Button mPlayButton_answer2;
    private Button mPlayButton_answer3;
    private Button mPlayButton_answer4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mNumberOfQuestions;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mNumberOfQuestions = 4;
        mTextQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayButton_answer1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayButton_answer2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayButton_answer3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayButton_answer4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        mQuestionBank = this.generateQuestions();
        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 4;
        }
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

        // Use the same listener for the four buttons.
// The tag value will be used to distinguish the button triggered
        mPlayButton_answer1.setOnClickListener(this);
        mPlayButton_answer2.setOnClickListener(this);
        mPlayButton_answer3.setOnClickListener(this);
        mPlayButton_answer4.setOnClickListener(this);

        // Connaitre sur quel bouton l'utilisateur appuie
        mPlayButton_answer1.setTag(0);
        mPlayButton_answer2.setTag(1);
        mPlayButton_answer3.setTag(2);
        mPlayButton_answer4.setTag(3);

    }

    private QuestionBank generateQuestions(){
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        Question question4 = new Question("Qui a codé l'application",
                Arrays.asList("Rénald",
                        "pierre",
                        "Paul",
                        "Jack"),
                1);

        Question question5 = new Question("Romain a pour nom de famille ",
                Arrays.asList("Gauthier",
                        "Gautier",
                        "Gothier",
                        "Gothique"),
                1);

        Question question6 = new Question("On fait un cours de ",
                Arrays.asList("PHP",
                        "CSS",
                        "Android",
                        "C"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6));
    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        mTextQuestion.setText(question.getQuestion());
        mPlayButton_answer1.setText(question.getChoiceList().get(0));
        mPlayButton_answer2.setText(question.getChoiceList().get(1));
        mPlayButton_answer3.setText(question.getChoiceList().get(2));
        mPlayButton_answer4.setText(question.getChoiceList().get(3));

    }


    @Override
    public void onClick(View v) {
        //La méthode getTag renvoie un objet, il faut donc l'initialiser en entier
        int responseIndex = (int) v.getTag();

        //Si la réponse de l'utilisateur est égale a la bonne réponse on affiche Correct !
        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
        }
        //sinon on affiche Wrong !
        else {
            // Wrong answer
            Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            // End the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Ton score : " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}