package com.cat.www.util;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUtil<T> {
    private static final int NUMBERAFTERWHERE= 1;
    /*
    单表update数据，condition是条件（目标行）（不通过主键id），即sql语句中where部分，target是希望更改的地方（目标列），即set部分
     */
    public int update(T t,String[] condition,String[] target) throws Exception {

        return 0;

    }
    /*
    通过主键id直接锁定目标行（一行），target同样表示目标列
     */
    public int update(T t,int id,String[] target) throws Exception {

        return 0;
    }
}
