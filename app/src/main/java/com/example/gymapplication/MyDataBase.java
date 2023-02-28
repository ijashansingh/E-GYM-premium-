package com.example.gymapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {



  // private List<clusterclass> userlist;

    public MyDataBase(Context context) {
        super(context, "name9.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      //  db.execSQL("create table tableimage  (name text , image blob,muscle text, image text);");
        db.execSQL("create table tableimage  (Musclename text , Exercisename text,image text, Exercisedescription text,thumbnailimage text);");
        db.execSQL("create table IF NOT EXISTS Recordimage (name text, image blob,date text);");
        db.execSQL("create table IF NOT EXISTS GraphTable  (xvalue TEXT,yvalue TEXT);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tableimage");
    }

    public boolean insertdata( String Musclename, String Exercisename,int image,String Exercisedescription,int thumbnailimage){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("musclename", Musclename);
        contentValues.put("Exercisename", Exercisename);
        contentValues.put("image", image);
        contentValues.put("Exercisedescription", Exercisedescription);
        contentValues.put("thumbnailimage", thumbnailimage);
        long ins = MyDB.insert("tableimage", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }



    public String getName(String name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tableimage where musclename = ?", new String[]{name});
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public Bitmap getImage(String name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tableimage where musclename = ?", new String[]{String.valueOf(name)});
       cursor.moveToFirst();
        byte[] bitmap = cursor.getBlob(1);
        Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0 , bitmap.length);
        return image;
    }
    public String getmusclename(String muscle){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tableimage where musclename = ?", new String[]{muscle});
        cursor.moveToFirst();
        return cursor.getString(2);
    }
    public  void AddDesiredTable(String TableNmae){

        SQLiteDatabase ourDatabase=this.getWritableDatabase();




        ourDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TableNmae+ " ("
                + "Musclename text , " +  "Exercisename text, "
                + "image text NOT NULL,Exercisedescription text,thumbnailimage text);");


    }

    public void datacopy(String data,String tablename){

        SQLiteDatabase MyDB = this.getWritableDatabase();

        MyDB.execSQL("INSERT INTO "+tablename+";");

    }
    public void deletetable(String tablename){

        SQLiteDatabase MyDB = this.getWritableDatabase();

        MyDB.execSQL("DROP TABLE "+tablename+";");


    }

    public void datacopyer(String data,String tablename){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("INSERT INTO "+tablename+" SELECT *FROM tableimage where Exercisename = '"+ data +"';");

    }
public void updateset(String data,String tablename,String sets){
    SQLiteDatabase MyDB = this.getWritableDatabase();

    MyDB.execSQL("UPDATE "+tablename+" SET thumbnailimage = '"+ sets +"'WHERE Exercisename ='"+data+"';");


}
        public  ArrayList<modelclass> getallImagesdata(){

            SQLiteDatabase MyDB = this.getReadableDatabase();
            ArrayList<modelclass> userlist = new ArrayList<>();

            Cursor cursor = MyDB.rawQuery("Select * from tableimage ", null);
            if (cursor.getCount() != 0) {
                while (cursor.moveToNext()) {

                    String textview1 = cursor.getString(0);
                    String textview2 = cursor.getString(1);
                    int imageview1 = cursor.getInt(2);
                    int thumbnail = cursor.getInt(4);

                    userlist.add(new modelclass(imageview1, textview1, textview2,thumbnail));
                }

            }

            return userlist;
        }


    public  ArrayList<modelclass> getimagebyname(String name){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ArrayList<modelclass> userlist = new ArrayList<>();

        Log.d("nice", "getimagebyname: "+name);
        Cursor cursor = MyDB.rawQuery("Select * from "+name+" ", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                String textview1 = cursor.getString(0);
                String textview2 = cursor.getString(1);
                int imageview1 = cursor.getInt(2);
                int thumbnail = cursor.getInt(4);

                userlist.add(new modelclass(imageview1, textview1, textview2,thumbnail));
            }

        }

        return userlist;}

    public  ArrayList<modelclass> getbackdata(String name){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ArrayList<modelclass> userlist = new ArrayList<>();

        Cursor cursor = MyDB.rawQuery("Select * from tableimage where musclename ='"+name+"'", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                String textview1 = cursor.getString(0);
                String textview2 = cursor.getString(1);
                int imageview1 = cursor.getInt(2);
                int thumbnail = cursor.getInt(4);

                userlist.add(new modelclass(imageview1, textview1, textview2,thumbnail));
            }

        }

        return userlist;
    }

    public  ArrayList<modelclass> tablelist2() {
        SQLiteDatabase MyDB = this.getReadableDatabase();

        ArrayList<modelclass> arrTblNames = new ArrayList<modelclass>();

        Cursor c = MyDB.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
int i = 0;
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {


                String textview1 = c.getString(0);
                if (i==0) {
                    c.moveToNext();

                }

                else if (i==1) {
                    c.moveToNext();

                }
             else {
                 arrTblNames.add(new modelclass(0, textview1, null,0));
             }


                    Log.d("tableimagetag", "tablelist2: "+textview1);

                    c.moveToNext();
                    i++;


            }
        }

        return arrTblNames;
    }
    public  ArrayList<String> tablelistnames() {
        SQLiteDatabase MyDB = this.getReadableDatabase();

       ArrayList<String> arrTblNames = new ArrayList<String>();

        Cursor c = MyDB.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
int i =0;
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                String textview1 = c.getString(0);
                if (i==0) {
                    c.moveToNext();

                }

               else if (i==1) {
                    c.moveToNext();

                }



                else {

                    Log.d("bill", "tablelist2: " + textview1);
                    arrTblNames.add(textview1);
                }
                    c.moveToNext();
                   i++;}}
        return arrTblNames;
    }

    public String getRecordName(String name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Recordimage where name = ?", new String[]{name});
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public Bitmap getRecordImage(String name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Recordimage where name = ?", new String[]{String.valueOf(name)});
        cursor.moveToFirst();
        byte[] bitmap = cursor.getBlob(1);
        Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0 , bitmap.length);
        return image;
    }


    public boolean insertdata(String username, byte[] img, String date){


        SQLiteDatabase MyDB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", username);
        contentValues.put("image", img);
        contentValues.put("date", date);
        long ins = MyDB.insert("Recordimage", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public ArrayList<SQLmodelclass> getrecordimagedata() {

        SQLiteDatabase MyDB = this.getReadableDatabase();
        ArrayList<SQLmodelclass> SQLuserlist = new ArrayList<>();

        Cursor cursor = MyDB.rawQuery("Select * from Recordimage", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String textview1 = cursor.getString(0);
                byte[] imageview1 = cursor.getBlob(1);
                String textview2 = cursor.getString(2);



                Bitmap objectbitmap = BitmapFactory.decodeByteArray(imageview1, 0, imageview1.length);
                SQLuserlist.add(new SQLmodelclass(objectbitmap, textview1, textview2));
            }}
        return SQLuserlist;}
    public boolean insertGraphdata(Long xvalue,float yvalue){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("xvalue", xvalue);
        contentValues.put("yvalue", yvalue);

        long ins = MyDB.insert("GraphTable", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

        public  ArrayList<modelclass> getdetailerdata(String name){
            SQLiteDatabase MyDB = this.getReadableDatabase();
            ArrayList<modelclass> userlist = new ArrayList<>();

            Cursor cursor = MyDB.rawQuery("Select * from tableimage where musclename ='"+name+"'", null);
            if (cursor.getCount() != 0) {
                while (cursor.moveToNext()) {

                    String textview1 = cursor.getString(1);
                    String textview2 = cursor.getString(3);
                    int imageview1 = cursor.getInt(2);
                    int thumbnail = cursor.getInt(4);

                    userlist.add(new modelclass(imageview1, textview1, textview2,thumbnail));
                }}
            return userlist;}
    public  ArrayList<modelclass> getplaydetailerdata(String name,String tablename){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        ArrayList<modelclass> userlist = new ArrayList<>();

       // Cursor cursor = MyDB.rawQuery("Select * from'"+tablename+"'", null);
        Cursor cursor = MyDB.rawQuery( "Select * from "+tablename+" ", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                String textview1 = cursor.getString(1);
                String textview2 = cursor.getString(3);
                int imageview1 = cursor.getInt(2);
                int thumbnail = cursor.getInt(4);

                userlist.add(new modelclass(imageview1, textview1, textview2,thumbnail));
            }}
        return userlist;}}


