package com.example.myinstaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customadpater extends BaseAdapter {

    Context context;
    int[] img;
    int[] id;
    String[] name;
    String[] time;
    int pos;
    int c=1;

    public Customadpater(Context context, int[] img, int[] id, String[] name, String[] time,int pos){
        this.context=context;
        this.img=img;
        this.id=id;
        this.name=name;
        this.time=time;
        this.pos=pos;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.customadpater,null);
        TextView id1=v.findViewById(R.id.id);
        TextView tv1=v.findViewById(R.id.txt1);
        TextView tv2=v.findViewById(R.id.txt2);
        ImageView img1=v.findViewById(R.id.imview);
        id1.setText(id[pos]+"");
        tv1.setText(name[pos]);
        tv2.setText(time[pos]);
        img1.setImageResource(img[pos]);
        return v;
    }
}
