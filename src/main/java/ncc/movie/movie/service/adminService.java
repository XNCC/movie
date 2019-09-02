package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.adminDaoImpl;
import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class adminService {
    @Autowired
    ncc.movie.movie.dao.impl.adminDaoImpl adminDaoImpl;
    public User getAdmin(String username) throws SQLException {
        User admin = adminDaoImpl.getAdmin(username);
        return admin;
    }
}
