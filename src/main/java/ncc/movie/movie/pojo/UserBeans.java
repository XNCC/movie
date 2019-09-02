package ncc.movie.movie.pojo;

import java.util.Date;

public class UserBeans {
        private  int userid;/////
        private String username;
        private String vip;
        private Date starttime;
        private Date endtime;
        private String phone;

        String start;
        String end;

        @Override
        public String toString() {
            return "UserBean{" +
                    "userid=" + userid +
                    ", username='" + username + '\'' +
                    ", vip='" + vip + '\'' +
                    ", starttime=" + starttime +
                    ", endtime=" + endtime +
                    ", phone='" + phone + '\'' +
                    '}';
        }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }



    public UserBeans() {
    }

    public UserBeans(int userid, String username, String password, String vip, Date starttime, Date endtime, String phone, String userimg_url) {
        this.userid = userid;
        this.username = username;

        this.vip = vip;
        this.starttime = starttime;
        this.endtime = endtime;
        this.phone = phone;

    }
}
