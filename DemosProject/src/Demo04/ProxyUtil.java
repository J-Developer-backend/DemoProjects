package Demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static  ProxyImplet  createProxy(Student stu){
        ProxyImplet o = (ProxyImplet)Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{ProxyImplet.class},
                new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if(method.getName().equals("homework")){
                    System.out.println("老师布置了"+objects[0]+"作业");
                } else if (method.getName().equals("run")) {
                    System.out.println("run!!!!");
                }
                return  method.invoke(stu,objects);

            }
        });
        return o;
    }
}
