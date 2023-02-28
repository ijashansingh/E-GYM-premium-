package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class Data_Copier extends AppCompatActivity implements Dialogbox_Adaptor.Viewholder.OnNoteListenerDA {

    Button dialog_buttonDC,saver,temp;
    MyDataBase DB;

    String name;
    ImageView imageViewTV;
    Dialogbox_Adaptor adaptor;
    HomeFragment homeFragment;
    int listy,listy2,image;
    Context context = Data_Copier.this;
    TextView nameTV;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> userlist;
    MyDataBase objectdatabaseHandler;
    EditText setsnumber;

    public ArrayList<modelclass> banasluserlist;
    private Dialogbox_Adaptor.Viewholder.OnNoteListenerDA OnNoteClick=this::OnNoteClickDA;
    private final Adaptor.Viewholder.OnNoteListener Onclick = this::OnNoteClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__copier);

            dialog_buttonDC =findViewById(R.id.dialog_buttonDC);
            temp =findViewById(R.id.tempdaata);
            saver =findViewById(R.id.SaverDC);
            String namer = getIntent().getStringExtra("Selectedtabler");
            nameTV = findViewById(R.id.dialog_nameTV);
            imageViewTV = findViewById(R.id.dialog_imageIV);
            setsnumber = findViewById(R.id.setsnumberDC);

            saver.setEnabled(false);
            temp.setEnabled(false);

        String a = setsnumber.getText().toString();
        Log.d("aa", "onClick: "+a);
        dialog_buttonDC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                  //  initdata2();
                    Context context =Data_Copier.this;
                    homeFragment.initdata();
                    userlist = new ArrayList<>();
                    //userlist=homeFragment.userlist;
                    Log.d("jad", "onCreateView: "+homeFragment.userlist);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    LayoutInflater inflater = LayoutInflater.from(context);
                    View row = inflater.inflate(R.layout.row_item,null);
                    recyclerView =row.findViewById(R.id.templister);

                    layoutManager= new LinearLayoutManager(context);
                  //  GridLayoutManager layoutManager=new GridLayoutManager(context,2);
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);

                     adaptor = new Dialogbox_Adaptor(homeFragment.userlist,OnNoteClick);
                    recyclerView.setAdapter(adaptor);
                    adaptor.notifyDataSetChanged();


                    temp.setEnabled(true);
                    builder.setView(row);
                    builder.setTitle("Choose course");

// add OK and Cancel buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // user clicked OK
                            closeContextMenu();
                        }
                    });
                    builder.setNegativeButton("Cancel", null);
// create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objectdatabaseHandler = new MyDataBase(context);
                Context context =Data_Copier.this;
                listerDC(listy);
                userlist = new ArrayList<>();

               userlist= banasluserlist;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                LayoutInflater inflater = LayoutInflater.from(context);
                View row = inflater.inflate(R.layout.row_item,null);
                recyclerView =row.findViewById(R.id.templister);

                layoutManager= new LinearLayoutManager(context);
                 // GridLayoutManager layoutManager=new GridLayoutManager(context,2);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);

                Adaptor  adaptor2 = new Adaptor(userlist,Onclick);
                recyclerView.setAdapter(adaptor2);
                adaptor2.notifyDataSetChanged();



                saver.setEnabled(true);
                builder.setView(row);
                builder.setTitle("Choose course");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        detaildata();
                        closeContextMenu();
                    }
                });
                builder.setNegativeButton("Cancel", null);
// create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        saver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = Data_Copier.this;

                    DB =new MyDataBase(context);


                  DB.datacopyer(name,namer);


                    if (setsnumber.getText().toString().trim().length() <= 0){
                        setmaker(namer,"1");
                    }
                    else if (setsnumber.getText().toString().trim().length() >= 8){
                        setmaker(namer,"8");
                    }else {
                        setmaker(namer,setsnumber.getText().toString());

                    }


                    Toast.makeText(getApplicationContext(),name.toUpperCase()+" EXERCISE SAVED IN PLAY LIST ",Toast.LENGTH_SHORT).show();
                }
            });



    }

    private void setmaker(String namer,String sets){
        DB.updateset(name,namer,sets);

    }
    private void detaildata(){
        name = banasluserlist.get(listy2).getTextview2();
        image = banasluserlist.get(listy2).getImage();
         Log.d("name", "onCreate: "+name);
        imageViewTV.setImageResource(image);
         nameTV.setText(name);
    }

    public void listerDC(int positionz) {

        switch (positionz) {
            case 0:

                banasluserlist = objectdatabaseHandler.getbackdata("CHEST");
                break;
            case 1:

                banasluserlist = objectdatabaseHandler.getbackdata("BACK");
                break;

            case 2:

                banasluserlist = objectdatabaseHandler.getbackdata("BICEPS");
                break;

            case 3:
                banasluserlist = objectdatabaseHandler.getbackdata("TRICEPS");
                break;
            case 4:
                banasluserlist = objectdatabaseHandler.getbackdata("LEGS");
                break;
            case 5:
                banasluserlist = objectdatabaseHandler.getbackdata("SHOULDER");
                break;
            default:
                banasluserlist = objectdatabaseHandler.getallImagesdata();
                break;


        }


    }

    @Override
    public void OnNoteClickDA(int adapterPosition) {
        homeFragment.userlist.get(adapterPosition);

        listy=(adapterPosition);
     //   Log.d("jad", "onCreateView: "+listy);
      //  startActivity(intent);
    }
    public void OnNoteClick(int adapterPosition) {
       // homeFragment.userlist.get(adapterPosition);

        listy2=(adapterPosition);
        Log.d("jad", "onCreateView: "+listy2);
        //  startActivity(intent);
    }
}