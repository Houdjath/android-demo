package Houdjath.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Calculatrice extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText edi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        edi = findViewById(R.id.editText);
    }

    public void buttonEvent(View view) {
        if(isNewOp)
            edi.setText("");
        isNewOp = false;
        String number = edi.getText().toString();
            switch (view.getId()){
                case R.id.button7:
                    number += "7";
                         break;

                         case R.id.button8:
                number += "8";
                break;

            case R.id.button9:
                number += "9";
                break;

            case R.id.button4:
                number += "4";
                break;

            case R.id.button5:
                number += "5";
                break;

            case R.id.button6:
                number += "6";
                break;

            case R.id.button1:
                number += "1";
                break;

            case R.id.button2:
                number += "2";
                break;

                case R.id.button3:
                number += "3";
                break;

                case R.id.button0:
                    number += "0";
                    break;

                case R.id.buttonSlash:
                    number = "-"+number;
                    break;

                case R.id.buttonVirgule:
                    number = ".";
                    break;

            }

        edi.setText(number);
    }


    public void operationEvent(View view) {
        isNewOp = true;
        oldNumber = edi.getText().toString();
        switch (view.getId()){
            case R.id.buttonDivision: op = "/"; break;
            case R.id.buttonfois: op = "*"; break;
            case R.id.buttonplus: op = "+"; break;
            case R.id.buttonmoins: op = "-"; break;


        }
    }

    public void equalEvent(View view) {
        String newNumber = edi.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;
        }
        edi.setText(result+"");

    }

    public void acEvent(View view) {
        edi.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
       double no = Double.parseDouble(edi.getText().toString())/100;
       edi.setText(no+"");
       isNewOp = true;

    }
}


