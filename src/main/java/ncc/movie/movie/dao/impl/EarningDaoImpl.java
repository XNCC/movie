package ncc.movie.movie.dao.impl;

import ncc.movie.movie.dao.EarningDao;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Component
public class EarningDaoImpl implements EarningDao {
    @Override
    public double sumEarning() throws SQLException {
        //获取全部电影收益
        String sql="select SUM(earning) from earning;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
        Object o = qr.query(sql, new ScalarHandler<>());
        return (double)o;
    }

    @Override
    public int getUserNum() throws SQLException {
        //获取用户数
        String sql1="select  COUNT(*) from `user`;";
        QueryRunner qr1=new QueryRunner(DruidUtil.getDs());
        Object o1= qr1.query(sql1, new ScalarHandler<>());

        return  Integer.parseInt(o1.toString());
    }

    @Override
    public double getMonthEarning(int n1,int n2) throws SQLException {
        //获取1-12每个月的收益,返回一个集合包括表中所包含的月份和当月的总收益，以map<k,value>形式
        String sql=" select SUM(earning)  from earning where  MONTH(earningtime) between ? and ?;";
        QueryRunner qr=new QueryRunner(DruidUtil.getDs());
//        qr.query(sql,new L)
        Object n = qr.query(sql, new ScalarHandler<>(),n1,n2);
        if(n==null){
            return 0;
        }else{
            return Double.parseDouble(n.toString());
        }

    }
}
