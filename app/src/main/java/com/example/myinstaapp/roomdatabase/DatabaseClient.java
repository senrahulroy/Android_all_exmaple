package com.example.myinstaapp.roomdatabase;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context context;
    private static  DatabaseClient databaseClient;
    private AppDatabase appDatabase;

    public DatabaseClient(Context context)
    {
        this.context=context;

        appDatabase= Room.databaseBuilder(context,AppDatabase.class,"myroom").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (databaseClient==null){ databaseClient=new DatabaseClient(context);}
        return databaseClient;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
