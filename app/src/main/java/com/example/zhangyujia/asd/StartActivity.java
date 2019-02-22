package com.example.zhangyujia.asd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {




    public static final String TAG="StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button signin = (Button) findViewById(R.id.signIn_btn);
        Button signup = (Button) findViewById(R.id.signUp_btn);




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
