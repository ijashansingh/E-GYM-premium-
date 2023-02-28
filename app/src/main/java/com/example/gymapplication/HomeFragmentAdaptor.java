package com.example.gymapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


    public class HomeFragmentAdaptor extends RecyclerView.Adapter<HomeFragmentAdaptor.Viewholder> {

        private List<modelclass> userlist;
        private Viewholder.OnNoteListener mOnotelistener;
        public HomeFragmentAdaptor(List<modelclass>userlist,Viewholder.OnNoteListener OnNoteListener){
            this.userlist=userlist;
            this.mOnotelistener = OnNoteListener;
        }

        @NonNull
        @Override
        public HomeFragmentAdaptor.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);

            return new Viewholder(view,mOnotelistener);
        }

        @Override
        public void onBindViewHolder(@NonNull HomeFragmentAdaptor.Viewholder holder, int position) {

            int resource = userlist.get(position).getImage();
            String name = userlist.get(position).getTextview1();
            String level = userlist.get(position).getTextview2();



            holder.imageView.setImageResource(resource);
            holder.textView1.setText(name);
            holder.textView2.setText(level);

        }

        @Override
        public int getItemCount() {
            return userlist.size();
        }

        public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView;
            TextView textView1,textView2 ;
            OnNoteListener onNoteListener;
            public Viewholder(@NonNull View itemView, OnNoteListener onNoteListener) {
                super(itemView);

                imageView=itemView.findViewById(R.id.rv_imageview1);
                textView1=itemView.findViewById(R.id.rv_textview);
                textView2=itemView.findViewById(R.id.rv_textview2);


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


