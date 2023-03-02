package com.cat.www.service;

import com.cat.www.po.Event;
import com.cat.www.po.User;
import com.cat.www.po.Circle;

import java.util.List;

public interface CircleService {
    List showCircle(User user) throws Exception;
    List<Event> showCircleEvent(Circle circle) throws Exception;
    List roleCheck(User user) throws Exception;
    int createCircle(User user, Circle circle) throws Exception;
    boolean deleteCircle(User user, Circle circle) throws Exception;
}
