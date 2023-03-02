package com.cat.www.util;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 自定义连接池
 */
public class DataSourceUtil implements DataSource {
    List<Connection> connectionList= new ArrayList<>();
    final int INITSIZE =10;
    public DataSourceUtil() {
        for (int i = 0; i < INITSIZE; i++) {
            Connection connection=JdbcUtil.getConnection();
            connectionList.add(connection);
        }
    }
    @Override
    public Connection getConnection() {

        return null;
    }

    @Override
    public Connection getConnection(String username, String password) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) {

    }

    @Override
    public void setLoginTimeout(int seconds) {

    }

    @Override
    public int getLoginTimeout() {
        return 0;
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }
}
