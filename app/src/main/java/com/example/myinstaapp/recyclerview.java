package com.example.myinstaapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerview extends RecyclerView.Adapter<recyclerview.myView_Holder> {

    Context context;
    int id[];
    int img[];
    String name[];
    String time[];

    public recyclerview(Context context,int id[],int img[],String name[],String time[]){
        this.context=context;
        this.id=id;
        this.img=img;
        this.name=name;
        this.time=time;
    }
    @NonNull
    @Override
    public myView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.customrecycler,parent,false);
        return new myView_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myView_Holder holder, int pos) {

        holder.img.setImageResource(img[pos]);
        holder.tv1.setText(id[pos]+"");
        holder.tv2.setText(name[pos]);
        holder.tv3.setText(time[pos]);


    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    class myView_Holder extends RecyclerView.ViewHolder
    {

        ImageView img;
        TextView tv1,tv2,tv3;
        public myView_Holder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.imviewrv);
            tv1=itemView.findViewById(R.id.txt1rv);
            tv2=itemView.findViewById(R.id.txt2rv);
            tv3=itemView.findViewById(R.id.txt3rv);


        }
    }
}
