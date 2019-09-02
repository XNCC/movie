package ncc.movie.movie.pojo;

import java.util.Date;

public class emailBean {
    int id;
    int total;
    String from;
    String title;
    int size;
    Date sendtime;
    String content;

    public emailBean() {
    }

    public emailBean(int id, int total, String from, String title, int size, Date sendtime, String content) {
        this.id = id;
        this.total = total;
        this.from = from;
        this.title = title;
        this.size = size;
        this.sendtime = sendtime;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "emailBean{" +
                "id=" + id +
                ", total=" + total +
                ", from='" + from + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", sendtime=" + sendtime +
                ", content='" + content + '\'' +
                '}';
    }
}
