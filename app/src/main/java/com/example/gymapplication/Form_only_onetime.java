package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Form_only_onetime extends AppCompatActivity {

Button button;
    clusterclass clusterclassobject ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_only_onetime);

        button = findViewById(R.id.next_page);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = Form_only_onetime.this;

                clusterclassobject =new clusterclass(context);
                clusterclassobject.dataclass();

                Intent intent = new Intent(Form_only_onetime.this,MainActivity.class);
                startActivity(intent);



            }
        });
    }
}