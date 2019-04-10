package com.example.zhangyujia.asd;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Test;


public class SearchRecipeTest {
    private static Recipe recipe;
    DatabaseReference databaseRecipes;

    @Before
    public void setUp() throws Exception {
        recipe = new Recipe();
    }
    @Test
    public void testAddRecipe() throws Exception{
        databaseRecipes = FirebaseDatabase.getInstance().getReference("recipes");
        String recipeId = databaseRecipes.push().getKey();

        Recipe r = new Recipe(recipeId, "testRecipe","testIngredient1","testIngredient2","testIngredient3","" );
        databaseRecipes.child(recipeId).setValue(recipe);
    }
}
