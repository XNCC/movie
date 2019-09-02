package ncc.movie.movie.pojo;

import java.util.Date;

public class CommentBean {
    int user_id;
    private  String video_name;
    private  String username;
    private String userimg_url;
    private String comment;
    Date date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public CommentBean() {
    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "video_name='" + video_name + '\'' +
                ", username='" + username + '\'' +
                ", userimg_url='" + userimg_url + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
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

    public String getUserimg_url() {
        return userimg_url;
    }

    public void setUserimg_url(String userimg_url) {
        this.userimg_url = userimg_url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
