package com.example.zhangyujia.asd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewShopListActivity extends AppCompatActivity {

    public ShoppingCartModel mShopCart;
    public ArrayList<Recipe> mCartItems = new ArrayList<Recipe>();


    public void addRecipeToCart(Recipe recipe){
        mCartItems.add(recipe);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shop_list);
    }
}
