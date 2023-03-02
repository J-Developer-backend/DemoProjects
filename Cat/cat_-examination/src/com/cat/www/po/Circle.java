package com.cat.www.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Circle {
    /*
    circle即瓜圈，两个成员变量，分别代表瓜圈的名称和创建瓜圈的时间
    */
    private String circleName;
    private String circleCreatetime;
    /*
    在创建瓜圈（即new一个circle对象时就会执行下方代码，记录创建时间）
     */
    {
        Date createDate=new Date();
        SimpleDateFormat crateTimeFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        this.circleCreatetime =crateTimeFormat.format(createDate);
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleCreatetime() {
        return circleCreatetime;
    }

    public void setCircleCreatetime(String circleCreatetime) {
        this.circleCreatetime = circleCreatetime;
    }
}
