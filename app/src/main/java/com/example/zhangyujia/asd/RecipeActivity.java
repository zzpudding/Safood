package com.example.zhangyujia.asd;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeActivity extends SingleFragmentActivity implements RecipeFragment.OnFragmentInteractionListener

{

    @Override
    protected Fragment createFragment() {
        return new RecipeFragment();

    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
