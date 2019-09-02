package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.userBean;

import java.sql.SQLException;

public interface adminDao {
    User getAdmin(String username) throws SQLException;
}
