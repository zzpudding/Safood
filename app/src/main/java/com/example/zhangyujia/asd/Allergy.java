package com.example.zhangyujia.asd;

import org.litepal.crud.LitePalSupport;

public class Allergy extends LitePalSupport {
//    private String userID;
//    private int value;
    private String allergyTypeName;
    private int isChecked=0;
    private String allergy_1;
    private String allergy_2;

    public String getAllergyTypeName() {
        return allergyTypeName;
    }

    public void setAllergyTypeName(String allergyTypeName) {
        this.allergyTypeName = allergyTypeName;
    }

    public int isChecked() {
        return isChecked;
    }

    public void setChecked(int checked) {
        isChecked = checked;
    }

    public String getAllergy_1() {
        return allergy_1;
    }

    public void setAllergy_1(String allergy_1) {
        this.allergy_1 = allergy_1;
    }

    public String getAllergy_2() {
        return allergy_2;
    }

    public void setAllergy_2(String allergy_2) {
        this.allergy_2 = allergy_2;
    }
//    public boolean isChecked() {
//        return isChecked;
//    }

//    public void setChecked(boolean checked) {
//        isChecked = checked;
//    }
//
//    public Allergy(String allergyTypeName, String allergy_1, String allergy_2){
//        this.allergyTypeName=allergyTypeName;
//        this.allergy_1=allergy_1;
//        this.allergy_2=allergy_2;
//    }
//
////    public String getUserID() {
////        return userID;
////    }
//    public void setAllergy_1(String allergy_1){
//        this.allergy_1=allergy_1;
//    }
//    public void setAllergy_2(String allergy_2){
//        this.allergy_2=allergy_2;
//    }
//    public void setAllergyTypeName(String allergyTypeName){
//        this.allergyTypeName=allergyTypeName;
//    }
//
//
//    public boolean getIsChecked(){
//        return isChecked;
//    }
//
//    public String getAllergy_1(){
//        return allergy_1;
//    }
//    public String getAllergy_2(){
//        return allergy_2;
//    }
//    public String getAllergyTypeName(){
//        return allergyTypeName;
//    }
//    public void check(){
//        this.isChecked=true;
//    }
//    public void unCheck(){
//        this.isChecked=false;
//    }
}
