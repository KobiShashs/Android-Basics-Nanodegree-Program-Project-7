package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 8/16/2016.
 */
public class NewsItemAdapter extends ArrayAdapter<NewsItem> {
    public NewsItemAdapter(Context context, List<NewsItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_feed_list_item, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) convertView.findViewById(R.id.title);
            holder.sectionTextView = (TextView) convertView.findViewById(R.id.section);
            holder.dateTextView = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NewsItem currentNewsItem = getItem(position);
        holder.titleTextView.setText(currentNewsItem.getmTitle());
        holder.sectionTextView.setText(currentNewsItem.getmSection());
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentNewsItem.getmTimeInMilliseconds());
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        holder.dateTextView.setText(formattedDate);
        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

    static class ViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView dateTextView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
