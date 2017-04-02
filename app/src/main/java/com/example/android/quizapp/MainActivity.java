package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.hubble;
import static com.example.android.quizapp.R.id.venus;

public class MainActivity extends AppCompatActivity {

    /**
     * I made String quizSummary a public variable that it would be used in all methods without separate initialization.
     */
    String quizSummary = "Answers: ";


    /**
     * RESULT
     */
    int result = 0;
    int both1 = 0;
    int both2 = 0;
    int both3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the button "Done" is clicked and displays the result.
     */
    public void reset(View view) {
        finish();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }

    /**
     * This method is called when the button "Done" is clicked and displays the result.
     */
    public void submitQuiz(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

/**
 * If only (both) correct answers in checkbox questions are clicked, then result increases by 1.
 */
        if (both1 >= 2) {
            result = result + 1;
        } else if (both1 < 2) {
            result = result + 0;
        }

        if (both2 >= 2) {
            result = result + 1;
        } else if (both2 < 2) {
            result = result + 0;
        }

        if (both3 >= 2) {
            result = result + 1;
        } else if (both3 < 2) {
            result = result + 0;
        }


/**
 * These toast messages display name (String name), score (int result) and additional text.
 */

        if (result >= 7) {
            Toast toast1 = Toast.makeText(this, name + ", your score is " + result + " out of 7." + "\n" + "Well done, great job!" + "\n" + "Thank you for using Space Quiz!", Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.show();
        } else if (result >= 4) {
            Toast toast2 = Toast.makeText(this, name + ", your score is " + result + " out of 7." + "\n" + "Not perfect, but still it's a good job!" + "\n" + "Thank you for using Space Quiz!", Toast.LENGTH_LONG);
            toast2.setGravity(Gravity.CENTER, 0, 0);
            toast2.show();
        } else if (result < 4) {
            Toast toast3 = Toast.makeText(this, name + ", your score is " + result + " out of 7." + "\n" + "You can do better so try again." + "\n" + "Thank you for using Space Quiz!", Toast.LENGTH_LONG);
            toast3.setGravity(Gravity.CENTER, 0, 0);
            toast3.show();
        }

    }


    /**
     * This method checks is the answers correct or not and is related with Check Boxes.
     */
    public String onCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked - q2
        switch (view.getId()) {
            case venus:
                if (checked) {
                    both1 = both1 - 1;
                }
                break;
            case R.id.mars:
                if (checked) {
                    both1 = both1 - 1;
                }
                break;
            case R.id.jupiter:
                if (checked) {
                    both1 = both1 + 1;
                    // This is correct answer
                }
                break;
            case R.id.saturn:
                if (checked) {
                    both1 = both1 + 1;
                    // This is correct answer
                }
                break;
        }


        // Check which checkbox was clicked - q5
        switch (view.getId()) {
            case R.id.q5a:
                if (checked) {
                    both2 = both2 - 1;
                }
                break;
            case R.id.q5b:
                if (checked) {
                    both2 = both2 + 1;
                    // This is correct answer
                }
                break;
            case R.id.q5c:
                if (checked) {
                    both2 = both2 + 1;
                    // This is correct answer
                }
                break;
            case R.id.q5d:
                if (checked) {
                    both2 = both2 -1;
                }
                break;
        }

        // Check which checkbox was clicked - q6
        switch (view.getId()) {
            case R.id.webb:
                if (checked) {
                    both3 = both3 + 1;
                    // This is correct answer
                }
                break;
            case R.id.newton:
                if (checked) {
                    both3 = both3 - 1;
                }
                break;
            case hubble:
                if (checked) {
                    both3 = both3 + 1;
                    // This is correct answer
                }
                break;
            case R.id.copernicus:
                if (checked) {
                    both3 = both3 - 1;
                }
                break;
        }

        return quizSummary;
    }


    // Check which radio button was clicked
    public String onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            //First radio button question
            case R.id.alphacentauri:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.sun:
                if (checked) {
                    result = result + 1;
                    // This is correct answer
                }
                break;
            case R.id.sirius:
                if (checked) {
                    result = result + 0;
                }
                break;

            //Image radio button question
            case R.id.firsta:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.secondb:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.thirdc:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.fourthd:
                if (checked) {
                    result = result + 1;
                    // This is correct answer
                }
                break;

            //Third radio button question
            case R.id.first:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.second:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.third:
                if (checked) {
                    result = result + 1;
                    // This is correct answer
                }
                break;

            //7th question radio buttons
            case R.id.yes:
                if (checked) {
                    result = result + 0;
                }
                break;
            case R.id.no:
                if (checked) {
                    result = result + 1;
                    // This is correct answer
                }
                break;

        }

        return quizSummary;
    }

}
