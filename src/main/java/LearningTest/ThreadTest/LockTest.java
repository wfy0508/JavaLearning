package LearningTest.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized与lock的异同：
 * 相同：两者都可以解决线程安全问题
 * 不同：synchronized在执行完同步代码后会自动释放同步监视器
 *      lock需手动开启lock()，同时结束同步也需要手动实现unlock()
 *
 * @author summer
 * @title: LockTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 22:27
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Window implements Runnable {
    private static int ticket = 100;
    /**
     * 实例化ReentrantLock
     */
    private final ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                // 调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}
