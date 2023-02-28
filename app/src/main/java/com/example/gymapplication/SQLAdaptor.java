package com.example.gymapplication;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SQLAdaptor extends RecyclerView.Adapter<SQLAdaptor.SQLViewholder> {
    private List<SQLmodelclass> userlist;


    public SQLAdaptor(List<SQLmodelclass> userlist) {
        this.userlist=userlist;
    }

    @NonNull
    @Override
    public SQLAdaptor.SQLViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new SQLViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SQLAdaptor.SQLViewholder holder, int position) {
        Bitmap resource = userlist.get(position).getSqlimageview1();
        String name = userlist.get(position).getSqltextview1();
        String level = userlist.get(position).getSqltextview2();


        holder.sqlimageView1.setImageBitmap(resource);
        holder.sqltextView1.setText(name);
        holder.sqltextView2.setText(level);
        Log.d("bansal", "onBindViewHolder: "+userlist.size());

    }



    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public static class SQLViewholder extends RecyclerView.ViewHolder {
        ImageView sqlimageView1;
        TextView sqltextView1,sqltextView2 ;
        public SQLViewholder(@NonNull View itemView) {
            super(itemView);



            sqlimageView1=itemView.findViewById(R.id.imageTV2);
            sqltextView1=itemView.findViewById(R.id.imagedetailsTV2);
            sqltextView2=itemView.findViewById(R.id.leveldetailsTV2);


        }
    }
}
