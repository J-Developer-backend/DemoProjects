package com.cat.www.impl;

import com.cat.www.dao.DeleteDao;
import com.cat.www.dao.InsertDao;
import com.cat.www.dao.SearchDao;
import com.cat.www.exception.PermissionException;
import com.cat.www.po.*;
import com.cat.www.service.CircleService;
import com.xiedafeng.www.po.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleServiceImpl implements CircleService {
    private Condition condition=new Condition();
    private SearchDao searchDao=new SearchDao();
    @Override
    public List showCircle(User user) throws Exception {
        Circle circle=new Circle();
        return searchDao.search(circle);
    }

    @Override
    public List<Event> showCircleEvent(Circle circle) throws Exception {
        Event event=new Event();
        return searchDao.relationSearch(1,event,circle,condition.circle(circle),null);
    }

    @Override
    public List roleCheck(User user) throws Exception {
        Role role=new Role();
        List list = searchDao.relationSearch(1,user,role,condition.userAndRole(user,"onlooker"),null);
        if (list.size()!=0){
            throw new PermissionException();
        }
        return list;
    }

    @Override
    public int createCircle(User user, Circle circle) throws Exception {
        InsertDao insertDao=new InsertDao();
        return insertDao.insert(circle,user,insertDao.inesrt(circle),searchDao.searchId(user,condition.user(user)));
    }

    @Override
    public boolean deleteCircle(User user, Circle circle) throws Exception {
        List<User> userList=searchDao.relationSearch(2,circle,user,condition.circle(circle),null);
        if (userList.get(0).getUserName().equals(user.getUserName())){
            DeleteDao deleteDao=new DeleteDao();
            Map noCondition=new HashMap();
            deleteDao.deleteRelation(circle,user,searchDao.searchId(circle,condition.circle(circle)),searchDao.searchId(user,condition.user(user)),null,noCondition);
            deleteDao.delete(circle,searchDao.searchId(circle,condition.circle(circle)));
            return true;
        }
        return false;
    }

}
