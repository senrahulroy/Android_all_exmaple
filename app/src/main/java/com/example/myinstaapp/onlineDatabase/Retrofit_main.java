package com.example.myinstaapp.onlineDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.myinstaapp.R;
import com.example.myinstaapp.roomdatabase.AppDatabase;

public class Retrofit_main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    EditText personName,personEmail;
    RadioGroup radioGroup;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    SwitchCompat moreoption;
    FrameLayout more_frame;
    Button btn_add,btn_show;
    String gender="";
    String hobbey="" , h1="",h2="",h3="",h4="",h5="",h6="";

    Boolean storeSwtich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);
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
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onClick(View v) {

    }
}