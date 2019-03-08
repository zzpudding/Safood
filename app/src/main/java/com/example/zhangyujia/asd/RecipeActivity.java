package com.example.zhangyujia.asd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

public class RecipeActivity extends SingleFragmentActivity implements RecipeFragment.OnFragmentInteractionListener

{
    private static final String EXTRA_RECIPE_ID = "com.example.zhangyujia.asd.recipe_id";
    @Override
    protected Fragment createFragment() {
        String recipeId=(String) getIntent().getStringExtra(EXTRA_RECIPE_ID);


        return RecipeFragment.newInstance(recipeId);

    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    public static Intent newIntent(Context packageContext, String recipeId){
        Intent intent = new Intent(packageContext, RecipeActivity.class);
        intent.putExtra(EXTRA_RECIPE_ID,recipeId);
        return intent;
    }


}
