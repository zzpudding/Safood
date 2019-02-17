package com.example.zhangyujia.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button login=(Button) findViewById(R.id.signIn_btn);
        Button logup=(Button) findViewById(R.id.signUp_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start.this, signIn.class);
                startActivity(intent);
            }
        });
        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start.this, signIn.class);
                startActivity(intent);
            }
        });
    }
}
