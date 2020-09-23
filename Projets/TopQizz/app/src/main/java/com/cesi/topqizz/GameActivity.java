package com.cesi.topqizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private TextView mTextQuestion;
    private Button mPlayButton_answer1;
    private Button mPlayButton_answer2;
    private Button mPlayButton_answer3;
    private Button mPlayButton_answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTextQuestion = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayButton_answer1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayButton_answer2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayButton_answer3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayButton_answer4 = (Button) findViewById(R.id.activity_game_answer4_btn);
    }
}