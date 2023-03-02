package com.cat.www.util;

import com.cat.www.exception.DatabaseException;
import com.cat.www.exception.ReflectException;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchUtil<T, E, X> {
    /*
    该方法进行单表查询，一个对象或类会对应一个表（如User类就对应User表），t对象就代表这个可能传进来的对象，，condition代表T这个类中有哪些属性（成员变量）
    是要作为限定条件的，由调用dao的service决定，传入变量名即可，（如要按照账号userName查找user就传入“UserName”），具体的条件由t对象确定，这是刚开始写项目时写的，用的是数组，通过getMethod获取相对应的Getter和Setter方法，进行
    sql语句的构建和执行结果的获取，后来写的一些方法基本都用成了Map来构建sql
     */
    public List<T> search(T t, String[] condition) {

        return null;
    }
    /*
    多表查询，t和e是两个不同类的对象，t去寻求关联，e被t关联，一般情况下，关联表表明即两个对应的类的类名，寻求关联的在前，即t，被关联的在后，即e，Map是条件，
    （如发表事件使，t即为event，e即为user，关联表的表名即为eventuser，Map可以是{“UserName”，user。getUserName}）
    但是，像是点赞，收藏等，这些也是将event和user进行关联，于是就有了这第三个泛型X x，它可以是点赞类Thumbup，收藏类Collect，关联表的表名就是对应的类名，x也可以是空null，
    同时，进行多表查询时还要确定service需要哪个表（类或对象）的数据，于是后来又有了position这个参数来指明是要第几个，
    t和e的顺序还是比较重要的！！！
    在举报功能那里，需要将举报的user和举报notice进行关联，而举报notice还需要和接收处理举报的user进行关联，也就是有两个user和notice的关联表，突然感觉像是在写个聊天系统或公告
   一开始想莫非又要像点赞，收藏那里一样在来一个第三方（类）对象，仔细一想，还是可以先确定哪个是主动寻求关联，哪个是被关联，举报时notice是寻求关联，user是被关联（我是把少的一方当作被关联
   ，多的是主动，如一个user可以发出多条notice，user是少的，接收时，一个notice可以发到多个user，这时notice是少的）
     */

    /**
     * @param position
     * @param t
     * @param e
     * @param condition
     * @param x
     * @return
     * @throws Exception
     */
    public List relationSearch(int position, T t, E e, Map condition, X x) throws Exception {
        return null;
    }

    /*
    这个方法是用来查询数据库中数据的主键id的，只要能找到，那返回值都不为0，否则就返回0，常在对关联表插入数据或者删除某一个表某行数据时使用
     */
    public int searchId(T t, Map condition) throws SQLException {

        return 0;
    }
}
