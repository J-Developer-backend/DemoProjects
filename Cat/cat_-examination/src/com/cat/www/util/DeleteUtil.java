package com.cat.www.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DeleteUtil<T,E,X> {
    /*
    可以通过searchid查找主键id进行删除，方便简洁
     */

    public void delete(T t,int id) throws SQLException {

    }
    /*
    参数的意义和封装的search那里差不多，请前往那里查看，
     */
    public void deleteRelation(T t, E e, int tid, int eid, X x, Map condition) throws SQLException {

    }
}
