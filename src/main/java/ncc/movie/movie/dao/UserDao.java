package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.UserBeans;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //分页查询用户查询
   List<User> findAllUser(int n1,int n2) throws SQLException;
    //删除用户
    public int delUser(int n) throws SQLException;
    //用户模糊查询
    public List<User> selUserlike(String name,int n1,int n2) throws SQLException;
    //查询所有用户数
    public int selCount() throws SQLException;

    public UserBeans selUserone(int n2) throws SQLException;
//    修改用户
    public int updUser(int id, UserBeans bean) throws SQLException;

}
