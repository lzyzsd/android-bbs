package gg.sf.android.app.model;

/**
 * Created by bruce on 14-1-24.
 */
public class User {
    private String name;
    private String _id;
    private String avatar;
    private int score;

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
