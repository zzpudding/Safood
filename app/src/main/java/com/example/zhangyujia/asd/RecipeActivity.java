package com.example.zhangyujia.asd;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;

public class RecipeActivity extends SingleFragmentActivity implements RecipeFragment.OnFragmentInteractionListener

{
    private static final String EXTRA_RECIPE_ID = "com.example.zhangyujia.asd.recipe_id";
    private static final String EXTRA_RECIPE_NAME = "com.example.zhangyujia.asd.recipe_name";
    private static final String EXTRA_RECIPE_INGREDIEND1 = "com.example.zhangyujia.asd.recipe_ingredient1";
    private static final String EXTRA_RECIPE_IMAGE = "com.example.zhangyujia.asd.recipe_image";


    @Override
    protected Fragment createFragment() {
        String recipeId=(String) getIntent().getStringExtra(EXTRA_RECIPE_ID);
        String recipeName=(String) getIntent().getStringExtra(EXTRA_RECIPE_NAME);
        String recipeIngredient1=(String) getIntent().getStringExtra(EXTRA_RECIPE_INGREDIEND1);
        String recipeImage=getIntent().getStringExtra(EXTRA_RECIPE_IMAGE);

        return RecipeFragment.newInstance(recipeId,recipeName,recipeIngredient1,recipeImage);

    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    public static Intent newIntent(Context packageContext, String recipeId,String recipeName, String ingredient1,String imageId){
        Intent intent = new Intent(packageContext, RecipeActivity.class);
        intent.putExtra(EXTRA_RECIPE_ID,recipeId);
        intent.putExtra(EXTRA_RECIPE_NAME,recipeName);
        intent.putExtra(EXTRA_RECIPE_INGREDIEND1,ingredient1);
        intent.putExtra(EXTRA_RECIPE_IMAGE,imageId);

        return intent;
    }



}
