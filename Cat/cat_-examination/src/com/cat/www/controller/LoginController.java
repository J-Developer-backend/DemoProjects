package com.cat.www.controller;

import com.cat.www.po.User;
import com.cat.www.impl.LoginServiceImpl;
import com.cat.www.proxy.ServiceProxy;
import com.cat.www.service.LoginService;
import com.cat.www.view.MenuView;
import com.cat.www.view.TipView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class LoginController {
    public void login(User user) {
        LoginService loginService=new LoginServiceImpl();
        MenuView menuView=new MenuView();
        TipView tipView = new TipView();
        InvocationHandler invocationHandler=new ServiceProxy(loginService);
        LoginService proxy= (LoginService) Proxy.newProxyInstance(loginService.getClass().getClassLoader(),loginService.getClass().getInterfaces(),invocationHandler);
        if ("".equals(user.getUserName())||"".equals(user.getPassword())){
            tipView.showTip("请输入完整账号和密码");
        }
        else {

            List<User> userList=proxy.loginCheck(user);

            if (userList.size()!=0) {
                menuView.menu(userList.get(0));
            } else {
                tipView.showTip("登录失败，账号或密码错误！");
            }
        }
    }
}
