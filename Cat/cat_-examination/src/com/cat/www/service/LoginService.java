package com.cat.www.service;

import com.cat.www.po.User;
import com.cat.www.exception.LoginException;

import java.util.List;

public interface LoginService {
    List<User> loginCheck(User user) throws LoginException;
}
