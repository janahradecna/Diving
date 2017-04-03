package com.example.android.diving;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //    defining global variables
    int totalPoints = 0;
    int maxPoints = 5;

    //    /  This method evaluate answers of question 1 - 5
    private void evaluateAnswers() {
         //       Check answer of question 1
        CheckBox answerOfCheckBoxoOfQuestion1 = (CheckBox) findViewById(R.id.checkBoxQuestion1);
        boolean checkBoxIsChecked1 = !answerOfCheckBoxoOfQuestion1.isChecked();
        //        Check answer of question 2
        CheckBox answerOfCheckBoxoOfQuestion2 = (CheckBox) findViewById(R.id.checkBoxQuestion2);
        boolean checkBoxIsChecked2 = answerOfCheckBoxoOfQuestion2.isChecked();
        //        Check answer of question 3
        RadioButton answerOfCheckBoxoOfQuestion3A = (RadioButton) findViewById(R.id.answer3a);
        boolean radioButtonIsChecked3A = answerOfCheckBoxoOfQuestion3A.isChecked();
        //        Check answer of question 4
        RadioButton answerOfCheckBoxoOfQuestion4A = (RadioButton) findViewById(R.id.answer4a);
        boolean radioButtonIsChecked4A = answerOfCheckBoxoOfQuestion4A.isChecked();
        //        Check answer of question 5
        EditText answer = (EditText)findViewById(R.id.answer5);
        String question5Answer = answer.getText(). toString();
        Boolean answer5IsCorrect = question5Answer.contains("upward");
        //        call add points method
        addPoints(checkBoxIsChecked1,  checkBoxIsChecked2, radioButtonIsChecked3A, radioButtonIsChecked4A, answer5IsCorrect);
    }

    //        this method add points if the answer is correct
    private int addPoints (boolean checkBoxIsChecked1,boolean checkBoxIsChecked2, boolean radioButtonIsChecked3A,boolean radioButtonIsChecked4A, Boolean answer5IsCorrect) {
        if (checkBoxIsChecked1) {
            totalPoints = totalPoints + 1;
        }
        if (checkBoxIsChecked2) {
            totalPoints = totalPoints + 1;
        }
        if (radioButtonIsChecked3A){
            totalPoints = totalPoints + 1;
        }
        if (radioButtonIsChecked4A){
            totalPoints = totalPoints + 1;
        }
        if (answer5IsCorrect){
            totalPoints = totalPoints + 1;
        }
        return totalPoints;
    }

    //    / Display toast message
    private String toastMessage(int totalPoints, int maxPoints) {
        if (totalPoints == maxPoints) {
            String message = "Total points: " + totalPoints + " from " + maxPoints + " Congrats!";
            return message;
        }
        String message = "Total points: " + totalPoints + " from " + maxPoints + "\nTry it again! :-)";
        return message;
    }

    //    Delete answers

    private void deleteAnswers () {
        //       Delete answer of question 1
        CheckBox answerOfCheckBoxoOfQuestion1 = (CheckBox) findViewById(R.id.checkBoxQuestion1);
        if (answerOfCheckBoxoOfQuestion1.isChecked()) {
            answerOfCheckBoxoOfQuestion1.setChecked(false);}
        //       Delete answer of question 2
        CheckBox answerOfCheckBoxoOfQuestion2 = (CheckBox) findViewById(R.id.checkBoxQuestion2);
        if (answerOfCheckBoxoOfQuestion2.isChecked()) {
            answerOfCheckBoxoOfQuestion2.setChecked(false);}
        //       Delete answer of question 3A or 3B
        RadioGroup answerOfCheckBoxoOfQuestion3AB = (RadioGroup)findViewById(R.id.rgroup1);
        answerOfCheckBoxoOfQuestion3AB.clearCheck();
        //       Delete answer of question 4A or 4B
        RadioGroup answerOfCheckBoxoOfQuestion4AB = (RadioGroup)findViewById(R.id.rgroup2);
        answerOfCheckBoxoOfQuestion4AB.clearCheck();
        //       Delete answer of question 5
        EditText answer = (EditText) findViewById(R.id.answer5);
        answer.setText("");
    }


//    /    This method is called when the CHECK THE ANSWERS button is clicked.
            public void vyhodnotit (View view){
                evaluateAnswers();
                Toast.makeText(this, toastMessage(totalPoints, maxPoints), Toast.LENGTH_SHORT).show();
                totalPoints = 0;
            }

//    /     This method is called when the RESET ANSWRES button is clicked.
            public void smazat (View view){
                deleteAnswers();
            }
            }





