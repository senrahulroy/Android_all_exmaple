package com.example.myinstaapp;


import android.service.autofill.CharSequenceTransformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> arrayList=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return arrayList.get(position);
    }

    public void addFragmetn (Fragment fragment,String fragment_Name){
        arrayList.add(fragment);
        name.add(fragment_Name);
    }
    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return name.get(position);
    }
}
