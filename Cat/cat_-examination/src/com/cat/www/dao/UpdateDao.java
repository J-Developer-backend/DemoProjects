package com.cat.www.dao;

import com.cat.www.util.UpdateUtil;

public class UpdateDao<T> {
    //直接看封装那里的注解吧
    private UpdateUtil updateUtil=new UpdateUtil();
    public int update(T t,String[] position,String[] target) throws Exception {
        return updateUtil.update(t,position,target);
    }
    public int update(T t,int id,String[] target) throws Exception {
        return updateUtil.update(t,id,target);
    }
}
