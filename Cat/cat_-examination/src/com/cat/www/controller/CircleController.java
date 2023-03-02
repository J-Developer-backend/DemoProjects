package com.cat.www.controller;

import com.cat.www.po.Event;
import com.cat.www.po.User;
import com.cat.www.impl.CircleServiceImpl;
import com.cat.www.po.Circle;
import com.cat.www.proxy.ServiceProxy;
import com.cat.www.service.CircleService;
import com.cat.www.view.CircleView;
import com.cat.www.view.CreateCircleView;
import com.cat.www.view.EventView;
import com.cat.www.view.TipView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class CircleController {
    private CircleService circleService=new CircleServiceImpl();
    InvocationHandler invocationHandler=new ServiceProxy(circleService);
    CircleService proxy= (CircleService) Proxy.newProxyInstance(circleService.getClass().getClassLoader(),circleService.getClass().getInterfaces(),invocationHandler);
    private TipView tipView=new TipView();
    public void showCircleView(User user) throws Exception {
        CircleView circleView=new CircleView();
        circleView.showCircle(user, showCircle(user));
    }
    private List showCircle(User user) throws Exception {
        return circleService.showCircle(user);
    }
    public void showCircleEventView(User user,Circle circle) throws Exception {
        EventView eventView=new EventView();
        eventView.showCircleEvent(user,circle,showCircleEvent(circle));
    }
    private List<Event> showCircleEvent(Circle circle) throws Exception {
        return circleService.showCircleEvent(circle);
    }
    public void checkRole(User user) throws Exception {

        if (proxy.roleCheck(user).size()==0){
            showCreateCircleView(user);
        }
        else {
            tipView.showTip("抱歉！你没有权限！");
        }
    }
    private void showCreateCircleView(User user){
        CreateCircleView createCircleView=new CreateCircleView();
        createCircleView.createView(user);
    }
    public void createCircle(User user, Circle circle) throws Exception {
        if ("".equals(circle.getCircleName())) {
            tipView.showTip("请输入瓜圈名!");
        }
        else {
            circleService.createCircle(user, circle);
            tipView.showTip("创建成功！重新进入刷新页面！欢迎撒瓜！");
        }
    }
    public void deleteCircle(User user, Circle circle) throws Exception {
        if (circleService.deleteCircle(user,circle)){
            tipView.showTip("删除成功！");
        }
        else {
            tipView.showTip("抱歉！你没有权限！");
        }
    }
}
