package com.jenniferlam.career_light_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jennifer on 11/5/2017.
 */

public class WorkshopActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        RecyclerView recList = (RecyclerView) findViewById(R.id.WorkshopCardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        WorkshopAdapter adapter = new WorkshopAdapter(createList(20));
        recList.setAdapter(adapter);
    }

    private List<WorkshopInfo> createList(int size) {
        ArrayList<WorkshopInfo> workshopList = new ArrayList();
        for (int i = 0; i < size; i++) {

            WorkshopInfo workshop = new WorkshopInfo();

            workshop.workshopName = "Test Course Name";
            workshop.workshopDate = "Date: 11/07/2017";
            workshop.workshopTime = "Time: 12:00PM";
            workshop.workshopAttendees = "Attending: 70";

            workshopList.add(workshop);
        }

        return workshopList;
    }
}
