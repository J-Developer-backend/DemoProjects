package com.cat.www.service;

import com.cat.www.po.User;

public interface RegisterService {
    boolean check(User user) throws Exception;
    int create(User user) throws Exception;
}
