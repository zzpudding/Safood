package com.example.zhangyujia.asd;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RecipeLab {
    private static RecipeLab sRecipeLab;
    private List<Recipe> mRecipes;

    public static RecipeLab get(Context context) {
        if (sRecipeLab == null) {
            sRecipeLab = new RecipeLab(context);
        }
        return sRecipeLab;
    }

    private RecipeLab(Context context) {
        mRecipes = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
            Recipe MapoTofu = new Recipe("1","Mapo Tofu","Tofu","Pork","",R.drawable.mapotofu_pic);
            mRecipes.add(MapoTofu);
            Recipe BroccoliShrimp = new Recipe("2","Broccoli Shrimp","Broccoli","Shrimp","",R.drawable.broccolishrimp_pic);
            mRecipes.add(BroccoliShrimp);
            Recipe KungpaoChicken = new Recipe("3","Kung Pao Chicken","Cucumber","Carrot","",R.drawable.kungpaochicken_pic);
            mRecipes.add(KungpaoChicken);
            Recipe CurryRice = new Recipe("4","Curry Rice","Chicken","Curry","Potato",R.drawable.curryrice_pic);
            mRecipes.add(CurryRice);
//        }
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }
    public Recipe getRecipe(String id){
        for (Recipe recipe : mRecipes){
            if(recipe.getRecipeId ().equals(id)){
                return recipe;
            }
        }
        return null;
    }
}
