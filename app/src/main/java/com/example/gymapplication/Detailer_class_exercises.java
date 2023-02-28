package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detailer_class_exercises extends AppCompatActivity {

    TextView textView1,textView2;
    ImageView imageView1;


    ArrayList<modelclass> userlist;
    int position;
    TextView textView3;
    String musclename,tablename;

    MyDataBase objectdatabaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailer_class_exercises);


        textView1=findViewById(R.id.DtextView);
        textView2=findViewById(R.id.DtextView2);

        textView3 = findViewById(R.id.DtextView3);
        imageView1=findViewById(R.id.DimageView);

        position = getIntent().getIntExtra("positioner", 0);
        musclename = getIntent().getStringExtra("musclename");
        tablename = getIntent().getStringExtra("tablename");

        objectdatabaseHandler = new MyDataBase(this);
        userlist = new ArrayList<>();

        if(tablename!=null){
        userlist = objectdatabaseHandler.getplaydetailerdata(musclename,tablename);}
        else{
            userlist = objectdatabaseHandler.getdetailerdata(musclename);}



        int resource = userlist.get(position).getImage();
        String name = userlist.get(position).getTextview1();
        String level = userlist.get(position).getTextview2();
       // String musclename = userlist.get(position).getTextview2();


        imageView1.setImageResource(resource);
        textView1.setText(name);
        textView2.setText(level);
        textView3.setText(musclename);

    }
}