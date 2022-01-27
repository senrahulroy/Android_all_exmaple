package com.example.myinstaapp.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "p_name")
    String p_name;

    @ColumnInfo(name = "p_email")
    String p_email;

    @ColumnInfo(name = "gender")
    String gender;

    @ColumnInfo(name = "hobbey")
    String hobbey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_emai(String personemail) {
        return p_email;
    }

    public void setP_emai(String p_emai) {
        this.p_email = p_emai;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbey() {
        return hobbey;
    }

    public void setHobbey(String hobbey) {
        this.hobbey = hobbey;
    }
}
