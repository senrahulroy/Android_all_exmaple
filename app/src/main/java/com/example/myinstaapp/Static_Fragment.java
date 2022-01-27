package com.example.myinstaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Static_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Button btn6;
        View v=inflater.inflate(R.layout.fragment_static,null);
        btn6=v.findViewById(R.id.frag_btn);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"my Name is statick fragment " , Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}