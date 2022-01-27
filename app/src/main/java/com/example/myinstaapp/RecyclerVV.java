package com.example.myinstaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerVV extends AppCompatActivity {

    RecyclerView rv;
    int id[]={12,13};
    int img[]={R.drawable.old,R.drawable.old2};
    String name[]={"karan","rahul"};
    String time[]={"10:00 AM","12:00 PM"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_vv);
        rv=findViewById(R.id.rv);

        recyclerview recyclerviewNN=new recyclerview(RecyclerVV.this,id,img,name,time);
        LinearLayoutManager linnn=new LinearLayoutManager(this);
        rv.setLayoutManager(linnn);
        rv.setAdapter(recyclerviewNN);
    }
}