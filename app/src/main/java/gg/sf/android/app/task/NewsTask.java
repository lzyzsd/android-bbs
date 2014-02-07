package gg.sf.android.app.task;

import android.os.AsyncTask;

import java.util.List;

import dao.NewsDao;
import gg.sf.android.app.adapter.NewsAdapter;
import gg.sf.android.app.model.News;

/**
 * Created by bruce on 14-1-24.
 */
public class NewsTask extends AsyncTask<String, Void, List<News>> {
    private NewsAdapter newsAdapter;

    public NewsTask(NewsAdapter adapter) {
        newsAdapter = adapter;
    }
    @Override
    protected List<News> doInBackground(String... strings) {
        return new NewsDao().getLatestNews(newsAdapter.getNewsType());
    }

    @Override
    protected void onPostExecute(List<News> newses) {
        super.onPostExecute(newses);
        newsAdapter.clear();
        newsAdapter.addAll(newses);
        newsAdapter.notifyDataSetChanged();
    }
}
