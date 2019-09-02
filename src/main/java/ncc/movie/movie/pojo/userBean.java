package ncc.movie.movie.pojo;

import java.util.Date;

public class userBean {
    int userid;
    String username;
    String password;
    String vip;
    Date starttime;
    Date endtime;

    public userBean() {
    }

    public userBean(int userid, String username, String password, String vip, Date starttime, Date endtime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.vip = vip;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
