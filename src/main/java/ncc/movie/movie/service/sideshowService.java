package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.sideshowdaoImpl;
import ncc.movie.movie.pojo.PictureBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class sideshowService {
    @Autowired
    ncc.movie.movie.dao.impl.sideshowdaoImpl sideshowdaoImpl;

    //更新
    public int uptPicture(int id,  PictureBean bean) throws SQLException {
        return sideshowdaoImpl.uptPicture(id,bean);
    }

    //查询
    public String fidPicture(int id) throws SQLException {
        return sideshowdaoImpl.fidPicture(id);
    }

}
