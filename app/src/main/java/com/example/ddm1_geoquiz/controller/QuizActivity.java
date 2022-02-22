package com.example.ddm1_geoquiz.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddm1_geoquiz.R;
import com.example.ddm1_geoquiz.model.Question;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    private Question[] questions = new Question[] {
            new Question(R.string.question_spain, true),
            new Question(R.string.question_australia, true),
            new Question(R.string.question_catalonia, false),
            new Question(R.string.question_egypt, true),
            new Question(R.string.question_mexico, false),
            new Question(R.string.question_newZealand, true),
            new Question(R.string.question_china, true),
            new Question(R.string.question_morocco, false)
    };

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTextView = findViewById(R.id.textview1);
        final Question[] q = {setQuestions()};

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q[0].getResponse()) {
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                } else Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                q[0] = setQuestions();
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!q[0].getResponse()) {
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                } else Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                setQuestions();
            }
        }));
    }

    Question setQuestions() {
        int randomIndex = new Random().nextInt(questions.length);
        int textId = questions[randomIndex].getsTextId();

        mTextView.setText(textId);

        return questions[randomIndex];
    }
}