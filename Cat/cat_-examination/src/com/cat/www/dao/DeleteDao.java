package com.cat.www.dao;

import com.cat.www.util.DeleteUtil;

import java.sql.SQLException;
import java.util.Map;

public class DeleteDao<T,E,X> {
    //直接看封装那里的注解吧
    private DeleteUtil deleteUtil=new DeleteUtil();
    public void delete(T t,int id){
        try {
            deleteUtil.delete(t,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void deleteRelation(T t, E e, int tid, int eid, X x, Map condition){
        try {
            deleteUtil.deleteRelation(t,e,tid,eid,x,condition);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
