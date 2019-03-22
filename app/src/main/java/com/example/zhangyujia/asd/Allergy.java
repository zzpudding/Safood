package com.example.zhangyujia.asd;

public class Allergy {
    private String userID;
    private int value;

    public Allergy(String userID, int value){
        this.userID = userID;
        this.value = value;
    }

    public String getUserID() {
        return userID;
    }

    public int getValue(){
        return value;
    }
}
