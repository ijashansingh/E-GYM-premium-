package com.example.gymapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adaptor extends RecyclerView.Adapter<Adaptor.Viewholder> {

    private List<modelclass>userlist;
    private Viewholder.OnNoteListener mOnotelistener;
    public Adaptor(List<modelclass>userlist, Viewholder.OnNoteListener OnNoteListener){
        this.userlist=userlist;
        this.mOnotelistener = OnNoteListener;
    }

    @NonNull
    @Override
    public Adaptor.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
         return new Viewholder(view,mOnotelistener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor.Viewholder holder, int position) {

        int resource = userlist.get(position).getImage();
        String name = userlist.get(position).getTextview1();
        String level = userlist.get(position).getTextview2();
        Log.d("billu", "onBindViewHolder: "+userlist.size());



      //  holder.imageViewTV.setImageResource(resource);
        holder.imageView1.setImageResource(resource);
        holder.textView1.setText(name);
        holder.textView2.setText(level);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView1;
        TextView textView1,textView2 ;
        OnNoteListener onNoteListener;
        public Viewholder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageTV2);
            textView1=itemView.findViewById(R.id.imagedetailsTV2);
            textView2=itemView.findViewById(R.id.leveldetailsTV2);

            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            onNoteListener.OnNoteClick(getAdapterPosition());
        }

        public interface OnNoteListener{


            void OnNoteClick(int adapterPosition);
        }


    }

}
