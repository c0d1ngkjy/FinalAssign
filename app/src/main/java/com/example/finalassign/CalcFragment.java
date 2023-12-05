package com.example.finalassign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CalcFragment extends Fragment {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText editText;
    float valOne, valTwo;
    boolean additionBool, subtractBool, multiplyBool, divisionBool;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_calc, container, false);
        button0 = (Button) view.findViewById(R.id.button0);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        button6 = (Button) view.findViewById(R.id.button6);
        button7 = (Button) view.findViewById(R.id.button7);
        button8 = (Button) view.findViewById(R.id.button8);
        button9 = (Button) view.findViewById(R.id.button9);
        button10 = (Button) view.findViewById(R.id.button10);
        buttonAdd = (Button) view.findViewById(R.id.buttonadd);
        buttonSub = (Button) view.findViewById(R.id.buttonsub);
        buttonMul = (Button) view.findViewById(R.id.buttonmul);
        buttonDivision = (Button) view.findViewById(R.id.buttondiv);
        buttonC = (Button) view.findViewById(R.id.buttonC);
        buttonEqual = (Button) view.findViewById(R.id.buttoneql);
        editText = (EditText) view.findViewById(R.id.edt1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null) {
                    editText.setText("");
                } else {
                    valOne = Float.parseFloat(editText.getText() + "");
                    additionBool = true;
                    editText.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(editText.getText() + "");
                subtractBool = true;
                editText.setText(null);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(editText.getText() + "");
                multiplyBool = true;
                editText.setText(null);
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(editText.getText() + "");
                divisionBool = true;
                editText.setText(null);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valTwo = Float.parseFloat(editText.getText() + "");
                if (additionBool == true) {
                    editText.setText(valOne + valTwo + "");
                    additionBool = false;
                }
                if (subtractBool == true) {
                    editText.setText(valOne - valTwo + "");
                    subtractBool = false;
                }
                if (multiplyBool == true) {
                    editText.setText(valOne * valTwo + "");
                    multiplyBool = false;
                }
                if (divisionBool == true) {
                    editText.setText(valOne / valTwo + "");
                    divisionBool = false;
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ".");
            }
        });

        return view;
    }
}