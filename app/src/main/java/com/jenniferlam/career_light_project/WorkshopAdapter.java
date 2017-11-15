package com.jenniferlam.career_light_project;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kennyquach on 11/14/17.
 */

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ContactViewHolder>{

    private List<WorkshopInfo> workshops;

    public WorkshopAdapter(List<WorkshopInfo> workshops){

        this.workshops = workshops;
    }


    @Override
    public WorkshopAdapter.ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.workshop_card_view, viewGroup, false);

        return new WorkshopAdapter.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkshopAdapter.ContactViewHolder holder, int position) {
        WorkshopInfo workshopInfo = workshops.get(position);
        holder.cName.setText(workshopInfo.workshopName);
        holder.cDate.setText(workshopInfo.workshopDate);
        holder.cTime.setText(workshopInfo.workshopTime);
        holder.cAttending.setText(workshopInfo.workshopAttendees);
    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView cName;
        protected TextView cDate;
        protected TextView cTime;
        protected TextView cAttending;
        protected TextView cSeeMore;

        public ContactViewHolder(View v) {
            super(v);
            cName =  (TextView) v.findViewById(R.id.workshop_title);
            cDate = (TextView)  v.findViewById(R.id.workshop_date);
            cTime = (TextView)  v.findViewById(R.id.workshop_time);
            cAttending = (TextView) v.findViewById(R.id.workshop_attending);
            cSeeMore = (TextView) v.findViewById(R.id.workshop_see_more);
        }
    }

}

