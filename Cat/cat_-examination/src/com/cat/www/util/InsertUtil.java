package com.cat.www.util;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

public class InsertUtil<T,E> {
    /*
    某个对象（类）对应的数据表，insert后返回主键id值，方便关联表操作
     */
    public int insert(T t) throws Exception {

        return 0;
    }
    /*
    insert数据到关联表中，t为主动寻求关联的一方，e被关联（和search那里一样，这个方法对应于search中参数x为null的情况）
     */
    public int insert(T t,E e,int id1,int id2) throws SQLException {
        return 0;
    }
    /*
    insert数据到关联表中，tid为主动寻求关联的一方的id，e被关联（和search那里一样，这个方法对应于search中参数x不为null的情况）
     */
    public int insert(T t,int tid,int eid) throws Exception {

        return 0;
    }
}
