package com.cat.www.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        try {
            Properties properties=new Properties();
            ClassLoader classLoader= JdbcUtil.class.getClassLoader();
            URL resource=classLoader.getResource("jdbc.properties");
            String path=resource.getPath();
            properties.load(new FileReader(path));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()  {

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static void close(PreparedStatement preparedstatement){
        if (preparedstatement!=null){
            try {
                preparedstatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public static void close(ResultSet resultset, PreparedStatement preparedstatement){
        if (resultset!=null){
            try {
                resultset.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (preparedstatement!=null){
            try {
                preparedstatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
