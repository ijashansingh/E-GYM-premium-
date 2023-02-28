package com.example.gymapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exeercise_data extends AppCompatActivity implements Dialogbox_Adaptor.Viewholder.OnNoteListenerDA  {
    public static Bitmap temp;
    TextView textView, textView1;
    EditText editText,muscletype,description;
    ImageView imageView;
    Button button, upload,next,dialog_buttonDC,newtable,autoinstall;
    private static Uri uri, tempimage;
    Dialogbox_Adaptor adaptor;
    int i = 1;
    MyDataBase DB;
    String nameDB,muscleDB;
    Bitmap imageDB;
    clusterclass clusterclassobject ;
    HomeFragment homeFragment;
    List<modelclass> userlist;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private Dialogbox_Adaptor.Viewholder.OnNoteListenerDA OnNoteClick=this::OnNoteClickDA;
    private final static int PICK_IMG_REQUEST = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exeercise_data);



                textView = (TextView) findViewById(R.id.textview);
                textView1 = (TextView) findViewById(R.id.textview1);
                editText = (EditText) findViewById(R.id.edittext);
                muscletype = (EditText) findViewById(R.id.musceltypeedittext);
                imageView = (ImageView) findViewById(R.id.image);
                button = (Button) findViewById(R.id.button);
             //   autoinstall = (Button) findViewById(R.id.autodata);
             //   newtable = (Button) findViewById(R.id.newtable);
        dialog_buttonDC = (Button) findViewById(R.id.upload);
                description = (EditText) findViewById(R.id.descriptiontext);
                DB = new MyDataBase(this);


        dialog_buttonDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //  initdata2();
                Context context =Exeercise_data.this;
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

                adaptor = new Dialogbox_Adaptor(homeFragment.userlist,this::OnNoteClick);
                recyclerView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();



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

            private void OnNoteClick(int i) {
            }
        });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String name = editText.getText().toString();
                        String muscle = muscletype.getText().toString();
                        String desription = description.getText().toString();

                        int i =R.drawable.a;

                        boolean insert = DB.insertdata(name, muscle,i,desription,i);
                        if (insert == true) {
                            Toast.makeText(Exeercise_data.this, "Data Saved", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Exeercise_data.this, "Data Not Saved",
                                    Toast.LENGTH_SHORT).show();
                        }

                        imageDB = DB.getImage(name);
                        nameDB = DB.getName(name);
                        muscleDB=DB.getmusclename(name);
//                        imageViewTV.setImageBitmap(imageDB);
                        textView1.setText("The name entered by you is \n\n" + nameDB+muscleDB);
                    }
                });

         



            }



            @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                //if (requestCode == IMG_REQUEST_CODE && requestCode == RESULT_OK && data != null && data.getData() != null) {
                uri = data.getData();

                tempimage = data.getData();
                try {
                    Bitmap bit = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView.setImageBitmap(bit);
                    //    upload.setEnabled(false);
                    //  save.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    @Override
    public void OnNoteClickDA(int adapterPosition) {

    }
}

