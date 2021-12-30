package LearningTest.ThreadTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 手动创建线程池
 *
 * @author summer
 * @title: ThreadPoolDemo
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/30/21 13:01
 */
public class ThreadPoolDemo {
    /**
     * 线程数
     */
    public static final int THREAD_POOL_SIZE = 16;

    public static void main(String[] args) throws InterruptedException {
        // 1 使用ThreadFactoryBuilder创建自定义线程名称的ThreadFactory
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-demo-%d").build();
        // 2 创建线程池，并设置合理的容量
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                THREAD_POOL_SIZE,
                THREAD_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 3 创建1000个线程，并执行打印各自的线程名
        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

        executor.shutdown();
        executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        System.out.println("Done.");
    }
}
