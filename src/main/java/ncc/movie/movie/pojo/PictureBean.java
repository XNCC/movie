package ncc.movie.movie.pojo;

public class PictureBean {
    int picture_id;
    String picture_url;

    @Override
    public String toString() {
        return "PictureBean{" +
                "picture_id=" + picture_id +
                ", picture_url='" + picture_url + '\'' +
                '}';
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public PictureBean() {
    }

    public PictureBean(int picture_id, String picture_url) {
        this.picture_id = picture_id;
        this.picture_url = picture_url;
    }
}
