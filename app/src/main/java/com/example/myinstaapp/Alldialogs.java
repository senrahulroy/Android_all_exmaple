package com.example.myinstaapp;

import static java.util.Calendar.YEAR;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class Alldialogs extends AppCompatActivity {

    TextView tv,tv2,tv3;
    Button btn,btn1,btn2,btn3,btn4;

    Calendar c=Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldialogs);
        btn=findViewById(R.id.dialog_button);
        btn1=findViewById(R.id.information_button);
        btn2=findViewById(R.id.date_btn);
        btn3=findViewById(R.id.time_picker);
        btn4=findViewById(R.id.progress_bar);
        tv=findViewById(R.id.date_pic_v);
        tv2=findViewById(R.id.date_Day);
        tv3=findViewById(R.id.time_v);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Alldialogs.this)
                    .setTitle("Delete Data")
                    .setMessage("Are you sure ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(Alldialogs.this, "Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Alldialogs.this)
                        .setTitle("Battry is low")
                        .setMessage("please connect charger")
                        .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Alldialogs.this, "Done", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Alldialogs.this,SetDT,c.get(YEAR),
                        c.get(Calendar.MONTH),c.get(Calendar.DATE)).show();



            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(Alldialogs.this,SetTime,
                        c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog pd= new ProgressDialog(Alldialogs.this);
                pd.setTitle("Loading data");
                pd.setMessage("Please Wait");
//                pd.setCancelable(false);
                pd.show();
            }
        });

    }

   private DatePickerDialog.OnDateSetListener SetDT=new DatePickerDialog.OnDateSetListener() {
       @Override
       public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
           String day=c.getFirstDayOfWeek()+"";

            tv.setText( "Year : " + year + "Month : " + (month+1) + "date : " + dayOfMonth );
//            tv2.setText( "Year : "  + c.set()   );

       }
   };
   private TimePickerDialog.OnTimeSetListener SetTime= new TimePickerDialog.OnTimeSetListener() {
       @Override
       public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tv3.setText("Hour : " +hourOfDay + "Time : " + minute);
       }
   };
}