package com.example.zhangyujia.asd;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRecipeActivity extends AppCompatActivity {
    private EditText recipeName;
    private EditText ingredient1;
    private EditText ingredient2;
    private EditText ingredient3;
    private Button addRecipe;
    DatabaseReference databaseRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        databaseRecipes = FirebaseDatabase.getInstance().getReference("recipes");

        recipeName = findViewById(R.id.etRecipeName);
        ingredient1 = findViewById(R.id.etIngredient1);
        ingredient2 = findViewById(R.id.etIngredient2);
        ingredient3 = findViewById(R.id.etIngredient3);
        addRecipe = findViewById(R.id.btnAddRecipe);

        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRecipe();
            }
        });
    }

    private void addRecipe() {
        String name = recipeName.getText().toString().trim();
        String ingre1 = ingredient1.getText().toString();
        String ingre2 = ingredient2.getText().toString();
        String ingre3 = ingredient3.getText().toString();

        if (!TextUtils.isEmpty(name)) {
            String recipeId = databaseRecipes.push().getKey();
            String imageUri = imageTranslateUri(R.drawable.default_recipe_pic);

            Recipe recipe = new Recipe(recipeId, name, ingre1, ingre2, ingre3, imageUri);

            databaseRecipes.child(recipeId).setValue(recipe);

            Toast.makeText(AddRecipeActivity.this, "Recipe added successfully!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(AddRecipeActivity.this, "Please enter the recipe name.", Toast.LENGTH_LONG).show();
        }

        String recipeId = databaseRecipes.push().getKey();
        Recipe r = new Recipe(recipeId, "junitTestRecipe","testIngredient1","testIngredient2","testIngredient3","android.resource://com.example.zhangyujia.asd/drawable/kungpaochicken_pic" );
        databaseRecipes.child(recipeId).setValue(r);
    }

    public String imageTranslateUri(int resId) {

        Resources r = getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(resId) + "/"
                + r.getResourceTypeName(resId) + "/"
                + r.getResourceEntryName(resId));

        return uri.toString();

    }
}
