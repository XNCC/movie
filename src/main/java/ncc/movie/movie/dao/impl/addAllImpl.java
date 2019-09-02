package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.addAll;
import ncc.movie.movie.pojo.actorBean;
import ncc.movie.movie.pojo.areaBean;
import ncc.movie.movie.pojo.typeBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class addAllImpl implements addAll {
    //    //根据导演，演员查询
    @Override
    public actorBean selactor(String actor_name, String directors) throws SQLException {
        String sql="select * from actor where actor_name=? and directors=?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        actorBean query = qr.query(sql, new BeanHandler<>(actorBean.class),actor_name,directors);
        return query;
    }
    //根据地区名查询地区
    @Override
    public areaBean selArea(String area_name) throws SQLException {
        String sql="select * from area where area_name=?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        areaBean query = qr.query(sql, new BeanHandler<>(areaBean.class),area_name);
        return query;
    }
    //根据类型查询id
    @Override
    public typeBean selType(String type_type) throws SQLException {
        String sql="select * from type where type_type=?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        typeBean query = qr.query(sql, new BeanHandler<>(typeBean.class), type_type);
        return query;
    }
}
