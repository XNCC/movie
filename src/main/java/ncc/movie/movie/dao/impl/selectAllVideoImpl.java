package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.selectAllVideo;
import ncc.movie.movie.pojo.CommentBean;
import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class selectAllVideoImpl implements selectAllVideo {
    @Override
    public List<VideoBean> selList(int n, int n2) throws SQLException {
        List<VideoBean> list=new ArrayList<>();
        //查询分页电影全部信息
        String sql="	"+
        "select video.*,"+
        " actor.*,"+
        "        type_type,"+
        "        area_name,"+
        "        img_url"+
        "  from video"+
        "  left join video_actor_type_area"+
        "  on video.video_id=video_actor_type_area.video_id"+
        "  left join actor"+
        "  on video_actor_type_area.actor_id=actor.actor_id"+
        " left join area"+
        " on video_actor_type_area.area_id=area.area_id"+
        " left join type"+
        "  on video_actor_type_area.type_id=type.type_id"+
                " limit ?,? ";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        list = qr.query(sql, new BeanListHandler<>(VideoBean.class),n,n2);
        System.out.println(list);
        return list;
    }

    @Override
    public List<VideoBean> findVideoList(String str) throws SQLException {
        //模糊查询所有电影信息，返回一个电影对象集合
        List<VideoBean> list=new ArrayList<>();
        //查询分页电影全部信息
        String sql="select video.*,"+
                " actor.*,"+
                "        type_type,"+
                "        area_name,"+
                "        img_url"+
                "  from video"+
                "  join video_actor_type_area"+
                "  on video.video_id=video_actor_type_area.video_id"+
                "  join actor"+
                "  on video_actor_type_area.actor_id=actor.actor_id"+
                " join area"+
                " on video_actor_type_area.area_id=area.area_id"+
                " join type"+
                "  on video_actor_type_area.type_id=type.type_id"+
                " where video_name like concat('%',?,'%')";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        list = qr.query(sql, new BeanListHandler<>(VideoBean.class),str);
        System.out.println(list);
        return list;

    }

    //查询用户评论
    @Override
    public List<CommentBean> selList(int n) throws SQLException {
        //查询Comment页面信息
        String sql="select b.video_name,a.user_id,c.username,c.userimg_url,a.`comment` ,a.date \n" +
                "\tfrom `comment` a\n" +
                "\tjoin video b\n" +
                "\ton a.video_id=b.video_id\n" +
                "\tjoin user c\n" +
                "\ton a.user_id=c.userid\n" +
                "\twhere b.video_id=?";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        List<CommentBean> list = qr.query(sql, new BeanListHandler<>(CommentBean.class), n);
        System.out.println(list);
        return list;

    }

    @Override
    public void dele(int n) throws SQLException {
        String sql="delete from video where video_id=?";
        String sql2="delete from video_actor_type_area where video_id=?";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        int update = qr.update(sql,n);
        qr.update(sql2,n);

    }

    @Override
    public VideoBean getOneVideo(int video_id) throws SQLException {
        String sql="select video.*,"+
                " actor.*,"+
                "        type_type,"+
                "        area_name,"+
                "        img_url"+
                "  from video"+
                "  join video_actor_type_area"+
                "  on video.video_id=video_actor_type_area.video_id"+
                "  join actor"+
                "  on video_actor_type_area.actor_id=actor.actor_id"+
                " join area"+
                " on video_actor_type_area.area_id=area.area_id"+
                " join type"+
//                " join type"+
                "  on video_actor_type_area.type_id=type.type_id"+
                " where video.video_id =?";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        VideoBean query = qr.query(sql, new BeanHandler<>(VideoBean.class), video_id);
        return query;
    }

    @Override
    public int updateMessage(int n, MessageBean bean) throws Exception {
        String sql="update video_actor_type_area vata\n" +
                "join type on vata.type_id =type.type_id\n" +
                "join  actor on vata.actor_id = actor.actor_id\n" +
                "join  area on  vata.area_id =area.area_id\n" +
                "join video on vata.video_id = video.video_id\n" +
                "set video_name=?,video_score=?,\n" +
                "video_time=?,video_count=?,\n" +
                " video_details=?,actor_name=?, directors=?,area_name=? ,type_type=?\n" +
                "where video.video_id="+n+";";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        int row = qr.update(sql,bean.getVideo_name(),bean.getVideo_score(),
                bean.getVideo_time(),bean.getVideo_count(),
                bean.getVideo_details(),bean.getActor_name(), bean.getDirectors(),bean.getArea_name(),bean.getArea_name());
//        Object query = qr.query("SELECT LAST_INSERT_ID()", new ScalarHandler(1));
//        int s=Integer.valueOf(query.toString());
//        System.out.println("受影响行数"+row);
        return row;
    }


    @Override
    public int delcomment(int user_id) throws SQLException {
       String sql="delete from comment where user_id=?;";
       QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        int update = qr.update(sql, user_id);

        return update;
    }
}
