package com.example.zhangyujia.asd;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecipeLab {
    private static RecipeLab sRecipeLab;
    private List<Recipe> mRecipes;
    DatabaseReference databaseRecipes;


    public static RecipeLab get(Context context) {
        if (sRecipeLab == null) {
            sRecipeLab = new RecipeLab(context);
        }
        return sRecipeLab;
    }

    private RecipeLab(Context context) {
        mRecipes = new ArrayList<>();
        databaseRecipes = FirebaseDatabase.getInstance().getReference("recipes");
//        for (int i = 0; i < 2; i++) {
//            Recipe MapoTofu = new Recipe("1","Mapo Tofu","Tofu","Pork","",R.drawable.mapotofu_pic);
//            mRecipes.add(MapoTofu);
//            Recipe BroccoliShrimp = new Recipe("2","Broccoli Shrimp","Broccoli","Shrimp","",R.drawable.broccolishrimp_pic);
//            mRecipes.add(BroccoliShrimp);
//            Recipe KungpaoChicken = new Recipe("3","Kung Pao Chicken","Cucumber","Carrot","",R.drawable.kungpaochicken_pic);
//            mRecipes.add(KungpaoChicken);
//            Recipe CurryRice = new Recipe("4","Curry Rice","Chicken","Curry","Potato",R.drawable.curryrice_pic);
//            mRecipes.add(CurryRice);
//        }
        databaseRecipes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mRecipes.clear();
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
                    mRecipes.add(recipe);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
