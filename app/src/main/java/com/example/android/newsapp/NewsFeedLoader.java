package com.example.android.newsapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by user on 8/16/2016.
 */
public class NewsFeedLoader extends AsyncTaskLoader<List<NewsItem>> {
    /** Tag for log messages */
    private static final String LOG_TAG = NewsFeedLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link NewsFeedLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsFeedLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<NewsItem> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<NewsItem> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
