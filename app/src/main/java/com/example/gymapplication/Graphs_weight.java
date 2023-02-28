package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.series.DataPoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class Graphs_weight extends AppCompatActivity {

    Button button,next;
    EditText editText;
    MyDataBase database;
    LineChartView graph;
    lecho.lib.hellocharts.model.Viewport viewport;
    //  Viewport viewport;
    SQLiteDatabase sqLiteDatabase;
    List yAxisValues = new ArrayList();
    List axisValues = new ArrayList();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("dd-MM-yyyy");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs_weight);


        graph = findViewById(R.id.graph2);
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editText2);
        database = new MyDataBase(this);
        sqLiteDatabase = database.getWritableDatabase();


        graphydata();
        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                insertdata();



                graphydata();
            }
        });
    }

        private void graphydata() {
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));



        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setName("DATE");
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("MEASURES IN CM");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        grabdata();
        graph.setLineChartData(data);

        graph.setHorizontalScrollBarEnabled(true);
        viewport = new lecho.lib.hellocharts.model.Viewport(graph.getMaximumViewport());
        viewport.right = 3;
        //  graph.setMaximumViewport(viewport);
        graph.setCurrentViewport(viewport);

    }




    private void insertdata() {

        long xvalue= new Date().getTime();
        //xvalues is time
        float yvalues = Integer.parseInt(String.valueOf(editText.getText()));
        database.insertGraphdata(xvalue,yvalues);


    }

    private DataPoint[] grabdata() {
        SQLiteDatabase MyDB  = database.getReadableDatabase();

        //  SQLiteDatabase MyDB = Database.getReadableDatabase();
        //  ArrayList<modelclass> userlist =

        String [] columns = {" xvalue , yvalue "};

        //  Cursor cursor = MyDB.rawQuery("Select * from table1 ", null);
        Cursor cursor = MyDB.query("GraphTable",columns,null,null,null,null,null);

        DataPoint [] dataPoints = new DataPoint[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i++) {
            cursor.moveToNext();
            dataPoints[i]= new DataPoint(cursor.getLong(0),cursor.getInt(1));
            //  yAxisValues.add(cursor.getLong(0));

            //   yAxisValues.add(i, new AxisValue(i).setLabel(String.valueOf(cursor.getLong(0))));
            yAxisValues.add(new PointValue(i, cursor.getLong(1)));
            //    axisValues.add(i, new AxisValue(i).setLabel(String.valueOf(cursor.getInt(0))));
            axisValues.add(i, new AxisValue(i).setLabel(formatLabel(cursor.getLong(0),true)));

        }
        return dataPoints;
    }
    public String formatLabel(double value, boolean isValueX) {
        if (isValueX) {
            return simpleDateFormat.format(new Date((long) value));
        } else {
            return formatLabel(value, isValueX);
        }
    }
    public  void getallImagesdata(){

        SQLiteDatabase MyDB = database.getReadableDatabase();
        // ArrayList<modelclass> userlist = new ArrayList<>();

        Cursor cursor = MyDB.rawQuery("Select * from table1 ", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {

                long textview1 = cursor.getLong(0);
                int textview2 = cursor.getInt(1);


                yAxisValues.add(textview2);
                axisValues.add(textview1);

            }

        }
        


    }

    }
