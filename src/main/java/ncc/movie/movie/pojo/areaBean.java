package ncc.movie.movie.pojo;

public class areaBean {
    int area_id;
    String area_name;

    public areaBean() {
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    @Override
    public String toString() {
        return "areaBean{" +
                "area_id=" + area_id +
                ", area_name='" + area_name + '\'' +
                '}';
    }
}
