package gg.sf.android.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dao.NewsDao;
import gg.sf.android.app.R;
import gg.sf.android.app.model.News;

/**
 * Created by bruce on 14-1-24.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private final Context context;
    private final List<News> newsList;
    private NewsDao.NewsType newsType = NewsDao.NewsType.LATEST;

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, R.layout.news_item, newsList);
        this.newsList = newsList;
        this.context = context;
    }

    public void setNewsType(NewsDao.NewsType newsType) {
        this.newsType = newsType;
    }

    public NewsDao.NewsType getNewsType() {
        return newsType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.news_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.news_item_title);
        TextView descriptionView = (TextView) rowView.findViewById(R.id.news_item_description);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.news_item_icon);
        News item = newsList.get(position);
        textView.setText(item.getTitle());
        String url = item.getAuthor().getAvatar();
        if(null == url || "".equals(url.trim())) {
            url = "http://cdn.angularjs.cn/img/avatar.png";
        }
        Picasso.with(context).load(url).into(imageView);
        descriptionView.setText(item.getContent());

        return rowView;
    }
}
