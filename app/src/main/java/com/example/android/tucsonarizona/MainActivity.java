package com.example.android.tucsonarizona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

    public int QuestionTwo() {
        EditText cactus = (EditText) findViewById(R.id.cactus);
        String inputCactus = cactus.getText().toString();
        inputCactus = inputCactus.toLowerCase();
        inputCactus = inputCactus.trim();
        Log.d("MainActivity", "QuestionTwo: " + inputCactus);

        if (inputCactus.equals("saguaro")) {
            return 1;
        }

        else {
            return 0;
        }
    }

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

    public int CalculateScore(int point1, int point2, int point3, int point4) {
        return point1 + point2 + point3 + point4;
    }

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

    }

}
