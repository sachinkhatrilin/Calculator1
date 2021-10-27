package com.skdesign.calculator;


import static java.lang.Double.parseDouble;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {
    double num1;
    double num2;
    private AdView mAdView;
    boolean procAdd, procSub, procMul, procDiv, procSqrt, procSquare;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button btn_Zero = findViewById(R.id.btn_Zero);
        Button btn_Sqrt = findViewById(R.id.btn_Sqrt);
        Button btn_Square = findViewById(R.id.btn_square);
        Button btn_Min = findViewById(R.id.btn_Min);
        Button btn_Plus = findViewById(R.id.button_Plus);
        Button btn_Div = findViewById(R.id.btn_Div);
        Button btn_Decimal = findViewById(R.id.btn_Decimal);
        Button btn_Mul = findViewById(R.id.btn_Mul);
        Button btn_Back = findViewById(R.id.btn_Back);
        Button btn_Clr = findViewById(R.id.btn_Clr);
        Button btn_Equals = findViewById(R.id.btn_Equals);
        TextView textInput = findViewById(R.id.textInput);
        TextView textResult = findViewById((R.id.textResult));
        textInput.setText(null);

        btn_1.setOnClickListener(v -> textInput.append("1"));
        btn_2.setOnClickListener(v -> textInput.append("2"));
        btn_3.setOnClickListener(v -> textInput.append("3"));
        btn_4.setOnClickListener(v -> textInput.append("4"));
        btn_5.setOnClickListener(v -> textInput.append("5"));
        btn_6.setOnClickListener(v -> textInput.append("6"));
        btn_7.setOnClickListener(v -> textInput.append("7"));
        btn_8.setOnClickListener(v -> textInput.append("8"));
        btn_9.setOnClickListener(v -> textInput.append("9"));
        btn_Zero.setOnClickListener(v -> textInput.append("0"));
        btn_Decimal.setOnClickListener(v -> textInput.append("."));
        btn_Clr.setOnClickListener(v -> {
            textInput.setText("0");
            textResult.setText("0");
        });
        btn_Back.setOnClickListener(v -> {
            String in = (textInput.getText().toString() + "");
            if (textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) {
                textInput.setText("0");
            } else
                textInput.setText(in.substring(0, in.length() - 1));
        });

        btn_Plus.setOnClickListener(v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText(null);
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procAdd = true;
                textResult.setText(String.valueOf(num1));
                textInput.setText(null);
            } else if (!textResult.getText().toString().equals("0")) {
                num1 = Double.parseDouble(textResult.getText().toString());
                procAdd = true;
                // textInput.setText(null);

            } else if (num1 != 0 && num2 != 0) {

                procAdd=false;
            }


        });

        btn_Min.setOnClickListener(v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText(null);
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procSub = true;
                textResult.setText(String.valueOf(num1));
                textInput.setText(null);
            } else if (!textResult.getText().toString().equals("0")) {
                num1 = Double.parseDouble(textResult.getText().toString());
                procSub = true;
                //  textInput.setText(null);
            } else if (num1 != 0 && num2 != 0) {

                procSub=false;
            }
        });
        btn_Mul.setOnClickListener(v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText(null);
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procMul = true;
                textResult.setText(String.valueOf(num1));
                textInput.setText(null);
            } else if (!textResult.getText().toString().equals("0")) {
                num1 = Double.parseDouble(textResult.getText().toString());
                procMul = true;
                //  textInput.setText(null);
            }else if (num1 != 0 && num2 != 0) {

                procMul=false;
            }
        });
        btn_Div.setOnClickListener(v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText("0");
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procDiv = true;
                textResult.setText(String.valueOf(num1));
                textInput.setText(null);
            } else  if (!textResult.getText().toString().equals("0")) {
                num1 = Double.parseDouble(textResult.getText().toString());
                procDiv = true;
                //   textInput.setText(null);
            } else if (num1 != 0 && num2 != 0) {

                procDiv=false;
            }
        });
        btn_Sqrt.setOnClickListener(v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText("0");
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procSqrt = true;
                textInput.setText(null);
            } else {
                num1 = Double.parseDouble(textResult.getText().toString());
                procSqrt = true;
                textInput.setText(null);
            }
        });
        btn_Square.setOnClickListener((v -> {
            if ((textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) && textResult.getText().toString().equals("0")) {
                textInput.setText("0");
            } else if (textResult.getText().toString().isEmpty() || textResult.getText().toString().equals(("0"))) {
                num1 = Double.parseDouble(textInput.getText().toString() + "");
                procSquare = true;
                textInput.setText(null);
            } else {
                num1 = Double.parseDouble(textResult.getText().toString());
                procSquare = true;
                textInput.setText(null);
            }
        }));
        btn_Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInput.getText().toString().isEmpty() || textInput.getText().toString().equals("0")) {
                    textInput.setText("0");
                } else
                    num2 = parseDouble(textInput.getText().toString() + "");
                if (procAdd) {
                    textResult.setText(num1 + num2 + "");
                    num1 = parseDouble(textResult.getText().toString());
                    textInput.setText(null);
                    procAdd = false;
                }
                if (procSub) {
                    textResult.setText((num1 - num2) + "");
                    num1 = parseDouble(textResult.getText().toString());
                    textInput.setText(null);
                    procSub = false;
                }
                if (procMul) {
                    textResult.setText(num1 * num2 + "");
                    num1 = parseDouble(textResult.getText().toString());
                    textInput.setText(null);
                    procMul = false;
                }
                if (procDiv) {
                    textResult.setText((num1 / num2) + "");
                    textInput.setText(null);
                    procDiv = false;
                }
                if (procSqrt) {
                    textResult.setText(Math.sqrt(num1) + "");
                    textInput.setText(null);
                    procSqrt = false;
                }
                if (procSquare) {
                    textResult.setText(num1 * num1 + "");
                    textInput.setText(null);
                    procSquare = false;
                }
            }
        });
    }
}




