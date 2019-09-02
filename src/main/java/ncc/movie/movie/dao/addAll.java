package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.actorBean;
import ncc.movie.movie.pojo.areaBean;
import ncc.movie.movie.pojo.typeBean;

import java.sql.SQLException;

public interface addAll {
    //根据导演，演员查询
    public actorBean selactor(String actor_name, String directors ) throws SQLException;
    //根据地区名查询地区
    public areaBean selArea(String area_name) throws SQLException;
    //根据类型查询id
    public typeBean selType(String type_type) throws SQLException;

    //判断视瓶是否存在
}
