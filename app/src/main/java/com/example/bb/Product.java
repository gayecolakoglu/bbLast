package com.example.bb;
//Author: Rozerin Yıldız

// product class with properties type and id
public class Product {
    //use same name in firebase
    public String  type;
    public int id;
    public Product(){
    }

    public Product(String type, int id) {

        this.type = type;
        this.id = id;

    }

    public String getUsertype() {
        return type;
    }

    public void setUsertype(String type) {
        this.type = type;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

}
