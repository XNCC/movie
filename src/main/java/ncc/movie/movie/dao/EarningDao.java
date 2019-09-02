package ncc.movie.movie.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EarningDao {
    double sumEarning() throws SQLException;
    public int getUserNum() throws SQLException;
    public double getMonthEarning(int n1,int n2) throws SQLException;
}
