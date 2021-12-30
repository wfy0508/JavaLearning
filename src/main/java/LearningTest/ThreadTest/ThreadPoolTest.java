package LearningTest.ThreadTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 使用线程池创建线程
 * 1 可以提高资源利用率，响应速度
 *
 * @author summer
 * @title: ThreadPoolTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/30/21 12:34
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                2,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(20),
                build,
                new ThreadPoolExecutor.AbortPolicy());
        executor.execute(new Num1());
        executor.execute(new Num2());
        executor.shutdown();
    }
}


class Num1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class Num2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
