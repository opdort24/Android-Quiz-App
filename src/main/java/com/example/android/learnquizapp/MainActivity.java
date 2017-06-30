package com.example.android.learnquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void correct(){
        TextView correctTextView = (TextView) findViewById(R.id.correct_text_view);
        TextView wrongTextView = (TextView) findViewById(R.id.wrong_text_view);
        wrongTextView.setVisibility(View.INVISIBLE);
        correctTextView.setVisibility(View.VISIBLE);

        score += 5;
        displayScore(score);

    }

    private void displayScore(int score){
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(String.valueOf(score));
    }

    private void wrong(){
        TextView correctTextView = (TextView) findViewById(R.id.correct_text_view);
        TextView wrongTextView = (TextView) findViewById(R.id.wrong_text_view);
        correctTextView.setVisibility(View.GONE);
        wrongTextView.setVisibility(View.VISIBLE);
        score -= 2;
        if (score<0)
            score = 0;
        displayScore(score);

    }

    public void begin (View view){
        TextView welcome = (TextView) findViewById(R.id.welcome_text_view);
        EditText editText = (EditText) findViewById(R.id.name_edit_text);
        welcome.setText(editText.getText().toString());

        LinearLayout nameLayout = (LinearLayout) findViewById(R.id.name_linear_layout);
        nameLayout.setVisibility(View.GONE);

        LinearLayout scoreLayout = (LinearLayout) findViewById(R.id.score_linear_layout);
        scoreLayout.setVisibility(View.VISIBLE);

        ScrollView scrollView = (ScrollView) findViewById(R.id.questions_scroll_view);
        scrollView.setVisibility(View.VISIBLE);

    }

    public void submitQuestion1(View view){
        RadioButton nigeriaRadio = (RadioButton) findViewById(R.id.nigeria_radio_button);
        if (nigeriaRadio.isChecked()) {
            correct();
            //Button button = (Button) findViewById(R.id.q1_button);
            //button.setEnabled(false);
            view.setEnabled(false);
        }
                    else{
            wrong();
        }
    }


    public void submitQuestion2(View view){
        RadioButton chinaRadio = (RadioButton) findViewById(R.id.china_radio_button);
        if (chinaRadio.isChecked()) {
            correct();
            view.setEnabled(false);
        }
        else{
            wrong();
        }
    }

    public void submitQuestion3(View view){
        CheckBox maliCheckBox = (CheckBox) findViewById(R.id.mali_check_box);
        CheckBox togoCheckBox = (CheckBox) findViewById(R.id.togo_check_box);
        if (maliCheckBox.isChecked() && togoCheckBox.isChecked()) {
            correct();
            view.setEnabled(false);
        }
        else{
            wrong();
        }
    }


    public void submitQuestion4(View view){
        EditText q4EditText = (EditText) findViewById(R.id.q4_edit_text);
        String answer = q4EditText.getText().toString();

        if (answer.equalsIgnoreCase("Russia")) {
            correct();
            view.setEnabled(false);
        }
        else{
            wrong();
        }
    }


    public void reset(View view){
        score = 0;
        displayScore(score);

        Button q1Button = (Button) findViewById(R.id.q1_button);
        q1Button.setEnabled(true);

        Button q2Button = (Button) findViewById(R.id.q2_button);
        q1Button.setEnabled(true);

        Button q3Button = (Button) findViewById(R.id.q3_button);
        q1Button.setEnabled(true);

        Button q4Button = (Button) findViewById(R.id.q4_button);
        q1Button.setEnabled(true);

    }


}
