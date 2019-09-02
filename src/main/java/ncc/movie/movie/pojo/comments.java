package ncc.movie.movie.pojo;

import java.util.Date;

public class comments {
    int user_id;
    int video_id;
    int comment_id;
    String comment;
    Date date;
    String username;
    String userimg_url;
    String video_name;

    public comments() {
    }

    public comments(int user_id, int video_id, int comment_id, String comment, Date date, String username, String userimg_url, String video_name) {
        this.user_id = user_id;
        this.video_id = video_id;
        this.comment_id = comment_id;
        this.comment = comment;
        this.date = date;
        this.username = username;
        this.userimg_url = userimg_url;
        this.video_name = video_name;
    }

    public String getUserimg_url() {
        return userimg_url;
    }

    public void setUserimg_url(String userimg_url) {
        this.userimg_url = userimg_url;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "comments{" +
                "user_id=" + user_id +
                ", video_id=" + video_id +
                ", comment_id=" + comment_id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
