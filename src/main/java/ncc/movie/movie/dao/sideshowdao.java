package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.PictureBean;

import java.sql.SQLException;

public interface sideshowdao {
    public int uptPicture(int id, PictureBean bean) throws SQLException;
    public String fidPicture(int id) throws SQLException;


}
