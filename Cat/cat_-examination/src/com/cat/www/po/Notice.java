package com.cat.www.po;

public class Notice {
    /*
    举报对应的类，4个成员变量分别代表举报的原因，举报者，所举报的事件的内容和所属瓜圈
     */
    private String noticeContent;
    private String sender;
    private String eventContent;
    private String circle;

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }
}
