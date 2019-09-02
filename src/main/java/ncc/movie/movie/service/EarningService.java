package ncc.movie.movie.service;

import ncc.movie.movie.dao.impl.EarningDaoImpl;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class EarningService {
@Autowired
ncc.movie.movie.dao.impl.EarningDaoImpl EarningDaoImpl;
    public double sumEarning() throws SQLException {
        //获取全部电影收益
        Double o=EarningDaoImpl.sumEarning();
        return (double)o;
    }
    public int getUserNum() throws SQLException {
        //获取用户数
        int userNum = EarningDaoImpl.getUserNum();
        return  userNum;
    }

    public double getMonthEarning(int n1,int n2) throws SQLException {
       return EarningDaoImpl.getMonthEarning(n1,n2);
    }

}
