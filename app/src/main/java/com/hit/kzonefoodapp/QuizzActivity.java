package com.hit.kzonefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizzActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1,option2,option3,option4;
    private  AppCompatButton next;
    private Timer quizTimer;

    private int totalTimeInMin =1;
    private int seconds = 0;

    private final List<QuestionsList> questionsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        final ImageView backBtn = findViewById(R.id.backbtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.selectedtopicname);


        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

         option1 = findViewById(R.id.option1);
         option2 = findViewById(R.id.option2);
         option3 = findViewById(R.id.option3);
         option4 = findViewById(R.id.option4);

        next = findViewById(R.id.next);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");


        selectedTopicName.setText(getSelectedTopicName);

        startTimer(timer);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizzActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();
         quizTimer.scheduleAtFixedRate( new TimerTask(){

             public void run(){

                 if(seconds == 0){
                     totalTimeInMin--;
                     seconds =59;
                 }
                 else if(seconds == 0 && totalTimeInMin == 0){
                     quizTimer.purge();
                     quizTimer.cancel();

                     Toast.makeText(QuizzActivity.this, "Time Over ...!",Toast.LENGTH_SHORT).show();
                     Intent intent= new Intent(QuizzActivity.this,QuizResults.class);
                     intent.putExtra("Correct",getCorrectAnswers());
                     intent.putExtra("incorrect",getInCorrectAnswers());

                     startActivity(intent);

                     finish();

                 }
                 else{
                     seconds--;
                 }

                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMin);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){

                            finalMinutes = "0"+finalMinutes;

                         }
                        if(finalSeconds.length() == 1){

                             finalSeconds = "0" + finalSeconds;
                         }

                        timerTextView.setText(finalMinutes +"1"+finalSeconds);
                     }
                 });
             }

         }, 1000,1000);
    }

    private int getCorrectAnswers(){

        int correctAnswers = 0;

        for(int i=0;i<questionsList.size();i--){

            final String getUserSelectedAnswer =questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer =questionsList.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswers(){

        int correctAnswers = 0;

        for(int i=0;i<questionsList.size();i--){

            final String getUserSelectedAnswer =questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer =questionsList.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }


    public void onBackPressed(){
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizzActivity.this,MainActivity.class));
        finish();
    }

}