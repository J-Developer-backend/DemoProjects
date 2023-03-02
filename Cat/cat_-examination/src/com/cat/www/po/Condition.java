package com.cat.www.po;

import java.util.HashMap;
import java.util.Map;

public class Condition {
    public Map user(User user){
        Map userCondition=new HashMap();
        userCondition.put("UserName",user.getUserName());
        return userCondition;
    }
    public Map circle(Circle circle){
        Map circleCondition=new HashMap();
        circleCondition.put("CircleName",circle.getCircleName());
        circleCondition.put("CircleCreatetime",circle.getCircleCreatetime());
        return circleCondition;
    }
    public Map event(Event event){
        Map eventCondition=new HashMap();
        eventCondition.put("Publisher",event.getPublisher());
        eventCondition.put("Createtime",event.getCreatetime());
        return eventCondition;
    }
    public Map userAndRole(User user, String role){
        Map usreAndRoleCondition=new HashMap();
        usreAndRoleCondition.put("Role",role);
        usreAndRoleCondition.put("UserName",user.getUserName());
        return usreAndRoleCondition;
    }
    public Map role(Role role){
        Map roleCondition=new HashMap();
        roleCondition.put("Role",role.getRole());
        return roleCondition;
    }
    public Map eventAndUser(User user, Event event){
        Map thumbUpCondition=new HashMap();
        thumbUpCondition.put("UserName",user.getUserName());
        thumbUpCondition.put("Publisher",event.getPublisher());
        thumbUpCondition.put("Createtime",event.getCreatetime());
        return thumbUpCondition;
    }
    public Map remark(Remark remark){
        Map remarkCondition=new HashMap();
        remarkCondition.put("RemarkContent",remark.getRemarkContent());
        return remarkCondition;
    }
    public Map noCondition(){
        return new HashMap();
    }
}
