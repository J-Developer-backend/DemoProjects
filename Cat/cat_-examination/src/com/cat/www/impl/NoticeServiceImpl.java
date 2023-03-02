package com.cat.www.impl;

import com.cat.www.po.Condition;
import com.cat.www.po.Notice;
import com.cat.www.po.User;
import com.cat.www.service.NoticeService;
import com.cat.www.dao.SearchDao;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    @Override
    public List<Notice> userNotice(User user) throws Exception {
        Notice notice=new Notice();
        SearchDao searchDao=new SearchDao();
        Condition condition=new Condition();
        return searchDao.relationSearch(2,user,notice,condition.user(user),null);
    }
}
