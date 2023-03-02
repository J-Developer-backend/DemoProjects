package com.cat.www.controller;

import com.cat.www.po.Circle;
import com.cat.www.po.Event;
import com.cat.www.po.Notice;
import com.cat.www.po.User;
import com.cat.www.service.EventService;
import com.cat.www.impl.EventServiceImpl;
import com.cat.www.view.CreateEventView;
import com.cat.www.view.CreateTipoffView;
import com.cat.www.view.TipView;
import com.xiedafeng.www.po.*;
import com.xiedafeng.www.view.*;

public class EventController {
    private final RemarkController remarkController=new RemarkController();
    private final EventService eventService=new EventServiceImpl();
    private final TipView tipView=new TipView();
    public void thumbUp(User user, Event event) throws Exception {
        if (eventService.thumbUp(user,event)){
            tipView.showTip("点赞成功！");
        }
        else{
            tipView.showTip("取消点赞成功！");
        }
    }
    public void collect(User user,Event event) throws Exception {
        if (eventService.collect(user,event)){
            tipView.showTip("收藏成功！");
        }
        else{
            tipView.showTip("取消收藏成功！");
        }
    }
    public void showEventRemark(User user,Event event) throws Exception {
        remarkController.showEventRemark(user,event);
    }
    public void showTipOffView(User user,Event event){
        CreateTipoffView createTipoffView=new CreateTipoffView();
        createTipoffView.tipOff(user,event);
    }
    public void tipOff(User user, Event event, Notice notice) throws Exception {
        if ("".equals(notice.getNoticeContent())){
            tipView.showTip("举报内容不能为空！");
        }
        else{
            eventService.tipOff(user,event,notice);
        }
    }
    public void createEventView(User user, Circle circle){
        CreateEventView createEventView=new CreateEventView();
        createEventView.create(user,circle);
    }
    public void createEvent(User user, Circle circle, Event event) throws Exception {
        if ("".equals(event.getContent())){
            tipView.showTip("请填充瓜料！");
        }
        else {
            if (eventService.createEvent(user,circle,event)==1){
                tipView.showTip("发表成功！欢迎继续撒瓜！");
            }
        }
    }
    public void deleteEvent(User user, Event event) throws Exception{
        if (eventService.deleteEvent(user,event)){
            tipView.showTip("删除成功！重新进入刷新页面！");
        }
        else {
            tipView.showTip("删除失败！你不是管理员或者该事件的发表者！");
        }
    }
}
