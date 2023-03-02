package Demo01;

public class Worker extends Person{

    public Worker() {
    }


    public Worker(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return "Worker{"+getName()+","+getAge()+"}";
    }
}
