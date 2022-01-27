package com.example.myinstaapp.SqliteDataBase;

public class User {

    // here getter setter method for database help
    int id;
    String person_n,person_e,person_gender,person_hobbey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson_n() {
        return person_n;
    }

    public void setPerson_n(String person_n) {
        this.person_n = person_n;
    }

    public String getPerson_e() {
        return person_e;
    }

    public void setPerson_e(String person_e) {
        this.person_e = person_e;
    }

    public String getPerson_gender() {
        return person_gender;
    }

    public void setPerson_gender(String person_gender) {
        this.person_gender = person_gender;
    }

    public String getPerson_hobbey() {
        return person_hobbey;
    }

    public void setPerson_hobbey(String person_hobbey) {
        this.person_hobbey = person_hobbey;
    }
}
