package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayList_DataShower extends AppCompatActivity implements Adaptor.Viewholder.OnNoteListener{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> userlist;
//    final TextView textView= new TextView(PlayList_DataShower.this);
    Adaptor adaptor;
    Button shower,entry,play;
    MyDataBase objectdatabaseHandler;
    ArrayList<modelclass> banasluserlist;
    Integer position;
    String [] strArray;
    String name,musclename;;
    String namepositioner;


    @Override
    protected void onResume() {
        super.onResume();
        initRecyclerview();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list__data_shower);
        getSupportActionBar().hide();

                shower=findViewById(R.id.datashowerbutton);
        entry=findViewById(R.id.newentry);
        play=findViewById(R.id.play);

                position = getIntent().getIntExtra("positioner", 0);

        namepositioner  = getIntent().getStringExtra("namepositioner");


        objectdatabaseHandler=new MyDataBase(this);
                userlist = new ArrayList<>();
        lister();
                shower.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context =PlayList_DataShower.this;
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);

                        LayoutInflater inflater = LayoutInflater.from(context);
                     //   View row = inflater.inflate(R.layout.row_item,null);

                        builder.setMessage("DO YOU WANT TO DELETE THIS PLAYLIST");

                        builder.setTitle("DELETE PLAYLIST");

// add OK and Cancel buttons
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // user clicked OK
                                deletetable();
                                closeContextMenu();
                            }
                        });
                        builder.setNegativeButton("Cancel", null);
// create and show the alert dialog
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }


                });
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(PlayList_DataShower.this,Data_Copier.class);

                intent.putExtra("Selectedtabler",name);
                Log.d("nirmal", "onClick: "+name);



                startActivity(intent);


            }
        });
play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(PlayList_DataShower.this,playactivity.class);
        intent.putExtra("Selectedtabler",name);
        startActivity(intent);

    }
});


    }
    private void deletetable(){

        objectdatabaseHandler.deletetable(name);

        Intent intent;
        intent = new Intent(PlayList_DataShower.this,MainActivity.class);
        startActivity(intent);



    }



            private void lister() {
                namepositioner = namepositioner.replace("]", "");
                namepositioner = namepositioner.replace("[", "");
                strArray = namepositioner.split(",");

                name = strArray[position];
                banasluserlist = objectdatabaseHandler.getimagebyname(name);

                Log.d("namefirst", "onClick: "+name);
                }

            private void initRecyclerview() {




                recyclerView =findViewById(R.id.datashower_RV);
                layoutManager= new LinearLayoutManager(this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                banasluserlist = objectdatabaseHandler.getimagebyname(name);
                if (userlist!=null){
                    adaptor = new Adaptor(banasluserlist,this);
                    userlist= banasluserlist;
                }


                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();
            }

            @Override
            public void OnNoteClick(int adapterPosition) {
                userlist.get(adapterPosition);
                String musclename = userlist.get(adapterPosition).getTextview1();

                Intent intent;
                intent = new Intent(this, Detailer_class_exercises.class);

                intent.putExtra("positioner", adapterPosition);
                intent.putExtra("tablename", name);
                intent.putExtra("musclename", musclename);

                startActivity(intent);

            }

        }


