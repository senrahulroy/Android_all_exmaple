package com.example.myinstaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Tab_layout extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        getSupportActionBar().hide();
        tabLayout=findViewById(R.id.tab_layout_V);
        viewPager=findViewById(R.id.view_pager);
        ViewPageAdapter viewPageAdapter= new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragmetn(new Calls(),"Calls");
        viewPageAdapter.addFragmetn(new Chates(),"chates");
        viewPageAdapter.addFragmetn(new Status(),"Status");
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.calls);
        tabLayout.getTabAt(1).setIcon(R.drawable.chates);
        tabLayout.getTabAt(2).setIcon(R.drawable.status);
    }
}