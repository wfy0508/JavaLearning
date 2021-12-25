package LearningTest.ThreadTest;

/**
 * @author summer
 * @title: ThreadTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/25/21 20:23
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 3. 创建实例对象
        MyThread myThread = new MyThread();
        // 4. 调用此对象调用start()，会自动调用当前线程的run()方法
        // 不能直接调用run()方法，这样会在main线程中运行
        // 同一个线程不能启用两次start()方法
        myThread.start();
        System.out.println("main线程");

    }
}

/**
 * 1. 创建MyThread，继承Thread
 */
class MyThread extends Thread {
    /**
     * 2. 实现run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}