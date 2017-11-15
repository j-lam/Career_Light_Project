package com.jenniferlam.career_light_project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kennyquach on 11/7/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder>  {

    private List<CourseActivity.CourseInfo> courses;

    public RecyclerViewAdapter(List<CourseActivity.CourseInfo> courses){

        this.courses = courses;
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        CourseActivity.CourseInfo courseInfo = courses.get(position);
        holder.cName.setText(courseInfo.courseName);
        holder.cDate.setText(courseInfo.courseDate);
        holder.cTime.setText(courseInfo.courseTime);
        holder.cAttending.setText(courseInfo.courseAttendees);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView cName;
        protected TextView cDate;
        protected TextView cTime;
        protected TextView cAttending;

        public ContactViewHolder(View v) {
            super(v);
            cName =  (TextView) v.findViewById(R.id.course_title);
            cDate = (TextView)  v.findViewById(R.id.course_date);
            cTime = (TextView)  v.findViewById(R.id.course_time);
            cAttending = (TextView) v.findViewById(R.id.course_attending);
        }
    }

}
