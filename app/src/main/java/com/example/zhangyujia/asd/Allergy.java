package com.example.zhangyujia.asd;

public class Allergy {
    private String userID;
    private int value;
    private String allergyTypeName;
    private boolean isChecked;
    private String allergy_1;
    private String allergy_2;

    public Allergy(String userID, boolean value){
        this.userID = userID;
        this.isChecked = value;
    }

    public String getUserID() {
        return userID;
    }

    public boolean getIsChecked(){
        return isChecked;
    }
}
