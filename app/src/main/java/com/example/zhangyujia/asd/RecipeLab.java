package com.example.zhangyujia.asd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

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
    private static final String TAG="RecipeLab";


    public static RecipeLab get(Context context) {
        if (sRecipeLab == null) {
            sRecipeLab = new RecipeLab(context);
        }
        Log.d(TAG,"get the recipelab");
        return sRecipeLab;
    }

    private RecipeLab(Context context) {
        mRecipes = new ArrayList<>();

        databaseRecipes = FirebaseDatabase.getInstance().getReference("recipes");
        databaseRecipes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mRecipes.clear();
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
                    mRecipes.add(recipe);

                }
            Log.d(TAG,"getmRecipes");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public List<Recipe> getRecipes() {
        Log.d(TAG,"getRecipes");
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
