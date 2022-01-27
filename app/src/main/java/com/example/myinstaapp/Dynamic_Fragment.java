package com.example.myinstaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Dynamic_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Button btn;
        View v= inflater.inflate(R.layout.fragment_dynamic_,null);
        btn=v.findViewById(R.id.frag_btn_Dy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dynamic_Fragment2 Df=new Dynamic_Fragment2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.dynamic_fragment,Df);
                ft.addToBackStack("rahul");
                ft.commit();

                Toast.makeText(getActivity(), "i am dynamic fragment secound", Toast.LENGTH_SHORT).show();
            }
        });
        return  v;
    }
}