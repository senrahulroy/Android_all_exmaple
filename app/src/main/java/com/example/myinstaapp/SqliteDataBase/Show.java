package com.example.myinstaapp.SqliteDataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myinstaapp.R;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

      static RecyclerView rv;
      static    ArrayList<User>arrayList;
      static    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rv=findViewById(R.id.show_sqlite);
        arrayList=new ArrayList<>();
        DBhelper dBhelper=new DBhelper(Show.this);
        arrayList= (ArrayList<User>) dBhelper.Show();

//        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
//        rv.setLayoutManager(linearLayoutManager);
//        RV_show_Adpater rv_show_adpater = new RV_show_Adpater(Show.this,arrayList);
        refresh();
    }

    public static void refresh(){
        DBhelper dBhelper=new DBhelper(rv.getContext());
        arrayList= (ArrayList<User>) dBhelper.Show();

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(context);
        rv.setLayoutManager(linearLayoutManager);
        RV_show_Adpater rv_show_adpater = new RV_show_Adpater(context,arrayList);
        rv.setAdapter(rv_show_adpater);
        rv.setAdapter(rv_show_adpater);
    }
}