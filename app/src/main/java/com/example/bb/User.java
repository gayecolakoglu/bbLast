package com.example.bb;

//Author: Gaye Çolakoğlu
public class User {

    //use same name in firebase
    public String  email, password, uid, routines;
    public User(){
    }

    public User(String email, String password, String uid) {

        this.email = email;
        this.password = password;
        this.uid = uid;
        this.routines = routines;
    }

    public String getUseremail() {
        return email;
    }

    public void setUseremail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRoutines() {
        return routines;
    }

    public void setRoutines(String routines) {
        this.routines = routines;
    }
}