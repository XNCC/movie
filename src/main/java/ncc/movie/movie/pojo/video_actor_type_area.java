package ncc.movie.movie.pojo;

public class video_actor_type_area {
    int video_id;
    int actor_id;
    int type_id;
    int area_id;

    public video_actor_type_area() {
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    @Override
    public String toString() {
        return "video_actor_type_area{" +
                "video_id=" + video_id +
                ", actor_id=" + actor_id +
                ", type_id=" + type_id +
                ", area_id=" + area_id +
                '}';
    }
}
