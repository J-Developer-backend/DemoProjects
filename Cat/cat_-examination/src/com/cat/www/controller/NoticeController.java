package com.cat.www.controller;

import com.cat.www.po.User;
import com.cat.www.impl.NoticeServiceImpl;
import com.cat.www.service.NoticeService;
import com.cat.www.view.NoticeView;

public class NoticeController {
    public void showNotice(User user) throws Exception {
        NoticeService noticeService=new NoticeServiceImpl();
        NoticeView noticeView=new NoticeView();
        noticeView.showNotice(noticeService.userNotice(user));
    }
}
