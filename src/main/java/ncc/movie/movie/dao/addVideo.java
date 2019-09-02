package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.VideoBean;

import java.sql.SQLException;

public interface addVideo {
    int addVideo(VideoBean videoBean) throws SQLException;
    int videoCount() throws SQLException;





}
