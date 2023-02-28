package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Record_image_shower_sql extends AppCompatActivity {

    RecyclerView SQLrecyclerView;
    LinearLayoutManager layoutManager;
    List<SQLmodelclass> SQLuserlist;
    SQLAdaptor adaptor;
    Button shower;
    MyDataBase objectdatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_image_shower_sql);


        objectdatabaseHandler=new MyDataBase(Record_image_shower_sql.this);
       // shower=findViewById(R.id.showimagesbutton);
        SQLrecyclerView =findViewById(R.id.imageRV);


        initRecyclerview();

//        initdata();
     /*   shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      initdata();
                initRecyclerview();

            }
        });/8*/






    }
    /*
            private void initdata() {



            userlist = new ArrayList<>();

            userlist.add(new SQLmodelclass(R.drawable.mario,"first",null));
           userlist.add(new SQLmodelclass(R.drawable.mario,"second",null));
           userlist.add(new SQLmodelclass(R.drawable.mario,"third",null));
            //    userlist.add(new)
              //    Bitmap objectbitmap= BitmapFactory.decodeByteArray(MainActivity.tempimage,0,imageByte.length);
              //     userlist.add(new modelclass(imageview1,textview1));

            }
    */
    private void initRecyclerview() {


        // objectrvAdaptor=new RVAdaptor( objectdatabaseHandler.getallImagesdata());

        //     objectrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //    objectrecyclerView.setAdapter(objectrvAdaptor);

        SQLrecyclerView =findViewById(R.id.imageRV);
        layoutManager= new LinearLayoutManager(Record_image_shower_sql.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        SQLrecyclerView.setLayoutManager(layoutManager);
        //ArrayList<modelclass> banasluserlist = objectdatabaseHandler.getallImagesdata();
        ArrayList<SQLmodelclass> banasluserlist = objectdatabaseHandler.getrecordimagedata();
        Log.d("bansal", "initRecyclerview: "+banasluserlist.size());
        adaptor = new SQLAdaptor(banasluserlist);
        // adaptor=new Adaptor( objectdatabaseHandler.getallImagesdata(),null);
        SQLrecyclerView.setHasFixedSize(true);
        SQLrecyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();
    }




}
