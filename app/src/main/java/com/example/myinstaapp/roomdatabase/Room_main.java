package com.example.myinstaapp.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myinstaapp.R;
import com.example.myinstaapp.SqliteDataBase.User;

public class Room_main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    EditText personName,personEmail;
    RadioGroup radioGroup;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    SwitchCompat moreoption;
    FrameLayout more_frame;
    Button btn_add,btn_show;
    String gender="";
    String hobbey="" , h1="",h2="",h3="",h4="",h5="",h6="";

    AppDatabase appDatabase;

    Boolean storeSwtich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_main);
        getSupportActionBar().hide();
        personName=findViewById(R.id.person_name);
        personEmail=findViewById(R.id.email);
        radioGroup=findViewById(R.id.radio_gp);
        cb1=findViewById(R.id.chess);
        cb2=findViewById(R.id.rummy);
        cb3=findViewById(R.id.checker);
        cb4=findViewById(R.id.ludo);
        cb5=findViewById(R.id.carrom);
        cb6=findViewById(R.id.pinball);
        btn_add=findViewById(R.id.add_data);
        btn_show=findViewById(R.id.show_data);
        more_frame=findViewById(R.id.more_frame);

        moreoption=findViewById(R.id.more_option);


        SharedPreferences sharedpre =getSharedPreferences("Myroom_Data", Context.MODE_PRIVATE);
        storeSwtich = sharedpre.getBoolean("R_isCheckd",false);


        radioGroup.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);
        btn_add.setOnClickListener(this);
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             String personname=personName.getText().toString();
//             String emailemail=personEmail.getText().toString();
//
//            }
//        });
        btn_show.setOnClickListener(this);
        moreoption.setChecked(storeSwtich);

        if(moreoption.isChecked()){
            more_frame.setVisibility(View.VISIBLE);
        }
        else {
            more_frame.setVisibility(View.GONE);

        }

        moreoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedpre =getSharedPreferences("Mysave_Data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpre.edit();
                editor.putBoolean("isCheckd",moreoption.isChecked());
                editor.apply();

                if(moreoption.isChecked()){
                    more_frame.setVisibility(View.VISIBLE);
                }
                else {
                    more_frame.setVisibility(View.GONE);

                }
            }
        });
    }
    @Override

    public void onClick(View v) {
        if(v==btn_add){
            String personname=personName.getText().toString();
            String personemail=personEmail.getText().toString();
            Task task=new Task();
            task.setP_name(personname);
            task.setP_name(personemail);
            task.setGender(gender);
            task.setHobbey(hobbey);
            Save(task);
//            DBhelper dBhelper=new DBhelper(SqliteMain.this);
//            dBhelper.insert(user);
//            Toast.makeText(SqliteMain.this, "Data Save" +personname, Toast.LENGTH_SHORT).show();
        }
        if(v==btn_show){
//            Intent intentR = new Intent(SqliteMain.this, Show.class);
//            startActivity(intentR);
        }

    }

    public void Save(Task task){

    class Savedata extends AsyncTask<Void,Void,Void>{

        @Override // this method for execute a start all active before   / same as like progressbar
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override// while execute prograssbar that time it will start work to activity
        protected Void doInBackground(Void... voids) {
            DatabaseClient.getInstance(Room_main.this).getAppDatabase().taskDao().insert(task);
            return null;
        }

        @Override // process bar Identifier
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override // do after get data , whatever you want to do like data display , insert , any kind of activity it execute last
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        RadioButton radioButton= (RadioButton) findViewById(checkedId);

        if(checkedId==R.id.male){
            gender=radioButton.getText().toString();
        }
        else if (checkedId==R.id.female){
            gender=radioButton.getText().toString();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (buttonView==cb1){
            if (isChecked){
                h1=cb1.getText().toString();}
            else{
                h1="";
            }
        }
        if (buttonView==cb2){
            if (isChecked){ h2=cb2.getText().toString();}else{h2="";}
        }
        if (buttonView==cb3){
            if (isChecked){ h3=cb3.getText().toString();}else{h3="";}
        }
        if (buttonView==cb4){
            if (isChecked){ h4=cb4.getText().toString();}else{h4="";}
        }
        if (buttonView==cb5){
            if (isChecked){ h5=cb5.getText().toString();}else{h5="";}
        }
        if (buttonView==cb6){
            if (isChecked){ h6=cb6.getText().toString();}else{h6="";}
        }
        hobbey= h1+"|"+h2+"|"+h3+"|"+h4+"|"+h5+"|"+h6;
        Log.e("Error",hobbey);
    }

}