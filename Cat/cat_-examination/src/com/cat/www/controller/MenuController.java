package com.cat.www.controller;

import com.cat.www.po.User;

public class MenuController {
    private InformationController informationController=new InformationController();
    private UserBehaviorController userBehaviorController =new UserBehaviorController();
    public void searchInformation(User user){
        informationController.show(user);
    }
    public void modifyInformation(User user) throws Exception {
        informationController.updateInput(user);
    }
    public void enterCircle(User user) throws Exception {
        CircleController circleController=new CircleController();
        circleController.showCircleView(user);
    }
    public void showUserEvent(User user) throws Exception {
        userBehaviorController.showUserEvent(user);
    }
    public void showUserThumbUp(User user) throws Exception {
        userBehaviorController.showThumbUpEvent(user);
    }
    public void showUserCollect(User user) throws Exception {
        userBehaviorController.showCollectEvent(user);
    }
    public void showUserRemark(User user) throws Exception{
        userBehaviorController.showRemarkEvent(user);
    }
    public void showNotice(User user) throws Exception {
        NoticeController noticeController=new NoticeController();
        noticeController.showNotice(user);
    }
}
