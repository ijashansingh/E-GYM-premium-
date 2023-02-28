package com.example.gymapplication;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.Handler;


public class Adaptorplay extends RecyclerView.Adapter<Adaptorplay.Viewholder> {

    playactivity playactivityobj;
    private List<modelclass>userlist;
    public    ArrayList<modelclass> checked_exercieces=new ArrayList<>();
    private Viewholder.OnNoteListener mOnotelistener;
    public Adaptorplay(List<modelclass>userlist, Viewholder.OnNoteListener OnNoteListener){
        this.userlist=userlist;
        this.mOnotelistener = OnNoteListener;

    }

    @NonNull
    @Override
    public Adaptorplay.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design2,parent,false);
         return new Viewholder(view,mOnotelistener);

    }

    @Override
    public void onBindViewHolder(@NonNull Adaptorplay.Viewholder holder, int position) {
        // ArrayList<modelclass> checked_exercieces=new ArrayList<>();
        String serial_no = String.valueOf(position + 1);
        //  int resource = userlist.get(position).getImageview1();
        String name = userlist.get(position).getTextview1();
        String level = userlist.get(position).getTextview2();
        boolean check = userlist.get(position).isSelected();

        holder.checkBox.setChecked(check);
        holder.serial.setText(serial_no);
        holder.textView1.setText(name);
        holder.textView2.setText(level);


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (holder.checkBox.isChecked()) {

                    holder.linear1.setBackgroundColor(Color.parseColor("#FF0000"));
                    checked_exercieces.add(userlist.get(position));
//                    checked_exercieces.notifyAll();
                } else if (!holder.checkBox.isChecked()) {

                    checked_exercieces.remove(userlist.get(position));
                    holder.linear1.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    //  Log.d("checksy", "onCheckedChanged: "+checked_exercieces);
                    //   playactivityobj = new playactivity();
                    // checked_exercieces = new ArrayList<>();

                }
                if(checked_exercieces.size()==userlist.size()){
                    mOnotelistener.allitemcheck();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
       return userlist.size();

    }

    public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView serial;
        View linear1;
        TextView textView1,textView2 ;
        OnNoteListener onNoteListener;

       public  CheckBox checkBox;
        public Viewholder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            serial=itemView.findViewById(R.id.serialno);
            textView1=itemView.findViewById(R.id.rv_textview);
            textView2=itemView.findViewById(R.id.rv_textView2);
            checkBox=itemView.findViewById(R.id.rv_checker);
            linear1 = itemView.findViewById(R.id.linear1);


            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);




        }
        @Override
        public void onClick(View v) {
            onNoteListener.OnNoteClick(getAdapterPosition());
        }

        public interface OnNoteListener{


            void OnNoteClick(int adapterPosition);
            void allitemcheck();
        }



    }

}
