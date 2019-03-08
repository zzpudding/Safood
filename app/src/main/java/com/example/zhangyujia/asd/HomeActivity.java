package com.example.zhangyujia.asd;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button addButton;
    private Button cbButton;
    private Button alButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addButton = findViewById(R.id.add_recipe_button);
        cbButton  = findViewById(R.id.cookbook_button);
        alButton =  findViewById(R.id.allergy_button);

        cbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this, CookbookActivity.class);
                startActivity(intent);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, AddRecipeActivity.class);
                startActivity(intent);
            }
        });
        alButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, initalSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
