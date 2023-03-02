package Demo02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    MyThread mt1 = new MyThread();
    MyThread mt2 = new MyThread();

    FutureTask<Integer> t1 = new FutureTask<>(mt1);
    FutureTask<Integer> t2 = new FutureTask<>(mt2);

    Thread td1 = new Thread(t1);
    Thread td2 = new Thread(t2);

    td1.setName("窗口1");
    td2.setName("窗口2");

    td1.start();
    td2.start();

        System.out.println(t1.get());
        System.out.println(t2.get());


    }
}
