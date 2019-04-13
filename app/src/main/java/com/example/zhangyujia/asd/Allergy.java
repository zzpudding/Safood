package com.example.zhangyujia.asd;

import org.litepal.crud.LitePalSupport;

public class Allergy extends LitePalSupport {

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
}
