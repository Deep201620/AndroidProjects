package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonAdd,buttonSubtract,buttonMul,buttonDiv,buttonClear,buttonEqual,buttonExit,buttonraise,buttondel;
    String result,result2;
    String tmp,operator;
    boolean flag = false;
    TextView resultTextView,t1view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
        t1view = findViewById(R.id.textview);
        resultTextView.setTextSize(40);
    }

    private  void initControlListener(){
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClicked();
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("-");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });
        buttonraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("^");
            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteButtonClicked();
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExitButtonClicked();
            }
        });
    }

    private void onExitButtonClicked(){
        Toast.makeText(MainActivity.this,"Successfully Exited from Application",Toast.LENGTH_SHORT).show();
        finish();

    }

    private void onEqualButtonClicked(){
        long res= 0;
        flag = true;
        try{
            long number = Long.valueOf(tmp);
            long number2 = Long.valueOf(resultTextView.getText().toString().substring(tmp.length()+operator.length(),resultTextView.length()));

            switch (operator) {
                case "+":
                    res = number + number2;
                    break;

                case "/":
                    res = number / number2;
                    break;

                case "-":
                    res = number - number2;
                    break;

                case "*":
                    res = number * number2;
                    break;

                case "^":
                    res = (int)Math.pow(number,number2);
            }
            result = String.valueOf(res);

            resultTextView.setText(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void onOperatorButtonClicked(String operator){
        tmp = resultTextView.getText().toString();
        //onClearButtonClicked();
        this.operator = operator;
        resultTextView.setText(tmp+operator);
    }

    private void onClearButtonClicked() {
        result = "";
        resultTextView.setText("");
    }

    private void onNumberButtonClicked(String pos){
        result = resultTextView.getText().toString();
        result = result+pos;
        resultTextView.setText(result);
    }

    private void onDeleteButtonClicked(){
        if(flag){
           onClearButtonClicked();
        }else {
            resultTextView.setText(resultTextView.getText().toString().substring(0, resultTextView.getText().length() - 1));
        }
    }

    private void initControl() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSub);
        buttonClear = findViewById(R.id.buttonClear);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonraise = findViewById(R.id.buttonraiseto);
        buttondel = findViewById(R.id.buttondelete);

        resultTextView = findViewById(R.id.textview_result);
        buttonExit = findViewById(R.id.buttonexit);
    }
}