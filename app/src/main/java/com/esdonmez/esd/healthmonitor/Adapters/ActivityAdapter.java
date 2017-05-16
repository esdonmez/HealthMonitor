package com.esdonmez.esd.healthmonitor.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.esdonmez.esd.healthmonitor.Models.ActivityModel;
import com.esdonmez.esd.healthmonitor.R;
import java.util.List;

public class ActivityAdapter extends BaseAdapter {

    private Context context;
    private List<ActivityModel> activityList;


    public ActivityAdapter(Context context, List<ActivityModel> activityList) {
        this.context = context;
        this.activityList = activityList;
    }


    @Override
    public int getCount() {
        return activityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_activity, parent, false);
        } else {
            view = convertView;
        }

        if(activityList != null && activityList.size() != 0)
        {
            ((TextView) view.findViewById(R.id.activityNameType)).setText(activityList.get(position).getName() + " - " + activityList.get(position).getType());
            ((TextView) view.findViewById(R.id.calorieEffect)).setText("Calorie Effect : " + activityList.get(position).getCalorieEffect() + " cal");
            ((TextView) view.findViewById(R.id.activityDuration)).setText("Duration : " + activityList.get(position).getDuration() + " min");
        }

        return view;
    }
}
