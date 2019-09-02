package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.videoupDao;
import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.actorBean;
import ncc.movie.movie.pojo.areaBean;
import ncc.movie.movie.pojo.typeBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class videoupDaoImpl implements videoupDao {
    //根据导演，演员查询,传入video_id = n;
    public int selactor(int n, String actor_name, String directors) throws SQLException {
        String sql = "select *from actor where actor_name=? and directors=?;"; //根据演员名称和导演名称查询actor表，返回actorBean对象或者是null
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        actorBean query = qr.query(sql, new BeanHandler<>(actorBean.class), actor_name, directors);
        int i;
        if (query != null) {
            String sql1 = "update video_actor_type_area set actor_id =? where video_id=?;";//如果有查到就更新中间表
            QueryRunner qr1 = new QueryRunner(DruidUtil.getDs());
             i = qr1.update(sql1, query.getActor_id(), n);

        } else{
            //没有查到就修改actor表中演员名字，导演名字
            String sql2 = "update actor set actor_name=? ,directors=?  where actor_id=(select actor_id from video_actor_type_area where video_id=?)";
            QueryRunner qr2 = new QueryRunner(DruidUtil.getDs());
             i = qr2.update(sql2, actor_name, directors, n);

        }
        return i;

    }

    //根据地区名查询地区
    public int selArea(int n, String area_name) throws SQLException {
        String sql = "select * from area where area_name=?;";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        areaBean query = qr.query(sql, new BeanHandler<>(areaBean.class), area_name);
        int i;
        if (!(query == null)) {
            String sql1 = "update video_actor_type_area set area_id =? where video_id=?;";//如果有查到就更新中间表
            QueryRunner qr1 = new QueryRunner(DruidUtil.getDs());
            i = qr1.update(sql1, query.getArea_id(), n);

        } else  {
            //没有查到就修改area表中地区名字
            String sql2 = "update area set area_name=?  where area_id=(select area_id from video_actor_type_area where video_id=?)";
            QueryRunner qr2 = new QueryRunner(DruidUtil.getDs());
            i = qr2.update(sql2, area_name, n);

        }
        return i;

    }

    //根据类型查询id
    public int selType(int n, String type_type) throws SQLException {
        String sql = "select * from type where type_type=?;";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        typeBean query = qr.query(sql, new BeanHandler<>(typeBean.class), type_type);
        int i;
        if (!(query == null)) {
            String sql1 = "update video_actor_type_area set type_id =? where video_id=?;";//如果有查到就更新中间表
            QueryRunner qr1 = new QueryRunner(DruidUtil.getDs());
            i = qr1.update(sql1, query.getType_id(), n);
        } else {
            //没有查到就修改area表中地区名字
            String sql2 = "update type set type_type=?  where type_id=(select type_id from video_actor_type_area where video_id=?)";
            QueryRunner qr2 = new QueryRunner(DruidUtil.getDs());
            i = qr2.update(sql2, type_type, n);

        }
        return i;

    }

    @Override
    public int selVideo(int n, MessageBean MessageBean) throws SQLException {
        String sql="update video set video_name=? " +
                ",video_score=?, video_count=?,video_time=?," +
                "video_details=?  where video_id=? ;";
        QueryRunner qr2 = new QueryRunner(DruidUtil.getDs());
       int i = qr2.update(sql,MessageBean.getVideo_name(),MessageBean.getVideo_score(),
                MessageBean.getVideo_count(),
                MessageBean.getVideo_time(),MessageBean.getVideo_details(), n);
        return i;
    }
}