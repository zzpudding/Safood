package com.example.zhangyujia.asd;

import android.net.Uri;
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

public class TagActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,CartFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener,CookbookFragment.OnFragmentInteractionListener,OnClickListener {
    public static final String TAG = "TagActivity";
    private ImageButton mTabHome;
    private ImageButton mTabCart;
    private ImageButton mTabProfile;

    private Fragment mTab1;
    private Fragment mTab2;
    private Fragment mTab3;
    private DatabaseHelper mDatabaseHelper;

    TextView top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tag_activity);
        mDatabaseHelper=new DatabaseHelper(this);
        mDatabaseHelper.getWritableDatabase();

        mTabHome = findViewById(R.id.id_home);
        mTabCart = findViewById(R.id.id_cart);
        mTabProfile = findViewById(R.id.id_profile);
        top = findViewById(R.id.top_title);
        mTabHome.setOnClickListener(this);
        mTabCart.setOnClickListener(this);
        mTabProfile.setOnClickListener(this);
        setSelect(0);
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
        if (mTab1 != null) {
            transaction.hide(mTab1);
        }
        if (mTab2 != null) {
            transaction.hide(mTab2);
        }
        if (mTab3 != null) {
            transaction.hide(mTab3);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //you can leave it empty
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy0");
    }

}
