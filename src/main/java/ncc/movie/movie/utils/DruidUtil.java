package ncc.movie.movie.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DruidUtil {
    //?rewriteBatchedStatements=true
    private static String url="jdbc:mysql:///movie?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static String user="root";
    private static String password="123456789";
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static DruidDataSource ds=null;
    static {
        ds=new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
    }

    public static DruidDataSource getDs(){
        return ds;
    }

    public static Connection getConn(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
