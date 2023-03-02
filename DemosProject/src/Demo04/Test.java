package Demo04;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("libai",15);
        ProxyImplet stu = ProxyUtil.createProxy(s);
        String homework = stu.homework("数学");
        System.out.println(homework);
        stu.run();
    }
}
