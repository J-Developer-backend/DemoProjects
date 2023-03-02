package com.cat.www.service;

import com.cat.www.po.Event;
import com.cat.www.po.Remark;
import com.cat.www.po.User;

import java.util.List;

public interface UserBehaviorService {
    List<Event> showUserEvent(User user) throws Exception;
    List<Event> showThumbUpEvent(User user) throws Exception;
    List<Event> showCollectEvent(User user) throws Exception;
    List<Event> showRemarkEvent(User user) throws Exception;
    List<Remark> showUserRemark(User user)throws Exception;
}
