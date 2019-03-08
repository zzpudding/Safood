package com.example.zhangyujia.asd;

import android.net.Uri;
import android.support.v4.app.Fragment;

public class CookbookActivity extends SingleFragmentActivity implements CookbookFragment.OnFragmentInteractionListener

      {

    @Override
    protected Fragment createFragment() {
        return new CookbookFragment();

    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }


}
