package com.cat.www.controller;

import com.cat.www.po.User;
import com.cat.www.impl.UserBehaviorBehaviorServiceImpl;
import com.xiedafeng.www.po.*;
import com.cat.www.service.UserBehaviorService;
import com.cat.www.view.EventView;

public class UserBehaviorController {
    private UserBehaviorService userBehaviorService =new UserBehaviorBehaviorServiceImpl();
    private EventView eventView=new EventView();
    public void showUserEvent(User user) throws Exception{
        eventView.showUserEvent(user, userBehaviorService.showUserEvent(user));
    }
    public void showThumbUpEvent(User user) throws Exception {
        eventView.showThumbUpEvent(user, userBehaviorService.showThumbUpEvent(user));
    }
    public void showCollectEvent(User user) throws Exception {
        eventView.showCollectEvent(user, userBehaviorService.showCollectEvent(user));
    }
    public void showRemarkEvent(User user) throws Exception {
        RemarkController remarkController=new RemarkController();
        remarkController.showRemarkEvent(user);
    }
}
