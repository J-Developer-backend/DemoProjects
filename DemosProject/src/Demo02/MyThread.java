package Demo02;


import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int num = 100;
        int sum = 0;
        while(num!=0){
            sum = sum + num;
            num--;
        }
        return sum;
    }
}

