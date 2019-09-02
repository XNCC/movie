package ncc.movie.movie.pojo;

public class typeBean {
    int type_id;
    String type_type;

    public typeBean() {
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_type() {
        return type_type;
    }

    public void setType_type(String type_type) {
        this.type_type = type_type;
    }

    @Override
    public String toString() {
        return "typeBean{" +
                "type_id=" + type_id +
                ", type_type='" + type_type + '\'' +
                '}';
    }
}
