package com.example.zhangyujia.asd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

    private EditText username;
    private EditText password1;
    private EditText password2;
    private Button signUpConfirm;
    private Button signUpClear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sign Up");

        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.etUsername);
        password1 = findViewById(R.id.etPassword1);
        password2 = findViewById(R.id.etPassword2);
        signUpConfirm = findViewById(R.id.signUpConfirm_btn);
        signUpClear = findViewById(R.id.signUpClear_btn);
        mAuth = FirebaseAuth.getInstance();

        signUpConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (password1.getText().toString().equals(password2.getText().toString())) {
                    mAuth.createUserWithEmailAndPassword(username.getText().toString(), password1.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "REGISTERED SUCCESSFULLY!", Toast.LENGTH_LONG).show();

                                        username.setText("");
                                        password1.setText("");
                                        password2.setText("");
                                        Intent intent=new Intent(SignUpActivity.this, TagActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SignUpActivity.this, "PASSWORD MISMATCH", Toast.LENGTH_LONG).show();
                }
            }
        });

        signUpClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password1.setText("");
                password2.setText("");
            }
        });

    }
}
