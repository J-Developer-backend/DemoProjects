package com.cat.www.service;

import com.cat.www.po.*;
import com.xiedafeng.www.po.*;

import java.util.List;

public interface EventService {
    boolean thumbUp(User user, Event event) throws Exception;
    boolean collect(User user, Event event) throws Exception;
    List<Remark> showEventRemark(Event event) throws Exception;
    List<User> showRemarkUserName(Event event) throws Exception;
    void createRemark(User user, Event event, Remark remark) throws  Exception;
    boolean deleteRemark(User user, Event event, Remark remark) throws Exception;
    void tipOff(User user, Event event, Notice notice) throws Exception;
    int createEvent(User user, Circle circle, Event event) throws Exception;
    boolean deleteEvent(User user, Event event) throws Exception;
}
