package com.example.myinstaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class All_Menu extends AppCompatActivity {

    Button btn1, btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menu);
        getSupportActionBar().setTitle("My All Menu");
        btn1 = findViewById(R.id.option);
        btn2 = findViewById(R.id.contextual);
        btn3 =findViewById(R.id.popup);
        registerForContextMenu(btn2);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pmenu=new PopupMenu(All_Menu.this,btn3);
                pmenu.getMenuInflater().inflate(R.menu.mymenu,pmenu.getMenu());

                pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.item1) {
                            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.item2) {

                            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.item3) {

                            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.item4) {
                            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                        // this is for submenu setting

                        else if (item.getItemId() == R.id.darktheme) {
                            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.acsetting) {
                            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.chatsetting) {
                            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.appbackup) {
                            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        }


                        Toast.makeText(All_Menu.this, "Selected Item : " + item.getTitle(), Toast.LENGTH_SHORT).show();

                        switch (item.getItemId()) {
                            case R.id.search:
                            case R.id.bookmark:
                            case R.id.print:
                            case R.id.share:
                            case R.id.copy:
                            case R.id.upload:
                                return true;
                            default:
                                return false;
                        }

                    }
                });
                pmenu.show();

            }
        });

//        btn1.setOnClickListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item1) {
            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item2) {

            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item3) {

            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item4) {
            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        // this is for submenu setting

        else if (item.getItemId() == R.id.darktheme) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.acsetting) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.chatsetting) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.appbackup) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(All_Menu.this, "Selected Item : " + item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()) {
            case R.id.search:
            case R.id.bookmark:
            case R.id.print:
            case R.id.share:
            case R.id.copy:
            case R.id.upload:
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item2) {

            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item3) {

            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item4) {
            Toast.makeText(All_Menu.this, "Selected" + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        // this is for submenu setting

        else if (item.getItemId() == R.id.darktheme) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.acsetting) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.chatsetting) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.appbackup) {
            Toast.makeText(All_Menu.this, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(All_Menu.this, "Selected Item : " + item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()) {
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
    }
}