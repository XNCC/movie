package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.MessageBean;

import java.sql.SQLException;

public interface videoupDao {

    //根据导演，演员查询,传入video_id = n;
    public int selactor(int n,String actor_name, String directors) throws SQLException;
    //根据地区名查询地区
    public int selArea(int n,String area_name) throws SQLException;
    //根据类型查询id
    public int selType(int n,String type_type) throws SQLException;
//    修改video表
    public int selVideo(int n, MessageBean MessageBean) throws SQLException;

    }

