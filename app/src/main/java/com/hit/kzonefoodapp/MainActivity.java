package com.hit.kzonefoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private String selectedTopicName ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout java = findViewById(R.id.javalayout);
        final LinearLayout react = findViewById(R.id.reactlayout);
        final LinearLayout android = findViewById(R.id.androidlayout);
        final LinearLayout c = findViewById(R.id.clayout);

        final Button startQuiz = findViewById(R.id.startquiz);

        java.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                selectedTopicName= "java";
                java.setBackgroundResource(R.drawable.around_back_white_stroke10);
                react.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

                c.setBackgroundResource(R.drawable.round_back_white10);


            }

        });


        react.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                selectedTopicName= "react";
                react.setBackgroundResource(R.drawable.around_back_white_stroke10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

                c.setBackgroundResource(R.drawable.round_back_white10);


            }

        });


        android.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                selectedTopicName= "android";
                android.setBackgroundResource(R.drawable.around_back_white_stroke10);
                react.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);

                c.setBackgroundResource(R.drawable.round_back_white10);


            }

        });

        c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                selectedTopicName= "c";
                c.setBackgroundResource(R.drawable.around_back_white_stroke10);
                react.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

                java.setBackgroundResource(R.drawable.round_back_white10);


            }

        });

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTopicName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Select the Topic",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent= new Intent(MainActivity.this,QuizzActivity.class);
                    intent.putExtra("selectedTopic",selectedTopicName);
                    startActivity(intent);

                }
            }
        });
    }
}