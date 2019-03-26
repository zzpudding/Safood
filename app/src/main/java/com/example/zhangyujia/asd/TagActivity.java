package com.example.zhangyujia.asd;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TagActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,CartFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener,CookbookFragment.OnFragmentInteractionListener,OnClickListener {
    public static final String TAG = "TagActivity";
    private ImageButton mTabHome;
    private ImageButton mTabCart;
    private ImageButton mTabProfile;

    private Fragment mTab1;
    private Fragment mTab2;
    private Fragment mTab3;
//    private CookbookFragment mCookbook;
//    private AddRecipeFragment mAddRecipeFragment;

    //    private HomeFragment homeFragment  = new HomeFragment();
//    private HomeFragment homeFragment=new HomeFragment();
//    FragmentManager fm = getSupportFragmentManager();
//
//    FragmentTransaction transaction= fm.beginTransaction();
    TextView top;

    //    @Override
//    protected Fragment createFragment() {
//        return new HomeFragment();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tag_activity);

        mTabHome = findViewById(R.id.id_home);
        mTabCart = findViewById(R.id.id_cart);
        mTabProfile = findViewById(R.id.id_profile);
        top = findViewById(R.id.top_title);
        mTabHome.setOnClickListener(this);
        mTabCart.setOnClickListener(this);
        mTabProfile.setOnClickListener(this);
        setSelect(0);
//        homeFragment.setOnButtonClickListener1(new HomeFragment.OnButtonClickListener1() {
//
//            @Override
//            public void onButtonClick1(View view) {
//                //切换到TwoFragment
//                if (mCookbook == null)
//                {
//                    mCookbook = new CookbookFragment();
//
//                }
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                Log.d("TagActivity","bianle");
//                transaction.hide(mTab1);
//                transaction.add(R.id.fragment_container, mCookbook, "COOKBOOK");
//                // tx.replace(R.id.id_content, fThree, "THREE");
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//            }
//        });
//        homeFragment.setOnButtonClick1(new HomeFragment.OnButtonClick1() {
//
//            @Override
//            public void onClick(View view) {
//                //切换到TwoFragment
//                FragmentManager fm = getSupportFragmentManager();
//
//                FragmentTransaction transaction= fm.beginTransaction();
//
//                transaction.replace(R.id.fragment_container,new CookbookFragment());
//                transaction.commit();
//
//            }
//        });
//        homeFragment.setOnButtonClick2(new HomeFragment.OnButtonClick2() {
//
//            @Override
//            public void onClick(View view) {
//                //切换到TwoFragment
//                FragmentManager fm = getSupportFragmentManager();
//
//                FragmentTransaction transaction= fm.beginTransaction();
//
//                transaction.replace(R.id.fragment_container,new CookbookFragment());
//                transaction.commit();
//
//
//            }
//        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onClick(View v) {
        resetIcon();
        switch (v.getId()) {
            case R.id.id_home:
                setSelect(0);
                break;
            case R.id.id_cart:
                setSelect(1);
                break;
            case R.id.id_profile:
                setSelect(2);
                break;
        }

    }

    private void resetIcon() {
        mTabHome.setImageResource(R.drawable.home_icon);
        mTabCart.setImageResource(R.drawable.cart_icon);
        mTabProfile.setImageResource(R.drawable.profile_icon);
    }

    private void setSelect(int i) {
        //change color of the icon clicked, and change fragment

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (mTab1 == null) {
                    mTab1 = new HomeFragment();
//                    transaction.replace(R.id.fragment_container,mTab1);
                    transaction.add(R.id.fragment_container, mTab1);
                } else {
                    transaction.show(mTab1);
                }
                top.setText("Home");
                mTabHome.setImageResource(R.drawable.home_icon_pressed);
                break;
            case 1:
                if (mTab2 == null) {
                    mTab2 = new CartFragment();
//                    transaction.replace(R.id.fragment_container,mTab2);
                    transaction.add(R.id.fragment_container, mTab2);
                } else {
                    transaction.show(mTab2);
                }
                top.setText("Shopping Cart");
                mTabCart.setImageResource(R.drawable.cart_icon_pressed);
                break;
            case 2:
                if (mTab3 == null) {
                    mTab3 = new ProfileFragment();
//                    transaction.replace(R.id.fragment_container,mTab3);
                    transaction.add(R.id.fragment_container, mTab3);
                } else {
                    transaction.show(mTab3);
                }
                top.setText("Profile");
                mTabProfile.setImageResource(R.drawable.profile_icon_pressed);
                break;
            default:
                break;
        }
        transaction.commit();


    }

    private void hideFragment(FragmentTransaction transaction) {
//        transaction.hide();

        if (mTab1 != null) {
            transaction.hide(mTab1);
        }
        if (mTab2 != null) {
            transaction.hide(mTab2);
        }
        if (mTab3 != null) {
            transaction.hide(mTab3);
        }
//        if(mCookbook!=null){
//            Log.d(TAG,"detach mCookbook");
//            transaction.remove(mCookbook);
//        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //you can leave it empty
    }
//    @Override
//    public void onButtonClick1()
//    {
//        Toast.makeText(getApplicationContext(), "Clicked AddRecipe",
//                Toast.LENGTH_SHORT).show();
////      if (mAddRecipeFragment == null)
////                {
//                    mAddRecipeFragment = new AddRecipeFragment();
//
//                }
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                Log.d("TagActivity","bianle");
//                transaction.hide(mTab1);
//                transaction.add(R.id.fragment_container, mAddRecipeFragment, "ADDRECIPE");
//                // tx.replace(R.id.id_content, fThree, "THREE");
//                transaction.addToBackStack(null);
//                transaction.commit();
//    }
//    @Override
//    public void onButtonClick2()
//    {
//
//        if (mCookbook == null)
//        {
//            Log.d(TAG,"create new cookbookfragment");
//            mCookbook = new CookbookFragment();
//
//        }
//        if(mCookbook.isAdded())
//        {
//            Log.d(TAG,"already exist");
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction transaction = fm.beginTransaction();
//            transaction.hide(mTab1);
//            transaction.show(mCookbook);
//            transaction.commit();
//            return; //or return false/true, based on where you are calling from
//        }
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        Log.d(TAG,"transaction");
//        transaction.hide(mTab1);
//        transaction.add(R.id.fragment_container, mCookbook, "COOKBOOK");
//        // tx.replace(R.id.id_content, fThree, "THREE");
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy0");
    }

}
