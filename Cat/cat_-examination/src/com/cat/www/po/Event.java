package com.cat.www.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    /*
    事件对应的类，6个成员变量，分别是事件发布者，发布时间，事件内容，点赞数，收藏数和评论数
     */
    private String publisher;
    private String createtime;
    private String content;
    private int thumbUp =0;
    private int collect =0;
    private int remark=0;

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getThumbUp() {
        return thumbUp;
    }
    public void setThumbUp(int thumbsUp) {
        this.thumbUp = thumbsUp;
    }
    public int getCollect() {
        return collect;
    }
    public void setCollect(int collect) {
        this.collect = collect;
    }
    public int getRemark() {
        return remark;
    }
    public void setRemark(int remark) {
        this.remark = remark;
    }
    /*
    在发表事件时（即new一个event对象时就会执行下方代码，记录发表时间）
     */
    {
        Date creatdate=new Date();
        SimpleDateFormat cratetimeformat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        this.createtime=cratetimeformat.format(creatdate);
    }
    public String getCreatetime() {
        /*Date creatdate=new Date();
        SimpleDateFormat cratetimeformat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        this.createtime=cratetimeformat.format(creatdate);
        System.out.println("执行了？");
        return createtime;*/
        return createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
