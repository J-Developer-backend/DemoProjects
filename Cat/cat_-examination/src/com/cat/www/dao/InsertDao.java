package com.cat.www.dao;

import com.cat.www.util.InsertUtil;

import java.sql.SQLException;

public class InsertDao<T,E> {
    private InsertUtil insertUtil=new InsertUtil();
    //直接看封装那里的注解吧
    public int inesrt(T t) throws Exception {
        return insertUtil.insert(t);
    }
    public int insert(T t,E e,int id1,int id2) throws SQLException {
        return insertUtil.insert(t,e,id1,id2);
    }
    public void insert(T t,int id1,int id2) throws Exception {
        insertUtil.insert(t,id1,id2);
    }
}
