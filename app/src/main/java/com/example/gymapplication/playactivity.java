package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class playactivity extends AppCompatActivity {
    ImageView imageView;
    clusterclass clusterclassobject;
    ArrayList<modelclass> mylist;
    MyDataBase myDataBase;
    public Button button;
    String tablename;
    MyDataBase objectdatabaseHandler;
    PlayList_DataShower playListDataShower;
    int z = 0, finishbt=0, finishbt2=0;
    int i, max = 1;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> userlist;
    public static ArrayList<modelclass> checker;
    Adaptorplay adaptorplay;
    int resource, sets;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);

        getSupportActionBar().hide();
        Timer timer = new Timer();
        //  Mytimer mt = new Mytimer();


        imageView = findViewById(R.id.imageViewplay);
        button = findViewById(R.id.buttonplay);
        tablename = getIntent().getStringExtra("Selectedtabler");

        button.setEnabled(false);
        photol();
        initdata();
        initRecyclerview();
        setschecker();
        Log.d("axz", "onCreate: " + sets);

        //  timer.schedule(mt,100,100);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finishbt==0) {


                        z++;
                        //max++;

                        photol();
                        initdata();
                        initRecyclerview();
                        setschecker();
                        button.setEnabled(false);

                    }

                   else if (finishbt==1){
                    /*     Fragment fragment = null;
                        fragment = new profileFragment();
                        fragmentManager= getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragment_container_play,fragment ).commit();
                       */
                                Intent intent;
                                intent = new Intent(playactivity.this,End_play_fullscreen.class);
                                startActivity(intent);
                            }}
                        });

                }










    //}

    private void setschecker() {

        //   checker = new ArrayList<>();
        Log.d("checcker", "setschecker: " + checker);
        if (checker != null) {
            if (checker.size() == sets) {

                button.setEnabled(false);
            }
        }


    }


    private void photol() {


        initdata();
        initRecyclerview();

        myDataBase = new MyDataBase(playactivity.this);

        objectdatabaseHandler = new MyDataBase(playactivity.this);

        mylist = objectdatabaseHandler.getimagebyname(tablename);

        resource = mylist.get(z).getImage();
        sets = mylist.get(z).getThumbnail();


        imageView.setImageResource(resource);

        if (z == mylist.size() - 1) {
            button.setText("finish");
            button.setEnabled(false);

if (z == mylist.size() - 1){
    finishbt++;
}



        }




    }


    private void initdata() {
        userlist = new ArrayList<>();

        for (i = 1; i <= sets; i++) {
            userlist.add(new modelclass(0, "", "", 0));
            Log.d("navin", "initdata: " + sets);
        }


    }

    private void initRecyclerview() {


        recyclerView = findViewById(R.id.recyclerviewplay);
        layoutManager = new LinearLayoutManager(playactivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adaptorplay = new Adaptorplay(userlist, new Adaptorplay.Viewholder.OnNoteListener() {
            @Override
            public void OnNoteClick(int adapterPosition) {

            }

            @Override
            public void allitemcheck() {
                button.setEnabled(true);

            }
        });
        recyclerView.setAdapter(adaptorplay);
        Log.d("chn", "initRecyclerview: " + checker);
        adaptorplay.notifyDataSetChanged();

    }


}
