package LearningTest.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable相比Runnable的优势？
 * 1、 call()可以有返回值
 * 2、 call()可以抛出异常，被外面捕获，获取异常的信息
 * 3、 Callable支持泛型
 *
 * @author summer
 * @title: CallableTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/29/21 12:09
 */
public class CallableTest {
    public static void main(String[] args) {
        // 1 创建实现了Callable接口类的对象
        Num num = new Num();
        // 2 创建FutureTask实例，将Callable对象传入
        FutureTask<Integer> task = new FutureTask<>(num);
        // 3 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
        new Thread(task).start();
        try {
            // 通过FutureTask的对象获取call()方法的返回值
            System.out.println("总和为：" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class Num implements Callable<Integer> {
    /**
     * 实现call()方法，将此线程需要执行的操作声明在call()中
     */
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }
        return sum;
    }
}