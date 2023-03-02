package Demo01;

public class Student  extends Person{




    public Student() {
    }
    public Student(String name,int age){
        super(name,age);
    }

    @Override
    public void eat() {
        System.out.println("eat.........zi");
    }
    public void run(){
        System.out.println("run...........zi");
    }
    @Override
    public String toString() {
        return "Student{"+getName()+","+getAge()+"}";
    }
}
