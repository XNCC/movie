package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.addVideoImpl;
import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
            @Autowired
        addVideoImpl addVideo;
            //插入数据
        public int addVideo(VideoBean videoBean) throws SQLException {
            int i = addVideo.addVideo(videoBean);
            return i;
        }
            //获取电影总数
        public int getVideoCount() throws SQLException {
               return addVideo.videoCount();
        }





    }
