package com.example.zhangyujia.asd;

import java.util.ArrayList;

public class ShoppingCartModel {

    private ArrayList<Recipe> cartItems= new ArrayList<Recipe>();

    public Recipe getRecipe(int position){
        return cartItems.get(position);
    }

    public void addRecipeToCart(Recipe recipe){
        cartItems.add(recipe);
    }

    public int getCartSize(){
        return cartItems.size();
    }

    public boolean checkRecipeInCart(Recipe recipe){
        return cartItems.contains(recipe);
    }
}
