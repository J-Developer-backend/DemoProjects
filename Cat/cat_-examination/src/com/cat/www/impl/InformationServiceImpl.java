package com.cat.www.impl;

import com.cat.www.dao.UpdateDao;
import com.cat.www.po.User;
import com.cat.www.service.InformationService;

public class InformationServiceImpl implements InformationService {
    @Override
    public void update(User user) throws Exception {
        UpdateDao updateDao=new UpdateDao();
        String[] position={"Password"};
        String[] target={"Name","Sex","Birthday","SelfIntroduce"};
        updateDao.update(user,position,target);
    }
}
