package com.example.zhangyujia.asd;

public class Recipe {
    private String recipeId;
    private String recipeName;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private int imageId;
    //private String ingredient4;


    public Recipe(String recipeId, String recipeName, String ingredient1, String ingredient2, String ingredient3,int imageId) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.imageId = imageId;
        //this.ingredient4 = ingredient4;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public int getImageId(){return imageId;}

//    public String getIngredient4() {
//        return ingredient4;
//    }
}
