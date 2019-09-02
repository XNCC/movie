package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.adminDao;
import ncc.movie.movie.pojo.User;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class adminDaoImpl implements adminDao {
    @Override
    public User getAdmin(String username) throws SQLException {
        String sql="select * from user where username=?;";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        User query = qr.query(sql, new BeanHandler<>(User.class), username);
        return query;
    }
}
