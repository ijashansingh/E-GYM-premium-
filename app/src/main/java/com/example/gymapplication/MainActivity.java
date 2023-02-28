package com.example.gymapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity  {
    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    private String Tag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();




        chipNavigationBar = findViewById(R.id.botton_navigation);


        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        String firsttime = preferences.getString("FirstTimeInstall","Yes");

        if(firsttime.equals("Yes")){

            Intent intent = new Intent(MainActivity.this,Form_only_onetime.class);
        startActivity(intent);
        }
        else{


        }


        defaultfragment();
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {


                switch (id) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.discover:
                        fragment = new DiscoverFragment();
                        break;

                    case R.id.profile:
                        fragment = new profileFragment();
                        break;
                }


                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();


                } else {
                    Log.e(Tag, "Error in creating Fragment");
                }
            }
        });

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FirstTimeInstall","no");
        editor.apply();
    }
private void defaultfragment() {
    fragment = new HomeFragment();
    fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

}

}




