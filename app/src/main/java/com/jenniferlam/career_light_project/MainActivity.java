package com.jenniferlam.career_light_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // hi
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
//        setHeader(getString(R.string.app_name), true);
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
