package com.example.myinstaapp.SqliteDataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinstaapp.R;

import java.util.ArrayList;

public class RV_show_Adpater extends RecyclerView.Adapter <RV_show_Adpater.My_Rv_show_View_Holder>{

     Context context;
     ArrayList<User>arrayList;
     private int position;

    public RV_show_Adpater(Context context, ArrayList<User>arrayList) {
        this.context= context;
        this.arrayList=arrayList;


    }

    @NonNull
    @Override
    public My_Rv_show_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_show_adpater,parent,false);

        return new My_Rv_show_View_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Rv_show_View_Holder holder, @SuppressLint("RecyclerView") int position) {

        holder.Sql_tv1.setText(arrayList.get(position).getId()+"");
        holder.Sql_tv2.setText(arrayList.get(position).getPerson_n()+"");
        holder.Sql_tv3.setText(arrayList.get(position).getPerson_e()+"");
        holder.Sql_tv4.setText(arrayList.get(position).getPerson_gender()+"");
        holder.Sql_tv5.setText(arrayList.get(position).getPerson_hobbey()+"");

        holder.Edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Edit_Update.class);
                intent.putExtra("id",arrayList.get(position).getId());
                intent.putExtra("name",arrayList.get(position).getPerson_n());
                intent.putExtra("email",arrayList.get(position).getPerson_e());
                intent.putExtra("gender",arrayList.get(position).getPerson_gender());
                intent.putExtra("hobbey",arrayList.get(position).getPerson_hobbey());


                context.startActivity(intent);


            }
        });

        holder.Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dBhelper=new DBhelper(v.getContext());
                int delete_id=arrayList.get(position).getId();
                dBhelper.deletedata(delete_id);
                Toast.makeText(v.getContext(), "Delete", Toast.LENGTH_SHORT).show();
                Show show=new Show();
                Show.refresh();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  My_Rv_show_View_Holder extends RecyclerView.ViewHolder{

        TextView Sql_tv1,Sql_tv2,Sql_tv3,Sql_tv4,Sql_tv5;
        Button Edit_btn,Delete_btn;
        public My_Rv_show_View_Holder(@NonNull View itemView) {
            super(itemView);
            Sql_tv1=itemView.findViewById(R.id.Sql_tv1);
            Sql_tv2=itemView.findViewById(R.id.Sql_tv2);
            Sql_tv3=itemView.findViewById(R.id.Sql_tv3);
            Sql_tv4=itemView.findViewById(R.id.Sql_tv4);
            Sql_tv5=itemView.findViewById(R.id.Sql_tv5);
            Edit_btn=itemView.findViewById(R.id.edit_btn);
            Delete_btn=itemView.findViewById(R.id.delete_btn);

        }
    }
}

