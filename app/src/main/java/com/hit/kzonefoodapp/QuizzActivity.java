package com.hit.kzonefoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        final String getSelectedTopicName = getIntent().getStringExtra("SelectedTopic");
    }
}