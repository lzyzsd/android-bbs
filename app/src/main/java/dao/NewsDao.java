package dao;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

import java.util.List;

import gg.sf.android.app.model.News;

/**
 * Created by bruce on 14-1-24.
 */
public class NewsDao {
    public static final String LATEST_NEWS_URL = "http://www.angularjs.cn/api/article/latest?s=20";
    public static final String HOT_NEWS_URL = "http://www.angularjs.cn/api/article/hots?s=20";
    public static final String UPDATE_NEWS_URL = "http://www.angularjs.cn/api/article/update?s=20";

    public enum NewsType {
        HOT,
        LATEST,
        UPDATE
    }

    public List<News> getLatestNews() {
        String response = HttpRequest.get(LATEST_NEWS_URL).body();
        return new DataWrapper().fromJson(response).data;
    }

    public List<News> getLatestNews(NewsType type) {
        String url = LATEST_NEWS_URL;
        switch (type) {
            case HOT:
                url = HOT_NEWS_URL;
                break;
            case LATEST:
                url = UPDATE_NEWS_URL;
                break;
        }
        String response = HttpRequest.get(url).body();
        System.out.println("--------------------url: "+url);
        return new DataWrapper().fromJson(response).data;
    }

    public class DataWrapper {
        public List<News> data;
        public long timestamp;
        public Error error;
        public boolean ack;

        public DataWrapper fromJson(String jsonString) {
            System.out.println("-------------------------"+jsonString);
            return new Gson().fromJson(jsonString, DataWrapper.class);
        }
    }

    public class Error {
        public String name;
        public String message;
    }
}
