package com.example.gymapplication;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Custom_Adaptor extends BaseAdapter {

    Context context;
    ArrayList<Single_row> arrayList;
    Custom_Adaptor(Context context){

        this.context=context;
       arrayList = new ArrayList<>();
        Resources res = context.getResources();
        String[] names = res.getStringArray(R.array.course);
        int[] images = {R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};

        for (int i=0;i<names.length;i++){
            arrayList.add(new Single_row(names[i],images[i]));
        }
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      //  LayoutInflater inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview,parent,false);
        TextView t1= row.findViewById(R.id.tempertextview);
        ImageView i1= row.findViewById(R.id.temperimageView);
        Single_row tem_obj= arrayList.get(position);
        t1.setText(tem_obj.text);
        i1.setImageResource(tem_obj.image);
        return row;

    }
}
