package com.example.zhangyujia.asd;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class ViewShopListActivity extends AppCompatActivity {

    public ShoppingCartModel mShopCart;
    public ArrayList<Recipe> mCartItems = new ArrayList<Recipe>();
    private RecyclerView mCartRecyclerView;
    private DatabaseHelper mDatabaseHelper;
    private Cursor data;
    public ArrayList<Recipe> cart_item_list;
    private RecipeAdapter mAdapter;

    public void addRecipeToCart(Recipe recipe) {
        mCartItems.add(recipe);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Your Cart");
        setContentView(R.layout.activity_view_shop_list);
        mCartRecyclerView = findViewById(R.id.cart_recycler_view);
        mCartRecyclerView.setLayoutManager(new LinearLayoutManager(ViewShopListActivity.this));
        cart_item_list = new ArrayList<Recipe>();
        mDatabaseHelper = new DatabaseHelper(this);
        data = mDatabaseHelper.getData();
        while (data.moveToNext()) {
            //get the value from database in column 1
            //add it to the ArrayList
            String recipeId=Integer.toString(data.getInt(0));
            String recipeName=data.getString(1);
            String ingredient1=data.getString(2);
            String ingredient2=data.getString(3);
            String ingredient3=data.getString(4);
            String recipeImageId=data.getString(5);
            Recipe recipe=new Recipe(recipeId,recipeName,ingredient1,ingredient2,ingredient3,recipeImageId);
            cart_item_list.add(recipe);
        }
        if(cart_item_list.size()==0){
            Toast.makeText(ViewShopListActivity.this,
                    "No items found", Toast.LENGTH_SHORT).show();
        }
        mAdapter = new RecipeAdapter(cart_item_list);
        mCartRecyclerView.setAdapter(mAdapter);
    }



    private class RecipeHolder extends RecyclerView.ViewHolder {
        private TextView mNameTextView;
        private ImageView mImageView;
        private Recipe mRecipe;
//        final String recipeId=mRecipe.getRecipeId();
//        final String recipeName=mRecipe.getRecipeName();
//        final String ingredient1=mRecipe.getIngredient1();


        public RecipeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_recipe, parent, false));

            mNameTextView = (TextView) itemView.findViewById(R.id.recipe_name);
            mImageView = (ImageView) itemView.findViewById(R.id.recipe_image);

        }
        public void bind(Recipe recipe){
            mRecipe = recipe;
            mNameTextView.setText(mRecipe.getRecipeName());
            Picasso.with(getContext()).load(recipe.getImageId()).placeholder(R.drawable.default_recipe_pic).fit().into(mImageView);
//            mImageView.setImageResource(recipe.getImageId());

        }
    }

    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {
            private List<Recipe> mRecipes;

            public RecipeAdapter(List<Recipe
                    > recipes) {
                mRecipes = recipes;

            }

            @Override
            public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                return new RecipeHolder(layoutInflater, parent);
            }

            @Override
            public void onBindViewHolder(RecipeHolder holder, int position) {
                Recipe recipe = mRecipes.get(position);
                holder.bind(recipe);
            }

            @Override
            public int getItemCount() {
                return mRecipes.size();
            }
        }

    }

