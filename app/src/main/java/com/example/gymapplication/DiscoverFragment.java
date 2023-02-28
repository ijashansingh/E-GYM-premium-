package com.example.gymapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment  implements HomeFragmentAdaptor.Viewholder.OnNoteListener {

    Button tableDialog;
    EditText addtableET;
    MyDataBase DB;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> userlist;
    List<String> tablename;
    playlistAdaptor adaptor;
    Button shower;
    MyDataBase objectdatabaseHandler;
    ArrayList<modelclass> banasluserlist;

    View view;
    DialogInterface dialog;
    String name;

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerview();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view  = inflater.inflate(R.layout.fragment_discover, container, false);

       shower=view.findViewById(R.id.tablenamebutton);
        addtableET=view.findViewById(R.id.addtableDF);
        tableDialog=view.findViewById(R.id.dialog_newtable);

        objectdatabaseHandler=new MyDataBase(getActivity());
        userlist = new ArrayList<>();
        final EditText editTextField = new EditText(getContext());

        tableDialog.setOnClickListener(v -> {


            //  initdata2();
            Context context = getActivity();

            userlist = new ArrayList<>();
            //userlist=homeFragment.userlist;




                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                LayoutInflater inflater1 = LayoutInflater.from(context);

                builder.setView(editTextField);
                editTextField.setHint("TABLE NAME");

                builder.setTitle("CREATE A NEW PLAYLIST");


// add OK and Cancel buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        //name = String.valueOf(editTextField.getText());
                        name= String.valueOf(editTextField.getText()).replace(" ", "");

                        newtable();
                        dialog.dismiss();



                    }

                });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener()  {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    ((ViewGroup)editTextField.getParent()).removeView(editTextField);
                }
            });

                builder.setNegativeButton("Cancel", null);
// create and show the alert dialog
            if (dialog==null){
                AlertDialog dialog = builder.create();
                dialog.show();
            }else{
                dialog=null;
            }



            });


        shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRecyclerview();
            }
        });



        return view;
    }
public void newtable(){

    Context context = getActivity();
    DB =new MyDataBase(context);

//    String tablename =editTextField.getText().toString();

        DB.AddDesiredTable(name);






   // addtableET = new EditText(getActivity());
  //  addtableET.getText().toString();
 //   String abc=addtableET.getText().toString();
    //editTextField = new EditText(this.)
    onResume();
    Log.d("zen2", "onClick: "+name);



}


    private void initRecyclerview() {


        recyclerView =view.findViewById(R.id.tablenameRV);
        layoutManager= new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        banasluserlist = objectdatabaseHandler.tablelist2();
        adaptor =  new playlistAdaptor(banasluserlist,this::OnNoteClick);
        userlist= banasluserlist;
        tablename=objectdatabaseHandler.tablelistnames();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();
    }


    @Override
    public void OnNoteClick(int adapterPosition) {
        userlist.get(adapterPosition);



        Intent intent;

        intent = new Intent(getActivity(),PlayList_DataShower.class);

        intent.putExtra("positioner",adapterPosition);

        intent.putExtra("namepositioner", String.valueOf(tablename));


        startActivity(intent);

    }

}


