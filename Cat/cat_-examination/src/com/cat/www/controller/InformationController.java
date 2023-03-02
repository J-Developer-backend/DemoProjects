package com.cat.www.controller;

import com.cat.www.po.User;
import com.cat.www.impl.InformationServiceImpl;
import com.cat.www.service.InformationService;
import com.cat.www.view.ShowInformationView;
import com.cat.www.view.TipView;
import com.cat.www.view.UpdateInformationView;

public class InformationController {
    private UpdateInformationView updateinformationView=new UpdateInformationView();
    private TipView tipView=new TipView();
    public void show(User user){
        ShowInformationView showinformationView=new ShowInformationView();
        showinformationView.show(user);
    }
    public void updateInput(User user) throws Exception {
        updateinformationView.show(user);
        if ("".equals(user.getName())||"".equals(user.getSex())||"".equals(user.getBirthday())){
            tipView.showTip("请填写完整信息!");
        }
        else {
            update(user);
        }
    }
    public void update(User user) throws Exception {
        InformationService informationService=new InformationServiceImpl();
        informationService.update(user);
        tipView.showTip("修改成功！");
        updateinformationView.close();
    }
}
