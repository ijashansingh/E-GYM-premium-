package com.example.gymapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class profileFragment extends Fragment  {
    View cardviewholder2,cardview2,cardview3,cardview4,cardview5,profile;
    NavigationView navigationView;
    FragmentManager fragmentManager2;
    int cal_no;
    DrawerLayout drawerLayout;
    MainActivity mainActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

cardviewholder2 = view.findViewById(R.id.profile_cardview1);
        cardview2=view.findViewById(R.id.calendarview3);
        cardview3=view.findViewById(R.id.profile_cardview2);
        cardview4=view.findViewById(R.id.calendarview4);
     //   profile=view.findViewById(R.id.profile);
        cardview5=view.findViewById(R.id.calendarview_calcu);
        navigationView = view.findViewById(R.id.nav_view);
        drawerLayout =view.findViewById(R.id.profile);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new fragment_calculators();
                        cal_no=0;
                        break;
                    case R.id.discover:
                        fragment = new fragment_calculators();
                        cal_no=1;
                        break;

                    case R.id.profile:
                        fragment = new fragment_calculators();
                        cal_no=2;
                        break;

                    case R.id.lossweight:
                        fragment = new fragment_calculators();
                        cal_no=3;
                        break;
                    case R.id.increaseweight:
                        fragment = new fragment_calculators();
                        cal_no=4;
                        break;
                }
                if (fragment != null) {

                    Bundle bundle = new Bundle();
                    String myMessage = "Stackoverflow is cool!";
                    bundle.putInt("message", cal_no );

                    fragment.setArguments(bundle);
                    fragmentManager2 = getParentFragmentManager();
                    fragmentManager2.beginTransaction().replace(R.id.fragment_container_profile, fragment).commit();




// set Fragmentclass Arguments

                    Log.d("cali", "onNavigationItemSelected: "+cal_no);
                    fragment.setArguments(bundle);
                } else {
                    Log.e("binn", "Error in creating Fragment");
                }
                return true;
            }
        });


        cardviewholder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Record_image_uploader_sql.class);
                startActivity(intent);
                Log.d("hmm", "onClick: "+intent);

            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Graphs_weight.class);
                startActivity(intent);
                Log.d("hmm", "onClick: "+intent);

            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Record_image_shower_sql.class);
                startActivity(intent);
                Log.d("hmm", "onClick: "+intent);

            }
        });
       // drawerLayout = findViewById(R.id.drawerlayout);
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Exeercise_data.class);
                startActivity(intent);
                Log.d("hmm", "onClick: "+intent);

            }
        });
        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.END);

            }
        });


        return view;
    }
}