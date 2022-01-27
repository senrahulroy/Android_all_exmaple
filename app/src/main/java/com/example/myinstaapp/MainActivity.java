package com.example.myinstaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Usename,PassWord;
    Button btn;
    String name="Rahul";
    String pass="Rahul@12345%";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //title bar removeble
        setContentView(R.layout.activity_main);
        Usename=findViewById(R.id.username);
        PassWord=findViewById(R.id.password);
        btn=findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bname=Usename.getText().toString();
                String BSpass=PassWord.getText().toString();
                if(Bname.equals(name) && BSpass.equals(pass)){

                    Intent i=new Intent(MainActivity.this, Second.class);
                    i.putExtra("Iuser" , Bname);
                    i.putExtra("IPass" , BSpass);
                    startActivity(i);
                    finish();


                }else{
                    Toast.makeText(MainActivity.this, "please check pass", Toast.LENGTH_SHORT).show();
                }


            }

        });


    }
}