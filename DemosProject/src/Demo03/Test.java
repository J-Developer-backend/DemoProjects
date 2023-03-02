package Demo03;


import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = Class.forName("Demo03.Student");
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }
        Field age = c.getDeclaredField("age");
        Student stu = new Student(15,"11");
        age.setAccessible(true);
        System.out.println(age.get(stu));
        age.set(stu,100);
        System.out.println(stu);
    }
}
