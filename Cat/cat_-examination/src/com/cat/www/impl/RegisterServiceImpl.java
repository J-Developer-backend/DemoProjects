package com.cat.www.impl;

import com.cat.www.dao.InsertDao;
import com.cat.www.dao.SearchDao;
import com.cat.www.po.Condition;
import com.cat.www.po.Role;
import com.cat.www.po.User;
import com.cat.www.service.RegisterService;

import java.util.List;

public class RegisterServiceImpl implements RegisterService {
    private SearchDao searchDao= new SearchDao<>();
    private InsertDao insertDao= new InsertDao<>();
    @Override
    public boolean check(User user) throws Exception {
        List<User> resultList=searchDao.search(user,"UserName");
        return resultList.size() == 0;
    }

    @Override
    public int create(User user) throws Exception {
        Role role=new Role();
        role.setRole("onlooker");
        Condition condition=new Condition();
        return insertDao.insert(user,role,insertDao.inesrt(user),searchDao.searchId(role,condition.role(role)));
    }
}
