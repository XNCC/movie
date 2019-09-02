package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.UserDaoImpl;
import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.UserBeans;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
@Autowired
ncc.movie.movie.dao.impl.UserDaoImpl UserDaoImpl;

    public List<User> findAllUser(int n1, int n2) throws SQLException {

        return UserDaoImpl.findAllUser(n1,n2);
    }
    public int delUser(int n) throws SQLException {
        return UserDaoImpl.delUser(n);
    }
    public List<User> selUserlike(String name,int n1,int n2) throws SQLException {
        return  UserDaoImpl.selUserlike(name,n1,n2);
    }
    public int selCount() throws SQLException {
        return UserDaoImpl.selCount();
    }


    public int updUser(int id, UserBeans bean) throws SQLException {
       return UserDaoImpl.updUser(id,bean);
    }

    public UserBeans selUserone(int n2) throws SQLException {
        return  UserDaoImpl.selUserone(n2);
    }
}
