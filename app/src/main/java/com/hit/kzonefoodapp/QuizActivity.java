package com.hit.kzonefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1,option2,option3,option4;
    private  AppCompatButton next;
    private Timer quizTimer;

    private int totalTimeInMin =1;
    private int seconds = 0;

    private List<QuestionsList> questionsList;


    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";
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


//       selectedTopicName.setText(getSelectedTopicName);

        questionsList = QuestionsBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        questions.setText((currentQuestionPosition+1)+"/"+questionsList.size());

        question.setText(questionsList.get(0).getQuestion());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.around_back_read10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.around_back_read10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.around_back_read10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.around_back_read10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){

                    Toast.makeText(QuizActivity.this,"Please select the option ...!",Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionsList.size()){
            next.setText("Submit Quiz");
        }

        if(currentQuestionPosition < questionsList.size()){

            selectedOptionByUser ="";
            option1.setBackgroundResource(R.drawable.around_back_white_stroke10);
            option1.setTextColor(Color.parseColor("#1F6108"));

            option2.setBackgroundResource(R.drawable.around_back_white_stroke10);
            option2.setTextColor(Color.parseColor("#1F6108"));

            option3.setBackgroundResource(R.drawable.around_back_white_stroke10);
            option3.setTextColor(Color.parseColor("#1F6108"));

            option4.setBackgroundResource(R.drawable.around_back_white_stroke10);
            option4.setTextColor(Color.parseColor("#1F6108"));


            questions.setText((currentQuestionPosition+1) + "/" +questionsList.size());

            question.setText(questionsList.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsList.get(currentQuestionPosition).getOption1());
            option2.setText(questionsList.get(currentQuestionPosition).getOption2());
            option3.setText(questionsList.get(currentQuestionPosition).getOption3());
            option4.setText(questionsList.get(currentQuestionPosition).getOption4());
        }

        else{
            Intent intent = new Intent(QuizActivity.this,QuizResults.class);

            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("Incorrect", getInCorrectAnswers());

            startActivity(intent);

            finish();
        }

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

                     Toast.makeText(QuizActivity.this, "Time Over ...!",Toast.LENGTH_SHORT).show();
                     Intent intent= new Intent(QuizActivity.this,QuizResults.class);
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

        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        final String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.around_back_grawan10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.around_back_grawan10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.around_back_grawan10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.around_back_grawan10);
            option4.setTextColor(Color.WHITE);
        }
    }

}