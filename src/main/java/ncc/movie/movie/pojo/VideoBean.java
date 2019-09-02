package ncc.movie.movie.pojo;

import java.util.Date;

public class VideoBean {
    int video_id;
    String video_name;
    String video_score;
    String video_count;
    String actor_name;
    String directors;
    Date video_time;
    String type_type;
    String area_name;
    String video_details;
    String video_url;
    String img_url;
    String vipcansee;
    String time;

    public String getVipcansee() {
        return vipcansee;
    }

    public void setVipcansee(String vipcansee) {
        this.vipcansee = vipcansee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public VideoBean() {
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_score() {
        return video_score;
    }

    public void setVideo_score(String video_score) {
        this.video_score = video_score;
    }

    public String getVideo_count() {
        return video_count;
    }

    public void setVideo_count(String video_count) {
        this.video_count = video_count;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public Date getVideo_time() {
        return video_time;
    }

    public void setVideo_time(Date video_time) {
        this.video_time = video_time;
    }

    public String getType_type() {
        return type_type;
    }

    public void setType_type(String type_type) {
        this.type_type = type_type;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getVideo_details() {
        return video_details;
    }

    public void setVideo_details(String video_details) {
        this.video_details = video_details;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "video_id=" + video_id +
                ", video_name='" + video_name + '\'' +
                ", video_score='" + video_score + '\'' +
                ", video_count='" + video_count + '\'' +
                ", actor_name='" + actor_name + '\'' +
                ", directors='" + directors + '\'' +
                ", video_time=" + video_time +
                ", type_type='" + type_type + '\'' +
                ", area_name='" + area_name + '\'' +
                ", video_details='" + video_details + '\'' +
                ", video_url='" + video_url + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
