package com.example.gymapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  implements HomeFragmentAdaptor.Viewholder.OnNoteListener {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
   public static List<modelclass> userlist;
    HomeFragmentAdaptor adaptor;



    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView =view.findViewById(R.id.HomeFragmentRV);



                initdata();
                initRecyclerview();
        Log.d("jad", "onCreateView: "+userlist);
                    return view;
            }

            public  static void initdata() {
                userlist = new ArrayList<>();

                userlist.add(new modelclass(R.drawable.chest_bodypart,"CHEST","BODY PART",0));

                userlist.add(new modelclass(R.drawable.back_bodypart,"BACK","BODY PART",0));

                userlist.add(new modelclass(R.drawable.biceps__bodypart,"BICEPS","BODY PART",0));

                userlist.add(new modelclass(R.drawable.tricep_bodypart,"TRICEPS","BODY PART",0));

                userlist.add(new modelclass(R.drawable.legs_bodypart,"LEGS","BODY PART",0));

                userlist.add(new modelclass(R.drawable.shoulder_bodypart,"SHOULDER","BODY PART",0));

             //   userlist.add(new modelclass(R.drawable.mario,"make new exercise","BODY PART",0));

            }

            private void initRecyclerview() {

                layoutManager= new LinearLayoutManager(getActivity());
                GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adaptor = new HomeFragmentAdaptor(userlist,this);
                recyclerView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();
            }



            @Override
            public void OnNoteClick(int position) {
                userlist.get(position);
                Intent intent;
            //    if (position!=6) {
                    intent = new Intent(getActivity(), Excercise_datashower.class);
                    intent.putExtra("positioner",position);
            //    }
              /*  else {
                    intent = new Intent(getActivity(), Exeercise_data.class);
                    intent.putExtra("positioner",position);
                }*/
               // intent.putExtra("positioner",position);



                startActivity(intent);

            }

        }
