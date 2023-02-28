package com.example.gymapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class fragment_calculators extends Fragment {
    EditText editText1, editText2, editText3,editText4,editText5;
    TextView data;
    RadioButton radioButton1,radioButton2;
    Button button;
    float weight =0, height =0,BMI=0,neck,waist,age;
    Double formula;
    int cal_no;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_calculators, container, false);
        editText1 = view.findViewById(R.id.edittext1_calculator);
        editText2 = view.findViewById(R.id.edittext2_calculator);
        editText3 = view.findViewById(R.id.edittext3_calculator);
        editText4 = view.findViewById(R.id.edittext4_calculator);
        editText5 = view.findViewById(R.id.edittext5_calculator);
        editText1.setVisibility(View.INVISIBLE);
        editText2.setVisibility(View.INVISIBLE);
        editText3.setVisibility(View.INVISIBLE);
        editText4.setVisibility(View.INVISIBLE);
        editText5.setVisibility(View.INVISIBLE);
        button= view.findViewById(R.id.button);
        data= view.findViewById(R.id.data);
        radioButton1= view.findViewById(R.id.radioButton1);
        radioButton2= view.findViewById(R.id.radioButton2);

        //  cal_no = getArguments().getInt("cal_no");
        Bundle bundle = this.getArguments();
        cal_no = bundle.getInt("message");
        Log.d("cali2", "onNavigationItemSelected: "+cal_no);
        Visibiltyseter();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  String weights=String.valueOf(editText3.getText());

                switch (cal_no){

                    case 0:
                        BMI_calculator();
                        break;

                    case 1:
                        Bodyfat_calculator();
                        break;

                    case 2:
                        protein_calculator();
                        break;
                    case 3:
                        defiet_calculator();
                        break;
                    case 4:
                        surplus_calculator();
                        break;
                }



            }
        });

        return view;
    }




    public void Visibiltyseter(){

        switch (cal_no){

            case 0:
                editText1.setVisibility(View.VISIBLE);
                editText2.setVisibility(View.VISIBLE);
                editText3.setVisibility(View.VISIBLE);
                break;

            case 1:
                editText1.setVisibility(View.VISIBLE);
                editText2.setVisibility(View.VISIBLE);
                editText3.setVisibility(View.VISIBLE);
                editText4.setVisibility(View.VISIBLE);
                editText5.setVisibility(View.VISIBLE);
                break;

            case 2:

                editText3.setVisibility(View.VISIBLE);

                break;
            case 3:

                editText3.setVisibility(View.VISIBLE);
                editText4.setHint("GOAL WEIGHT");
                editText4.setVisibility(View.VISIBLE);

                break;

            case 4:

                editText3.setVisibility(View.VISIBLE);
                editText4.setHint("GOAL WEIGHT");
                editText4.setVisibility(View.VISIBLE);

                break;
        }





    }


    public void BMI_calculator(){

        weight = Integer.parseInt(String.valueOf(editText3.getText()));
        height =Integer.parseInt(String.valueOf(editText2.getText()));

        BMI = weight /((height /100)* height /100);
        // BMI = (Weight in Kilograms / (Height in Meters x Height in Meters))
        Log.d("TAG", weight +"onClick: "+((height /100)*2));


        data.setText(String.valueOf(BMI));


    }
    public void Bodyfat_calculator(){

        age =Integer.parseInt(String.valueOf(editText1.getText()));
        neck = Integer.parseInt(String.valueOf(editText5.getText()));
        waist =Integer.parseInt(String.valueOf(editText5.getText()));
        weight = Integer.parseInt(String.valueOf(editText3.getText()));
        height =Integer.parseInt(String.valueOf(editText2.getText()));
        BMI = weight /((height /100)* height /100);
        // formula=(495/ (1.0324 - 0.19077*log10(waist-neck) + 0.15456*log10(height))) - 450;

        formula= (1.20 * BMI + 0.23 * age )- 16.2;

        data.setText(String.valueOf(formula));
    }
    private void protein_calculator() {


        weight = Integer.parseInt(String.valueOf(editText3.getText()));
        float formula= weight*2;
        data.setText(String.valueOf(formula));
    }
    private void defiet_calculator() {

        weight = Integer.parseInt(String.valueOf(editText3.getText()));
        float goal_weight = Integer.parseInt(String.valueOf(editText4.getText()));
        if (weight>goal_weight){
            float formula= (goal_weight*2)*11;
            data.setTextSize(20);
            data.setText(String.valueOf(formula)+"\n calories to eat per day to weight loss");
        }
        else if (weight==goal_weight){
            data.setTextSize(20);
            data.setText("goal weight should not be equal to current weight");
        }
        else {
            data.setTextSize(20);
            data.setText("goal weight should be lesser to current weight");
        }
    }
    private void surplus_calculator() {

        weight = Integer.parseInt(String.valueOf(editText3.getText()));
        float goal_weight = Integer.parseInt(String.valueOf(editText4.getText()));
        if (weight<goal_weight){
            float formula= (goal_weight*2)*16;
            data.setTextSize(20);
            data.setText(String.valueOf(formula)+"\n calories to eat per day to weight gain");
        }
        else if (weight==goal_weight){
            data.setTextSize(20);
            data.setText("goal weight should not be equal to current weight");
        }
        else {
            data.setTextSize(20);
            data.setText("goal weight should be more to current weight");
        }
    }
}
