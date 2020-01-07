


package com.example.temperatureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView history;
    private TextView farhan;
    private TextView tommy;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = findViewById(R.id.ResultHistory);
        farhan = findViewById(R.id.textViewF);
        tommy = findViewById(R.id.textViewC);
        resultText = findViewById(R.id.Output);
    }

    public void Convert(View v) {


        double value = 0;

        TextView outputText = findViewById(R.id.ResultHistory);
       // TextView resultText = findViewById(R.id.Output);

        outputText.setMovementMethod(new ScrollingMovementMethod());
        String orig = outputText.getText().toString();


        RadioButton rb;

        rb = findViewById(R.id.fbutton);

        //rb.isChecked();
        String output;

        //boolean checked = ((RadioButton) v).isChecked();
        try {
            if (rb.isChecked() == true) {
                EditText Fahrenheit = findViewById(R.id.Input);

                String Famount = Fahrenheit.getText().toString();

                double Fair = Double.parseDouble(Famount);
                value = (Fair - 32.0) / 1.8;

                output = String.format("%.1f F ==> %.1f C %n", Fair, value);
                outputText.setText(output + orig);
                Fahrenheit.setText("");
            } else {
                EditText Celsius = findViewById(R.id.Input);
                String Camount = Celsius.getText().toString();
                double Cells = Double.parseDouble(Camount);
                value = (Cells * 1.8) + 32.0;
                output = String.format("%.1f C ==> %.1f F %n", Cells, value);
                outputText.setText(output + orig);
                Celsius.setText("");
            }
        } catch (IllegalStateException e) {
            System.out.print("IllegalStateException Caught");
            Toast.makeText(this, "ERROR EMPTY BOX", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            System.out.print("NumberFormatException Caught");
            Toast.makeText(this, "ERROR EMPTY BOX", Toast.LENGTH_SHORT).show();
        }


        String answer = String.format("%.1f", value);
        resultText.setText(answer);

        //String output = String.format("%.1f F ==> %.1f %n", Fair, value);
        //outputText.setText(output + orig);

    }

    public void rotate(View v) {


        farhan.setText("Celsius Degrees:");
        tommy.setText("Fahrenheit Degrees:");


    }

    public void rotateFair(View v) {


        farhan.setText("Fahrenheit Degrees:");
        tommy.setText("Celsius Degrees:");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("HISTORY", history.getText().toString());
        outState.putString("Fa", farhan.getText().toString());
        outState.putString("Cel", tommy.getText().toString());
        outState.putString("result", resultText.getText().toString());



        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        history.setText(savedInstanceState.getString("HISTORY"));
        farhan.setText(savedInstanceState.getString("Fa"));
        tommy.setText(savedInstanceState.getString("Cel"));
        resultText.setText(savedInstanceState.getString("result"));

    }

    public void yolo(View v) {
        history.setText("");
    }
}

