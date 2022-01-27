package com.example.myinstaapp.SqliteDataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.myinstaapp.R;

public class Edit_Update extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    EditText personName,personEmail;
    RadioGroup radioGroup;
    RadioButton male,female;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    SwitchCompat moreoption;
    FrameLayout more_frame;
    Button btn_add;
    String gender="";
    String hobbey="" , h1,h2,h3,h4,h5,h6;
    Boolean storeSwtich;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
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
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        btn_add=findViewById(R.id.add_data);
        more_frame=findViewById(R.id.more_frame);
        moreoption=findViewById(R.id.more_option);

        radioGroup.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);

        SharedPreferences sharedpre =getSharedPreferences("Mysave_Data", Context.MODE_PRIVATE);
        storeSwtich = sharedpre.getBoolean("isCheckd",false);
        basicmathid();

        btn_add.setOnClickListener(this);
    }

    public void  basicmathid(){

        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        String name =intent.getStringExtra("name");
        String email=intent.getStringExtra("email");
        String gender1=intent.getStringExtra("gender");
        Log.e("GENDER", gender1);
        String hobbey1=intent.getStringExtra("hobbey");
        Log.e("HOBBEY1", hobbey1);
        personName.setText(name);
        personEmail.setText(email);
        // below code for cetch store data from table to sprated
        if(male.getText().toString().equals(gender1)){
            male.setChecked(true);
        }else if(female.getText().toString().equals(gender1)){
            female.setChecked(true);
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
            if (true){ h1=cb1.getText().toString();}else{h1="";}
        }
        if (buttonView==cb2){
            if (true){ h1=cb2.getText().toString();}else{h2="";}
        }
        if (buttonView==cb3){
            if (true){ h3=cb3.getText().toString();}else{h3="";}
        }
        if (buttonView==cb4){
            if (true){ h4=cb4.getText().toString();}else{h4="";}
        }
        if (buttonView==cb5){
            if (true){ h5=cb5.getText().toString();}else{h5="";}
        }
        if (buttonView==cb6){
            if (true){ h6=cb6.getText().toString();}else{h6="";}
        }
        hobbey= h1+h2+h3+h4+h5+h6;
        Log.e("Error",hobbey);
    }

    @Override
    public void onClick(View v) {

        if(v==btn_add){
            String personname=personName.getText().toString();
            String personemail=personEmail.getText().toString();
            User user=new User();
            user.setPerson_n(personname);
            user.setPerson_e(personemail);
            user.setPerson_gender(gender);
            user.setPerson_hobbey(hobbey);
            DBhelper dBhelper=new DBhelper(Edit_Update.this);
            dBhelper.update(user);

        }

    }
}