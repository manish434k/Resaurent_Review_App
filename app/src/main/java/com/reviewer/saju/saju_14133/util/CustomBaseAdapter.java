package com.reviewer.saju.saju_14133.util;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.reviewer.saju.saju_14133.R;
 
public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<DashboardItem> dashboardItems;
     
    public CustomBaseAdapter(Context context, List<DashboardItem> items) {
        this.context = context;
        this.dashboardItems = items;
    }
     
    /*private view holder class*/
    private class ViewHolder {
        TextView restName;
        TextView address;
        RatingBar rating;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
         
        LayoutInflater mInflater = (LayoutInflater) 
            context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.dashboard_item, null);
            holder = new ViewHolder();
            holder.restName = (TextView) convertView.findViewById(R.id.restName);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            holder.rating = (RatingBar) convertView.findViewById(R.id.item_ratingBar);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        DashboardItem dashboardItem = (DashboardItem) getItem(position);
         
        holder.restName.setText(dashboardItem.getRestName());
        holder.address.setText("Address:"+dashboardItem.getAddress()+"\n"+"" +
                dashboardItem.getDate()+"\n"+
                dashboardItem.getTime()+"\n"+
                "Bill:"+dashboardItem.getBill());
        holder.rating.setRating(dashboardItem.getRating());
         
        return convertView;
    }
 
    @Override
    public int getCount() {     
        return dashboardItems.size();
    }
 
    @Override
    public Object getItem(int position) {
        return dashboardItems.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return dashboardItems.indexOf(getItem(position));
    }
}