package com.cat.www.controller;

import com.cat.www.po.User;
import com.cat.www.impl.RegisterServiceImpl;
import com.cat.www.service.RegisterService;
import com.cat.www.view.RegisterView;
import com.cat.www.view.TipView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RegisterController {
    private RegisterView registerView=new RegisterView();
    public void create(){
        registerView.create();
    }
    public void check(User user) throws Exception {
        RegisterService registerService=new RegisterServiceImpl();
        /*InvocationHandler invocationHandler=new MyHander(registerService);
        RegisterService proxy= (RegisterService) Proxy.newProxyInstance(registerService.getClass().getClassLoader(),registerService.getClass().getInterfaces(),invocationHandler);
        proxy.create(user);*/
        TipView tipView=new TipView();
        if ("".equals(user.getName())|| "".equals(user.getUserName())|| "".equals(user.getPassword())|| "".equals(user.getSex())|| "".equals(user.getBirthday())) {
            tipView.showTip("请完善你的信息");
        }
        else {
            if (registerService.check(user)) {
                if (checkBirthday(user.getBirthday())) {
                    //proxy.create(user);
                    registerService.create(user);
                    tipView.showTip("注册成功,请从登录界面进入本系统");
                    registerView.close();
                }
                else{
                    tipView.showTip("请输入正确的生日日期格式！如2020年01月01日");
                }
            } else {
                tipView.showTip("注册失败！该账号已存在！");
            }
        }
    }
    private boolean checkBirthday(String birthday){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        boolean flag=true;
        try {
            LocalDate.parse(birthday,dateTimeFormatter);
        }catch (DateTimeParseException | NullPointerException e){
            flag=false;
        }
        return flag;
    }
}
