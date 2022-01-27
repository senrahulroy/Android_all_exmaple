package com.example.myinstaapp;

import static com.example.myinstaapp.R.menu.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myinstaapp.SqliteDataBase.SqliteMain;
import com.example.myinstaapp.onlineDatabase.Retrofit_main;
import com.example.myinstaapp.roomdatabase.Room_main;

public class Second extends AppCompatActivity implements View.OnClickListener {

    TextView Suser,Spass;
    ListView lv;

    Button btn1,btn2,btn3,btn4,btn5,btn6, btn7,btn8,btn9;
    int[] img ={R.drawable.old,R.drawable.old2};
    String[] name ={"Jay","Rahul"};
    String[] time ={"11:00 AM","12:00 PM"};
    int id[]={1,2};

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        getSupportActionBar().hide();
        getSupportActionBar().setTitle("My Menu");
        setContentView(R.layout.activity_second);


        Suser=findViewById(R.id.Username);
        Spass=findViewById(R.id.Password);
        lv=findViewById(R.id.lv);
        btn1=findViewById(R.id.jay);
        btn2=findViewById(R.id.rahul);
        btn3=findViewById(R.id.rcv);
        btn4=findViewById(R.id.alldialog);
        btn5=findViewById(R.id.allmenu);
        btn6=findViewById(R.id.tb_layout);
        btn7=findViewById(R.id.sqlitebtn);
        btn8=findViewById(R.id.roomd);
        btn9=findViewById(R.id.retrofit_db);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tbintent = new Intent(Second.this,Tab_layout.class);
                startActivity(tbintent);
//                finish();

            }
        });
        //  this code Demostras as a dynamic fragment //

        Dynamic_Fragment Df=new Dynamic_Fragment();
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.dynamic_fragment,Df);
        ft.commit();
        // end of Dynamic fragment


        Intent Nintent =getIntent();

           String Iuser=Nintent.getStringExtra("Iuser");
           String Ipass=Nintent.getStringExtra("IPass");

        Suser.setText(Iuser);
        Spass.setText(Ipass);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v==btn1){
            int pos=0;
            Customadpater customadpater=new Customadpater(Second.this,img,id,name,time,pos);
            lv.setAdapter(customadpater);
            customadpater.notifyDataSetChanged();


        }
        else if (v==btn2){
            int pos=1;
            Customadpater Customadpater1=new Customadpater(Second.this,img,id,name,time,pos);
            lv.setAdapter(Customadpater1);
            Customadpater1.notifyDataSetChanged();
        }
        else if(v==btn3){
            Intent inttt=new Intent(Second.this,RecyclerVV.class);
            startActivity(inttt);
//            finish();

        }
        else if(v==btn4){
            Intent Alldialog =new Intent(Second.this,Alldialogs.class);
            startActivity(Alldialog);
        }
        else if(v==btn5){
            Intent allmenu = new  Intent(Second.this,All_Menu.class);
            startActivity(allmenu);
        }
        else if (v==btn7){
            Intent sqlintent= new Intent(Second.this, SqliteMain.class);
            startActivity(sqlintent);
        }
        else if(v==btn8){
            Intent room=new Intent(Second.this, Room_main.class);
            startActivity(room);
        }else if(v==btn9){
            Intent retrofit=new Intent(Second.this, Retrofit_main.class);
            startActivity(retrofit);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.item1){
            Toast.makeText(Second.this, "Selected"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.item2){

            Toast.makeText(Second.this, "Selected"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.item3){

            Toast.makeText(Second.this, "Selected"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.item4){
            Toast.makeText(Second.this, "Selected"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        // this is for submenu setting

        else if(item.getItemId()==R.id.darktheme){
            Toast.makeText(Second.this, "Selected : "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.acsetting){
            Toast.makeText(Second.this, "Selected : "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.chatsetting){
            Toast.makeText(Second.this, "Selected : "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.appbackup){
            Toast.makeText(Second.this, "Selected : "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(Second.this, "Selected Item : "+item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case R.id.search:
            case R.id.bookmark:
            case R.id.print:
            case R.id.share:
            case R.id.copy:
            case R.id.upload:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
     //return super.onOptionsItemSelected(item);
    }

    // this code demostrat fragment back setup it mean you will entery in to fragment to fragment then you want to back
    // with spacific fragment wise then you will do belowm method for it
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount()>0)
        {
            getSupportFragmentManager().popBackStack();
        }
        else

        {
            super.onBackPressed();
        }
    }
}