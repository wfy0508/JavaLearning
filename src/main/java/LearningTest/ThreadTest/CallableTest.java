package LearningTest.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author summer
 * @title: CallableTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/29/21 12:09
 */
public class CallableTest {
    public static void main(String[] args) {
        Num num = new Num(10);
        FutureTask<Integer> task = new FutureTask<>(num);
        Thread thread = new Thread(task);
        thread.setName("线程1");
        thread.start();
    }
}


class Num implements Callable<Integer> {
    private int number;

    public Num(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }
        System.out.println("sum= " + sum);
        return sum;
    }
}