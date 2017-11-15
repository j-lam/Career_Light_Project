package com.jenniferlam.career_light_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //declare variable
    private Toolbar mToolbar;  //toolbar
    private TextInputLayout mLoginEmail; //user login email
    private TextInputLayout mLoginPassword; //user login password
    private Button mLogin_btn; //button login

    private FirebaseAuth mAuth; //firebase auth
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize firebase auth
        mAuth = FirebaseAuth.getInstance();

        //toolbar action bar
        mToolbar = (Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");


        mLoginEmail = (TextInputLayout) findViewById(R.id.login_email);
        mLoginPassword = (TextInputLayout) findViewById(R.id.login_password);
        mLogin_btn = (Button) findViewById(R.id.login_btn);

        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mLoginEmail.getEditText().getText().toString();
                String password = mLoginPassword.getEditText().getText().toString();

                if(!TextUtils.isEmpty(email)|| !TextUtils.isEmpty(password)){
                    loginUser(email, password);
                }
            }
        });
    }

    private void loginUser(String email, String password) {
       mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){

                Intent mainInent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainInent);
                finish();
            }else{
                // If sign in fails, display a message to the user.
                Toast.makeText(LoginActivity.this,"Cannot Sign in. Please try again", Toast.LENGTH_LONG).show();
            }
           }
       });
    }
}
