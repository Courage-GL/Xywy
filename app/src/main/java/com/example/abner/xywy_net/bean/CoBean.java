package com.example.abner.xywy_net.bean;

/**
 * Created by 张萌 on 2017/6/12.
 */

public class CoBean {
    private String  title;
    private String  date;
    private String  body;
    private String  userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public CoBean(String title, String date, String body, String userid) {
        this.title = title;
        this.date = date;
        this.body = body;
        this.userid = userid;
    }

    public CoBean(String title, String date, String body) {
        this.title = title;
        this.date = date;
        this.body = body;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
