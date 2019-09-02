package ncc.movie.movie.dao;

import ncc.movie.movie.pojo.CommentBean;
import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.VideoBean;

import java.sql.SQLException;
import java.util.List;

//用于电影管理页面
public interface selectAllVideo {
    public List<VideoBean> selList(int n, int n2 ) throws SQLException;
    public List<VideoBean> findVideoList(String str) throws SQLException;
    public List<CommentBean> selList(int n ) throws SQLException;
    public void dele(int n) throws SQLException ;
    public VideoBean getOneVideo(int n) throws SQLException;
    //修改video
    public int updateMessage(int n, MessageBean bean) throws Exception ;

    //删除评论
    public int delcomment(int user_id) throws SQLException;
}
