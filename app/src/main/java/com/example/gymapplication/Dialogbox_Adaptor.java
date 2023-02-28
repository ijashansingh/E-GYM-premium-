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

public class Dialogbox_Adaptor extends RecyclerView.Adapter<Dialogbox_Adaptor.Viewholder> {

    private List<modelclass> userlist;
    private Viewholder.OnNoteListenerDA mOnotelistener;

    public Dialogbox_Adaptor(List<modelclass> userlist, Viewholder.OnNoteListenerDA OnNoteListenerDA) {
        this.userlist=userlist;
        this.mOnotelistener = OnNoteListenerDA;
    }

    @NonNull
    @Override
    public Dialogbox_Adaptor.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_single_row,parent,false);
        return new Dialogbox_Adaptor.Viewholder(view,mOnotelistener);
    }

    @Override
    public void onBindViewHolder(@NonNull Dialogbox_Adaptor.Viewholder holder, int position) {
        int resource = userlist.get(position).getImage();
        String name = userlist.get(position).getTextview1();
        String level = userlist.get(position).getTextview2();
        Log.d("billu", "onBindViewHolder: "+userlist.size());



        //  holder.imageViewTV.setImageResource(resource);
        holder.imageView1.setImageResource(resource);
        holder.textView1.setText(name);

    }



    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView1;
        TextView textView1;
       OnNoteListenerDA onNoteListenerDA;
        public Viewholder(@NonNull View itemView, OnNoteListenerDA mOnotelistener) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageTV2);
            textView1=itemView.findViewById(R.id.imagedetailsTV2);

            this.onNoteListenerDA =mOnotelistener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListenerDA.OnNoteClickDA(getAdapterPosition());
        }

        public interface OnNoteListenerDA {


            void OnNoteClickDA(int adapterPosition);
        }
    }
}
