package com.jenniferlam.career_light_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    //declare variable
    private Button mRegBtn;  //register button
    private Button mLoginBtn; //login button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mRegBtn = (Button) findViewById(R.id.start_reg_btn);
        mLoginBtn = (Button) findViewById(R.id.start_login_btn);

           //on click to register activity
           mRegBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent reg_intent = new Intent(StartActivity.this,RegisterActivity.class);
                   startActivity(reg_intent);
               }
           });

           //on click to login activity
           mLoginBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent login_intent = new Intent(StartActivity.this, LoginActivity.class);
                   startActivity(login_intent);
               }
           });
        }
}
