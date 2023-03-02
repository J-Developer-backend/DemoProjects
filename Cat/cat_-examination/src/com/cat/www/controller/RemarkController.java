package com.cat.www.controller;

import com.cat.www.po.Event;
import com.cat.www.po.Remark;
import com.cat.www.po.User;
import com.cat.www.service.EventService;
import com.cat.www.service.UserBehaviorService;
import com.cat.www.impl.EventServiceImpl;
import com.cat.www.impl.UserBehaviorBehaviorServiceImpl;
import com.cat.www.view.CreateRemarkView;
import com.cat.www.view.RemarkView;
import com.cat.www.view.TipView;

public class RemarkController {
    private EventService eventService=new EventServiceImpl();
    private UserBehaviorService userBehaviorService =new UserBehaviorBehaviorServiceImpl();
    private TipView tipView=new TipView();
    public void showEventRemark(User user, Event event) throws Exception {
        RemarkView remarkView=new RemarkView();
        remarkView.showEventRemark(user,event,eventService.showEventRemark(event),eventService.showRemarkUserName(event));
    }
    public void showRemarkEvent(User user) throws Exception {
        RemarkView remarkView=new RemarkView();
        remarkView.showUserRemarkEvent(user, userBehaviorService.showUserRemark(user), userBehaviorService.showRemarkEvent(user));
    }
    public void showCreateRemarkView(User user, Event event){
        CreateRemarkView createRemarkView=new CreateRemarkView();
        createRemarkView.create(user,event);
    }
    public void createRemark(User user, Event event, Remark remark) throws Exception {
        if ("".equals(remark.getRemarkContent())){
            tipView.showTip("评论不能为空！");
        }
        else {
            eventService.createRemark(user,event,remark);
            tipView.showTip("成功发表成功！");
        }
    }
    public void deleteRemark(User user, Event event, Remark remark) throws Exception {
        if (eventService.deleteRemark(user,event,remark)){
            tipView.showTip("成功删除评论！");
        }
        else {
            tipView.showTip("抱歉！你没有权限！因为你不是该评论的发表者或者该事件的发布者！");
        }
    }
}
