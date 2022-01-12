package com.example.bb;

//Author: Gaye Çolakoğlu
public class User {

    //use same name in firebase
    public String  skinType,skinSubtype,email, password, uid, morningCleanser,morningMoisturizer, morningSun,nightCleanser,nightMoisturizer,nightSun;
    public User(){
    }

    public User(String email, String password, String uid) {

        this.email = email;
        this.skinType = skinType;
        this.skinSubtype = skinSubtype;
        this.password = password;
        this.uid = uid;
        this.morningCleanser = morningCleanser;
        this.morningMoisturizer = morningMoisturizer;
        this.morningSun = morningSun;
        this.nightCleanser = nightCleanser;
        this.nightMoisturizer = nightMoisturizer;
        this.nightSun = nightSun;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getSkinSubtype() {
        return skinSubtype;
    }

    public void setSkinSubtype(String skinSubtype) {
        this.skinSubtype = skinSubtype;
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

    public String getMorningCleanser() {
        return morningCleanser;
    }

    public void setMorningCleanser(String morningCleanser) {
        this.morningCleanser = morningCleanser;
    }

    public String getMorningMoisturizer() {
        return morningMoisturizer;
    }

    public void setMorningMoisturizer(String morningMoisturizer) {
        this.morningMoisturizer = morningMoisturizer;
    }

    public String getMorningSun() {
        return morningSun;
    }

    public void setMorningSun(String morningSun) {
        this.morningSun = morningSun;
    }

    public String getNightCleanser() {
        return nightCleanser;
    }

    public void setNightCleanser(String nightCleanser) {
        this.nightCleanser = nightCleanser;
    }

    public String getNightMoisturizer() {
        return nightMoisturizer;
    }

    public void setNightMoisturizer(String nightMoisturizer) {
        this.nightMoisturizer = nightMoisturizer;
    }
    public String getNightSun() {
        return nightSun;
    }

    public void setNightSun(String nightSun) {
        this.nightSun = nightSun;
    }

}