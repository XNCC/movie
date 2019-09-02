package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.UserDao;
import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.UserBeans;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser(int n1, int n2) throws SQLException {
        String sql="select * from user limit ?,?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        List<User> query = qr.query(sql, new BeanListHandler<>(User.class),n1,n2);
        return query;
    }

    @Override
    public int delUser(int n) throws SQLException {
        String sql="delete from user where userid=?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        int update = qr.update(sql, n);
        return update;
    }


    @Override
    public List<User> selUserlike(String name,int n1,int n2) throws SQLException {
        String sql="select * from user where username like concat('%',?,'%') limit ?,?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        System.out.println(sql);
        List<User> query = qr.query(sql, new BeanListHandler<>(User.class),name,n1,n2);
        System.out.println(query);
        return query;
    }

    @Override
    public int selCount() throws SQLException {
        String sql="select count(*) from user";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        Object query = qr.query(sql, new ScalarHandler<>());
        return Integer.parseInt(query.toString());
    }

    @Override
    public int updUser(int id, UserBeans bean) throws SQLException {
        Connection conn=null;
        int row=0;
        try {
            conn = DruidUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "update user set" +
                    "       username=?," +
                    "        vip=?," +
                    "        starttime=?," +
                    "        endtime=?," +
                    "        phone=?" +
                    "        where userid= ?;";
            QueryRunner qr = new QueryRunner(DruidUtil.getDs());
             row = qr.update(sql, bean.getUsername(), bean.getVip(),
                    bean.getStarttime(), bean.getEndtime(), bean.getPhone(), id);
             conn.commit();
        }catch(Exception e){
            conn.rollback();
        }finally {
            if (conn!=null)
            conn.close();
        }

      return row;
    }

    @Override
    public UserBeans selUserone(int n2) throws SQLException {
        String sql="select * from user where userid=?;";
        QueryRunner qr = new QueryRunner(DruidUtil.getDs());
        UserBeans query = qr.query(sql, new BeanHandler<>(UserBeans.class), n2);
        return query;
    }
}
