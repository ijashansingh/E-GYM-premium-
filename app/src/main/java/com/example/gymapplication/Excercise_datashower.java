package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Excercise_datashower extends AppCompatActivity implements Adaptor.Viewholder.OnNoteListener {
    // public  static List<Homefragmentmodelclass> banasluserlist;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> userlist;
    Adaptor adaptor;
    Button shower;
     MyDataBase objectdatabaseHandler;
    public ArrayList<modelclass> banasluserlist;
    Integer position, positionz;

    String musclename;
    @Override
    protected void onResume() {
        super.onResume();

        initRecyclerview();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_datashower);


        position = getIntent().getIntExtra("positioner", 0);


        //     positionz=position;
//        initdata();

        initRecyclerview();
       // shower=findViewById(R.id.datashowerbutton);
        objectdatabaseHandler = new MyDataBase(this);
        userlist = new ArrayList<>();

    }


    public  ArrayList<modelclass> lister(int positionz) {

        switch (positionz) {
            case 0:
                musclename="CHEST";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;
            case 1:
                musclename="BACK";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;

            case 2:
                musclename="BICEPS";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;

            case 3:
                musclename="TRICEPS";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;
            case 4:
                musclename="LEGS";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;
            case 5:
                musclename="SHOULDER";
                banasluserlist = objectdatabaseHandler.getbackdata(musclename);
                break;
            default:
                banasluserlist = objectdatabaseHandler.getallImagesdata();
                break;


        }

        return banasluserlist;

    }


    public void initRecyclerview() {

        recyclerView = findViewById(R.id.datashower_RV);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Log.d("listyy", "initRecyclerview: " + position);

        if (userlist!=null){
            lister(position);
        }


        adaptor = new Adaptor(banasluserlist, this);


        userlist = banasluserlist;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();
    }

    @Override
    public void OnNoteClick(int adapterPosition) {
        userlist.get(adapterPosition);

        Intent intent;
        intent = new Intent(this, Detailer_class_exercises.class);

        intent.putExtra("positioner", adapterPosition);
        intent.putExtra("musclename", musclename);


        startActivity(intent);

    }

}

