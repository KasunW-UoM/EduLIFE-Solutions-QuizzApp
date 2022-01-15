package com.hit.kzonefoodapp;

import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList>javaQuestions(){

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Which of the following option leads to the portability and security of Java?","Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects","");
        final QuestionsList  question2 = new QuestionsList("Which of the following is not a Java features?","Dynamic ","Architecture Neutral","Use of pointers","Object-oriented","");
        final QuestionsList  question3 = new QuestionsList("The \\u0021 article referred to as a","Unicode escape sequence","Octal escape","Hexadecimal","Line feed","");
        final QuestionsList  question4 = new QuestionsList("_____ is used to find and fix bugs in the Java programs.","JVM","JRE","JDK","JDB","");
        final QuestionsList  question5 = new QuestionsList("Which of the following is a valid declaration of a char?","char ch = '\\utea';","char ca = 'tea';","char cr = \\u0223;","char cc = '\\itea';","");
        final QuestionsList  question6 = new QuestionsList("What is the return type of the hashCode() method in the Object class?","Object","int","long","void","");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);

        return questionsList;
    }

    private static List<QuestionsList>reactQuestions(){

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question2 = new QuestionsList("What is mean of java Concept","Encapsulation ","Polymopism","Inhetitance","Abstractions","");
        final QuestionsList  question3 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question4 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question5 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question6 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);

        return questionsList;
    }

    private static List<QuestionsList>androidQuestions(){

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question2 = new QuestionsList("What is mean of java Concept","Encapsulation ","Polymopism","Inhetitance","Abstractions","");
        final QuestionsList  question3 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question4 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question5 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question6 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);

        return questionsList;
    }


    private static List<QuestionsList>cQuestions(){

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question2 = new QuestionsList("What is mean of java Concept","Encapsulation ","Polymopism","Inhetitance","Abstractions","");
        final QuestionsList  question3 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question4 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question5 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");
        final QuestionsList  question6 = new QuestionsList("What is mean of OOP Concept","16 bit","20 bit","28 bit","32 bit","");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);

        return questionsList;
    }


    public static List<QuestionsList>getQuestions(String selectedTopicName){


        switch (selectedTopicName){
            case "java":
                return javaQuestions();


            case "react":
                return reactQuestions();
            case "android":
                return androidQuestions();

            default:
                return cQuestions();
        }
    }
}
