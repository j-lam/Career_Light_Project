package com.jenniferlam.career_light_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase Auth
        mAuth = FirebaseAuth.getInstance();
//        setHeader(getString(R.string.app_name), true);

        //Toobar Set
        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Career Light");
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            sentToStart();
        }
    }

    private void sentToStart() {
        Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(startIntent);
        finish();
    }
    //menu action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.main_logout_btn){
            FirebaseAuth.getInstance().signOut();
            sentToStart();
        }

        return true;
    }

    public void onButtonClicker(View view){
        Intent intent;

        switch(view.getId()){
            case R.id.main_btn_calendar:
                intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_chat:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_workshop:
                intent = new Intent(this, WorkshopActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_resource:
                intent = new Intent(this, ResourceActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_course:
                intent = new Intent(this, CourseActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_setting:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
