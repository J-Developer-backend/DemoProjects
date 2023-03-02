package com.cat.www.impl;

import com.cat.www.po.*;
import com.cat.www.service.UserBehaviorService;
import com.cat.www.dao.SearchDao;
import com.xiedafeng.www.po.*;

import java.util.List;

public class UserBehaviorBehaviorServiceImpl implements UserBehaviorService {
    private Condition condition=new Condition();
    private SearchDao searchDao=new SearchDao<>();
    private Event event=new Event();
    private Remark remark=new Remark();
    @Override
    public List<Event> showUserEvent(User user) throws Exception {
        return searchDao.relationSearch(1,this.event,user,condition.user(user),null);
    }

    @Override
    public List<Event> showThumbUpEvent(User user) throws Exception {
        Thumbup thumbup=new Thumbup();
        return searchDao.relationSearch(1,this.event,user,condition.user(user),thumbup);
    }

    @Override
    public List<Event> showCollectEvent(User user) throws Exception {
        Collect collect=new Collect();
        return searchDao.relationSearch(1,this.event,user,condition.user(user),collect);
    }

    @Override
    public List<Event> showRemarkEvent(User user) throws Exception {
        return searchDao.relationSearch(1,this.event,user,condition.user(user),this.remark);
    }

    @Override
    public List<Remark> showUserRemark(User user) throws Exception {
        return searchDao.relationSearch(3,this.event,user,condition.user(user),this.remark);
    }
}
