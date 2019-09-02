package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.sideshowdao;
import ncc.movie.movie.pojo.PictureBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class sideshowdaoImpl implements sideshowdao {
    @Override
    public int uptPicture(int id, PictureBean bean) throws SQLException {
        String sql = "update picture set picture_url=?  where picture_id =?;";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        int update = qr.update(sql,  bean.getPicture_url(),id);
        return update;
    }


    @Override
    public String fidPicture(int id) throws SQLException {
        String sql = "select picture_url from  picture where picture_id=?;";
        QueryRunner qr1=new QueryRunner(DruidUtil.getDs());
        Object o= qr1.query(sql, new ScalarHandler<>(),id);
        return o.toString();

    }
}
