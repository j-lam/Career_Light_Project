package com.jenniferlam.career_light_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jennifer on 11/5/2017.
 */

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        RecyclerView recList = (RecyclerView) findViewById(R.id.CardList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                               .setAction("Action", null).show();
                                   }
                               }
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        CourseAdapter adapter = new CourseAdapter(createList(20));
        recList.setAdapter(adapter);
    }

    private List<CourseInfo> createList(int size) {
        ArrayList<CourseInfo> courseList = new ArrayList<CourseInfo>();
        for (int i = 0; i < size; i++) {

            CourseInfo course = new CourseInfo();
            course.courseName = "Test Course Name";
            course.courseDate = "Date: 11/07/2017";
            course.courseTime = "Time: 12:00PM";
            course.courseAttendees = "Attending: 70";

            courseList.add(course);
        }

        return courseList;
    }
}
