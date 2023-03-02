package com.cat.www.impl;

import com.cat.www.dao.SearchDao;
import com.cat.www.exception.LoginException;
import com.cat.www.po.User;
import com.cat.www.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    @Override
    public List<User> loginCheck(User user) throws LoginException {
        SearchDao searchDao=new SearchDao();
        List userList=searchDao.search(user,"UserName","Password");
        if (userList.size()==0){
            throw new LoginException();
        }
        return userList;
    }
}
