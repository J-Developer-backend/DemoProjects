package com.cat.www.service;

import com.cat.www.po.Notice;
import com.cat.www.po.User;

import java.util.List;

public interface NoticeService {
    List<Notice> userNotice(User user) throws Exception;
}
