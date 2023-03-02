package com.cat.www.dao;

import com.cat.www.util.SearchUtil;

import java.util.List;
import java.util.Map;

public class SearchDao<T,E,X> {
    //直接看封装那里的注解吧
    private SearchUtil searchUtil=new SearchUtil<>();
    public List search(T t, String... condition) {
        return searchUtil.search(t,condition);
    }
    public List relationSearch(int position, T t, E e, Map condition, X x) throws Exception {
        return searchUtil.relationSearch(position,t,e,condition,x);
    }
    public int searchId(T t, Map condition) throws Exception {
        return searchUtil.searchId(t,condition);
    }
}
