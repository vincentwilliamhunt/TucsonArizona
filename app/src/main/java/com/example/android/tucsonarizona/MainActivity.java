package com.example.android.tucsonarizona;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * This app calculates score for the quiz using methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method determines if question one is correct and returns one point
     * if the correct RadioButton is checked
     */
    public int QuestionOne() {
        RadioButton threeFifty = (RadioButton) findViewById(R.id.three_fifty);
        boolean isChecked = threeFifty.isChecked();
        if (isChecked) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * This method checks to see if the user has input "saguaro"
     * This method uses .toLowerCase() and .Trim() to ignore trailing spaces and cap letters
     * returns one point if the user enters the correct cactus
     */
    public int QuestionTwo() {
        EditText cactus = (EditText) findViewById(R.id.cactus);
        String inputCactus = cactus.getText().toString();
        inputCactus = inputCactus.toLowerCase(); //convert input to lower case
        inputCactus = inputCactus.trim(); //trim whitespace before and after the string
        Log.d("MainActivity", "QuestionTwo: " + inputCactus);

        if (inputCactus.equals("saguaro")) {
            return 1;
        }

        else {
            return 0;
        }
    }

    /**
     * This method checks to see that the correct CheckBoxes are selected and returns one point
     * if so.
     */
    public int QuestionThree() {
        CheckBox gilaMonster = (CheckBox) findViewById(R.id.gila_monster);
        boolean gilaMonsterIsChecked = gilaMonster.isChecked();
        CheckBox coyote = (CheckBox) findViewById(R.id.coyote);
        boolean coyoteIsChecked = coyote.isChecked();
        CheckBox javelina = (CheckBox) findViewById(R.id.javelina);
        boolean javelinaIsChecked = javelina.isChecked();

        if (gilaMonsterIsChecked && coyoteIsChecked && javelinaIsChecked) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * This method checks to see if the correct radioButton is checked and returns 1 point if true
     */
    public int QuestionFour() {
        RadioButton cleanAir = (RadioButton) findViewById(R.id.clean_air);
        boolean cleanAirIsChecked = cleanAir.isChecked();

        if (cleanAirIsChecked) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * This method sums four integers and returns the result
     */
    public int CalculateScore(int point1, int point2, int point3, int point4) {
        return point1 + point2 + point3 + point4;
    }

    /**
     * This method submits the quiz when the submit button is checked.
     * This method calls the defined modules above which allows it to display the score to the user
     * in both a text view on the screen and a SHORT toast view.
     */
    public void SubmitQuiz(View view) {

        int questionOnePoint = QuestionOne();
        Log.d("MainActivity", "Days : " + questionOnePoint);
        int questionTwoPoint = QuestionTwo();
        Log.d("MainActivity", "Saguaro : " + questionTwoPoint);
        int questionThreePoint = QuestionThree();
        int questionFourPoint = QuestionFour();
        int totalScore = CalculateScore(questionOnePoint, questionTwoPoint, questionThreePoint,
                questionFourPoint);

        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText("" + totalScore + "/4");

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = getString(R.string.toast_one) + " " + totalScore + " " +getString(R.string.toast_two);
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
