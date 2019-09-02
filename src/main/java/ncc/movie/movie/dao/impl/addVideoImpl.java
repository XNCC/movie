package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.addVideo;
import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.pojo.actorBean;
import ncc.movie.movie.pojo.areaBean;
import ncc.movie.movie.pojo.typeBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@Component
public class addVideoImpl implements addVideo {

    @Autowired
    addAllImpl addAllImpl;
    @Override
    public int addVideo(VideoBean videoBean) throws SQLException {
        int row4=0;
        Connection conn=null;
        try {
             conn = DruidUtil.getConn();
            conn.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //向数据库插video表入数据
            String sql = "insert into video values(?,?,?,?,?,?,?,?,?)";
            QueryRunner qr = new QueryRunner(DruidUtil.getDs());
            int row = qr.update(sql, null, videoBean.getVideo_url(),
                    videoBean.getImg_url(), videoBean.getVideo_name(),
                    videoBean.getVideo_score(), videoBean.getVideo_time(),
                    videoBean.getVideo_count(), videoBean.getVideo_details(),videoBean.getVipcansee());
            Object query = qr.query("SELECT LAST_INSERT_ID()", new ScalarHandler(1));
            int s1 = Integer.valueOf(query.toString());

            //判断演员跟导演是否存在，存在返回id，不存在插入然后返回id
            int s2;
            actorBean selactor = addAllImpl.selactor(videoBean.getActor_name(), videoBean.getDirectors());
            if (selactor != null) {
                s2 = selactor.getActor_id();
            } else {
                String sql1 = "insert into actor values(?,?,?)";
                QueryRunner qr1 = new QueryRunner(DruidUtil.getDs());
                int row1 = qr1.update(sql1, null, videoBean.getActor_name(), videoBean.getDirectors());
                Object query2 = qr.query("SELECT LAST_INSERT_ID()", new ScalarHandler(1));
                s2 = Integer.valueOf(query2.toString());
            }

            //判断地区是否存在，存在就返回id，不存在就插入并返回id
            int s3;
            areaBean areaBean = addAllImpl.selArea(videoBean.getArea_name());
            if (areaBean != null) {
                s3 = areaBean.getArea_id();
            } else {
                String sql2 = "insert into area values(?,?)";
                QueryRunner qr2 = new QueryRunner(DruidUtil.getDs());
                int row2 = qr2.update(sql2, null, videoBean.getArea_name());
                Object query3 = qr2.query("SELECT LAST_INSERT_ID()", new ScalarHandler(1));
                s3 = Integer.valueOf(query3.toString());
            }
            int s4;
            typeBean typeBean = addAllImpl.selType(videoBean.getType_type());
            if (typeBean != null) {
                s4 = typeBean.getType_id();
            } else {
                String sql3 = "insert into type values(?,?)";
                QueryRunner qr3 = new QueryRunner(DruidUtil.getDs());
                int row3 = qr3.update(sql3, null, videoBean.getType_type());

                Object query4 = qr.query("SELECT LAST_INSERT_ID()", new ScalarHandler(1));
                s4 = Integer.valueOf(query4.toString());
            }

            //处理关联表
            String sql4 = "insert into video_actor_type_area values(?,?,?,?)";
            QueryRunner qr4 = new QueryRunner(DruidUtil.getDs());
            row4 = qr4.update(sql4, s1, s2, s4, s3);
            conn.commit();
        }catch (Exception e){
            conn.rollback();
        }finally {
            if (conn!=null)
                conn.close();
        }
        System.out.println(row4);
        return row4;
    }

    @Override
    public int videoCount() throws SQLException {
        //返回电影信息数量
        String sql="select count(*) from video";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        Object o = qr.query(sql, new ScalarHandler<>());
        return  Integer.parseInt(o.toString());
    }


}
