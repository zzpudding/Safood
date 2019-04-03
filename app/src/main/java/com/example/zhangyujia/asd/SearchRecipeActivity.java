package com.example.zhangyujia.asd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchRecipeActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG="SearchActivity";
    private EditText mSearchArea;
    private RecyclerView mSearchResults;
    private ImageButton mSearchBtn;
    private SearchRecipeActivity.RecipeAdapter mAdapter;
    DatabaseReference mReference;
    public ArrayList<Recipe>  list;

    private List<Allergy> mAllergens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);
        mSearchArea=findViewById(R.id.search_area);
        mSearchResults=findViewById(R.id.search_results);
        mSearchBtn=findViewById(R.id.search_imgbtn);
        mSearchResults.setLayoutManager(new LinearLayoutManager(SearchRecipeActivity.this));
        mSearchBtn.setOnClickListener(this);

        mAllergens= LitePal.select("allergyTypeName","allergy_1","allergy_2").where("isChecked = ?","1").find(Allergy.class);

        list=new ArrayList<Recipe>();

        mAdapter = new SearchRecipeActivity.RecipeAdapter(list);
        mSearchResults.setAdapter(mAdapter);

    }
    @Override
    public void onClick(View view){
        if(!mSearchArea.getText().toString().isEmpty()){
            String searchText=mSearchArea.getText().toString().toLowerCase();
            RecipeSearch(searchText);}
        else{
            Toast.makeText(this,"Please enter a text",Toast.LENGTH_LONG).show();
        }

    }


    protected void RecipeSearch(final String searchText){
        list.clear();

        mReference= FirebaseDatabase.getInstance().getReference().child("recipes");
//        Query query1 = mReference.orderByChild("recipeName").startAt(searchText).endAt(searchText+"\uf8ff");
//        Query query2 = mReference.orderByChild("ingredient1").startAt(searchText).endAt(searchText+"\uf8ff");
//        Query query3 = mReference.orderByChild("ingredient2").startAt(searchText).endAt(searchText+"\uf8ff");
//        Query query4 = mReference.orderByChild("ingredient3").startAt(searchText).endAt(searchText+"\uf8ff");



        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                list.clear();
                if(!dataSnapshot.exists()){
                    Toast.makeText(SearchRecipeActivity.this,
                            "No recipes found", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
                    int toAdd= 1;

                    for(int i = 0; i<mAllergens.size(); i++){
                        Log.d(TAG,"sd");
                        String mKey=mAllergens.get(i).getAllergyTypeName().toLowerCase()+mAllergens.get(i).getAllergy_1().toLowerCase()+mAllergens.get(i).getAllergy_2().toLowerCase();
                        if(mKey.contains(recipe.getIngredient1())||mKey.contains(recipe.getIngredient2())||mKey.contains(recipe.getIngredient3())){
                            toAdd=0;
                            break;
                        }
                    }

                    if(toAdd ==1&&(recipe.getRecipeName().contains(searchText)||recipe.getIngredient1().contains(searchText)||recipe.getIngredient2().contains(searchText)||recipe.getIngredient3().contains(searchText))){
                        list.add(recipe);
                    }
//                    if(!list.contains(recipe)){
//                        Log.d(TAG,"first show1");
//
//                        list.add(recipe);
//                    }
//                    else{
//                        Log.d(TAG,"Duplicated1");
//                    }

                }

                if(list.size()==0){
                    Toast.makeText(SearchRecipeActivity.this,
                            "No recipes found", Toast.LENGTH_SHORT).show();
                }
                mAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        query2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                list.clear();
//                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
//                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
//                    if(recipe.getIngredient1().contains("nuts")||recipe.getIngredient2().contains("nuts")||recipe.getIngredient3().contains("nuts")){
//
//                        continue;
//                    }
//
//                    if(!list.contains(recipe)){
//                        list.add(recipe);
//                        Log.d(TAG,"first show2");
//                    }
//                    else{
//                        Log.d(TAG,"Duplicated2");
//                    }
//                }
//                mAdapter.notifyDataSetChanged();
//


//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        query3.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                list.clear();
//                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
//                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
//                    if(recipe.getIngredient1().contains("nuts")||recipe.getIngredient2().contains("nuts")||recipe.getIngredient3().contains("nuts")){
//
//                        continue;
//                    }
//
//                    if(!list.contains(recipe)){
//                        list.add(recipe);
//                    }
//                    else{
//                        Log.d(TAG,"Duplicated3");
//                    }
//
//                }
//                mAdapter.notifyDataSetChanged();
//
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        query4.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                list.clear();
//                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
//                    Recipe recipe=recipeSnapshot.getValue(Recipe.class);
//                    if(recipe.getIngredient1().contains("nuts")||recipe.getIngredient2().contains("nuts")||recipe.getIngredient3().contains("nuts")){
//
//                        continue;
//                    }
//
//                    if(!list.contains(recipe)){
//                        list.add(recipe);
//                    }
//                    else{
//                        Log.d(TAG,"Duplicated4");
//                    }
//
//                }
//                mAdapter.notifyDataSetChanged();
//
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }



    private class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mNameTextView;
        private ImageView mImageView;
        private Recipe mRecipe;
//        final String recipeId=mRecipe.getRecipeId();
//        final String recipeName=mRecipe.getRecipeName();
//        final String ingredient1=mRecipe.getIngredient1();

        public RecipeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_recipe,parent,false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.recipe_name);
            mImageView = (ImageView) itemView.findViewById(R.id.recipe_image);

        }

        @Override
        public void onClick(View view){
            Intent intent=RecipeActivity.newIntent(SearchRecipeActivity.this,mRecipe.getRecipeId(),mRecipe.getRecipeName(),mRecipe.getIngredient1(),mRecipe.getIngredient2(),mRecipe.getIngredient3(),mRecipe.getImageId());
            startActivity(intent);
        }

        public void bind(Recipe recipe){
            mRecipe = recipe;
            mNameTextView.setText(mRecipe.getRecipeName());
//            mImageView.setImageResource(recipe.getImageId());
            Picasso.with(SearchRecipeActivity.this).load(recipe.getImageId()).placeholder(R.drawable.default_recipe_pic).fit().into(mImageView);

        }

    }
    private class RecipeAdapter extends RecyclerView.Adapter<SearchRecipeActivity.RecipeHolder>{
        private List<Recipe> mRecipes;

        public RecipeAdapter(List<Recipe
                > recipes){
            mRecipes=recipes;

        }
        @Override
        public SearchRecipeActivity.RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater=LayoutInflater.from(SearchRecipeActivity.this);
            return new SearchRecipeActivity.RecipeHolder(layoutInflater,parent);
        }
        @Override
        public void onBindViewHolder(SearchRecipeActivity.RecipeHolder holder, int position){
            Recipe recipe=mRecipes.get(position);
            holder.bind(recipe);
        }
        @Override
        public int getItemCount(){
            return mRecipes.size();
        }
    }
}
