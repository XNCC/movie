package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.selectAllVideoImpl;
import ncc.movie.movie.dao.impl.videoupDaoImpl;
import ncc.movie.movie.pojo.CommentBean;
import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ManageService {
    @Autowired
    selectAllVideoImpl selectAllVideo;

    @Autowired
    ncc.movie.movie.dao.impl.videoupDaoImpl videoupDaoImpl;
    public List<VideoBean> selList(int n, int n2) throws SQLException {
       return selectAllVideo.selList(n, n2);
    }
    public List<VideoBean> findVideoList(String str) throws SQLException {
       return  selectAllVideo.findVideoList(str);
    }
    public List<CommentBean> selList(int n) throws SQLException {
        return selectAllVideo.selList(n);
    }
    public void dele(int n) throws SQLException{
        selectAllVideo.dele(n);
    }
    public VideoBean getOneVideo(int video_id) throws SQLException {
        return selectAllVideo.getOneVideo(video_id);
    }
    public int updateMessage(int n, MessageBean bean) throws Exception {
        return selectAllVideo.updateMessage(n,bean);
    }

    public int updateMessages(int n, MessageBean bean) throws Exception {
        int i0=videoupDaoImpl.selVideo(n,bean);
        int i1 =videoupDaoImpl.selactor(n,bean.getActor_name(),bean.getDirectors());
        int i2=videoupDaoImpl.selArea(n,bean.getArea_name());
        int i3 = videoupDaoImpl.selType(n, bean.getType_type());
        return i0+i1+i2+i3;
    }


    public int delcomment(int user_id) throws SQLException {
       return selectAllVideo.delcomment(user_id);
    }

}
