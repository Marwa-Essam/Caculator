package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    String operator = "";
    String res = " ";
    String squarres = "";
    String soperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.resulttv);
    }

    public void onDigitClick(View view) {
       /* Button btn=(Button) view;
        resultTv.append(btn.getText());*/
        resultTv.append(((Button) view).getText());
    }

    public void onOperatorClick(View view) {
        // view is a reference on cliked View => polymerphism(3l4an 3ndi parent class View by4WER 3LA IMAGE AW BUTTON da m3na an al View byt4akel bkol a4kal al child bto3o zy ma hwa 3ayaz
        Button clickedoperator = (Button) view;
        if (operator.isEmpty()) {
            res = resultTv.getText().toString();
            operator = clickedoperator.getText().toString();
            resultTv.setText(null);
        } else {
            String newNumber = resultTv.getText().toString();
            res = calculate(res, operator, newNumber);
            operator = clickedoperator.getText().toString();
            resultTv.setText(null);
        }
    }

    public String calculate(String liftSide, String operator, String rightSide) {
        double LHS = Double.parseDouble(liftSide);
        double newnum = Double.parseDouble(rightSide);
        double res = 0;

        if (operator.equals("+")) {
            res = LHS + newnum;
        } else if (operator.equals("-")) {
            res = LHS - newnum;
        } else if (operator.equals("X")) {
            res = LHS * newnum;
        } else if (operator.equals("/")) {
            res = LHS / newnum;

        } else if (operator.equals("^")) {
            res = Math.pow(LHS, newnum);
        } else if (operator.equals("√")) {
            res = LHS * Math.sqrt(newnum);
        }
        return res + "";

    }

    ///////////////////////
    public String calculatesquar(String operator, String rightSide) {
        double newnum = Double.parseDouble(rightSide);
        double res = 0;
        if (operator.equals("√"))
            res = Math.sqrt(newnum);
        return res + "";
    }

    /*public void onSquar(View view){
        Button clickedoperator = (Button) view;
        if(soperator.isEmpty()){
            squarres = resultTv.getText().toString();
            soperator= clickedoperator.getText().toString();
            resultTv.setText(null);
        }else {
            String newNumber = resultTv.getText().toString();
            squarres=calculatesquar(soperator,newNumber);
            soperator=clickedoperator.getText().toString();
            resultTv.setText(null);
        }
    }*/
//////////////////////////
    public void backspace(View view) {
        String backspace = resultTv.getText().toString();
        backspace = backspace.substring(0, backspace.length() - 1);
        resultTv.setText(backspace);
    }

    public void onEqual(View view) {
        String newNm = resultTv.getText().toString();
        res = calculate(res, operator, newNm);
        resultTv.setText(res);
        operator = "";
        res = "";
        /*if (res .equals(calculate(res, operator, newNm))){
            resultTv.setText(res);
            operator="";
            res="";
        }else {
            squarres=calculatesquar(soperator,newNm);
            resultTv.setText(squarres);
            soperator="";
            squarres="";
        }*/

    }
}