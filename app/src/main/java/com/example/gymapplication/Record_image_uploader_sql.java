package com.example.gymapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Record_image_uploader_sql extends AppCompatActivity {

    public static Bitmap temp;
    TextView textView, textView1;
    EditText editText;
    ImageView SQLimageView;
    Button button, upload,next;
    private static Uri uri, tempimage;
    Bitmap lenght;
    int MAXBYTES = 1152 * 2048;
    MyDataBase DB;
    String nameDB;
    Bitmap imageDB;
    LocalDateTime date;
    private final static int PICK_IMG_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_image_uploader_sql);


        textView = (TextView) findViewById(R.id.sqltextview);
        textView1 = (TextView) findViewById(R.id.sqltextview1);
        editText = (EditText) findViewById(R.id.sqledittext);
        SQLimageView = (ImageView) findViewById(R.id.sqlimage);
        button = (Button) findViewById(R.id.sqlbutton);
        next = (Button) findViewById(R.id.sqlnext);
        upload = (Button) findViewById(R.id.sqlupload);
        DB = new MyDataBase(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = editText.getText().toString();
                // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mario);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), tempimage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                temp=bitmap;
                byte[] img = byteArray.toByteArray();
                date = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy   HH:mm");

                boolean insert = DB.insertdata(name, img,String.valueOf(dateTimeFormatter.format(date)));
                if (insert == true) {
                    Toast.makeText(Record_image_uploader_sql.this, "Data Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Record_image_uploader_sql.this, "Data Not Saved",
                            Toast.LENGTH_SHORT).show();
                }

                imageDB = DB.getRecordImage(name);
                nameDB = DB.getRecordName(name);
                SQLimageView.setImageBitmap(imageDB);
                textView1.setText("The name entered by you is \n\n" + nameDB);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "pictures"), PICK_IMG_REQUEST);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Record_image_uploader_sql.this, Record_image_shower_sql.class);
                startActivity(intent);
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
            SQLimageView.setImageBitmap(bit);
            //    upload.setEnabled(false);
            //  save.setEnabled(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
